
import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidVisa(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$");
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4123456789012345", //  Valid Visa
            "5123456789012345", // Valid MasterCard
            "6123456789012345", //  Invalid (Does not start with 4 or 5)
            "412345678901234",  //  Invalid (Only 15 digits)
            "51234567890123456" //  Invalid (17 digits)
        };

        for (String card : testCards) {
            System.out.println(card + " is " +
                (isValidVisa(card) ? "Valid Visa" : isValidMasterCard(card) ? "Valid MasterCard" : "Invalid"));
        }
    }
}

