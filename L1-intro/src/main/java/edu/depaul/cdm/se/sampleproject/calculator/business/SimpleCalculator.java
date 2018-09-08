package edu.depaul.cdm.se.sampleproject.calculator.business;

import edu.depaul.cdm.se.sampleproject.calculator.DivideByZeroException;
import edu.depaul.cdm.se.sampleproject.calculator.ICalculator;

/**
 * Performs "business" logic
 */
public final class SimpleCalculator implements ICalculator {
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
