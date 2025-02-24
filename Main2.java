
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Calculation{
    @Todo(task="perform Addition",assignedTo = "Monika",priority = "HIGH")
    public void addition(){
        System.out.println("Addition to be performed");
    }
    @Todo(task="perform subtraction",assignedTo = "Aryan",priority = "LOW")
    public void subtraction(){
        System.out.println("Subtraction to be performed");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Class<?> cls=Calculation.class;
        for(Method m:cls.getDeclaredMethods())
        {
            if(m.isAnnotationPresent(Todo.class))
            {
                Todo t=m.getAnnotation(Todo.class);
                System.out.println("Method: "+m.getName());
                System.out.println("Task: "+t.task());
                System.out.println("assignedTo: "+t.assignedTo());
                System.out.println("priority: "+t.priority());

            }
        }
    }
}



