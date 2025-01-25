import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is valid
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer greater than 0.");
            return; // Exit the program
        }

        // Initialize variables
        int maxFactors = 10; // Initial size of the array to store factors
        int[] factors = new int[maxFactors]; // Array to store the factors
        int index = 0; // Index to track the current position in the array

        // Loop to find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If i is a factor, add it to the factors array
                if (index == maxFactors) {
                    // Resize the factors array if it's full
                    maxFactors *= 2; // Double the size
                    int[] temp = new int[maxFactors];
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                    factors = temp; // Update the factors array to the new, larger array
                }
                factors[index] = i;
                index++;
            }
        }

        // Display the factors of the number
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
