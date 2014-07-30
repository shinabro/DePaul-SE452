package edu.depaul.se.calculator.business;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.ICalculator;
import edu.depaul.se.calculator.log.jpa.DBLogger;
import edu.depaul.se.calculator.log.jpa.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
    public double divide(double numerator, double denominator) throws DivideByZeroException{
        double result = numerator / denominator;
        logger.log(numerator + " / " + denominator + " = " + result);

        if (denominator == 0)
            throw new DivideByZeroException();

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
        return result;    }
}
