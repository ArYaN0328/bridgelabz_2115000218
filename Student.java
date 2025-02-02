// Parent class: Student
class Student {
    // Public member
    public int rollNumber;

    // Protected member
    protected String name;

    // Private member
    private double CGPA;

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        if(CGPA >= 0.0 && CGPA <= 4.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {
    private String thesisTitle;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTitle) {
        super(rollNumber, name, CGPA);  // Call the constructor of the parent class
        this.thesisTitle = thesisTitle;
    }

    // Method to display postgraduate student details
    public void displayPostgraduateDetails() {
        displayStudentDetails();  // Call the parent class method to display common details
        System.out.println("Thesis Title: " + thesisTitle);
    }

    // Access the protected 'name' member directly in subclass
    public void modifyName(String newName) {
        this.name = newName;
    }
}

// Main class to test the functionality
public class UniversityManagement {
    public static void main(String[] args) {
        // Create a student
        Student student1 = new Student(101, "Alice", 3.8);
        
        // Display student details
        student1.displayStudentDetails();
        
        // Modify and display CGPA
        student1.setCGPA(3.9);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        
        // Create a postgraduate student
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 3.7, "AI and Machine Learning");

        // Display postgraduate student details
        pgStudent.displayPostgraduateDetails();

        // Modify name (protected member) via subclass method
        pgStudent.modifyName("Robert");
        System.out.println("Updated Name: " + pgStudent.name);
    }
}
