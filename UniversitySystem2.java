
import java.util.ArrayList;

// Course class (Aggregation by Professor)
class Course {
    private String courseName;
    private ArrayList<Student> students;  // Association: Students enroll in multiple courses
    private ArrayList<Professor> professors;  // Aggregation: Professors teach courses

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    // Add student to the course
    public void addStudent(Student student) {
        students.add(student);
    }

    // Add professor to the course
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    // Display course details
    public void displayCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Students Enrolled:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
        System.out.println("Professors Teaching:");
        for (Professor professor : professors) {
            System.out.println("  - " + professor.getName());
        }
    }
}

// Student class (Can enroll in multiple courses)
class Student {
    private String name;
    private ArrayList<Course> courses;  // Association: A student can enroll in multiple courses

    // Constructor
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Get student details
    public String getName() {
        return name;
    }

    // Enroll in a course (Communication)
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);  // Add this student to the course as well
        System.out.println(name + " has enrolled in " + course.courseName);
    }

    // Display courses the student is enrolled in
    public void displayCourses() {
        System.out.println("\n" + name + "'s Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("  - " + course.courseName);
        }
    }
}

// Professor class (Teaches multiple courses)
class Professor {
    private String name;
    private ArrayList<Course> courses;  // Aggregation: A professor can teach multiple courses

    // Constructor
    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Get professor details
    public String getName() {
        return name;
    }

    // Assign a professor to a course (Communication)
    public void assignProfessor(Course course) {
        courses.add(course);
        course.addProfessor(this);  // Add this professor to the course as well
        System.out.println(name + " has been assigned to teach " + course.courseName);
    }

    // Display courses the professor teaches
    public void displayCourses() {
        System.out.println("\n" + name + "'s Teaching Courses:");
        for (Course course : courses) {
            System.out.println("  - " + course.courseName);
        }
    }
}

// Main class to demonstrate the University Management System
public class UniversitySystem2 {
    public static void main(String[] args) {
        // Creating courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Computer Science");
        Course course3 = new Course("Physics");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Creating professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Students enrolling in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course2);
        student2.enrollCourse(course3);

        // Professors teaching courses
        professor1.assignProfessor(course1);
        professor1.assignProfessor(course2);
        professor2.assignProfessor(course3);

        // Displaying student courses
        student1.displayCourses();
        student2.displayCourses();

        // Displaying professor courses
        professor1.displayCourses();
        professor2.displayCourses();

        // Displaying course details (students and professors)
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        course3.displayCourseDetails();
    }
}

