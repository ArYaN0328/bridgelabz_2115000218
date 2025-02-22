
import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }

    public static void main(String[] args) {
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";

        System.out.println(ssn1 + " is valid: " + isValidSSN(ssn1));
        System.out.println(ssn2 + " is valid: " + isValidSSN(ssn2));
    }
}

