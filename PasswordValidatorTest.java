
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d).{8,}$";

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("Password1"));
        assertTrue(PasswordValidator.isValid("StrongPass99"));
        assertTrue(PasswordValidator.isValid("A1b2c3d4"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("P1ss")); // Less than 8 characters
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("password1")); // No uppercase letter
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("Password")); // No digit
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null)); // Null input
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValid("")); // Empty string
    }

    @Test
    void testOnlyNumbers() {
        assertFalse(PasswordValidator.isValid("12345678")); // No uppercase letter
    }

    @Test
    void testOnlyUppercaseLetters() {
        assertFalse(PasswordValidator.isValid("PASSWORD")); // No digit
    }
}



