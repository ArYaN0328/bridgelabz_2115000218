import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUM_EMPLOYEES = 10;
        double[] salaries = new double[NUM_EMPLOYEES];
        double[] yearsOfService = new double[NUM_EMPLOYEES];
        double[] bonuses = new double[NUM_EMPLOYEES];
        double[] newSalaries = new double[NUM_EMPLOYEES];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Input loop to get salary and years of service for 10 employees
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");

            // Validate salary input
            while (true) {
                System.out.print("Enter salary: ");
                double salary = scanner.nextDouble();
                if (salary > 0) {
                    salaries[i] = salary;
                    break;
                } else {
                    System.out.println("Invalid salary. Please enter a positive number.");
                }
            }

            // Validate years of service input
            while (true) {
                System.out.print("Enter years of service: ");
                double years = scanner.nextDouble();
                if (years >= 0) {
                    yearsOfService[i] = years;
                    break;
                } else {
                    System.out.println("Invalid years of service. Please enter a non-negative number.");
                }
            }
        }

        // Calculate bonuses, new salaries, and totals
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Output results
        System.out.println("\nEmployee Details with Bonus and New Salary:");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "Employee", "Salary", "Years", "Bonus", "New Salary");
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-10.2f%n", 
                              (i + 1), salaries[i], yearsOfService[i], bonuses[i], newSalaries[i]);
        }

        // Print total payouts
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
