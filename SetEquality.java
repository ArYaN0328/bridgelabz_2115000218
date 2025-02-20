
import java.util.*;

public class SetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        boolean isEqual = areSetsEqual(set1, set2);
        System.out.println("Are sets equal? " + isEqual);
    }

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        // Check if both sets are non-null and have the same size
        if (set1 == null || set2 == null) return false;
        if (set1.size() != set2.size()) return false;

        // Use the built-in equals() method to compare contents
        return set1.equals(set2);
    }
}

