package edu.depaul.cdm.bank.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.service.AccountService;

@Repository
public class DebitDAOImpl implements DebitDAO {

	@Autowired
	private SessionFactory sessionFactory; //spring will inject this
	
	@Autowired
	private AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}//End setAccountDAO
	
	public void insert(List<Debit> listDebits) {
		Session session = sessionFactory.getCurrentSession();
		for (Debit debit : listDebits) {
			session.save(debit);
			accountDAO.debitUpdate(debit.getAccountId(), debit.getAmount());
		}
	}
	
	//Method takes two paramaters. One for the Debit to insert and a newBalance 
	//parameter to use to update the account balance for the associated Account
	public int insert(Debit d) {
		Session session = sessionFactory.getCurrentSession();
		session.save(d);
		//Should also update the Account its associated with so make a call to AccountDAO
		//updateAcctBalance method
		accountDAO.debitUpdate(d.getAccountId(), d.getAmount());
		System.out.println("Debit in the amount of " + d.getAmount() + " has been saved to the database.");
		return d.getAccountId();
	}
	
	public List findAll(){
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("From Debit").list();
		System.out.println(list.size() + "debits retrieved from database");
		return list;
	}
	
	public List findAllByAccountId(int accountId){
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Debit where accountId = '" + accountId + "'").list();
		System.out.println("Returning " + list.size() + " debits for accountId " + accountId);
		return list;
	}
	
	public Account getAccountByAccountId(int accountId) {
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery("from Account where accountId = '" + accountId + "'").list();
		if (l.size() == 1) {
			return (Account) l.get(0);
		} else {
			return null;
		}
	}
	
	//required for spring injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
