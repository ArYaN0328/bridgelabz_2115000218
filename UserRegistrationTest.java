
import java.util.regex.Pattern;

public class UserRegistration {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static String registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain one uppercase letter, and one digit.");
        }
        return "User registered successfully.";
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully.",
                UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "SecurePass1"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("", "user@example.com", "ValidPass1");
        });
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser(null, "user@example.com", "ValidPass1");
        });
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("User", "invalid-email", "ValidPass1");
        });
        assertEquals("Invalid email format.", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("User", "user@example.com", "Short1");
        });
        assertEquals("Password must be at least 8 characters long, contain one uppercase letter, and one digit.", exception.getMessage());
    }

    @Test
    void testPasswordMissingUppercase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("User", "user@example.com", "password1");
        });
        assertEquals("Password must be at least 8 characters long, contain one uppercase letter, and one digit.", exception.getMessage());
    }

    @Test
    void testPasswordMissingDigit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("User", "user@example.com", "Password");
        });
        assertEquals("Password must be at least 8 characters long, contain one uppercase letter, and one digit.", exception.getMessage());
    }
}



