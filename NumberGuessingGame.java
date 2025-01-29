import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game introduction
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Please think of a number between 1 and 100, and I will try to guess it.");
        System.out.println("You can tell me if my guess is 'high', 'low', or 'correct'.");
        
        // Initialize variables for the game
        int low = 1;
        int high = 100;
        int guess = 0;
        boolean isGuessed = false;

        // Loop until the correct guess is made
        while (!isGuessed) {
            guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);
            
            // Receive user feedback
            String feedback = getUserFeedback(scanner);
            
            // Process feedback and adjust the range
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Hooray! I guessed your number correctly.");
                isGuessed = true;  // Exit the loop if the guess is correct
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;  // Adjust the high range
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;   // Adjust the low range
            } else {
                System.out.println("Invalid feedback. Please respond with 'high', 'low', or 'correct'.");
            }
        }

        scanner.close();
    }

    // Method to generate a random guess between low and high
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;  // Generate a number between low and high (inclusive)
    }

    // Method to get feedback from the user
    public static String getUserFeedback(Scanner scanner) {
        System.out.print("Is the guess too high, too low, or correct? ");
        return scanner.nextLine();
    }
}
