package edu.depaul.se.calculator.business;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.ICalculator;

/**
 * Performs "business" logic
 */
public final class Calculator implements ICalculator {

    /**
     * Adds two numbers together
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double add(double lhs, double rhs) {
        return lhs + rhs;
    }

    /**
     * Multiplies two numbers together
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double multiply(double lhs, double rhs) {
        return lhs * rhs;
    }

    /**
     * Divide lhs by rhs (lhs/rhs)
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double divide(double numerator, double denominator) throws DivideByZeroException{
        if (denominator == 0)
            throw new DivideByZeroException();
        
        return numerator / denominator;
    }

    /**
     * Subtract rhs from lhs (lhs - rhs)
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double subtract(double lhs, double rhs) {
        return lhs - rhs;
    }
}
