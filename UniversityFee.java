public class UniversityFee {
    public static void main(String[] args) {
        // Input values
        double fee = 125000; // Original course fee in INR
        double discountPercent = 10; // Discount percentage

        // Calculate the discount and final fee
        double discount = (fee * discountPercent) / 100; // Discount amount
        double discountedFee = fee - discount; // Final fee after discount

        // Display the results
        System.out.println(
            "The discount amount is INR " + discount + 
            " and the final discounted fee is INR " + discountedFee
        );
    }
}
