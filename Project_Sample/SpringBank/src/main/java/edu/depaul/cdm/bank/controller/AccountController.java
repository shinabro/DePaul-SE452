package edu.depaul.cdm.bank.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolderToAccount;
import edu.depaul.cdm.bank.form.AccountCreateAddForm;
import edu.depaul.cdm.bank.form.AccountDeleteForm;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.AddDebitForm;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.service.AccountService;

@Controller
@SessionAttributes({"account", "accountholder", "accountCreateAddForm"})
public class AccountController {
	
	private AccountService accountService;
	@Autowired
	public void setAccountService(AccountService accountService){
		this.accountService = accountService;
	}//End setAccountService
	
	@RequestMapping(value = "/account/deleteAccount.htm", method = RequestMethod.GET)
	public String showDeleteAccount(@ModelAttribute("accountholder") AccountHolder accountholder, ModelMap model){
		List<Account> accounts = accountService.retrieveAccountByUser(accountholder.getUserId());
		List<Integer> accountIds = new ArrayList<Integer>();
		for(Account account : accounts){
			int accountId = account.getAccountId();
			accountIds.add(accountId);
		}
		model.addAttribute("acctList", accountIds);
		AccountDeleteForm accountDeleteForm = new AccountDeleteForm();
		model.addAttribute("accountDeleteForm", accountDeleteForm);
		return "/account/accountDelete";
	}//End showDeleteAccount
	
	@RequestMapping(value = "/account/deleteAccount.htm", method = RequestMethod.POST)
	public String deleteAccount(@ModelAttribute("accountDeleteForm") AccountDeleteForm accountDeleteForm, 
			@ModelAttribute("accountholder") AccountHolder accountHolder, 
			@ModelAttribute("account") Account account, ModelMap model){
		String accountToDeleteString = accountDeleteForm.getAccountId();
		int accountToDelete = Integer.parseInt(accountToDeleteString);
		Set<AccountHolderToAccount> ahSet = accountHolder.getAccountHolderToAccounts();
		Iterator<AccountHolderToAccount> setIterator = ahSet.iterator();
		for(int i=0; setIterator.hasNext(); i++){
			AccountHolderToAccount ahta = setIterator.next();
			if(ahta.getAccount().getAccountId() == accountToDelete){
				setIterator.remove();
			}
		}
		/*for(AccountHolderToAccount ahta : ahSet){
			if(ahta.getAccount().getAccountId() == accountToDelete){
				ahSet.remove(ahta);
			}
		}*/
		model.addAttribute("deletedId", accountToDelete);
		accountService.deleteAndUnlinkById(accountToDelete, accountHolder);	
		return "/account/accountDeleteSuccess";
	}//End deleteAccount
	
	@RequestMapping(value = "/account/showAccountInfo.htm", method = RequestMethod.GET)
	public String showAccountInfo(@ModelAttribute("accountholder") AccountHolder accountholder, ModelMap model){
		List<Account> accounts = accountService.retrieveAccountByUser(accountholder.getUserId());
		for(Account account : accounts){
			System.out.println("Account ID: " + account.getAccountId() + "\nUser ID: " + account.getUserId());
		}
		model.addAttribute("acctList", accounts);
		return "/account/showAccountList";
	}//End showAccountInfo
	
	@RequestMapping(value = "/account/account.htm", method = RequestMethod.GET)
	public String showAddAccount(ModelMap model){
		ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();
		accountTypes.add(AccountType.CHECKING);
		accountTypes.add(AccountType.LOAN);
		accountTypes.add(AccountType.SAVINGS);
		model.addAttribute("accountTypes", accountTypes);
		
		AccountCreateAddForm accountCreateAddForm = new AccountCreateAddForm();
		model.addAttribute("accountCreateAddForm", accountCreateAddForm);
		Account account = new Account();
		model.addAttribute("account", account);
		return "/account/accountCreateAdd";
	}
	
	@RequestMapping(value = "/account/account.htm", method = RequestMethod.POST)
	public String addDebit(@ModelAttribute("accountCreateAddForm") AccountCreateAddForm accountCreateAddForm,
			@ModelAttribute("account") Account account,
			@ModelAttribute("accountholder") AccountHolder accountholder){
		account.setAccountType(accountCreateAddForm.getAccountType());
		account.setBalance(accountCreateAddForm.getBalance());
		account.setInterestRate(accountCreateAddForm.getInterestRate());
		account.setUserId(accountholder.getUserId());
		accountService.insertAndLink(account, accountholder);			
		System.out.println("There are now " + accountService.getAccounts().size() + " accounts in the database");
		return "/account/accountCreateAdd";
	}
	
	
	
}//End AccountController
