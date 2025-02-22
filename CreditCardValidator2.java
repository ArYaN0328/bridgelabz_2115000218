
import java.util.regex.*;

public class CreditCardValidator {
    private static final String CARD_REGEX = "^(4\\d{15}|5\\d{15})$";

    public static boolean isValidCard(String cardNumber) {
        return Pattern.matches(CARD_REGEX, cardNumber);
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4111111111111111",  // Visa (Valid)
            "5111111111111111",  // MasterCard (Valid)
            "6111111111111111",  // Invalid (does not start with 4 or 5)
            "422222222222222"    // Invalid (15 digits instead of 16)
        };

        for (String card : testCards) {
            System.out.println(card + " → " + (isValidCard(card) ? "Valid" : "Invalid"));
        }
    }
}

