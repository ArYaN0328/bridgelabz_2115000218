
// Superclass: Person
class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher, Subject: " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    private int grade;
    
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String department;
    
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Department: " + department);
    }
}

// Main class to test the implementation
public class SchoolSystem {
    public static void main(String[] args) {
        Person teacher = new Teacher("Alice", 35, "Mathematics");
        Person student = new Student("Bob", 16, 10);
        Person staff = new Staff("Charlie", 40, "Administration");
        
        teacher.displayDetails();
        System.out.println();
        student.displayDetails();
        System.out.println();
        staff.displayDetails();
    }
}

