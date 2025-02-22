
import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    private static final String CURRENCY_REGEX = "\\$\\d+\\.\\d{2}|\\b\\d+\\.\\d{2}\\b";

    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Pattern pattern = Pattern.compile(CURRENCY_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> extractedValues = extractCurrencyValues(text);
        System.out.println(extractedValues);
    }
}

