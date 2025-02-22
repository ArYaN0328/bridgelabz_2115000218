
public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testDivideValid() {
        assertEquals(5, MathUtils.divide(10, 2));
        assertEquals(-3, MathUtils.divide(9, -3));
        assertEquals(0, MathUtils.divide(0, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}




