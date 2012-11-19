package edu.depaul.cdm.bank.form;

/*
 * Abstract Account Class
 * Declared as abstract to allow for easy extension if the decision is made
 * to add more types of accounts that inherit and extend the functionality
 * of the base Account class.
 */
public class Account {
	
	//Instance Variables
	private int accountId;
	private AccountType accountType;
	private double balance = 0;
	private double interestRate;
	private int userId;
	
	//Constructors
	public Account(){}
	
	public Account(AccountType accountType, double balance, int userId){
		this.accountType = accountType;
		this.balance = balance;
		this.userId = userId;
	}
	
	//Accessors
	public int getUserId(){
		return this.userId;
	}
	public int getAccountId(){
		return this.accountId;
	}//End getAccountId
	
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
	public void setUserId(int userId){
		this.userId = userId;
	}//End setUserId
	public void setAccountId(int accountId){
		this.accountId = accountId;
	}//End setAccountId
	
	public void setAccountType(AccountType accountType){
		this.accountType = accountType;
	}//End setAccountType
	
	public void setBalance(double balance){
		this.balance = balance;
	}//End setBalance 

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	//toString()
	@Override
	public String toString(){
		return ("AccountId: " + this.getAccountId() + "\nAccount Type: " + this.getAccountType() +
				"\nAccount Balance: " + this.getBalance());
	}//End toString
	
	//creditAccount
	//Returns the new balance for the current Account
	public double creditAccount(double creditAmount){
		double newBalance = this.getBalance() + creditAmount;
		this.setBalance(newBalance);
		return newBalance;
	}//End creditAccount
	
	//debitAccount
	//Returns the new balance for the current Account
	public double debitAccount(double debitAmount){
		double newBalance = this.getBalance() - debitAmount;
		this.setBalance(newBalance);
		return newBalance;
	}//End debitAccount
	
	//accountTransfer
	//Transfers argument balance from the argument account to current account
	//Should also generate a debit for the argument account, and a credit for the
	//credited account (this).
	//Returns the balances needed to update the respective accounts as an ArrayList
	//The first value in the List is the fromAcctBalance
	//The second value in the List is the toAcctBalance
	public void accountTransfer(double transferAmt, Account transferAccount){
		double fromAcctBalance = transferAccount.debitAccount(transferAmt);
		double toAcctBalance = this.creditAccount(transferAmt);
	}//End accountTransfer
	
}//end Account
