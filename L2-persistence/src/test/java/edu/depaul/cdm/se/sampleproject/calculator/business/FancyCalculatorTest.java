package edu.depaul.cdm.se.sampleproject.calculator.business;

import edu.depaul.cdm.se.sampleproject.calculator.ICalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class FancyCalculatorTest {
    private static ICalculator calculator;
    
    @BeforeAll
    static void setUpClass() {
        calculator = new FancyCalculator();
    }

    @Test
    void testAdd() {
        double lhs = 1.0;
        double rhs = 1.5;
        double expectedResult = 2.5;
        
        double result = calculator.add(lhs, rhs);
        assertEquals(expectedResult, result);
    }
    
}
