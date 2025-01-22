import java.util.Scanner; // Import Scanner class for user input

public class IntOperation {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for a, b, and c
        int a, b, c;

        // Prompt the user to enter the values of a, b, and c
        System.out.print("Enter the value of a: ");
        a = input.nextInt(); // Take user input for a
        System.out.print("Enter the value of b: ");
        b = input.nextInt(); // Take user input for b
        System.out.print("Enter the value of c: ");
        c = input.nextInt(); // Take user input for c

        // Perform the integer operations
        int result1 = a + b * c;       // Multiplication (*) has higher precedence than addition (+)
        int result2 = a * b + c;       // Multiplication (*) is performed first, followed by addition (+)
        int result3 = c + a / b;       // Division (/) has higher precedence than addition (+)
        int result4 = a % b + c;       // Modulus (%) is performed first, followed by addition (+)

        // Display the results
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        // Close the Scanner
        input.close();
    }
}
