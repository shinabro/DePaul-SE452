package edu.depaul.cdm.bank.persistence;


import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.AccountHolderToAccount;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.form.AccountHolderType;
import edu.depaul.cdm.bank.form.Credit;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.Account;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.hibernate.*;
//import org.hibernate.cfg.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.depaul.cdm.bank.service.AccountService;
import edu.depaul.cdm.bank.service.AccountHolderService;
import edu.depaul.cdm.bank.service.AccountHolderServiceImpl;
import edu.depaul.cdm.bank.dao.AccountHolderDAO;
import edu.depaul.cdm.bank.dao.AccountHolderDAOImpl;
import edu.depaul.cdm.bank.dao.DebitDAO;
import edu.depaul.cdm.bank.dao.DebitDAOImpl;
import edu.depaul.cdm.bank.service.DebitService;
import edu.depaul.cdm.bank.service.CreditService;
import edu.depaul.cdm.bank.service.DebitServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class AccountPersistence {
	private String firstName1 = "Zachary";
	private String middleName1 = "Daniel";
	private String lastName1 = "Wilson";
	private String title1 = "Mr.";
	private String ssn1 = "123-45-6789";
	private String mailingAddress1 = "P.O. Box 1";
	private String mailingCity1 = "Oak City";
	private String mailingState1 = "AR";
	private String mailingZip1 = "12345-0987";
	private String physicalAddress1 = "123 Oak Street";
	private String physicalCity1 = "Oak City";
	private String physicalState1 = "AR";
	private String physicalZip1 = "12346-8765";
	private String userPhone1 = "123-456-7890";
	private String userEmail1 = "zw@zw.com";
	private String employerName1 = "The Raven's Nest";
	private String employerPhone1 = "098-765-4321";
	private int salary1 = 50000;
	
	private int newUserId = -1;
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private AccountService service = (AccountService)context.getBean("accountService");
	private AccountHolderService ahService = (AccountHolderService)context.getBean("accountHolderService");
	private DebitService debitService = (DebitService)context.getBean("debitService");
	private CreditService creditService = (CreditService)context.getBean("creditService");
	//private List<Account> accounts = new ArrayList<Account>();
	private static List<Account> accounts = new ArrayList<Account>();
	
	@Before
	public void initializeList(){
		//Clear out accounts list before testing
		accounts.clear();
	}//End initializeList
	
	public void createAccounts(){
		//Create a few Accounts and add to accounts List
		//accounts.add(AccountFactory.createAccount(100.00, AccountType.CHECKING, 0));
		//accounts.add(AccountFactory.createAccount(250.00, AccountType.SAVINGS, 1));
		//accounts.add(AccountFactory.createAccount(0.00, AccountType.LOAN, 1));
		//accounts.add(AccountFactory.createAccount(25.00,  AccountType.LOAN, 2));
		//accounts.add(AccountFactory.createAccount(550.00, AccountType.CHECKING, 3));
		//accounts.add(AccountFactory.createAccount(50.00,  AccountType.CHECKING, 3));
		accounts.add(new Account(AccountType.CHECKING, 100.00, 1));
		accounts.add(new Account(AccountType.SAVINGS, 250.00, 1));
		accounts.add(new Account(AccountType.LOAN, 0.00, 1));
		accounts.add(new Account(AccountType.LOAN, 25.00, 2));
		accounts.add(new Account(AccountType.CHECKING, 550.00, 3));
		accounts.add(new Account(AccountType.CHECKING, 50.00, 3));
	}//End createAccounts
	
	@Test
	public void insertAccountTest(){
		//Create a few Accounts and add to accounts List
		createAccounts();
		service.insertAccount(accounts);
	}//End insertAccountTest
	
	@Test
	public void getAllAccountsTest(){
		createAccounts();
		service.insertAccount(accounts);
		List<Account> retrievedAccounts = new ArrayList<Account>();
		retrievedAccounts = service.getAccounts();
		assertTrue(retrievedAccounts.size() > 0);
	}//End getAllAccountsTest
	
	@Test
	public void findAccountTypeTest(){
		createAccounts();
		service.insertAccount(accounts);
		List<Account> accountList = new ArrayList<Account>();
		accountList = service.getAccountsByType(AccountType.LOAN);
		assertTrue(accountList.size() == 2);
	}//End findAccountTypeTest
	
	@Test
	public void retrieveAccountByIdTest(){
		createAccounts();
		service.insertAccount(accounts);
		Account account = service.getAccountById(1);
		assertTrue(account.getBalance() == 100.00);
	}//End retrieveAccountByIdTest
	
	@Test
	public void deleteAccountTest(){
		createAccounts();
		service.insertAccount(accounts);
		service.deleteAccountById(2);
		Account deletedAccount = service.getAccountById(2);
		Assert.assertTrue(deletedAccount == null);
	}//End deleteAccountTest
	
	@Test
	public void retrieveByUserIdTest(){
		createAccounts();
		service.insertAccount(accounts);
		List<Account> accountsFromUser = service.retrieveAccountByUser(1);
		Assert.assertTrue(accountsFromUser.size() == 3);
	}//End retrieveByUserIdTest
	
	@Test
	public void linkToAccountHolderTest(){
		//Method Logic
		//When an AccountHolder is created and inserted into the database using a page, 
		//it generates a userId. When an Account is created using a page, the user is 
		//prompted for their userId to create the Account. That userId is saved in the
		//Account object that is created. The Account can then be inserted into the 
		//database. To add the Account to AccountHolder's set of AccountHolder_To_Account,
		//retrieve the AccountHolder from its table in the database using the userId
		//associated with the Account. Once the AccountHolder object is retrieved, add 
		//the Account to the set of AccountHolder_To_Account.
		
		//Create the AccountHolder
		AccountHolder ah = createAccountHolder1(new AccountHolder());
		//Insert AccountHolder into DB to generate userId
		int ahUserId = ahService.insert(ah);
		//Create an Account object using the ahUserId
		Account account = new Account(AccountType.CHECKING, 0.00, ahUserId);
		//Insert account into DB to generate an accountId
		int ahAccountId = service.insertAccount(account);
		//Retrieve account from DB
		Account retrievedAccount = service.getAccountById(ahAccountId);
		//Should be able to add account to its associated AccountHolder's AccountHolder_To_Account map
		AccountHolder retrievedAH = ahService.getAccountHolderById(ahUserId);
		//Create an AccountHolderToAccount object
		AccountHolderToAccount ahta = new AccountHolderToAccount();
		ahta.setAccount(retrievedAccount);
		ahta.setAccountHolder(retrievedAH);
		ahta.setAccountHolderType(AccountHolderType.PRIMARY);
		//Add AccountHolderToAccount to the Set in AccountHolder
		Set<AccountHolderToAccount> setToAdd = new HashSet<AccountHolderToAccount>();
		setToAdd.add(ahta);
		retrievedAH.setAccountHolderToAccounts(setToAdd);
		//Update AccountHolder
		ahService.update(retrievedAH);	
	}//End linkToAccountHolderTest
	
	@Test
	public void updateAcctBalanceTest(){
		//Create and insert two accounts
		Account toAccount = new Account(AccountType.CHECKING, 0, 1);
		Account fromAccount = new Account(AccountType.CHECKING, 250.00, 2);
		//Insert created accounts into DB
		service.insertAccount(toAccount);
		service.insertAccount(fromAccount);
		
		//Update the balance of the first account added to DB
		service.updateAcctBalance(1, 345.00);
		//Retrieve the updated Account to test if the balance was properly updated
		Account retrievedAccount = service.getAccountById(1);
		Assert.assertTrue(retrievedAccount.getBalance() == 345.00);
	}//End updateAcctBalance
	
	@Test
	public void accountTransferTest(){
		//To transfer funds from one account to the other, create a Debit for the
		//"from" account and a Credit for the "to" account. Insert those into the 
		//DB and they should update the respective accounts.
		createAccounts();
		service.insertAccount(accounts);
		//Retrieve accounts from DB to do a transfer
		Account toAccount = service.getAccountById(1);
		Account fromAccount = service.getAccountById(2);
		int toAccountId = toAccount.getAccountId();
		int fromAccountId = fromAccount.getAccountId();
		Assert.assertTrue(toAccount.getBalance() == 100.00);
		Assert.assertTrue(fromAccount.getBalance() == 250.00);
		//Transfer $200.00
		Credit testCredit = new Credit("Account Transfer", toAccountId, 200.00, new Date(), "Transfer",  
				200.00, "Account Transfer");
		Debit testDebit = new Debit(fromAccountId, 200.00, new Date(), "Account Transfer", 200.00);
		creditService.insert(testCredit);
		debitService.insertDebit(testDebit);
		//Retrieve updated account and check that the balances were updated
		Account retrievedTo = service.getAccountById(toAccountId);
		Account retrievedFrom = service.getAccountById(fromAccountId);
		
		Assert.assertTrue(retrievedTo.getBalance() == 300.00);
		Assert.assertTrue(retrievedFrom.getBalance() == 50.00);
		
	}//End accountTransferTest
	
	@Test
	public void debitFromAccountTest(){
		//Test to see if creating and inserting a debit updates an account balance in DB
		Account testAccount = new Account(AccountType.CHECKING, 100.00, 1);
		int accountId = service.insertAccount(testAccount);
		//Create a Debit and insert into DB
		Debit testDebit = new Debit(accountId, 50.00, new Date(), "Check", 50.00);
		debitService.insertDebit(testDebit);
		//Get account and test to see if the balance has changed
		Account retrievedAccount = service.getAccountById(accountId);
		Assert.assertTrue(retrievedAccount.getBalance() == 50.00);
	}//End debitFromAccountTest
	
	@Test
	public void creditToAccountTest(){
		//Test to see if creating and inserting a credit updates an account balance in DB
		Account testAccount = new Account(AccountType.SAVINGS, 500.00, 1);
		int accountId = service.insertAccount(testAccount);
		//Create a credit and insert into DB
		Credit testCredit = new Credit("Payroll Check", accountId, 700.00, new Date(), "Payroll", 
				700.00, "Payroll Credit to Account");
		creditService.insert(testCredit);
		//Get account and test to see if the balance has changed
		Account retrievedAccount = service.getAccountById(accountId);
		Assert.assertTrue(retrievedAccount.getBalance() == 1200.00);
	}//End creditToAccountTest
	
	@Test
	public void insertSingleAccountTest(){
		Account testAccount = new Account(AccountType.CHECKING, 0.00, 1);
		Account testAccountTwo = new Account(AccountType.SAVINGS, 150.00, 2);
		int accountId = service.insertAccount(testAccount);
		int accountIdTwo = service.insertAccount(testAccountTwo);
		Assert.assertTrue(accountId == 1);
		Assert.assertTrue(accountIdTwo == 2);
	}//insertSingleAccountTest
	
	@Test
	public void insertAndLinkTest(){
		//Create the AccountHolder
		AccountHolder ah = createAccountHolder1(new AccountHolder());
		//Insert AccountHolder into DB to generate userId
		int ahUserId = ahService.insert(ah);
		//Create an Account object using the ahUserId
		Account testAccount = new Account(AccountType.CHECKING, 0.00, ahUserId);
		//Insert testAccount into using insertAndLink
		int accountId = service.insertAndLink(testAccount, ah);
		Assert.assertTrue(accountId == 1);
	}//End insertAndLinkTest
	
	
	private AccountHolder createAccountHolder1(AccountHolder ah) {
		ah.setFirstName(firstName1);
		ah.setMiddleName(middleName1);
		ah.setLastName(lastName1);
		ah.setTitle(title1);
		ah.setSsn(ssn1);
		ah.setMailingAddress(mailingAddress1);
		ah.setMailingCity(mailingCity1);
		ah.setMailingState(mailingState1);
		ah.setMailingZip(mailingZip1);
		ah.setPhysicalAddress(physicalAddress1);
		ah.setPhysicalCity(physicalCity1);
		ah.setPhysicalState(physicalState1);
		ah.setPhysicalZip(physicalZip1);
		ah.setUserPhone(userPhone1);
		ah.setUserEmail(userEmail1);
		ah.setEmployerName(employerName1);
		ah.setEmployerPhone(employerPhone1);
		ah.setSalary(salary1);
		//accounts1.add(savingsAccount1);
		//ah.setAccounts(accounts1);
		return ah;
	}//End createAccountHolder1
	
}//End AccountPersistence test class
