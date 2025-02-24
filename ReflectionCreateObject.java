public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

import java.lang.reflect.Constructor;

public class ReflectionCreateObject {
    public static void main(String[] args) {
        try {
            // Load the class dynamically
            Class<?> cls = Class.forName("Student");

            // Get the constructor with parameters (String, int)
            Constructor<?> constructor = cls.getConstructor(String.class, int.class);

            // Create an instance dynamically
            Object studentInstance = constructor.newInstance("Alice", 21);

            // Invoke method to confirm object creation
            cls.getMethod("displayInfo").invoke(studentInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
