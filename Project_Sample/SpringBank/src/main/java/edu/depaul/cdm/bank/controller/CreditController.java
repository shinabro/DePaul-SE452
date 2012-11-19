package edu.depaul.cdm.bank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.AccountHolder;

import edu.depaul.cdm.bank.service.AccountService;
import edu.depaul.cdm.bank.form.AddCreditForm;
import edu.depaul.cdm.bank.form.Credit;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.service.CreditService;

@Controller
@SessionAttributes({"accountholder", "account"})
public class CreditController 
{
	private CreditService creditService;
	private AccountService accountService;
	
	@Autowired
	public void setCreditService(CreditService creditService)
	{
		this.creditService = creditService;
	}
	
	@Autowired
	public void setAccountService(AccountService accountService)
	{
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/credit/addCredit.htm", method = RequestMethod.GET)
	public String showAddCredit(ModelMap model,
								@ModelAttribute("accountholder") AccountHolder accountHolder,
								@ModelAttribute("account") Account account)
	{
		Credit credit = new Credit();
		model.addAttribute("credit", credit);
		AddCreditForm addCreditForm = new AddCreditForm();
		model.addAttribute("addCreditForm", addCreditForm);
		Account a = accountService.getAccountById(accountHolder.getUserId());
		model.addAttribute("account",a);
		return "/credit/addCredit";
	}
	
	@RequestMapping(value = "/credit/addCredit.htm", method = RequestMethod.POST)
	public String addCredit(@ModelAttribute("addCreditForm") AddCreditForm addCreditForm,
						    @ModelAttribute("credit") Credit credit,
						    @ModelAttribute("accountholder") AccountHolder accountHolder,
						    @ModelAttribute("account") Account account)
	{
		credit = updateCredit(credit, accountHolder, addCreditForm, account);
		return "/credit/addCredit";
	}
	
	public Credit updateCredit(Credit credit,
							   AccountHolder accountHolder,
							   AddCreditForm addCreditForm, 
							   Account account)
	{
		credit.setAccountId(accountHolder.getUserId());
		credit.setAmount(addCreditForm.getAmount());
		credit.setCreditType(addCreditForm.getCreditType());
		credit.setPostedDate(new Date());
		double balance = account.getBalance() + credit.getAmount();
		credit.setBalance(balance);
		account.setBalance(balance);
		creditService.insert(credit);
		accountService.updateAccount(account);		
		return credit;		
	}
	
	@RequestMapping(value = "/credit/getCreditList.htm", method = RequestMethod.GET)
	public String getDebits(ModelMap model, 
							@ModelAttribute("accountholder") AccountHolder accountHolder)
	{
		System.out.println("getUserId is " + accountHolder.getUserId());
		List<Credit> l = creditService.getAllCredit();
		model.addAttribute("creditList", l);
		List<Debit> l2 = creditService.getAllCreditsByAccountID(accountHolder.getUserId());
		model.addAttribute("creditListByAccountId", l2);
		return "/credit/getCreditHistory";
	}
}
