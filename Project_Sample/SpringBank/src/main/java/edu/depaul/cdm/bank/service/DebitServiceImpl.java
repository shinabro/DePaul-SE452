package edu.depaul.cdm.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.bank.dao.DebitDAO;
import edu.depaul.cdm.bank.dao.DebitDAOImpl;
import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.Debit;

@Service
public class DebitServiceImpl implements DebitService {

	@Autowired
	private DebitDAO debitDao;
	
	@Transactional
	public void setDebitDao(DebitDAO debitDao) {
		this.debitDao = debitDao;
	}
	
	@Transactional
	public void insertDebit(List<Debit> listDebits) {
		debitDao.insert(listDebits); //Spring will inject the appropriate class because of the bean id we created for it.
		List<Debit> l = debitDao.findAll();
		System.out.println("There are " + l.size() + " debits saved to the database.");
	}
	
	@Transactional
	public int insertDebit(Debit d) {
		return debitDao.insert(d); //Spring will inject the appropriate class because of the bean id we created for it.
	}
	
	@Transactional
	public List getAllDebits() {
		List<Debit> l = debitDao.findAll();
		System.out.println("You retrieved all " + l.size() + " debits from the database");
		return l;
	}
	
	@Transactional
	public List getAllDebitsByAccountId(int accountId) {
		List<Debit> l = debitDao.findAllByAccountId(accountId);
		System.out.println("You retrieved " + l.size() + " debits for account id " + accountId);
		return l;
	}
	
	@Transactional
	public double getBalanceByAccountId(int accountId) {
		List<Account> l = (List<Account>) debitDao.getAccountByAccountId(accountId);
//		System.out.println("The balance for account id " + accountId + " is " + l.get(0).getBalance());
		return l.get(0).getBalance();
	}

}
