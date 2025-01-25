import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights for the three friends
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + friends[i] + ":");
            
            // Input and validate age
            while (true) {
                System.out.print("Age: ");
                ages[i] = scanner.nextInt();
                if (ages[i] > 0) break;
                else System.out.println("Invalid age. Please enter a positive value.");
            }

            // Input and validate height
            while (true) {
                System.out.print("Height (in cm): ");
                heights[i] = scanner.nextDouble();
                if (heights[i] > 0) break;
                else System.out.println("Invalid height. Please enter a positive value.");
            }
        }

        // Find the youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        // Find the tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("The youngest friend is " + friends[youngestIndex] + " with an age of " + ages[youngestIndex] + " years.");
        System.out.println("The tallest friend is " + friends[tallestIndex] + " with a height of " + heights[tallestIndex] + " cm.");

        scanner.close();
    }
}
