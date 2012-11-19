package edu.depaul.cdm.bank.service;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;
import java.util.List;

public interface AccountService {
	//Use AccountDAO to insert accounts into database
	public void insertAccount(List<Account> accounts);
	
	// Insert one account into database
	public int insertAccount(Account account);
	
	//Insert and link Account to AccountHolder
	public int insertAndLink(Account account, AccountHolder accountHolder);
	
	public int updateAccount(Account account);
	
	//Update the balance of the Account associated to argument accountId
	public void updateAcctBalance(int accountId, double newBalance);
	
	//Retrieve all Accounts from database
	public List<Account> getAccounts();
	
	//Retrieve all Accounts of argument accountType from database
	public List<Account> getAccountsByType(AccountType accountType);
	
	//Retrieve Account associated with argument accountId
	public Account getAccountById(int accountId);
	
	//Delete Account associated with argument accountId
	public void deleteAccountById(int accountId);
	
	//Delete argument Account
	public void deleteAccount(Account account);
	
	//Retrieve Account associated with argument userId
	public List<Account> retrieveAccountByUser(int userId);
	
	//Delete and Unlink account and account holder
	public void deleteAndUnlink(Account account, AccountHolder accountHolder);
	
	//Delete and Unlink by Id
	public void deleteAndUnlinkById(int accountId, AccountHolder accountHolder);
	
}//End AccountService