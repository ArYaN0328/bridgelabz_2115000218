import java.util.Scanner; // Import Scanner class for user input

public class TotalIncomeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for salary and bonus
        double salary, bonus;

        // Prompt the user to enter the salary
        System.out.print("Enter your salary (in INR): ");
        salary = input.nextDouble(); // Take user input for salary

        // Prompt the user to enter the bonus
        System.out.print("Enter your bonus (in INR): ");
        bonus = input.nextDouble(); // Take user input for bonus

        // Calculate total income
        double totalIncome = salary + bonus;

        // Display the results
        System.out.println("The salary is INR " + salary + 
                           " and bonus is INR " + bonus + 
                           ". Hence Total Income is INR " + totalIncome);

        // Close the Scanner
        input.close();
    }
}
