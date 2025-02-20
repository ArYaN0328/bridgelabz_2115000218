   import java.io.*;
import java.util.*;

public class MapInverter {
    public static void main(String[] args) {
        // Sample input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> original) {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return inverted;
    }
}
