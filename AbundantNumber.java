import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize the sum variable to 0
        int sum = 0;

        // Run a for loop from i = 1 to i < number
        for (int i = 1; i < number; i++) {
            // Check if number is divisible by i (i is a divisor of the number)
            if (number % i == 0) {
                sum += i;  // Add i to the sum of divisors
            }
        }

        // Check if sum of divisors is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }

        scanner.close();
    }
}
