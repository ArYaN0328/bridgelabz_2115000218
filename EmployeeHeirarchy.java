
// Superclass: Employee
abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public abstract void displayDetails();
}

// Subclass: Manager
class Manager extends Employee {
    private int teamSize;
    
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Manager: " + name + ", ID: " + id + ", Salary: " + salary + ", Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Developer: " + name + ", ID: " + id + ", Salary: " + salary + ", Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    private String university;
    
    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Intern: " + name + ", ID: " + id + ", Salary: " + salary + ", University: " + university);
    }
}

// Main class to demonstrate polymorphism
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice", 101, 80000, 10),
            new Developer("Bob", 102, 60000, "Java"),
            new Intern("Charlie", 103, 20000, "MIT")
        };
        
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}

