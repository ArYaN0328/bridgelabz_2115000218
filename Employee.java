// Parent class: Employee
class Employee {
    // Public member
    public int employeeID;

    // Protected member
    protected String department;

    // Private member
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void modifySalary(double newSalary) {
        if (newSalary >= 0) {
            salary = newSalary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }

    // Method to get salary (optional)
    public double getSalary() {
        return salary;
    }
}

// Subclass: Manager
class Manager extends Employee {
    private String managerialRole; // Additional property for Manager

    // Constructor
    public Manager(int employeeID, String department, double salary, String managerialRole) {
        super(employeeID, department, salary);  // Call the constructor of the parent class
        this.managerialRole = managerialRole;
    }

    // Method to display manager details
    public void displayManagerDetails() {
        displayEmployeeDetails();  // Call the parent class method to display common details
        System.out.println("Managerial Role: " + managerialRole);
    }

    // Method to get the managerial role
    public String getManagerialRole() {
        return managerialRole;
    }
}

// Main class to test the functionality
public class EmployeeRecords {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee1 = new Employee(101, "IT", 55000.00);
        
        // Display employee details
        employee1.displayEmployeeDetails();

        // Modify salary using the public method
        employee1.modifySalary(60000.00);
        System.out.println("\nUpdated Salary: $" + employee1.getSalary());

        // Create a Manager object
        Manager manager1 = new Manager(102, "HR", 80000.00, "HR Manager");

        // Display manager details
        manager1.displayManagerDetails();

        // Modify manager salary
        manager1.modifySalary(85000.00);
        System.out.println("\nUpdated Manager Salary: $" + manager1.getSalary());
    }
}
