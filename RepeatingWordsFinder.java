
import java.util.regex.*;
import java.util.HashSet;
import java.util.Set;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1)); // Capture only the repeated word
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeatingWords = findRepeatingWords(text);

        System.out.println(repeatingWords);
    }
}

