import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for n
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the input is a valid natural number
        if (n <= 0) {
            System.out.println("Please enter a positive integer (natural number).");
        } else {
            // Compute the sum using the formula
            int formulaSum = n * (n + 1) / 2;

            // Compute the sum using a for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // Display both results
            System.out.println("Sum using the formula n*(n+1)/2: " + formulaSum);
            System.out.println("Sum using the for loop: " + loopSum);

            // Compare the results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is an error in the computations.");
            }
        }

        scanner.close();
    }
}
