
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null, tail = null;
    private int bookCount = 0;

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newBook;
            }
            temp.next = newBook;
            if (newBook.next == null) {
                tail = newBook;
            }
            bookCount++;
        }
    }

    public void removeById(int bookId) {
        if (head == null) return;

        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) head.prev = null;
            bookCount--;
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp == tail) {
            tail = temp.prev;
        }
        bookCount--;
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " | Author: " + temp.author + " | Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found: " + temp.title + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\nLibrary Books (Forward Order):");
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\nLibrary Books (Reverse Order):");
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + " | " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        return bookCount;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding predefined books
        library.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 101, true);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 102, false);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", 103, true);
        library.addAtPosition("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 104, true, 2);

        // Displaying books
        library.displayBooksForward();

        // Searching for books
        System.out.println("\nSearching for book '1984':");
        library.searchByTitle("1984");

        System.out.println("\nSearching for books by 'Harper Lee':");
        library.searchByAuthor("Harper Lee");

        // Updating book availability
        System.out.println("\nUpdating availability of book ID 102 to Available...");
        library.updateAvailability(102, true);
        library.displayBooksForward();

        // Displaying books in reverse order
        library.displayBooksReverse();

        // Counting total books
        System.out.println("\nTotal Books in Library: " + library.countBooks());

        // Removing a book
        System.out.println("\nRemoving book ID 104...");
        library.removeById(104);
        library.displayBooksForward();

        System.out.println("\nTotal Books in Library after removal: " + library.countBooks());
    }
}

