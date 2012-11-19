package edu.depaul.cdm.bank.persistence;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.Credit;
import edu.depaul.cdm.bank.service.AccountService;
import edu.depaul.cdm.bank.service.CreditService;

public class CreditPersistence 
{
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private CreditService service = (CreditService)context.getBean("creditService");
	private AccountService acctService = (AccountService)context.getBean("accountService");
	
	@Test
	public void insertCreditTest() 
	{	
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountId = acctService.insertAccount(testAccount);
		Credit credit = createCredit(accountId);
		try {
			service.insert(credit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List listCredit = service.getAllCredit();
		Credit insertedCredit = (Credit)listCredit.get(0);
		
		Assert.assertEquals(credit.getCreditId(), insertedCredit.getCreditId());
		Assert.assertEquals(credit.getAccountId(), insertedCredit.getAccountId());
	}
	
	@Test
	public void insertCreditAccountIDTest() 
	{	
		int accountIDCredit = -1;
		Credit insertedCredit = null;
		
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountIDAcc = acctService.insertAccount(testAccount);
		Credit credit = createCredit(accountIDAcc);
		try {
			accountIDCredit = service.insert(credit);
			insertedCredit = service.getCreditByAccountID(accountIDAcc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Assert.assertEquals(credit.getCreditId(), accountIDCredit);
		Assert.assertEquals(credit.getCreditId(), insertedCredit.getCreditId());
		Assert.assertEquals(credit.getAccountId(), insertedCredit.getAccountId());
	}
	
	@Test
	public void getBalanceByAccountIDTest() 
	{	
		int accountIDCredit = -1;
		Account updatedAccount = null;
		
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountIDAcc = acctService.insertAccount(testAccount);
		Credit credit = createCredit(accountIDAcc);
		try {
			accountIDCredit = service.insert(credit);
			updatedAccount = acctService.getAccountById(accountIDAcc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(updatedAccount.getBalance() == (testAccount.getBalance() + credit.getAmount()));
	}
	
	@Test
	public void insertCreditCollectionTest() 
	{	
		List<Integer> accountIDIntegers = new ArrayList<Integer>();
		accountIDIntegers.add(1);
		accountIDIntegers.add(2);
		for (Integer accountIDInteger : accountIDIntegers) 
		{
			Account testAccount = new Account(AccountType.CHECKING, 1000.00, accountIDInteger.intValue());
			int accountId = acctService.insertAccount(testAccount);
			Assert.assertEquals(accountIDInteger.intValue(), accountId);
		}
		
		List<Credit> creditCollection = createCollectionCredit(accountIDIntegers);
		Credit createdCredit = (Credit)creditCollection.get(0);
		
		try {
			service.insert(creditCollection);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List listCredit = service.getAllCredit();
		Credit insertedCredit = (Credit)listCredit.get(0);
		
		Assert.assertEquals(createdCredit.getCreditId(), insertedCredit.getCreditId());
		Assert.assertEquals(createdCredit.getAccountId(), insertedCredit.getAccountId());
		assertTrue(listCredit.size() > 0);
	}
	
	@Test
	public void updateCreditTest() 
	{	
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountId = acctService.insertAccount(testAccount);
		Credit credit = createCredit(accountId);
		
		try {
			service.insert(credit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		List insertedListCredit = service.getAllCredit();
		Credit insertedCredit = (Credit)insertedListCredit.get(0);
		
		// set the updated properties
		String updatedCategory = "Updated_Category_1";
		String updatedDescription = "Updated_Description_1";
		insertedCredit.setCategory(updatedCategory);
		insertedCredit.setDescription(updatedDescription);
		
		try {
			service.update(insertedCredit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List updatedListCredit = service.getAllCredit();
		Credit updatedCredit = (Credit)insertedListCredit.get(0);
		assertTrue(credit.getCategory() != updatedCredit.getCategory());
		assertTrue(credit.getDescription() != updatedCredit.getDescription());
		Assert.assertEquals(credit.getCreditId(), updatedCredit.getCreditId());
		Assert.assertEquals(credit.getAccountId(), updatedCredit.getAccountId());
	}
	
	@Test
	public void deleteCreditTest() 
	{	
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountId = acctService.insertAccount(testAccount);
		Credit credit = createCredit(accountId);
		
		try {
			service.insert(credit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List insertedListCredit = service.getAllCredit();
		
		try {
			service.delete(credit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List deletedListCredit = service.getAllCredit();
		
		assertTrue(insertedListCredit.size() > deletedListCredit.size());
	}
	
	@Test
	public void deleteCreditByCreditIDTest() 
	{	
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountId = acctService.insertAccount(testAccount);
		int creditID = -1;
		Credit credit = createCredit(accountId);
		
		try {
			creditID = service.insert(credit);
			service.delete(creditID);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List deletedListCredit = service.getAllCredit();
		
		assertTrue(deletedListCredit.isEmpty());
	}
	
	@Test
	public void getCreditByCreditIDTest() 
	{	
		Account testAccount = new Account(AccountType.CHECKING, 1000.00, 1);
		int accountId = acctService.insertAccount(testAccount);
		int creditID = -1;
		Credit credit = createCredit(accountId);
		
		try {
			creditID = service.insert(credit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Credit creditById = null;
		try {
			creditById = service.getCreditByCreditID(creditID);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(credit.getCreditId() == creditById.getCreditId());
		Assert.assertEquals(credit.getCreditId(), creditById.getCreditId());
		Assert.assertEquals(credit.getAccountId(), creditById.getAccountId());
	}
	
	
	// create an individual Credit
	private Credit createCredit(int accountId)
	{
		Credit credit = new Credit( "CreditType_1",
									accountId,
				   					100,
				   					new Date(),
				   					"Category_1",
				   					1000,
				   					"Description_1");
		
		return credit;
	}
	
	// create a Credit collection
	private List<Credit> createCollectionCredit(List<Integer> accountIDIntegers)
	{		
		List<Credit> credits = new ArrayList<Credit>();
		
		for (Integer accountIDInteger : accountIDIntegers) 
		{
			String accountIDIntegerString = accountIDInteger.toString();
			int accountIDIntegerValue = accountIDInteger.intValue();
			credits.add(new Credit( "CreditType_"+accountIDIntegerString,
					accountIDIntegerValue,
   					100*accountIDIntegerValue,
   					new Date(),
   					"Category_"+accountIDIntegerString,
   					1000*accountIDIntegerValue,
   					"Description_"+accountIDIntegerString));
		}
		
		return credits;
	}
}
