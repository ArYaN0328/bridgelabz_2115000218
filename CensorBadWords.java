import java.util.regex.*;

public class CensorBadWords {
    public static String censorWords(String text, String[] badWords) {
        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b"; // Match whole word
            text = text.replaceAll(regex, "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"}; // List of bad words to censor

        String output = censorWords(input, badWords);
        System.out.println(output);
    }
}
