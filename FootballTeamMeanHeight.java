import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store the heights of the players (size 11)
        double[] heights = new double[11];
        
        // Get the height values from the user
        System.out.println("Enter the height of 11 players:");

        double sum = 0.0;

        // Take input for the heights of the 11 players
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; // Add each player's height to the sum
        }

        // Calculate the mean height
        double meanHeight = sum / 11;

        // Print the mean height
        System.out.println("The mean height of the football team is: " + meanHeight);

        scanner.close();
    }
}
