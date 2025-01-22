import java.util.Scanner; // Import Scanner class for user input

public class BasicCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for the two numbers
        double number1, number2;

        // Prompt the user to enter two numbers
        System.out.print("Enter the first number: ");
        number1 = input.nextDouble(); // Take user input for the first number

        System.out.print("Enter the second number: ");
        number2 = input.nextDouble(); // Take user input for the second number

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = 0; // Initialize division result
        if (number2 != 0) {
            division = number1 / number2; // Perform division if the second number is not zero
        } else {
            System.out.println("Cannot divide by zero.");
        }

        // Display the results
        System.out.println("The addition, subtraction, multiplication and division value of " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + (number2 != 0 ? division : "undefined"));

        // Close the Scanner
        input.close();
    }
}
