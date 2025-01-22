public class ProfitLossCalculator {
    public static void main(String[] args) {
        // Input values
        double costPrice = 129; // Cost Price in INR
        double sellingPrice = 191; // Selling Price in INR

        // Calculate profit and profit percentage
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;

        // Display the results using a single print statement
        System.out.println(
            "The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" +
            "The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%"
        );
    }
}
