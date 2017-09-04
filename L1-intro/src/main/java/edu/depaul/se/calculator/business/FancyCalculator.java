/*
 */
package edu.depaul.se.calculator.business;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.ICalculator;

/**
 * More advanced functionality
 */
public class FancyCalculator implements ICalculator{
    @Override
    public double add(double lhs, double rhs) {
        return lhs + rhs;
    }


    @Override
    public double multiply(double lhs, double rhs) {
        return lhs * rhs;
    }


    @Override
    public double divide(double numerator, double denominator) throws DivideByZeroException{
        if (denominator == 0)
            throw new DivideByZeroException();
        
        return numerator / denominator;
    }

    @Override
    public double subtract(double lhs, double rhs) {
        return lhs - rhs;
    }    
}
