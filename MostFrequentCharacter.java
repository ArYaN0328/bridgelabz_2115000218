import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "success";  // Example input

        // Call the method to find the most frequent character
        char mostFrequentChar = findMostFrequentCharacter(input);

        // Output the result
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        // Create a map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Iterate through the string to build the frequency map
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the character with the highest frequency
        char mostFrequentChar = str.charAt(0);
        int maxFrequency = 0;
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostFrequentChar;
    }
}
