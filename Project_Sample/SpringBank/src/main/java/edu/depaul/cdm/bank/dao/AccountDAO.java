package edu.depaul.cdm.bank.dao;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import java.util.List;
import edu.depaul.cdm.bank.form.AccountType;

public interface AccountDAO {
	//Insert a list of Accounts into database
	public void insert(List<Account> accountsList);
	
	//Insert one account into database
	public int insert(Account account);
	
	//Insert one account into DB and link to associated AccountHolder
	public int insertAndLink(Account account, AccountHolder accountHolder);
	
	public void update(Account account);
	
	//Update account balance
	public void updateBalance(int accountId, double newBalance);
	
	//DebitUpdate account balance
	public void debitUpdate(int accountId, double debitAmount);
	
	//Credit update account balance
	public void creditUpdate(int accountId, double creditAmount);
	
	//Retrieve all Accounts of argument accountType from database
	public List<Account> findAccountType(AccountType accountType);
	
	//Retrieve all Accounts from database
	public List<Account> getAllAccounts();
	
	//Retrieve an Account by accountId #
	public Account retrieveAccount(int accountId);
	
	//Delete an Account by accountId #
	public void deleteAccount(int accountId);
	
	//Delete an Account
	public void deleteAccount(Account account);
	
	//Retrieve accounts by userId
	public List<Account> retrieveAccountByUser(int userId);
	
	//Delete an Account and Unlink it from AccountHolder
	public void deleteAndUnlink(Account account, AccountHolder accountHolder);
	
	//Delete and Unlink by account Id
	public void deleteAndUnlinkById(int accountId, AccountHolder accountHolder);
	
}//End AccountDAO