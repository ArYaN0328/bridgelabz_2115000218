
import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        String regex = "^#([A-Fa-f0-9]{6})$";
        return color.matches(regex);
    }

    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "#GHIJKL", "#000000"};

        for (String color : colors) {
            System.out.println(color + " is valid: " + isValidHexColor(color));
        }
    }
}

