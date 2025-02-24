import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority = "High",assignedTo = "Aryan")
    public void completeOrder(){
        System.out.println("completing order");
    }


    @TaskInfo(priority = "Medium",assignedTo="Anshul")
    public void processRefund(){
        System.out.println("Processing refund.....");
    }
}
public class AnnotationProcessor{
    public static void main(String []args)
    {
        Class<?> obj=TaskManager.class;
        for(Method method:obj.getDeclaredMethods())
        {
            if(method.isAnnotationPresent(TaskInfo.class))
            {
               TaskInfo task=method.getAnnotation(TaskInfo.class);
               System.out.println("Method: "+method.getName());
               System.out.println("Priority: "+task.priority());
               System.out.println("Assigned To: "+task.assignedTo());
               System.out.println("--------------------------");
            }
        }
    }
}
