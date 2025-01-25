import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Create a String array to store the results
            String[] results = new String[number + 1]; // +1 to include the number itself

            // Loop from 0 to the number and store results in the array
            for (int i = 0; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    results[i] = "FizzBuzz"; // Divisible by both 3 and 5
                } else if (i % 3 == 0) {
                    results[i] = "Fizz"; // Divisible by 3
                } else if (i % 5 == 0) {
                    results[i] = "Buzz"; // Divisible by 5
                } else {
                    results[i] = String.valueOf(i); // Otherwise, store the number itself
                }
            }

            // Loop through the array and print the results in the specified format
            for (int i = 0; i <= number; i++) {
                System.out.println("Position " + i + " = " + results[i]);
            }
        }

        scanner.close();
    }
}
