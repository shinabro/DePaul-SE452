package edu.depaul.se.calculator;

import edu.depaul.se.calculator.business.SimpleCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Example to show JUnit test
 */
class SimpleCalculatorTest {
    
    private static ICalculator calculator;
    
    SimpleCalculatorTest() {
    }
    
    @BeforeAll
    static void setUpClass() {
        calculator = new SimpleCalculator();
    }

    @Test
    void testAdd() {
        double lhs = 1.0;
        double rhs = 1.5;
        double expectedResult = 2.5;
        
        double result = calculator.add(lhs, rhs);
        assertEquals(expectedResult, result);
    }

    @Test
    void testSubtract() {
        double lhs = 1.5;
        double rhs = 1.0;
        double expectedResult = 0.5;
        
        double result = calculator.subtract(lhs, rhs);
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testMultiply() {
        double lhs = 2.0;
        double rhs = 3.0;
        double expectedResult = 6.0;
        
        double result = calculator.multiply(lhs, rhs);
        assertEquals(expectedResult, result);
    }

    @Test
    void testDivide() throws DivideByZeroException {
        double lhs = 6.0;
        double rhs = 3.0;
        double expectedResult = 2.0;
        
        double result = calculator.divide(lhs, rhs);
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testDivideWithException() {
        double lhs = 6.0;
        double rhs = 0.0;

        assertThrows(DivideByZeroException.class, () -> {
            calculator.divide(lhs, rhs);
        });
    }
}
