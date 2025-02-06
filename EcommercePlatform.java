import java.util.ArrayList;

// Product class (Aggregated by Order)
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Get product details
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class (Contains multiple Products)
class Order {
    private String orderId;
    private ArrayList<Product> products;  // Aggregation: Order contains multiple products

    // Constructor
    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    // Add product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Display order details
    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Products in Order:");
        double totalAmount = 0;
        for (Product product : products) {
            System.out.println("  - " + product.getName() + ": $" + product.getPrice());
            totalAmount += product.getPrice();
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

// Customer class (Places Orders)
class Customer {
    private String name;
    private ArrayList<Order> orders;  // Association: Customer can place multiple orders

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // Get customer details
    public String getName() {
        return name;
    }

    // Place an order (communication)
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " has placed an order with Order ID: " + order.orderId);
    }

    // Display all orders placed by the customer
    public void displayOrders() {
        System.out.println("\n" + name + "'s Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

// Main class to demonstrate the E-commerce Platform system
public class EcommercePlatform {
    public static void main(String[] args) {
        // Creating products
        Product product1 = new Product("Laptop", 800);
        Product product2 = new Product("Smartphone", 500);
        Product product3 = new Product("Headphones", 100);

        // Creating a customer
        Customer customer = new Customer("John Doe");

        // Creating an order for the customer
        Order order1 = new Order("ORD001");
        order1.addProduct(product1);
        order1.addProduct(product2);

        // Customer places the order (Communication between customer and order)
        customer.placeOrder(order1);

        // Creating another order for the customer
        Order order2 = new Order("ORD002");
        order2.addProduct(product2);
        order2.addProduct(product3);

        // Customer places another order
        customer.placeOrder(order2);

        // Display customer's orders
        customer.displayOrders();
    }
}
