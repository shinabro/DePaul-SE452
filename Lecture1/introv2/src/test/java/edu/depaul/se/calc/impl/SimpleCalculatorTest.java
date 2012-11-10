package edu.depaul.se.calc.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oose
 */
public class SimpleCalculatorTest {
    
    public SimpleCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class SimpleCalculator.
     */
    @Test
    public void testAdd() {
        int lhs = 1;
        int rhs = 2;
        SimpleCalculator instance = new SimpleCalculator();
        int expResult = 3;
        int result = instance.add(lhs, rhs);
        assertEquals(expResult, result);
    }
}
