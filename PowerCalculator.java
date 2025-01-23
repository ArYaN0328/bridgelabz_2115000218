import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the exponent (power): ");
        int power = scanner.nextInt();

        // Initialize result variable
        int result = 1;

        // Loop to calculate power
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        // Display the result
        System.out.println(number + " raised to the power of " + power + " is: " + result);
    }
}