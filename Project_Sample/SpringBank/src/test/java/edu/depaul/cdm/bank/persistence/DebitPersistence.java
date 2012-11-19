package edu.depaul.cdm.bank.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountFactory;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.form.SavingsAccount;
import edu.depaul.cdm.bank.service.AccountService;
import edu.depaul.cdm.bank.service.DebitService;

public class DebitPersistence {

	private List<Debit> debits = new ArrayList<Debit>(0);
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private DebitService debitService = (DebitService)ctx.getBean("debitService");
	private AccountService accountService = (AccountService)ctx.getBean("accountService");

	@Before
	public void initializeList() {
		// Clear the list before you start testing
		debits.clear();
	}

	@Test
	public void singleDebitTest(){
		//Create and insert a test account
		Account testAccount = new Account(AccountType.SAVINGS, 1000.00, 1);
		int accountId = accountService.insertAccount(testAccount);
		//Create and insert a debit for the created account
		Debit testDebit = new Debit(accountId, 450.00, new Date(), "Check", 450.00);
		debitService.insertDebit(testDebit);
		//Retrieve updated account to ensure it has been updated properly
		Account retrievedAccount = accountService.getAccountById(accountId);
		Assert.assertTrue(retrievedAccount.getBalance() == 550.00);
	}//End singleDebitTest
	
	@Test
	public void createDebitTest() throws Exception {
		try {
			Account testAccount = new Account(AccountType.SAVINGS, 1000.00, 1);
			int accountId = accountService.insertAccount(testAccount);
			addDebits(accountId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void getAllDebitsTest() throws Exception {
		try {
			Account testAccount = new Account(AccountType.LOAN, 1000.00, 1);
			int accountId = accountService.insertAccount(testAccount);
			addDebits(accountId);
			List l = debitService.getAllDebits();
			Assert.assertTrue(l.size() == 5);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void getAllDebitsByAccountIdTest() throws Exception {
		try {
			Account testAccount = new Account(AccountType.LOAN, 1000.00, 1);
			int accountId = accountService.insertAccount(testAccount);
			addDebits(accountId);
			List<Account> l = debitService.getAllDebitsByAccountId(1);
			Assert.assertTrue(l.size() == 5);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addDebits(int accountId) {
		debits.add(new Debit(accountId,250.00,new Date(),"Check",100.00));
		debits.add(new Debit(accountId,50.00,new Date(),"Check",50.00));
		debits.add(new Debit(accountId,150.00,new Date(),"Bill Pay",50.00));
		debits.add(new Debit(accountId,10.00,new Date(),"Debit Card",50.00));
		debits.add(new Debit(accountId,5.00,new Date(),"Debit Card",5000.00));
		debitService.insertDebit(debits);
	}
	
	public void addAccounts() {
		Account a = new Account();
		a.setAccountType(AccountType.LOAN);
		a.setBalance(1000.0);
		a.setInterestRate(5.0);
		List<Account> list = new ArrayList<Account>();
		list.add(a);
		accountService.insertAccount(list);
	}

}
