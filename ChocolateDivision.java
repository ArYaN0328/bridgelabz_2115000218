import java.util.Scanner;

public class ChocolateDivision {

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor; // Chocolates per child
        int remainder = number % divisor; // Remaining chocolates
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of chocolates and children from the user
        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Validate input for zero children to avoid division by zero
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero. Please enter a valid value.");
        } else {
            // Call the method to calculate quotient and remainder
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            // Display the results
            System.out.println("Each child will get " + result[0] + " chocolates.");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        scanner.close();
    }
}
