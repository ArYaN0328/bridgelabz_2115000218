public class EarthVolume {
    public static void main(String[] args) {
        // Radius of Earth
        double radiusKm = 6378; // in kilometers

        // Conversion factor: 1 kilometer = 0.621371 miles
        double conversionFactor = 0.621371;

        // Calculate volume in cubic kilometers
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        // Convert radius to miles
        double radiusMiles = radiusKm * conversionFactor;

        // Calculate volume in cubic miles
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        // Display the results
        System.out.println(
            "The volume of Earth in cubic kilometers is " + volumeKm3 +
            " and in cubic miles is " + volumeMiles3
        );
    }
}
