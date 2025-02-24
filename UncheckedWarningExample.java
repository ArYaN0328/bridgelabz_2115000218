
import java.util.ArrayList;

public class UncheckedWarningExample {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        // Creating an ArrayList without generics (raw type)
        ArrayList list = new ArrayList(); 
        
        // Adding elements of different types
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Retrieving elements without type safety
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

