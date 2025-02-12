
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(itemName, itemId, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    public void removeById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Item temp = head, prev = null;

        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Found: " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: $" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found: ID: " + temp.itemId + " | Quantity: " + temp.quantity + " | Price: $" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;

        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextOfMid, sortByName, ascending);

        return merge(left, right, sortByName, ascending);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item merge(Item left, Item right, boolean sortByName, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        int compare;

        if (sortByName) {
            compare = left.itemName.compareToIgnoreCase(right.itemName);
        } else {
            compare = Double.compare(left.price, right.price);
        }

        if ((ascending && compare <= 0) || (!ascending && compare > 0)) {
            result = left;
            result.next = merge(left.next, right, sortByName, ascending);
        } else {
            result = right;
            result.next = merge(left, right.next, sortByName, ascending);
        }
        return result;
    }

    public void sortInventory(boolean sortByName, boolean ascending) {
        head = mergeSort(head, sortByName, ascending);
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        System.out.println("\nInventory List:");
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + " | " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding predefined items
        inventory.addAtEnd("Laptop", 101, 10, 1200.50);
        inventory.addAtEnd("Phone", 102, 25, 799.99);
        inventory.addAtBeginning("Tablet", 103, 15, 499.99);
        inventory.addAtPosition("Monitor", 104, 8, 199.99, 2);

        // Display inventory
        inventory.displayInventory();

        // Searching for an item
        System.out.println("\nSearching for item ID 102:");
        inventory.searchById(102);

        System.out.println("\nSearching for item 'Tablet':");
        inventory.searchByName("Tablet");

        // Updating quantity
        System.out.println("\nUpdating quantity of item ID 101 to 12...");
        inventory.updateQuantity(101, 12);
        inventory.displayInventory();

        // Calculating total inventory value
        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());

        // Sorting inventory
        System.out.println("\nSorting by Name (Ascending)...");
        inventory.sortInventory(true, true);
        inventory.displayInventory();

        System.out.println("\nSorting by Price (Descending)...");
        inventory.sortInventory(false, false);
        inventory.displayInventory();

        // Removing an item
        System.out.println("\nRemoving item ID 104...");
        inventory.removeById(104);
        inventory.displayInventory();
    }
}

