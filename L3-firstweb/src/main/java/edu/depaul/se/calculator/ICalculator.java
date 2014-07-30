package edu.depaul.se.calculator;

public interface ICalculator {

    /**
     * Adds two numbers together
     *
     * @param lhs
     * @param rhs
     * @return
     */
    double add(double lhs, double rhs);

    /**
     * Divide numerator by denominator (numerator/denominator)
     *
     * @param numerator
     * @param denominator
     * @return
     * @throws DivideByZeroException when denominator is 0
     */
    double divide(double numerator, double denominator) throws DivideByZeroException;

    /**
     * Multiplies two numbers together
     *
     * @param lhs
     * @param rhs
     * @return
     */
    double multiply(double lhs, double rhs);

    /**
     * Subtract rhs from lhs (lhs - rhs)
     *
     * @param lhs
     * @param rhs
     * @return
     */
    double subtract(double lhs, double rhs);
    
}
