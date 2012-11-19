package edu.depaul.cdm.bank.form;

/**
 * AccountFactory used to create Account types
 * Can be easily extended with more Account types if more Account types
 * are added to the system
 * Currently accepts the creation of three types:
 * Checking, Savings, and Loan Accounts
 * @author Owner
 *
 */
public class AccountFactory {
	
	//*************Constructor**************
	//No arguments needed methods declared static
	public AccountFactory(){}
	
	//*************Methods******************
	//createAccount
	/**
	 * Method used by AccountFactory to create Account types
	 * @param balance balance that initializes created account
	 * @param accountType type of account that will be created. Must be Checking,
	 * Savings, or Loan
	 * @return the Account object created. Returns null if an unsupported accountType is passed.
	 */
	public static Account createAccount(double balance, AccountType accountType, int userId){
		//Negative balance check
		if(balance < 0){
			balance = 0;
		}
		if(accountType == AccountType.CHECKING){
			Account account = new CheckingAccount(balance);
			account.setUserId(userId);
			return account;
		}//End Checking condition
		else if(accountType == AccountType.SAVINGS){
			Account account = new SavingsAccount(balance);
			account.setUserId(userId);
			return account;
		}//End Savings condition
		else if(accountType == AccountType.LOAN){
			Account account = new LoanAccount(balance);
			account.setUserId(userId);
			return account;
		}
		else
			return null;
	}//End createAccount

}//End AccountFactory class
