import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the choice of conversion from the user
        System.out.println("Choose the conversion type:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice (1/2): ");
        int choice = scanner.nextInt();

        // Take the temperature input from the user
        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        // Perform the conversion based on the user's choice
        if (choice == 1) {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit is equal to " + celsius + " Celsius.");
        } else if (choice == 2) {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
        } else {
            System.out.println("Invalid choice! Please choose either 1 or 2.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
