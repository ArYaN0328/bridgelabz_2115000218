public class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable (shared among all vehicles)
    private static double registrationFee = 100.00; // Default registration fee

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update the registration fee for all vehicles
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method to test the Vehicle class
    public static void main(String[] args) {
        // Create instances of Vehicle
        Vehicle vehicle1 = new Vehicle("John Doe", "Car");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle");

        // Display vehicle details
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        // Update the registration fee for all vehicles
        Vehicle.updateRegistrationFee(120.00);

        // Display vehicle details again after updating the registration fee
        System.out.println("\nAfter updating registration fee:");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
