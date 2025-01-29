import java.util.Scanner;

public class FactorialUsingRecursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        int number = getInput(scanner);

        // Calculate the factorial using recursion
        long factorial = calculateFactorial(number);

        // Display the result
        displayResult(number, factorial);

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to take input from the user
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }

    // Recursive function to calculate the factorial
    public static long calculateFactorial(int n) {
        if (n <= 1) {  // Base case: factorial of 0 or 1 is 1
            return 1;
        } else {
            return n * calculateFactorial(n - 1);  // Recursive case
        }
    }

    // Function to display the result
    public static void displayResult(int number, long factorial) {
        System.out.println("The factorial of " + number + " is: " + factorial);
    }
}
