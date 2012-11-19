package edu.depaul.cdm.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.bank.dao.AccountDAO;
import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}//End setAccountDAO 
	
	@Transactional
	public void insertAccount(List<Account> accountList){
		accountDAO.insert(accountList); //Spring should inject appropriate class
		List<Account> listCheck = accountDAO.getAllAccounts();
		System.out.println("There are " + listCheck.size() + " accounts in the database");
	}//End insertAccount
	
	@Transactional
	public int insertAccount(Account account){
		accountDAO.insert(account); //Spring should inject appropriate class
		return account.getAccountId();
	}//End insertAccount
	
	@Transactional
	public int insertAndLink(Account account, AccountHolder accountHolder){
		accountDAO.insertAndLink(account, accountHolder);
		return account.getAccountId();
	}//end insertAndLink
	
	@Transactional
	public void deleteAndUnlink(Account account, AccountHolder accountHolder){
		accountDAO.deleteAndUnlink(account, accountHolder);
	}//End deleteAndUnlink
	
	@Transactional
	public void deleteAndUnlinkById(int accountId, AccountHolder accountHolder){
		accountDAO.deleteAndUnlinkById(accountId, accountHolder);
	}//End deleteAndUnlinkById
	
	@Transactional
	public int updateAccount(Account account){
		accountDAO.update(account); //Spring should inject appropriate class
		return account.getAccountId();
	}//End insertAccount
	
	@Transactional
	public void updateAcctBalance(int accountId, double newBalance){
		accountDAO.updateBalance(accountId, newBalance);
	}//End updateAcctBalance
	
	@Transactional
	public List<Account> getAccounts(){
		List<Account> accounts = accountDAO.getAllAccounts();
		System.out.println("Retrieved " + accounts.size() + " from the database");
		return accounts;
	}//End getAccounts
	
	@Transactional
	public List<Account> getAccountsByType(AccountType accountType){
		List<Account> accounts = accountDAO.findAccountType(accountType);
		System.out.println("Retrieved " + accounts.size() + " " + accountType + " accounts");		
		return accounts;
	}//End getAccountsByType
	
	@Transactional
	public Account getAccountById(int accountId){
		Account account = accountDAO.retrieveAccount(accountId);
		return account;
	}//End getAccountById
	
	@Transactional
	public void deleteAccountById(int accountId){
		accountDAO.deleteAccount(accountId);
	}//End deleteAccountById
	
	@Transactional
	public void deleteAccount(Account account){
		accountDAO.deleteAccount(account);
	}//End deleteAccount
	
	@Transactional
	public List<Account> retrieveAccountByUser(int userId){
		List<Account> accounts = accountDAO.retrieveAccountByUser(userId);
		return accounts;
	}//End retrieveAccountByUser

}//End AccountServiceImpl class
