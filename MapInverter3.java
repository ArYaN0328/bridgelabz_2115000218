  import java.io.*;
import java.util.*;

public class MapInverter {
    public static void main(String[] args) {
        // Sample input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println("Merged Map: " + mergedMap);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(mergedMap);
        System.out.println("Inverted Map: " + invertedMap);

        // Find the key with the highest value
        String maxKey = findMaxKey(mergedMap);
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

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return merged;
    }
}
