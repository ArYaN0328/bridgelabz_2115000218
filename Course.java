public class Course {
    // Instance variables
    private String courseName;
    private int duration; // Duration in hours or weeks, depending on your preference
    private double fee;

    // Class variable (shared among all courses)
    private static String instituteName = "Default Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    // Class method to update the institute name for all courses
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method to test the Course class
    public static void main(String[] args) {
        // Create instances of Course
        Course course1 = new Course("Java Programming", 8, 199.99);
        Course course2 = new Course("Data Structures", 6, 149.99);
        
        // Display course details
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        
        // Update the institute name for all courses
        Course.updateInstituteName("Tech Academy");
        
        // Display course details again after updating the institute name
        System.out.println("\nAfter updating institute name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
