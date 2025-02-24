
import java.lang.annotation.*;
import java.lang.reflect.*;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH"; // Optional level parameter with default value
}

// Class with annotated methods
class Calculation {
    
    @ImportantMethod(level = "HIGH")
    public void add() {
        System.out.println("Addition done");
    }

    @ImportantMethod(level = "MEDIUM")
    public void subtract() {
        System.out.println("Subtraction done");
    }
}

// Main class to process annotations
public class CalculationManager {
    public static void main(String[] args) {
        Class<?> cls = Calculation.class;

        for (Method m : cls.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod anno = m.getAnnotation(ImportantMethod.class);
                System.out.println("Method name: " + m.getName());
                System.out.println("Level: " + anno.level());
                System.out.println("---------------------");
            }
        }
    }
}



