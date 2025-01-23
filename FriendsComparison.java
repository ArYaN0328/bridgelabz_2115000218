import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for ages
        System.out.print("Enter the age of Amar: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = scanner.nextInt();

        // Taking user input for heights
        System.out.print("Enter the height of Amar: ");
        double heightAmar = scanner.nextDouble();
        System.out.print("Enter the height of Akbar: ");
        double heightAkbar = scanner.nextDouble();
        System.out.print("Enter the height of Anthony: ");
        double heightAnthony = scanner.nextDouble();

        // Finding the youngest friend
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        if (youngestAge == ageAmar) {
            System.out.println("The youngest friend is Amar.");
        } else if (youngestAge == ageAkbar) {
            System.out.println("The youngest friend is Akbar.");
        } else {
            System.out.println("The youngest friend is Anthony.");
        }

        // Finding the tallest friend
        double tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        if (tallestHeight == heightAmar) {
            System.out.println("The tallest friend is Amar.");
        } else if (tallestHeight == heightAkbar) {
            System.out.println("The tallest friend is Akbar.");
        } else {
            System.out.println("The tallest friend is Anthony.");
        }
    }
}
