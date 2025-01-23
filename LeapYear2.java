import java.util.Scanner;

public class LeapYear2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();

        // Checking for valid year and leap year condition in a single if statement
        if (year >= 1582 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))) {
            System.out.println(year + " is a Leap Year.");
        } else if (year < 1582) {
            System.out.println("Invalid year! Please enter a year greater than or equal to 1582.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
    }
}
