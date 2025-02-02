// Parent class: Book
class Book3 {
    // Public member
    public String ISBN;

    // Protected member
    protected String title;

    // Private member
    private String author;

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to get the author's name
    public String getAuthor() {
        return author;
    }

    // Public method to set the author's name
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends Book {
    private double fileSize; // Additional property for EBook

    // Constructor
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);  // Call the constructor of the parent class
        this.fileSize = fileSize;
    }

    // Method to display EBook details
    public void displayEBookDetails() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN);  // Accessing public member from parent class
        System.out.println("Title: " + title);  // Accessing protected member from parent class
        System.out.println("File Size: " + fileSize + " MB");
    }

    // Accessor method to get file size
    public double getFileSize() {
        return fileSize;
    }
}

// Main class to test the functionality
public class BookLibrarySystem {
    public static void main(String[] args) {
        // Create a Book object
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", "John Doe");
        
        // Display book details
        book1.displayBookDetails();

        // Modify author name using setter method
        book1.setAuthor("Jane Smith");
        System.out.println("\nUpdated Author: " + book1.getAuthor());

        // Create an EBook object
        EBook ebook1 = new EBook("978-1-23-456789-0", "Advanced Java", "Robert Brown", 5.2);
        
        // Display EBook details
        ebook1.displayEBookDetails();

        // Access the author's name from the parent class
        System.out.println("\nEBook Author: " + ebook1.getAuthor());
    }
}
