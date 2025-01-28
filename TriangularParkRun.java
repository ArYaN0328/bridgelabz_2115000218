import java.util.Scanner;

public class TriangularParkRun {
    
    // Method to calculate the number of rounds needed to complete the target distance
    public static double calculateRounds(double side1, double side2, double side3, double targetDistanceKm) {
        // Calculate the perimeter of the triangular park
        double perimeter = side1 + side2 + side3;
        
        // Convert the target distance from kilometers to meters
        double targetDistanceMeters = targetDistanceKm * 1000;
        
        // Calculate the number of rounds
        return targetDistanceMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for the three sides of the triangular park
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();
        
        // Define the target distance in kilometers
        double targetDistanceKm = 5.0;
        
        // Calculate the number of rounds needed
        double rounds = calculateRounds(side1, side2, side3, targetDistanceKm);
        
        // Display the result
        System.out.printf("The athlete needs to complete %.2f rounds to run 5 km.%n", rounds);
        
        scanner.close();
    }
}
