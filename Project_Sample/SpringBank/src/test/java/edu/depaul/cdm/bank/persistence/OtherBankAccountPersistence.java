package edu.depaul.cdm.bank.persistence;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.OtherBankAccount;
import edu.depaul.cdm.bank.service.AccountHolderService;
import edu.depaul.cdm.bank.service.OtherBankAccountService;

public class OtherBankAccountPersistence {
	
	private String bankRoutingNumber = "123456789";
	private String bankAccountNumber = "123456789";
	private int userId = 1;
	private String bankName = "First Federal Bank";
	private String bankAddress ="123 Oak Street";
	
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
	
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private OtherBankAccountService service = (OtherBankAccountService)ctx.getBean("otherBankAccountService");
	private AccountHolderService accountHolderService = (AccountHolderService)ctx.getBean("accountHolderService");
	
	@Test
	public void otherBankAccountInsertTest(){
			AccountHolder ah = createAccountHolder1();
			accountHolderService.insert(ah);
			service.insert(createOtherBankAccount(ah));
	}
	
	private OtherBankAccount createOtherBankAccount(AccountHolder ah){
		OtherBankAccount oba = new OtherBankAccount();
		oba.setAccountNumber(bankAccountNumber);
		oba.setBankRoutingNumber(bankRoutingNumber);
		oba.setAccountHolder(ah);
		oba.setBankName(bankName);
		oba.setBankAddress(bankAddress);
		return oba;
	}
	
	private AccountHolder createAccountHolder1() {
		AccountHolder ah = new AccountHolder();
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
	}
	
}
