import java.util.Scanner; // Import Scanner class for user input

public class TotalPriceCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Declare variables for unit price and quantity
        double unitPrice;
        int quantity;

        // Prompt the user to enter the unit price
        System.out.print("Enter the unit price of the item (in INR): ");
        unitPrice = input.nextDouble(); // Take user input for unit price

        // Prompt the user to enter the quantity
        System.out.print("Enter the quantity to be bought: ");
        quantity = input.nextInt(); // Take user input for quantity

        // Calculate the total price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.println("The total purchase price is INR " + totalPrice + 
                           " if the quantity " + quantity + 
                           " and unit price is INR " + unitPrice);

        // Close the Scanner
        input.close();
    }
}
