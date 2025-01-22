import java.util.Scanner; // Import Scanner class for user input

public class HeightConversion {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variable for height in centimeters
        double heightCm;

        // Prompt the user to enter the height in centimeters
        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble(); // Take user input for height

        // Conversion factors
        double cmPerInch = 2.54; // 1 inch = 2.54 cm
        double inchesPerFoot = 12; // 1 foot = 12 inches

        // Convert height to inches
        double totalInches = heightCm / cmPerInch;

        // Convert inches to feet and remaining inches
        int feet = (int) totalInches / (int) inchesPerFoot; // Number of feet
        double remainingInches = totalInches % inchesPerFoot; // Remaining inches

        // Display the results
        System.out.println("Your Height in cm is " + heightCm + 
                           " while in feet is " + feet + " and inches is " + remainingInches);

        // Close the Scanner
        input.close();
    }
}
