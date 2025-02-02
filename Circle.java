public class Circle {
    private double radius;

    // Default constructor (sets a default radius)
    public Circle() {
        this(1.0); // Calls the parameterized constructor with a default value
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Display Circle details
    public void displayInfo() {
        System.out.println("Circle Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public static void main(String[] args) {
        // Using default constructor
        Circle circle1 = new Circle();
        circle1.displayInfo();

        System.out.println();

        // Using parameterized constructor
        Circle circle2 = new Circle(5.5);
        circle2.displayInfo();
    }
}
