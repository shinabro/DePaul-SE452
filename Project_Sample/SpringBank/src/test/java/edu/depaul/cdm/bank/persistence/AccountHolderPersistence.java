package edu.depaul.cdm.bank.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountHolderLogin;
import edu.depaul.cdm.bank.service.AccountHolderService;


public class AccountHolderPersistence {

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
	private String userName = "zwilson";
	private String password = "password";
	
	private int newUserId = -1;
	
	//private SavingsAccount savingsAccount1 = new SavingsAccount(200);
	//private Set<Account> accounts1 = new HashSet<Account>(0);
		
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private AccountHolderService service = (AccountHolderService)ctx.getBean("accountHolderService"); //Spring will load the appropriate class
	//private AccountHolderService service = new AccountHolderServiceImpl();
	

	@Test
	public void accountHolderPersistenceInsertTest() {
		AccountHolder ah = createAccountHolder1(new AccountHolder());
		//write the account holder information to the database
		//System.out.println("New User ID: " + newUserId);
		newUserId = service.insert(ah);
		//System.out.println("New User ID: " + newUserId);
		AccountHolder tempAccountHolder = service.getAccountHolderById(newUserId);
		if (tempAccountHolder == null) {
			Assert.fail("Was not able to find user with id " + newUserId);
		}
		Assert.assertEquals(tempAccountHolder.getFirstName(), ah.getFirstName());
		
		tempAccountHolder = service.getAccountHolderByUserName(userName);
		if (tempAccountHolder == null) {
			Assert.fail("Was not able to find user with userName " + userName);
		}
		service.delete(newUserId);
		AccountHolder deletedAccountHolder = service.getAccountHolderById(newUserId);
		Assert.assertEquals(deletedAccountHolder, null);
	}
	
	
	/*@Test
	public void emptyAccountHolderPersistenceTest(){
		AccountHolder emptyAccountHolder= new AccountHolder();
		try {
			service.insertAccountHolder(emptyAccountHolder);
			Assert.fail("An empty account holder was inserted into the database");
		} catch (ConstraintViolationException cve) {

		} catch (Exception e) {
			Assert.fail("Exception thrown that was not expected\n" + e.getMessage());
		}
		
	}*/
	


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
		AccountHolderLogin ahl = new AccountHolderLogin();
		ahl.setUserName(userName);
		ahl.setPassword(password);
		ahl.setAuthority("ROLE_USER");
		ahl.setEnabled(1);
		ah.setAccountHolderLogin(ahl);
		ahl.setAccountHolder(ah);
		//accounts1.add(savingsAccount1);
		//ah.setAccounts(accounts1);
		return ah;
	}
}
