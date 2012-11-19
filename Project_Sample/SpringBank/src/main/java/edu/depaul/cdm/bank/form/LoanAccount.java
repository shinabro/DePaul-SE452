package edu.depaul.cdm.bank.form;

public class LoanAccount extends Account {
	
	private double interestRate = .05;
	
	//***************Constructors******************
	//No argument constructor
	public LoanAccount(){}
	
	public LoanAccount(double balance){
		//AccountId is auto set when Account is added to database
		super.setAccountType(AccountType.LOAN);
		super.setBalance(balance);
	}
	
	public LoanAccount(double balance, double interestRate){
		//AccountId is auto set when Account is added to database
		super.setAccountType(AccountType.LOAN);
		super.setBalance(balance);
		setInterestRate(interestRate);
	}
	
	//******************Methods********************
	//setInterestRate
	/**
	 * Sets LoanAccount interest rate attribute
	 * @param interestRate the interest rate to assign. If the argument is not within
	 * the range of 0% to 20%, the interest rate is set to default loan rate of 5%
	 */
	public void setInterestRate(double interestRate){
		if(interestRate < 0 || interestRate > .20){
			this.interestRate = .05;
		}
		else
			this.interestRate = interestRate;
	}//End setInterestRate
	
	//getInterestRate
	/**
	 * @return the current LoanAccount interest rate
	 */
	public double getInterestRate(){
		return this.interestRate;
	}//End getInterestRate
	
	//addInterestToBalance
	/**
	 * Calculates the amount of interest to be added to principle balance and adds
	 * the amount to the balance on the account. 
	 * @return the balance after adding interest
	 */
	public double addInterestToBalance(){
		double interestAmount = this.getBalance() * this.getInterestRate();
		return this.creditAccount(interestAmount);
	}//End calculateInterest
	

}//End LoanAccount class
