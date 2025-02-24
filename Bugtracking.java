import java.lang.annotation.*;


import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugRepots{
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugRepots.class)
@interface BugReport{
    String Description();
}


class BugTracker{
    @BugReport(Description="NullPointerException occurs")
    @BugReport(Description ="Performance issue when processing large data")
    public void processdata(){
        System.out.println("Processing data");
    }
}


public class Bugtracking{
    public static void main(String[] args)
    {
        Class<?> cls=BugTracker.class;


        for(Method method:cls.getDeclaredMethods())
        {
            if(method.isAnnotationPresent(BugRepots.class))
            {
                BugRepots bg=method.getAnnotation(BugRepots.class);
                System.out.println("Method: "+method.getName());
                for(BugReport b:bg.value())
                {
                    System.out.println("Bug: "+b.Description());
                }


            }
        }
    }
}


