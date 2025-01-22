import java.util.Scanner; // Import Scanner class for user input

public class KilometerToMiles {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare a variable to store kilometers
        double km;

        // Prompt the user to enter the distance in kilometers
        System.out.print("Enter the distance in kilometers: ");
        km = input.nextDouble(); // Take user input

        // Conversion factor: 1 mile = 1.6 km
        double miles = km / 1.6;

        // Display the result
        System.out.println("The total miles is " + miles + " mile(s) for the given " + km + " km.");
        
        // Close the Scanner
        input.close();
    }
}
