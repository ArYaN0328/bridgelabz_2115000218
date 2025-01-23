import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define sum variable and initialize it to zero
        int sum = 0;

        // Store the original number
        int originalNumber = number;

        // Use while loop to check each digit
        while (number != 0) {
            // Find the remainder (last digit)
            int remainder = number % 10;

            // Cube the remainder and add it to the sum
            sum += remainder * remainder * remainder;

            // Find the quotient (remove the last digit)
            number = number / 10;
        }

        // Check if the sum is equal to the original number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        scanner.close();
    }
}
