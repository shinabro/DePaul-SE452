package edu.depaul.cdm.bank.form;

public class SavingsAccount extends Account {
	
	//Default interest rate for Savings account
	private double interestRate = .02;
	
	//************Constructors*************
	//No Argument Constructor
	public SavingsAccount(){} 
	
	public SavingsAccount(double balance){
		//AccountId is set when Account is added to the database
		super.setAccountType(AccountType.SAVINGS);
		super.setBalance(balance);
	}
	
	public SavingsAccount(double balance, double interestRate){
		//AccountId is set when Account is added to the database
		super.setAccountType(AccountType.SAVINGS);
		super.setBalance(balance);
		setInterestRate(interestRate);
	}
	
	//**************Methods*****************
	//getInterestRate
	/**
	 * @return the current Accounts interest rate
	 */
	public double getInterestRate(){
		return this.interestRate;
	}//End getInterestRate
	
	//setInterestRate
	/**
	 * Set the current Accounts interest rate
	 * @param interestRate interestRate argument must be in the range of 0% to 10%
	 * or the current Accounts interest rate is set to the default rate of 2%
	 */
	public void setInterestRate(double interestRate){
		if(interestRate < 0 || interestRate > .10){
			this.interestRate = .02;
		}
		else
			this.interestRate = interestRate;
	}//End setInterestRate
	
	//applyInterest
	/**
	 * Add interest generated to the current balance of the Account
	 * @return the new balance after adding interest
	 */
	public double applyInterest(){
		double interestAmount = this.getBalance() * this.getInterestRate();
		return creditAccount(interestAmount);
	}//End applyInterest
	

}//End SavingsAccount class
