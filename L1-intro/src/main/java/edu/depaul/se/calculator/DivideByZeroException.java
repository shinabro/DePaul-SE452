package edu.depaul.se.calculator;

public class DivideByZeroException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DivideByZeroException() {
        super();
    }
    
    public DivideByZeroException(String msg) { 
        super(msg);
    }
    
    public DivideByZeroException(Throwable throwable) {
        super(throwable);
    }
    
    public DivideByZeroException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
