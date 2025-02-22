
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(6, 4));
        assertEquals(-2, calculator.add(-1, -1));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(6, 4));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(24, calculator.multiply(6, 4));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    void testDivide() {
        assertEquals(3, calculator.divide(6, 2));
        assertEquals(-2, calculator.divide(-10, 5));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}

