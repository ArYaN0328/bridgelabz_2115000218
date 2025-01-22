import java.util.Scanner; // Import Scanner class for user input

public class TemperatureCon {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare a variable for temperature in Fahrenheit
        double fahrenheit;

        // Prompt the user to enter the temperature in Fahrenheit
        System.out.print("Enter the temperature in Fahrenheit: ");
        fahrenheit = input.nextDouble(); // Take user input for temperature in Fahrenheit

        // Convert Fahrenheit to Celsius
        double celsius = (fahrenheit - 32) * 5 / 9;

        // Display the result
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius");

        // Close the Scanner
        input.close();
    }
}
