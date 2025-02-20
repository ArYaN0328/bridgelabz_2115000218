   import java.io.*;
import java.util.*;

public class MapInverter2 {
    public static void main(String[] args) {
        // Sample input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);

        // Find the key with the highest value
        String maxKey = findMaxKey(inputMap);
        System.out.println("Key with the highest value: " + maxKey);
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> original) {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return inverted;
    }

    public static String findMaxKey(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}


