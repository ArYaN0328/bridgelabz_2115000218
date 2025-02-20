 import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        // Input list
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");

        // Get frequency map
        Map<String, Integer> frequencyMap = findFrequency(list);

        // Output the result
        System.out.println("Frequency Map: " + frequencyMap);
    }

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }
}
