package edu.depaul.se.calculator;

import edu.depaul.se.calculator.business.FancyCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FancyCalculatorTest {
    private static ICalculator calculator;
    
    public FancyCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        calculator = new FancyCalculator();
    }

    @Test
    public void testAdd() {
        double lhs = 1.0;
        double rhs = 1.5;
        double expectedResult = 2.5;
        
        double result = calculator.add(lhs, rhs);
        assertEquals(expectedResult, result, 0.0);
    }
    
}
