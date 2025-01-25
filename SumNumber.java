import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define an array of 10 elements to store numbers and a variable to store the total sum
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Use an infinite while loop to get user input
        while (true) {
            // Get user input
            System.out.print("Enter a number (enter 0 or negative to stop): ");
            double input = scanner.nextDouble();

            // Check if the input is 0 or negative, or if the array has reached its max size
            if (input <= 0 || index == 10) {
                break;
            }

            // Store the number in the array and increment the index
            numbers[index] = input;
            index++;
        }

        // Calculate the total sum of the numbers entered
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display the numbers entered and the total sum
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("\nTotal sum: " + total);

        scanner.close();
    }
}
