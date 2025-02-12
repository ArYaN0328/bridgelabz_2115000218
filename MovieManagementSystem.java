
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    public void removeByTitle(String title) {
        if (head == null) {
            return;
        }

        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + ") | Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " by " + temp.director + " (" + temp.year + ")");
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        System.out.println("\nMovies (Forward Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        System.out.println("\nMovies (Reverse Order):");
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManagement mms = new MovieManagement();

        // Adding Movies
        mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtEnd("Titanic", "James Cameron", 1997, 7.8);
        mms.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        mms.addAtBeginning("Avatar", "James Cameron", 2009, 7.9);
        mms.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 3);

        // Display movies in forward and reverse order
        mms.displayForward();
        mms.displayReverse();

        // Searching for movies by director
        System.out.println("\nMovies directed by Christopher Nolan:");
        mms.searchByDirector("Christopher Nolan");

        // Searching for a movie by rating
        System.out.println("\nMovies with rating 7.9:");
        mms.searchByRating(7.9);

        // Updating a movie's rating
        System.out.println("\nUpdating rating of 'Titanic' to 8.0...");
        mms.updateRating("Titanic", 8.0);

        // Display movies after rating update
        mms.displayForward();

        // Removing a movie
        System.out.println("\nRemoving 'The Dark Knight'...");
        mms.removeByTitle("The Dark Knight");

        // Display movies after deletion
        mms.displayForward();
    }
}

