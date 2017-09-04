package edu.depaul.se.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.depaul.se.calculator.business.SimpleCalculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Example to show JUnit test
 */
public class SimpleCalculatorTest {
    
    private static ICalculator calculator;
    
    public SimpleCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        calculator = new SimpleCalculator();
    }

    @Test
    public void testAdd() {
        double lhs = 1.0;
        double rhs = 1.5;
        double expectedResult = 2.5;
        
        double result = calculator.add(lhs, rhs);
        assertEquals(expectedResult, result, 0.0);
    }

    @Test
    public void testSubtract() {
        double lhs = 1.5;
        double rhs = 1.0;
        double expectedResult = 0.5;
        
        double result = calculator.subtract(lhs, rhs);
        assertEquals(expectedResult, result, 0.0);
    }
    
    @Test
    public void testMultiply() {
        double lhs = 2.0;
        double rhs = 3.0;
        double expectedResult = 6.0;
        
        double result = calculator.multiply(lhs, rhs);
        assertEquals(expectedResult, result, 0.0);
    }

    @Test
    public void testDivide() throws DivideByZeroException {
        double lhs = 6.0;
        double rhs = 3.0;
        double expectedResult = 2.0;
        
        double result = calculator.divide(lhs, rhs);
        assertEquals(expectedResult, result, 0.0);
    }
    
    @Test(expected = DivideByZeroException.class)
    public void testDivideWithException() throws DivideByZeroException {
        double lhs = 6.0;
        double rhs = 0.0;
        
        calculator.divide(lhs, rhs);
        fail("Should not have gotten here");
    }
}
