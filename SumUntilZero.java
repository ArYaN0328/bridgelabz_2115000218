import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize total to 0.0
        double total = 0.0;

        // Create a variable to store user input
        double number;

        // Ask user for the first number
        System.out.print("Enter a number (enter 0 to stop): ");
        number = scanner.nextDouble();

        // Loop to continue until user enters 0
        while (number != 0) {
            total += number;  // Add the entered number to total
            System.out.print("Enter a number (enter 0 to stop): ");
            number = scanner.nextDouble();  // Ask for another number
        }

        // Display the total sum
        System.out.println("The total sum is: " + total);

        scanner.close();
    }
}
