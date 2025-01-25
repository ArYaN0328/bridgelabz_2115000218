import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Initialize a frequency array of size 10 (to store counts of digits 0-9)
        int[] frequency = new int[10];

        // Extract digits and calculate frequencies
        long tempNumber = Math.abs(number); // Handle negative numbers
        while (tempNumber > 0) {
            int digit = (int) (tempNumber % 10); // Get the last digit
            frequency[digit]++; // Increment the frequency of that digit
            tempNumber /= 10; // Remove the last digit
        }

        // Display the frequency of each digit
        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }

        scanner.close();
    }
}
