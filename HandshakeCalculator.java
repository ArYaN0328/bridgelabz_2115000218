import java.util.Scanner; // Import Scanner class for user input

public class HandshakeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variable for the number of students
        int numberOfStudents;

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        numberOfStudents = input.nextInt(); // Take user input for the number of students

        // Calculate the maximum number of handshakes using the combination formula
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is " + handshakes + ".");

        // Close the Scanner
        input.close();
    }
}
