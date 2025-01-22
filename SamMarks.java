public class SamMarks {
    public static void main(String[] args) {
        int maths = 94;    // Marks in Maths
        int physics = 95;  // Marks in Physics
        int chemistry = 96; // Marks in Chemistry

        // Calculate total and average
        int totalMarks = maths + physics + chemistry;
        double average = totalMarks / 3.0;

        // Print the result
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
