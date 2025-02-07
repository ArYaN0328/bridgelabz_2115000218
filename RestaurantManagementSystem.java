
// Superclass: Person
class Person {
    protected String name;
    protected int id;
    
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {
    private String specialty;
    
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    private int tablesAssigned;
    
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
}

// Main class to test the implementation
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Worker chef = new Chef("John", 101, "Italian");
        Worker waiter = new Waiter("Alice", 102, 5);
        
        chef.performDuties();
        waiter.performDuties();
    }
}

