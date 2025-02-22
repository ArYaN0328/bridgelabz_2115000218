
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = extractEmails(text);

        System.out.println(emails);
    }
}

