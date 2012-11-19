package edu.depaul.cdm.bank.form;

public class CheckingAccount extends Account {
	
	//Constructors
	
	//No argument constructor
	public CheckingAccount(){}
	
	public CheckingAccount(double balance){
		//AccountId is set when the Account is added to the database
		super.setAccountType(AccountType.CHECKING);
		super.setBalance(balance);
	}//End argument constructor

}//End CheckingAccount class
