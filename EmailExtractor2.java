
import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String regex = "[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org.";
        List<String> emails = extractEmails(text);
        
        System.out.println("Extracted Emails: " + emails);
    }
}

