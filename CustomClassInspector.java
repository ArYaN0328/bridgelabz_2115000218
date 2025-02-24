
import java.lang.reflect.*;

public class CustomClassInspector {
    public static void main(String[] args) {
        // Specify the custom class name
        String className = "Person";

        try {
            // Load the class dynamically
            Class<?> cls = Class.forName(className);

            // Display class name
            System.out.println("Class: " + cls.getName());

            // Display constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                System.out.println("  " + constructor);
            }

            // Display fields
            System.out.println("\nFields:");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println("  " + field);
            }

            // Display methods
            System.out.println("\nMethods:");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println("  " + method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}

