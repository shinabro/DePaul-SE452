package edu.depaul.cdm.bank.dao;

import java.util.List;

import edu.depaul.cdm.bank.form.AccountHolder;


public interface AccountHolderDAO {
	
	public int insert(AccountHolder accountHolder);
	public AccountHolder getAccountHolderById(int id);
	public AccountHolder getAccountHolderByUserName(String userName);
	public List<AccountHolder> getAllAccountHolders();
	public void update(AccountHolder accountHolder);
	public void delete(int id);
	public void delete(AccountHolder accountHolder);
	
}
