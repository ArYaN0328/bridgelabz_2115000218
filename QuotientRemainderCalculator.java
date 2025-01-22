import java.util.Scanner; // Import Scanner class for user input

public class QuotientRemainderCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for the two numbers
        int number1, number2;

        // Prompt the user to enter the first number
        System.out.print("Enter the first number (dividend): ");
        number1 = input.nextInt(); // Take user input for the first number

        // Prompt the user to enter the second number
        System.out.print("Enter the second number (divisor): ");
        number2 = input.nextInt(); // Take user input for the second number

        // Validate divisor to avoid division by zero
        if (number2 == 0) {
            System.out.println("Division by zero is not allowed. Please enter a valid divisor.");
        } else {
            // Calculate quotient and remainder
            int quotient = number1 / number2; // Quotient
            int remainder = number1 % number2; // Remainder

            // Display the results
            System.out.println("The Quotient is " + quotient + 
                               " and the Remainder is " + remainder + 
                               " of two numbers " + number1 + " and " + number2 + ".");
        }

        // Close the Scanner
        input.close();
    }
}
