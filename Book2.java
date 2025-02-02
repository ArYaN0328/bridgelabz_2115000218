public class Book2 {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently unavailable.");
        }
    }

    // Method to return a book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have returned \"" + title + "\". Thank you!");
        } else {
            System.out.println("\"" + title + "\" is already available in the library.");
        }
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        // Creating a book object
        Book book1 = new Book("Java Programming", "James Gosling", 29.99, true);

        // Display book details
        book1.displayBookInfo();
        System.out.println();

        // Borrowing the book
        book1.borrowBook();
        book1.displayBookInfo();
        System.out.println();

        // Trying to borrow again
        book1.borrowBook();
        System.out.println();

        // Returning the book
        book1.returnBook();
        book1.displayBookInfo();
    }
}
