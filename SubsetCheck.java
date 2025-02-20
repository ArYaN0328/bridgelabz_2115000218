
import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        // Input sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        // Check if set1 is a subset of set2
        boolean isSubset = checkSubset(set1, set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }

    // Method to check if one set is a subset of another
    public static <T> boolean checkSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset); // Check if all elements of subset are in superset
    }
}

