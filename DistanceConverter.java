public class DistanceConverter {
    public static void main(String[] args) {
        double kilometers = 10.8; // Distance in kilometers
        double conversionFactor = 1.6; // 1 km = 1.6 miles

        // Calculate distance in miles
        double miles = kilometers / conversionFactor;

        // Print the result
        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
