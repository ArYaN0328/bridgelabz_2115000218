import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a date input in the format yyyy-MM-dd
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the input string into a LocalDate object
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Perform the date arithmetic: add 7 days, 1 month, and 2 years, then subtract 3 weeks
        LocalDate resultDate = date.plusDays(7)           // Add 7 days
                                   .plusMonths(1)       // Add 1 month
                                   .plusYears(2)        // Add 2 years
                                   .minusWeeks(3);      // Subtract 3 weeks

        // Display the result
        System.out.println("Original date: " + date);
        System.out.println("After adding 7 days, 1 month, and 2 years, then subtracting 3 weeks: " + resultDate);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
