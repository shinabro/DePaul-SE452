package edu.depaul.cdm.bank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountHolderLogin;


@Repository
public class AccountHolderDAOImpl implements AccountHolderDAO {

	
	@Autowired
	private SessionFactory sessionFactory; //spring will inject this
	
	
	
	public int insert(AccountHolder accountHolder) {
		Session session = sessionFactory.getCurrentSession();
		session.save(accountHolder);
		return accountHolder.getUserId();

	}
	
	
	public AccountHolder getAccountHolderById(int id){
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery("get.individual.account.holder");
		q.setInteger("userId", id);
		List<AccountHolder> l = q.list();
		if (l.size() == 1) {
			return l.get(0);
		} else{
			return null;
		}
	}
	
	public AccountHolder getAccountHolderByUserName(String userName){
		Session session = sessionFactory.getCurrentSession();
		AccountHolderLogin ahl;
		List<AccountHolderLogin> accountHolderLoginList;
		List<AccountHolder> accountHolderList;
		Query q = session.getNamedQuery("get.accountHolderLogin.by.userName");
		q.setString("userName", userName);
		accountHolderLoginList = q.list();
		ahl = accountHolderLoginList.get(0);
		q = session.getNamedQuery("get.individual.account.holder");
		q.setInteger("userId", ahl.getUserId());
		accountHolderList = q.list();
		return accountHolderList.get(0);
	}
	
	public List<AccountHolder> getAllAccountHolders(){
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(AccountHolder.class);
		return cr.list();
	}
	
	
	public void update(AccountHolder accountHolder){
		Session session = sessionFactory.getCurrentSession();
		session.update(accountHolder);
	}
	
	
	public void delete(int id){
		Session session = sessionFactory.getCurrentSession();
		session.delete(getAccountHolderById(id));
	}
	
	public void delete(AccountHolder accountHolder){
		Session session = sessionFactory.getCurrentSession();
		session.delete(accountHolder);
	}

	
	//required for spring injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
