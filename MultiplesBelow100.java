// Program to find all multiples of a user-input number below 100
import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input value for the variable `number`
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Loop backward from 100 to 1
        System.out.println("Multiples of " + number + " below 100:");
        for (int i = 100; i >= 1; i--) {
            // Check if `i` is a multiple of `number`
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}