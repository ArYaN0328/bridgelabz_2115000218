import java.util.Scanner;

public class Countdown2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input value for the countdown
        System.out.print("Enter the starting value for the countdown: ");
        int counter = scanner.nextInt();

        // Countdown using a for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Rocket launch!");

        scanner.close();
    }
}
