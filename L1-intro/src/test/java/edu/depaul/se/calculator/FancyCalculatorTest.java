package edu.depaul.se.calculator;

import edu.depaul.se.calculator.business.FancyCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 */
class FancyCalculatorTest {
    private static ICalculator calculator;
    
    FancyCalculatorTest() {
    }
    
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
