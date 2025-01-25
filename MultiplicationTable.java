import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number for which we need the multiplication table
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Define an array to store the results of the multiplication table
        int[] multiplicationTable = new int[10];

        // Fill the array with multiplication results
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("Multiplication table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        scanner.close();
    }
}
