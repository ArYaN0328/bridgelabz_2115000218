
import java.util.*;
public class ShoppingCart {
// HashMap to store product prices
private Map<String, Double> productPrices = new HashMap<>();
35
// LinkedHashMap to maintain the order of items added (Product -> Quantity)
private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
// TreeMap to display items sorted by price
private TreeMap<Double, String> sortedItemsByPrice = new TreeMap<>();
// Method to add a product to the catalog
public void addProductToCatalog(String product, double price) {
productPrices.put(product, price);
}
// Method to add a product to the cart
public void addToCart(String product, int quantity) {
if (!productPrices.containsKey(product)) {
System.out.println("Product not found in catalog: " + product);
return;
}
// Add or update the product quantity
cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
}
36
// Method to display the items in the order they were added
public void displayCartItems() {
System.out.println("Items in the cart (order added):");
for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
String product = entry.getKey();
int quantity = entry.getValue();
System.out.println("Product: " + product + ", Quantity: " + quantity
+ ", Price: " + productPrices.get(product));
}
}
// Method to display items sorted by price
public void displayItemsSortedByPrice() {
System.out.println("Items sorted by price:");
for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
sortedItemsByPrice.put(entry.getValue(), entry.getKey());
}
for (Map.Entry<Double, String> entry : sortedItemsByPrice.entrySet()) {
String product = entry.getValue();
double price = entry.getKey();
System.out.println("Product: " + product + ", Price: " + price + ",
Quantity: " + cartItems.getOrDefault(product, 0));
37
}
}
// Method to display the total price of the cart
public void displayTotalPrice() {
double total = 0.0;
for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
String product = entry.getKey();
int quantity = entry.getValue();
total += productPrices.get(product) * quantity;
}
System.out.println("Total price of the cart: $" + total);
}
public static void main(String[] args) {
ShoppingCart cart = new ShoppingCart();
// Adding products to the catalog
cart.addProductToCatalog("Apple", 1.20);
cart.addProductToCatalog("Banana", 0.80);
cart.addProductToCatalog("Orange", 1.50);
cart.addProductToCatalog("Milk", 2.00);
38
// Adding items to the cart
cart.addToCart("Apple", 3);
cart.addToCart 

