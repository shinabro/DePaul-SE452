package edu.depaul.cdm.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.Credit;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.service.AccountHolderService;
import edu.depaul.cdm.bank.service.AccountService;
import edu.depaul.cdm.bank.service.CreditService;
import edu.depaul.cdm.bank.service.DebitService;


@Controller
@SessionAttributes("accountholder")
public class UserHomeController {
	
	@Autowired
	private AccountHolderService accountHolderService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CreditService creditService;
	@Autowired
	private DebitService debitService;

	public void setAccountHolderService(AccountHolderService accountHolderService){
		this.accountHolderService = accountHolderService;
	}
	
	public void setCreditService(CreditService creditService) {
		this.creditService = creditService;
	}

	public void setDebitService(DebitService debitService) {
		this.debitService = debitService;
	}
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	@RequestMapping( value = "/user_home/userHome.htm", method = RequestMethod.GET)
	public String displayHome(@ModelAttribute("accountholder") AccountHolder accountHolder, ModelMap modelMap) {
		List<Account> accountsList = accountService.retrieveAccountByUser(accountHolder.getUserId());
		modelMap.addAttribute("accountsList", accountsList);
		return "/user_home/userHome";
	}
	
	@RequestMapping( value = "/user_home/viewAccount.htm", method = RequestMethod.POST)
	public String displayAccount(@RequestParam("accountId") int accountId, ModelMap modelMap){
		List<Credit> creditsList = creditService.getAllCreditsByAccountID(accountId);
		List<Debit> debitsList = debitService.getAllDebitsByAccountId(accountId);
		Account account = accountService.getAccountById(accountId);
		modelMap.addAttribute("account", account);
		modelMap.addAttribute("creditsList", creditsList);
		modelMap.addAttribute("debitsList", debitsList);
		return "/user_home/viewAccount";
	}
}
