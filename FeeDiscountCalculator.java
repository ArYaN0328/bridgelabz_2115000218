import java.util.Scanner; // Import Scanner class for user input

public class FeeDiscountCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for fee and discount percentage
        double fee;
        double discountPercent;

        // Prompt the user to enter the fee
        System.out.print("Enter the student fee (in INR): ");
        fee = input.nextDouble(); // Take user input for the fee

        // Prompt the user to enter the discount percentage
        System.out.print("Enter the discount percentage: ");
        discountPercent = input.nextDouble(); // Take user input for the discount percentage

        // Calculate the discount and final fee
        double discount = (fee * discountPercent) / 100; // Discount amount
        double discountedFee = fee - discount; // Final fee after discount

        // Display the results
        System.out.println(
            "The discount amount is INR " + discount + 
            " and the final discounted fee is INR " + discountedFee
        );

        // Close the Scanner
        input.close();
    }
}
