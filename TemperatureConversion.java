import java.util.Scanner; // Import Scanner class for user input

public class TemperatureConversion {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare a variable for temperature in Celsius
        double celsius;

        // Prompt the user to enter the temperature in Celsius
        System.out.print("Enter the temperature in Celsius: ");
        celsius = input.nextDouble(); // Take user input for temperature in Celsius

        // Convert Celsius to Fahrenheit
        double fahrenheit = (celsius * 9 / 5) + 32;

        // Display the result
        System.out.println("The " + celsius + " Celsius is " + fahrenheit + " Fahrenheit");

        // Close the Scanner
        input.close();
    }
}
