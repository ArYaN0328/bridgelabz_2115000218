
import java.util.regex.*;
import java.util.*;

public class ProgrammingLanguageExtractor {
    private static final String LANGUAGE_REGEX = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|TypeScript|Perl|Scala|Dart)\\b";

    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Pattern pattern = Pattern.compile(LANGUAGE_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> extractedLanguages = extractLanguages(text);
        System.out.println(extractedLanguages);
    }
}

