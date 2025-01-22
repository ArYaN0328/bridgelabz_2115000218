import java.util.Scanner;

public class Weight{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        // Converting pounds to kilograms
        double weightInKg = weightInPounds / 2.2;

        // Printing results
        System.out.println("\nThe weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKg);
    }
}
