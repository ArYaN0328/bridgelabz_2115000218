
import java.util.regex.*;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345", "XY9876", "ab1234"};

        for (String plate : plates) {
            System.out.println(plate + " is valid: " + isValidLicensePlate(plate));
        }
    }
}

