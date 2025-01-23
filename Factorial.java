import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for an integer
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Initialize factorial result to 1
            int factorial = 1;
            int i = 1;

            // Compute the factorial using a while loop
            while (i <= number) {
                factorial *= i; // Multiply factorial by current i
                i++; // Increment i
            }

            // Display the result
            System.out.println("The factorial of " + number + " is: " + factorial);
        }

        scanner.close();
    }
}
