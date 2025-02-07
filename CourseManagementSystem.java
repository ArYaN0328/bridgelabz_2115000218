
// Superclass: Course
class Course {
    protected String courseName;
    protected int duration; // duration in hours
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    public void displayDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " hours");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // in percentage
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%" + ", Final Price: $" + finalPrice);
    }
}

// Main class to test the implementation
public class CourseManagementSystem {
    public static void main(String[] args) {
        Course basicCourse = new Course("Java Basics", 30);
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", 40, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full-Stack Development", 50, "Coursera", false, 200, 20);
        
        basicCourse.displayDetails();
        System.out.println();
        onlineCourse.displayDetails();
        System.out.println();
        paidCourse.displayDetails();
    }
}

