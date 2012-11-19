package edu.depaul.cdm.bank.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.depaul.cdm.bank.form.OtherBankAccount;

@Repository
public class OtherBankAccountDAOImpl implements OtherBankAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(OtherBankAccount otherBankAccount) {
		sessionFactory.getCurrentSession().save(otherBankAccount);
	}

	public void delete(OtherBankAccount otherBankAccount) {
		sessionFactory.getCurrentSession().delete(otherBankAccount);

	}

	public void update(OtherBankAccount otherBankAccount) {
		sessionFactory.getCurrentSession().update(otherBankAccount);

	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
