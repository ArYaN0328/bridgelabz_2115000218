
import java.util.*;

public class ListRotation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        System.out.println("Original List: " + list);
        List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println("Rotated List: " + rotatedList);
    }

    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        
        // Handle cases where positions > size or positions < 0
        positions = positions % size; 
        if (positions < 0) positions += size; 

        // Rotate using sublist
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size)); // Add second part
        rotated.addAll(list.subList(0, positions));    // Add first part

        return rotated;
    }
}


