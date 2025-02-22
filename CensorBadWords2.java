
import java.util.regex.*;

public class CensorBadWords {
    public static String censorText(String text, String[] badWords) {
        for (String word : badWords) {
            String regex = "\\b" + word + "\\b"; // Ensures full-word match
            text = text.replaceAll(regex, "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String output = censorText(input, badWords);
        System.out.println(output);
    }
}

