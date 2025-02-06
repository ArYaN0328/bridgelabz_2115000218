import java.util.ArrayList;

// Course class (Has multiple enrolled students)
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Enroll a student
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this); // Bidirectional relationship
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Display enrolled students
    public void displayStudents() {
        System.out.println("\nCourse: " + courseName);
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Student class (Can enroll in multiple courses)
class Student {
    private String name;
    private ArrayList<Course> courses;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Get student name
    public String getName() {
        return name;
    }

    // Add a course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Display enrolled courses
    public void displayCourses() {
        System.out.println("\nStudent: " + name);
        for (Course course : courses) {
            System.out.println("  - Enrolled in: " + course.getCourseName());
        }
    }
}

// School class (Aggregates multiple Students)
class School {
    private String schoolName;
    private ArrayList<Student> students;

    // Constructor
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Add student to school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display school details
    public void displaySchool() {
        System.out.println("\nSchool: " + schoolName);
        for (Student student : students) {
            System.out.println("  - Student: " + student.getName());
        }
    }
}

// Main class to demonstrate Association and Aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        // Creating a School (Aggregation)
        School mySchool = new School("Greenwood High");

        // Creating Students (Exist independently)
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Adding students to the school (Aggregation)
        mySchool.addStudent(alice);
        mySchool.addStudent(bob);

        // Creating Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses (Association)
        math.enrollStudent(alice);
        math.enrollStudent(bob);
        science.enrollStudent(alice);

        // Displaying details
        mySchool.displaySchool();  // Aggregation demonstration
        alice.displayCourses();    // Association demonstration
        bob.displayCourses();
        math.displayStudents();
        science.displayStudents();
    }
}