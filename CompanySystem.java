
import java.util.ArrayList;

// Employee class (Exists only within a Department)
class Employee {
    private String name;
    private String position;

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Display employee details
    public void displayEmployee() {
        System.out.println("   Employee: " + name + " - " + position);
    }
}

// Department class (Exists only within a Company)
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Display department details
    public void displayDepartment() {
        System.out.println(" Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

// Company class (Owns Departments and Employees - Composition)
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    // Constructor
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Add department
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Get department by index
    public Department getDepartment(int index) {
        return departments.get(index);
    }

    // Display company details
    public void displayCompany() {
        System.out.println("\nCompany: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }
}

// Main class to demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {
        // Creating a Company
        Company myCompany = new Company("TechCorp");

        // Adding Departments
        myCompany.addDepartment("IT");
        myCompany.addDepartment("HR");

        // Adding Employees to Departments
        myCompany.getDepartment(0).addEmployee("Alice", "Software Engineer");
        myCompany.getDepartment(0).addEmployee("Bob", "System Administrator");
        myCompany.getDepartment(1).addEmployee("Charlie", "HR Manager");

        // Display company structure
        myCompany.displayCompany();

        // Company goes out of scope and is deleted, removing all Departments and Employees
    }
}

