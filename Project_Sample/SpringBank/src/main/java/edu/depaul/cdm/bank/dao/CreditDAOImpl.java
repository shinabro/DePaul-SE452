package edu.depaul.cdm.bank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.bank.form.Credit;
import edu.depaul.cdm.bank.form.Account;

@Repository
public class CreditDAOImpl implements CreditDAO 
{	
	@Autowired
	private SessionFactory sessionFactory; //spring will inject this
	
	@Autowired
	private AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}

	public int insert(Credit credit) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(credit);
		//Should also update the Account its associated with so make a call to AccountDAO
		//creditUpdate method
		accountDAO.creditUpdate(credit.getAccountId(), credit.getAmount());
		return credit.getCreditId();
	}

	public void insert(List<Credit> listCredits) 
	{
		Session session = sessionFactory.getCurrentSession();
		for (Credit credit : listCredits) 
		{
			session.save(credit);
			accountDAO.creditUpdate(credit.getAccountId(), credit.getAmount());
		}
	}
	
	public Credit getCreditByCreditID(int creditID) 
	{
		Credit credit = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Credit where creditId = '" + creditID + "'").list();
		if (list.size() == 1) 
		{
			credit = (Credit)list.get(0);
		}

		return credit;
	}
	
	public List<Credit> getAllCredit() 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Credit.class);
		return cr.list();
	}
	
	public Credit getCreditByAccountID(int accountID)
	{
		Credit credit = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Credit where accountId = '" + accountID + "'").list();
		if (list.size() == 1) 
		{
			credit = (Credit)list.get(0);
		}

		return credit;
	}
	
	public List getAllCreditsByAccountID(int accountID)
	{
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Credit where creditId = '" + accountID + "'").list();

		return list;
	}
	
	public Account getAccountByAccountID(int accountID) 
	{
		Account account = null; 
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery("from Account where accountId = '" + accountID + "'").list();
		if (l.size() == 1) 
		{
			account = (Account) l.get(0);
		} 
		
		return account;
	}
	
	

	public void update(Credit credit) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(credit);
	}

	public void delete(int creditID) 
	{
		Credit credit = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Credit where creditId = '" + creditID + "'").list();
		if (list.size() == 1) 
		{
			credit = (Credit)list.get(0);
		}
		
		if (null != credit)
		{
			session.delete(credit);
		}
	}

	public void delete(Credit credit) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.delete(credit);
	}
	
	public Account getAccountByAccountId(int accountID)
	{
		Account account = null;
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery("from Account where accountId = '" + accountID + "'").list();
		
		if (l.size() == 1) 
		{
			account = (Account)l.get(0);
		} 
		
		return account;
	}
	
	//required for spring injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
