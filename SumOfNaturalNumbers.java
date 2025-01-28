import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to calculate the sum of n natural numbers
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // Add each number to the sum
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        
        // Validate the input
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Call the method to calculate the sum and display the result
            int sum = findSum(n);
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }
        
        scanner.close();
    }
}
