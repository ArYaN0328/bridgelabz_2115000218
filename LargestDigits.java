import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Variables and array initialization
        int maxDigits = 10; // Maximum number of digits allowed
        int[] digits = new int[maxDigits]; // Array to store digits
        int index = 0; // Array index

        // Extract digits and store them in the array
        while (number != 0 && index < maxDigits) {
            digits[index] = number % 10; // Get the last digit
            number /= 10; // Remove the last digit
            index++;
        }

        // Initialize variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Find the largest and second largest digits in the array
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest; // Update second largest
                largest = digits[i]; // Update largest
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i]; // Update second largest
            }
        }

        // Display results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}
