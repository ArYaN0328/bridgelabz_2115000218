import java.util.Scanner;

public class FibonacciSequenceGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input the number of terms
        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int terms = scanner.nextInt();

        // Call the function to generate and print the Fibonacci sequence
        generateFibonacci(terms);

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to generate and print the Fibonacci sequence
    public static void generateFibonacci(int terms) {
        // Handle the case for 0 or negative terms
        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
            return;
        }

        // Variables to store the first two terms
        long first = 0;
        long second = 1;

        System.out.println("Fibonacci sequence up to " + terms + " terms:");

        // Print the Fibonacci sequence
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            // Calculate the next term in the sequence
            long next = first + second;
            first = second;
            second = next;
        }

        System.out.println(); // Move to the next line after printing the sequence
    }
}
