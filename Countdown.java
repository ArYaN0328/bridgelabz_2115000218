// Program to count down from a user input value to 1 for a rocket launch
import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input value for the countdown
        System.out.print("Enter the starting value for the countdown: ");
        int counter = scanner.nextInt();

        // Countdown using a while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Rocket launch!");

        scanner.close();
    }
}
