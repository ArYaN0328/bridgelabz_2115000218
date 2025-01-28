import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate the maximum number of handshakes using the combination formula
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // Calculate the maximum number of handshakes
        int handshakes = calculateHandshakes(n);

        // Output the result
        System.out.println("The maximum number of handshakes among " + n + " students is: " + handshakes);

        // Close the scanner
        scanner.close();
    }
}
