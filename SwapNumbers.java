import java.util.Scanner; // Import Scanner class for user input

public class SwapNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for the numbers
        double number1, number2, temp;

        // Prompt the user to enter the first number
        System.out.print("Enter the first number: ");
        number1 = input.nextDouble(); // Take user input for the first number

        // Prompt the user to enter the second number
        System.out.print("Enter the second number: ");
        number2 = input.nextDouble(); // Take user input for the second number

        // Swap the numbers using a temporary variable
        temp = number1;
        number1 = number2;
        number2 = temp;

        // Display the swapped numbers
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        // Close the Scanner
        input.close();
    }
}
