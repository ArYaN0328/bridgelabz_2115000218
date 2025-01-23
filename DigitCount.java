import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Create a variable count and initialize it to 0
        int count = 0;

        // Use a loop to iterate until the number is 0
        while (number != 0) {
            number = number / 10;  // Remove the last digit
            count++;  // Increment the count by 1
        }

        // Display the count to show the number of digits
        System.out.println("The number of digits is: " + count);

        scanner.close();
    }
}
