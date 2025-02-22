
import java.util.regex.*;

public class BadWordFilter {
    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"}; // List of bad words
        String output = censorBadWords(input, badWords);
        System.out.println("Output: " + output);
    }
}

