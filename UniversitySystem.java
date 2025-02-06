
import java.util.ArrayList;

// Faculty class (Exists independently of a University)
class Faculty {
    private String name;
    private String specialization;

    // Constructor
    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Display faculty details
    public void displayFaculty() {
        System.out.println("  Faculty: " + name + " - Specialization: " + specialization);
    }
}

// Department class (Exists only within a University - Composition)
class Department {
    private String departmentName;

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // Display department details
    public void displayDepartment() {
        System.out.println("  Department: " + departmentName);
    }
}

// University class (Owns Departments and Aggregates Faculty)
class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties; // Aggregation

    // Constructor
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add department (Composition)
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display university details
    public void displayUniversity() {
        System.out.println("\nUniversity: " + universityName);
        
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayDepartment();
        }

        System.out.println("\nFaculty Members:");
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
        }
    }
}

// Main class to demonstrate Composition and Aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating a University
        University myUniversity = new University("Harvard University");

        // Adding Departments (Composition - Strong Ownership)
        myUniversity.addDepartment("Computer Science");
        myUniversity.addDepartment("Physics");

        // Creating Faculty Members (Exist Independently)
        Faculty profJohn = new Faculty("Dr. John", "Artificial Intelligence");
        Faculty profEmma = new Faculty("Dr. Emma", "Quantum Mechanics");

        // Adding Faculty to the University (Aggregation)
        myUniversity.addFaculty(profJohn);
        myUniversity.addFaculty(profEmma);

        // Display University details
        myUniversity.displayUniversity();

        // University is deleted (Departments are also removed, but Faculty remains independent)
    }
}

