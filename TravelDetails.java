import java.util.Scanner; // Import Scanner class for user input

public class TravelDetails {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for user details and journey information
        String name, fromCity, viaCity, toCity;
        double distanceFromToVia, distanceViaToFinalCity, timeTakenFromToVia, timeTakenViaToFinalCity;

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        name = input.nextLine();

        // Prompt the user for cities
        System.out.print("Enter the city you are starting from: ");
        fromCity = input.nextLine();

        System.out.print("Enter the city you will travel via: ");
        viaCity = input.nextLine();

        System.out.print("Enter the destination city: ");
        toCity = input.nextLine();

        // Prompt the user for distances
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        distanceFromToVia = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        distanceViaToFinalCity = input.nextDouble();

        // Prompt the user for time taken
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (in hours): ");
        timeTakenFromToVia = input.nextDouble();

        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (in hours): ");
        timeTakenViaToFinalCity = input.nextDouble();

        // Calculate total distance and total time taken
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        double totalTime = timeTakenFromToVia + timeTakenViaToFinalCity;

        // Display the results
        System.out.println("\n--- Travel Details ---");
        System.out.println("Name: " + name);
        System.out.println("Traveling from: " + fromCity);
        System.out.println("Via: " + viaCity);
        System.out.println("To: " + toCity);
        System.out.println("Distance from " + fromCity + " to " + viaCity + ": " + distanceFromToVia + " miles");
        System.out.println("Distance from " + viaCity + " to " + toCity + ": " + distanceViaToFinalCity + " miles");
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time taken from " + fromCity + " to " + viaCity + ": " + timeTakenFromToVia + " hours");
        System.out.println("Time taken from " + viaCity + " to " + toCity + ": " + timeTakenViaToFinalCity + " hours");
        System.out.println("Total Time Taken: " + totalTime + " hours");

        // Close the Scanner
        input.close();
    }
}
