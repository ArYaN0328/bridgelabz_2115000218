
import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String text) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static void main(String[] args) {
        String ssn1 = "My SSN is 123-45-6789.";
        String ssn2 = "My SSN is 123456789.";

        System.out.println("\"123-45-6789\" is " + (isValidSSN(ssn1) ? "valid" : "invalid"));
        System.out.println("\"123456789\" is " + (isValidSSN(ssn2) ? "valid" : "invalid"));
    }
}

