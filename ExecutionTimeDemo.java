
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
}

public class MathOperations {
    
    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating a slow operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }
}

import java.lang.reflect.Method;

public class ExecutionTimeLogger {
    
    public static void logExecutionTime(Object obj) {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long startTime = System.nanoTime();
                    method.setAccessible(true);
                    method.invoke(obj);
                    long endTime = System.nanoTime();

                    long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                    System.out.println("[LOG] Method " + method.getName() + " executed in " + executionTime + " ms");
                    
                } catch (Exception e) {
                    System.out.println("Error executing method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ExecutionTimeDemo {
    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();
        
        // Automatically logs execution time for annotated methods
        ExecutionTimeLogger.logExecutionTime(mathOps);
    }
}

