import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        String input = getInput(scanner);

        // Check if the string is a palindrome
        boolean isPalindrome = checkPalindrome(input);

        // Display the result
        displayResult(input, isPalindrome);

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to take input from the user
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to check if the string is a palindrome
    public static boolean checkPalindrome(String str) {
        // Remove spaces and convert the string to lowercase for case-insensitive comparison
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        // Check if the string reads the same forward and backward
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It is a palindrome
    }

    // Function to display the result
    public static void displayResult(String str, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
}
