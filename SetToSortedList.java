  import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Input: HashSet of integers
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Original Set: " + hashSet);

        // Convert to a sorted list
        List<Integer> sortedList = convertToSortedList(hashSet);
        System.out.println("Sorted List: " + sortedList);
    }

    // Method to convert a HashSet to a sorted list
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Create a list from the set
        List<Integer> list = new ArrayList<>(set);
        
        // Sort the list in ascending order
        Collections.sort(list);
        
        return list;
    }
}
