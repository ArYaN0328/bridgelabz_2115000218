import java.util.Scanner; // Import Scanner class for user input

public class Distancecon {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variable for distance in feet
        double distanceInFeet;

        // Prompt the user to enter the distance in feet
        System.out.print("Enter the distance in feet: ");
        distanceInFeet = input.nextDouble(); // Take user input for distance in feet

        // Conversion factors
        double feetPerYard = 3; // 1 yard = 3 feet
        double yardsPerMile = 1760; // 1 mile = 1760 yards

        // Convert distance to yards
        double distanceInYards = distanceInFeet / feetPerYard;

        // Convert distance to miles
        double distanceInMiles = distanceInYards / yardsPerMile;

        // Display the results
        System.out.println("The distance of " + distanceInFeet + " feet is equal to " + 
                           distanceInYards + " yards and " + distanceInMiles + " miles.");

        // Close the Scanner
        input.close();
    }
}
