
// Superclass: Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed;
    
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    
    public void charge() {
        System.out.println(model + " is charging...");
    }
}

// Subclass: PetrolVehicle implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    
    @Override
    public void refuel() {
        System.out.println(model + " is refueling...");
    }
}

// Main class to test the implementation
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180);
        
        ev.displayInfo();
        ev.charge();
        System.out.println();
        
        pv.displayInfo();
        pv.refuel();
    }
}

