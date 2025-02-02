public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared among all products)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment the total products count when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display the total number of products created
    public static void displayTotalProducts() {
        System.out.println("Total products created: " + totalProducts);
    }

    // Main method to test the Product class
    public static void main(String[] args) {
        // Create instances of Product
        Product product1 = new Product("Laptop", 799.99);
        Product product2 = new Product("Smartphone", 599.99);
        
        // Display product details
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        // Display total products created
        Product.displayTotalProducts();
    }
}
