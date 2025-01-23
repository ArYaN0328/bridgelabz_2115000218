import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for salary and years of service
        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter the employee's years of service: ");
        int yearsOfService = scanner.nextInt();

        // Check if the employee qualifies for a bonus (more than 5 years of service)
        double bonus = 0;
        if (yearsOfService > 5) {
            bonus = salary * 0.05; // 5% bonus
        }

        // Print the bonus amount
        System.out.println("The bonus amount is: " + bonus);

        scanner.close();
    }
}
