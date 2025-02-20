
import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        // Calculate symmetric difference
        Set<Integer> symmetricDiff = getSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }

    // Method to compute the symmetric difference of two sets
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);

        // Find common elements (intersection)
        intersection.retainAll(set2);

        // Add all elements from set2 to the result
        result.addAll(set2);

        // Remove common elements
        result.removeAll(intersection);

        return result;
    }
}

