import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the number input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Create an array to store the multiplication results for 6 to 9
        int[] multiplicationResult = new int[4];  // Array to store results for 6 to 9

        // Use a for loop to calculate the multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;  // Store the result in the array
        }

        // Display the multiplication results
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        scanner.close();
    }
}
