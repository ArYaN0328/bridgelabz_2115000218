import java.util.Scanner;

public class TravelCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter side 1 of the triangular park (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 of the triangular park (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 of the triangular park (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculating perimeter and rounds
        double perimeter = side1 + side2 + side3;
        int totalRounds = (int) Math.ceil(5000 / perimeter);

        // Printing results
        System.out.println("\nThe total number of rounds the athlete will run is " + totalRounds + " to complete 5 km");
    }
}
