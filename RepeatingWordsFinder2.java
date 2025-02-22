
import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1)); // Add only the repeated word
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> words = findRepeatingWords(text);
        System.out.println(words);
    }
}

