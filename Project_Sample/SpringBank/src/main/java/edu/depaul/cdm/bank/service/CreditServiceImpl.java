package edu.depaul.cdm.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.bank.dao.CreditDAO;
import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.Credit;

@Service
public class CreditServiceImpl implements CreditService 
{
	@Autowired
	private CreditDAO creditDao; //spring will inject this
	
	@Transactional
	public void setCreditDao(CreditDAO creditDao) {
		this.creditDao = creditDao;
	}

	@Transactional
	public int insert(Credit credit)
	{
		return creditDao.insert(credit);
	}

	@Transactional
	public void insert(List<Credit> listCredits) 
	{
		creditDao.insert(listCredits); //Spring will inject the appropriate class because of the bean id we created for it.
		List<Credit> list = creditDao.getAllCredit();
		System.out.println("There are " + list.size() + " credits saved to the database.");
	}

	@Transactional
	public Credit getCreditByCreditID(int creditID) 
	{
		return creditDao.getCreditByCreditID(creditID);
	}

	@Transactional
	public List<Credit> getAllCredit() 
	{
		return creditDao.getAllCredit();
	}
	
	@Transactional
	public Credit getCreditByAccountID(int accountID)
	{
		return creditDao.getCreditByAccountID(accountID);
	}
	
	@Transactional
	public List getAllCreditsByAccountID(int accountID)
	{
		return creditDao.getAllCreditsByAccountID(accountID);
	}

	@Transactional
	public double getBalanceByAccountID(int accountID)
	{
		List<Account> list = (List<Account>) creditDao.getAccountByAccountID(accountID);
		return list.get(0).getBalance();
	}

	@Transactional
	public void update(Credit credit) 
	{
		creditDao.update(credit);
	}

	@Transactional
	public void delete(int creditID) 
	{
		creditDao.delete(creditID);
	}

	@Transactional
	public void delete(Credit credit) 
	{
		creditDao.delete(credit);
	}
}
