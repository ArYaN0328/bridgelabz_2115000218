import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the count of digits in the number
        int tempNumber = number;
        int count = 0;
        while (tempNumber != 0) {
            tempNumber /= 10;
            count++;
        }

        // Create an array to store the digits
        int[] digits = new int[count];

        // Extract digits and store them in the array
        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10; // Get the last digit
            number /= 10; // Remove the last digit
        }

        // Create an array to store the digits in reverse order (optional step)
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[i];
        }

        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i]);
        }

        scanner.close();
    }
}
