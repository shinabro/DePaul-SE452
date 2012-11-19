package edu.depaul.cdm.bank.form;
/*
 * AccountCreateAddForm Class
 * This is an AccountCreateAddForm backing class.
 * It stores user input from the JSP.
 */
public class AccountCreateAddForm {
	
	//Instance Variables
	private AccountType accountType;
	private double balance;
	private double interestRate;
	
	//Accessors
	
	public AccountType getAccountType(){
		return this.accountType;
	}//End getAccountType
	
	public double getBalance(){
		return this.balance;
	}//End getBalance
	
	public double getInterestRate(){
		return this.interestRate;
	}//End getInterestRate
	
	//Modifiers
	
	public void setAccountType(AccountType accountType){
		this.accountType = accountType;
	}//End setAccountType
	
	public void setBalance(double balance){
		this.balance = balance;
	}//End setBalance 

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
