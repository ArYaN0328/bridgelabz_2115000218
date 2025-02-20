
    import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        try {
            // Read text from a file
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            reader.close();

            // Count word frequency
            Map<String, Integer> wordCount = new HashMap<>();
            String[] words = content.toString().toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            // Print word frequency
            System.out.println("Word Frequencies: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


