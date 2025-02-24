
public class MathOperations {
    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public int multiply(int a, int b) {
        return a * b;
    }
}

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();
            
            // Get the class object
            Class<?> cls = mathOps.getClass();

            // User input for method selection
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // User input for arguments
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Get the method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOps, num1, num2);

            // Display the result
            System.out.println("Result: " + result);

            // Close scanner
            scanner.close();

        } catch (Exception e) {
            System.out.println("Error: Invalid method name or arguments.");
            e.printStackTrace();
        }
    }
}

