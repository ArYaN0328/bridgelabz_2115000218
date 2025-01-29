import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Call the function to check if the number is prime
        boolean isPrime = checkPrime(number);

        // Output the result
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to check if a number is prime
    public static boolean checkPrime(int number) {
        // Handle edge cases
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }

        // Check divisibility from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // The number is divisible by i, so it's not prime
            }
        }
        return true; // The number is prime if no divisors were found
    }
}
