package edu.depaul.cdm.se.sampleproject.calculator.business;

import edu.depaul.cdm.se.sampleproject.calculator.DivideByZeroException;
import edu.depaul.cdm.se.sampleproject.calculator.ICalculator;
import edu.depaul.cdm.se.sampleproject.calculator.jpa.Logger;

/**
 * Performs "business" logic
 */
public final class Calculator implements ICalculator {

    private Logger logger = new Logger();

    /**
     * Adds two numbers together
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double add(double lhs, double rhs) {
        double result = lhs + rhs;
        logger.log(lhs + " + " + rhs + " = " + result);
        return result;
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
        double result = lhs * rhs;
        logger.log(lhs + " * " + rhs + " = " + result);
        return result;
    }

    /**
     * Divide lhs by rhs (lhs/rhs)
     *
     * @param lhs
     * @param rhs
     * @return
     */
    @Override
    public double divide(double numerator, double denominator) throws DivideByZeroException {
        double result = numerator / denominator;
        logger.log(numerator + " / " + denominator + " = " + result);

        if (denominator == 0) {
            throw new DivideByZeroException();
        }

        return result;
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
        double result = lhs - rhs;
        logger.log(lhs + " - " + rhs + " = " + result);
        return result;
    }
}
