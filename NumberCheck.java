import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define an array to store 5 numbers
        int[] numbers = new int[5];

        // Get user input for the 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Loop through the array and check each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            // Check if the number is positive, negative, or zero
            if (num > 0) {
                // If the number is positive, check if it is even or odd
                if (num % 2 == 0) {
                    System.out.println(num + " is positive and even.");
                } else {
                    System.out.println(num + " is positive and odd.");
                }
            } else if (num < 0) {
                // If the number is negative
                System.out.println(num + " is negative.");
            } else {
                // If the number is zero
                System.out.println(num + " is zero.");
            }
        }

        // Compare the first and last elements of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("The first and last elements are equal.");
        } else if (first > last) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        scanner.close();
    }
}
