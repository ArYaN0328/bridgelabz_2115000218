
import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        String regex = "\\$\\d+\\.\\d{2}|\\b\\d+\\.\\d{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> values = extractCurrencyValues(text);
        System.out.println(values);
    }
}

