import java.util.Scanner;

public class MaximumOfThreeNumbers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Call function to take input from user
        int num1 = getInput(scanner, "Enter the first number: ");
        int num2 = getInput(scanner, "Enter the second number: ");
        int num3 = getInput(scanner, "Enter the third number: ");
        
        // Call function to find the maximum value
        int max = findMaximum(num1, num2, num3);
        
        // Output the result
        System.out.println("The maximum number is: " + max);

        // Close scanner to avoid resource leak
        scanner.close();
    }

    // Function to take input from the user
    public static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to find the maximum of three numbers
    public static int findMaximum(int num1, int num2, int num3) {
        int max = num1;  // Assume the first number is the maximum
        if (num2 > max) {
            max = num2;  // Update max if num2 is greater
        }
        if (num3 > max) {
            max = num3;  // Update max if num3 is greater
        }
        return max;
    }
}
