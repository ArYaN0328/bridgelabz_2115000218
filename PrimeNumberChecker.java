import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number greater than 1: ");
        int number = scanner.nextInt();

        // Check if number is greater than 1
        if (number <= 1) {
            System.out.println("Invalid input! Please enter a number greater than 1.");
        } else {
            boolean isPrime = true;

            // Checking for prime number
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Printing results
            if (isPrime) {
                System.out.println(number + " is a Prime Number.");
            } else {
                System.out.println(number + " is not a Prime Number.");
            }
        }
    }
}