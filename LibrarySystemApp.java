
import java.util.ArrayList;

// Book class (Can exist independently)
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (Aggregates Books)
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library details
    public void displayLibrary() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayBook();
        }
        System.out.println();
    }
}

// Main class to demonstrate Aggregation
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating books (Exist independently)
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("City Library");

        // Adding books to libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        // Displaying libraries and their books
        library1.displayLibrary();
        library2.displayLibrary();
    }
}

