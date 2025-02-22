
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        String regex = "https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);

        System.out.println(links);
    }
}

