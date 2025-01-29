import java.util.Scanner;

public class GCDandLCMCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate the GCD and LCM
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        // Display the results
        displayResult(gcd, lcm);

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to calculate the GCD using Euclid's algorithm
    public static int calculateGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    // Function to calculate the LCM using the GCD
    public static int calculateLCM(int num1, int num2, int gcd) {
        return (num1 * num2) / gcd;
    }

    // Function to display the results
    public static void displayResult(int gcd, int lcm) {
        System.out.println("The Greatest Common Divisor (GCD) is: " + gcd);
        System.out.println("The Least Common Multiple (LCM) is: " + lcm);
    }
}
