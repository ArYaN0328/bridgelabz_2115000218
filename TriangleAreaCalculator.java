import java.util.Scanner; // Import Scanner class for user input

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for base and height
        double base, height;

        // Prompt the user to enter the base and height of the triangle
        System.out.print("Enter the base of the triangle in inches: ");
        base = input.nextDouble(); // Take user input for base

        System.out.print("Enter the height of the triangle in inches: ");
        height = input.nextDouble(); // Take user input for height

        // Calculate the area of the triangle in square inches
        double areaInInches = 0.5 * base * height;

        // Convert the area from square inches to square centimeters
        // 1 square inch = 6.4516 square centimeters
        double areaInCm = areaInInches * 6.4516;

        // Display the results
        System.out.println("The area of the triangle is " + areaInInches + " square inches or " + areaInCm + " square centimeters.");

        // Close the Scanner
        input.close();
    }
}
