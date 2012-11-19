package edu.depaul.cdm.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.bank.dao.AccountHolderDAO;
import edu.depaul.cdm.bank.form.AccountHolder;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

	@Autowired
	private AccountHolderDAO accountHolderDao; //spring will inject this
	

	
	@Transactional
	public int insert(AccountHolder accountHolder) {
		return accountHolderDao.insert(accountHolder);
	}
	
	@Transactional
	public AccountHolder getAccountHolderById(int id){
		return accountHolderDao.getAccountHolderById(id);
	}
	
	@Transactional
	public AccountHolder getAccountHolderByUserName(String userName){
		return accountHolderDao.getAccountHolderByUserName(userName);
	}
	
	@Transactional
	public List<AccountHolder> getAllAccountHolders(){
		return accountHolderDao.getAllAccountHolders();
	}
	
	@Transactional
	public void update(AccountHolder accountHolder){
			accountHolderDao.update(accountHolder);
	}
	
	@Transactional
	public void delete(int id){
		accountHolderDao.delete(id);
	}
	
	@Transactional
	public void delete(AccountHolder accountHolder){
		accountHolderDao.delete(accountHolder);
	}
	
	
	
	//needed for spring injection
	public void setAccountHolderDao(AccountHolderDAO accountHolderDao) {
		this.accountHolderDao = accountHolderDao;
	}

}
