
import java.util.regex.*;
import java.util.*;

public class RepeatedWordsFinder {
    private static final String REPEATED_WORD_REGEX = "\\b(\\w+)\\b\\s+\\b\\1\\b";

    public static Set<String> findRepeatedWords(String text) {
        Set<String> repeatedWords = new HashSet<>();
        Pattern pattern = Pattern.compile(REPEATED_WORD_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));  // Add the repeated word
        }
        return repeatedWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeatedWords = findRepeatedWords(text);
        System.out.println(repeatedWords);
    }
}

