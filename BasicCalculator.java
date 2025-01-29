import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu for the user
        System.out.println("Basic Calculator");
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice (1/2/3/4): ");
        int choice = scanner.nextInt();

        // Take two numbers as input for the operation
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Perform the operation based on the user's choice
        switch (choice) {
            case 1:
                double sum = add(num1, num2);
                System.out.println("Result: " + sum);
                break;
            case 2:
                double difference = subtract(num1, num2);
                System.out.println("Result: " + difference);
                break;
            case 3:
                double product = multiply(num1, num2);
                System.out.println("Result: " + product);
                break;
            case 4:
                if (num2 != 0) {
                    double quotient = divide(num1, num2);
                    System.out.println("Result: " + quotient);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid choice! Please choose between 1 and 4.");
                break;
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to perform addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Function to perform subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Function to perform multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Function to perform division
    public static double divide(double a, double b) {
        return a / b;
    }
}
