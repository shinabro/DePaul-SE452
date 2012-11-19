package edu.depaul.cdm.bank.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolderType;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountHolderToAccount;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	//Create the sessionFactory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AccountHolderDAO accountHolderDao;
	
	public void setAccountHolderDao(AccountHolderDAO accountHolderDao){
		this.accountHolderDao = accountHolderDao;
	}//End setAccountHolderDAO

	//Interface implementations
	//createAccount
	public void insert(List<Account> accountsList){
		Session session = sessionFactory.getCurrentSession();
		for(Account account : accountsList){
			session.save(account);
		}
	}//End insert
	
	public int insert(Account account){
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		int accountId = account.getAccountId();
		return accountId;
	}//End insert
	
	//insertAndLink method
	public int insertAndLink(Account account, AccountHolder accountHolder){
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		int accountId = account.getAccountId();
		//Link the account to the argument accountHolder
		//Retrieve the set of AccountHolderToAccount in retrieved AccountHolder
		Set<AccountHolderToAccount> ahSet = accountHolder.getAccountHolderToAccounts();
		//Create an AccountHolderToAccount object
		AccountHolderToAccount ahta = new AccountHolderToAccount();
		ahta.setAccount(account);
		ahta.setAccountHolder(accountHolder);
		ahta.setAccountHolderType(AccountHolderType.PRIMARY);
		//Add created AccountHolderToAccount to the set
		if(ahSet == null){
			ahSet = new HashSet<AccountHolderToAccount>();
			ahSet.add(ahta);
		}
		else{
			ahSet.add(ahta);
		}
		//Update the accountHolder in the DB
		accountHolderDao.update(accountHolder);
		return accountId;
	}//insertAndLink
	
	//deleteAndUnlink method
	public void deleteAndUnlink(Account account, AccountHolder accountHolder){
		Set<AccountHolderToAccount> ahSet = accountHolder.getAccountHolderToAccounts();
		//First remove the AccountHolderToAccount that exist for argument account
		Iterator<AccountHolderToAccount> it = ahSet.iterator();
		while(it.hasNext()){
			AccountHolderToAccount current = it.next();
			if(current.getAccount().getAccountId() == account.getAccountId()){
				it.remove();
			}
		}//End set iteration
		Session session = sessionFactory.getCurrentSession();
		session.delete(account);
		//Update the accountHolder to reflect change in Set of AccountHolderToAccount
		accountHolderDao.update(accountHolder);
	}//End deleteAndUnlink
	
	//deleteAndUnlinkById method
	public void deleteAndUnlinkById(int accountId, AccountHolder accountHolder){
		Set<AccountHolderToAccount> ahSet = accountHolder.getAccountHolderToAccounts();
		//First remove the AccountHolderToAccount that exist for argument account
		Iterator<AccountHolderToAccount> it = ahSet.iterator();
		while(it.hasNext()){
			AccountHolderToAccount current = it.next();
			if(current.getAccount().getAccountId() == accountId){
				it.remove();
			}
		}//End set iteration
		//Delete account
		this.deleteAccount(accountId);
		//Update the accountHolder to reflect change in Set
		accountHolderDao.update(accountHolder);
	}//End deleteAndUnlinkById
	
	public void update(Account account){
		Session session = sessionFactory.getCurrentSession();
		session.update(account);
	}
	
	//updateBalance
	public void updateBalance(int accountId, double newBalance){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "update Account set balance = :balance where accountId =  :accountId";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("balance", newBalance);
		query.setParameter("accountId", accountId);
		query.executeUpdate();
	}//End updateBalance
	
	//debitUpdate
	public void debitUpdate(int accountId, double debitAmount){
		//First need to access the account associated with accountId to get balance
		Account account = this.retrieveAccount(accountId);
		double newBalance = account.getBalance() - debitAmount;
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "update Account set balance = :balance where accountId = :accountId";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("balance", newBalance);
		query.setParameter("accountId", accountId);
		query.executeUpdate();
	}//End updateBalance
	
	//creditUpdate
	public void creditUpdate(int accountId, double creditAmount){
		Account account = this.retrieveAccount(accountId);
		double newBalance = account.getBalance() + creditAmount;
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "update Account set balance = :balance where accountId = :accountId";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("balance", newBalance);
		query.setParameter("accountId", accountId);
		query.executeUpdate();
	}//End creditUpdate
	
	//findAccountType
	//Returns all Account of the argument accountType
	public List<Account> findAccountType(AccountType accountType){
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "from Account where accountType= :accountType ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("accountType", accountType);
		List<Account> accountsList = query.list();
		return accountsList;
	}//End findAccountType
	
	//getAllAccounts
	//Retrieves all account from database and returns them in a list
	public List<Account> getAllAccounts(){
		Session session = sessionFactory.getCurrentSession();
		List<Account> accountList = session.createQuery("From Account").list();
		return accountList;
	}//End getAllAccounts
	
	public Account retrieveAccount(int accountId){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "from Account where accountId = :accountId ";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("accountId", accountId);
		List<Account> retrievedAccount = query.list();
		//List should only contain one Account so retrieve from list and return
		if(retrievedAccount.size() == 1){
			return retrievedAccount.get(0);
		}
		else
			return null;
	}//End retrieveAccount
	
	public void deleteAccount(int accountId){
		Session session = sessionFactory.getCurrentSession();
		session.delete(retrieveAccount(accountId));
	}//End deleteAccount
	
	public void deleteAccount(Account account){
		Session session = sessionFactory.getCurrentSession();
		session.delete(account);
	}//End deleteAccount
	
	public List<Account> retrieveAccountByUser(int userId){
		//Method Logic
		//When an AccountHolder is created and inserted into the database using a page, 
		//it generates a userId. When an Account is created using a page, the user is 
		//prompted for their userId to create the Account. That userId is saved in the
		//Account object that is created. The Account can then be inserted into the 
		//database. To add the Account to AccountHolder's set of AccountHolder_To_Account,
		//retrieve the AccountHolder from its table in the database using the userId
		//associated with the Account. Once the AccountHolder object is retrieved, add 
		//the Account to the set of AccountHolder_To_Account.
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "from Account where userId = :userId ";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("userId", userId);
		List<Account> retrievedAccount = query.list();
		return retrievedAccount;
	}//End retrieveAccountByUser

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}//End AccountDAOImpl 
