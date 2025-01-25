import java.util.Scanner;

public class LargestDigitsDynamicArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Variables and array initialization
        int maxDigits = 10; // Initial size of the digits array
        int[] digits = new int[maxDigits]; // Array to store digits
        int index = 0; // Array index

        // Extract digits and store them in the array
        while (number != 0) {
            // Check if array needs resizing
            if (index == maxDigits) {
                maxDigits += 10; // Increase the size by 10
                int[] temp = new int[maxDigits]; // Create a new larger array
                System.arraycopy(digits, 0, temp, 0, digits.length); // Copy old array into new array
                digits = temp; // Reassign the digits array to the new array
            }

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
