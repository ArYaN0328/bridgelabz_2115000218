
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            throw new IllegalArgumentException("Input date cannot be null or empty.");
        }
        try {
            LocalDate date = LocalDate.parse(inputDate, INPUT_FORMAT);
            return date.format(OUTPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.");
        }
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2024", DateFormatter.formatDate("2024-01-01"));
        assertEquals("15-08-2022", DateFormatter.formatDate("2022-08-15"));
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate("12/25/2023"); // Incorrect format
        });
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate("");
        });
        assertEquals("Input date cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testNullDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate(null);
        });
        assertEquals("Input date cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testNonExistingDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateFormatter.formatDate("2023-02-30"); // Invalid date
        });
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }
}

