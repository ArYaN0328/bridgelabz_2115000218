import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            return; // Exit the program
        }

        // Calculate the size for odd and even arrays
        int size = number / 2 + 1;

        // Create arrays for odd and even numbers
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];

        // Initialize index variables for odd and even numbers
        int oddIndex = 0;
        int evenIndex = 0;

        // Loop through numbers from 1 to the entered number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                // If the number is even, store it in the evenNumbers array
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                // If the number is odd, store it in the oddNumbers array
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print the odd numbers array
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        // Print the even numbers array
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
