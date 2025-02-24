
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
public class Book {
    public void display() {
        System.out.println("This is a book.");
    }
}

import java.lang.annotation.Annotation;

public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            // Get the Class object of Book
            Class<?> cls = Book.class;

            // Check if the class has the Author annotation
            if (cls.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = cls.getAnnotation(Author.class);

                // Display the annotation value
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

