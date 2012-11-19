package edu.depaul.cdm.bank.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Date;
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
import edu.depaul.cdm.bank.form.AccountCreateAddForm;
import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountType;
import edu.depaul.cdm.bank.form.AddDebitForm;
import edu.depaul.cdm.bank.form.Debit;
import edu.depaul.cdm.bank.form.DebitType;
import edu.depaul.cdm.bank.service.DebitService;
import edu.depaul.cdm.bank.service.AccountService;

@Controller
@SessionAttributes({"accountholder", "account"})
public class DebitController {

	private DebitService debitService;
	private AccountService accountService;
	
	@Autowired
	public void setDebitService(DebitService debitService) {
		this.debitService = debitService;
	}
	
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/debit/addDebit.htm", method = RequestMethod.GET)
	public String showAddDebit(ModelMap model,
			@ModelAttribute("accountholder") AccountHolder accountHolder,
			@ModelAttribute("account") Account account){
		Debit debit = new Debit();
		model.addAttribute("debit", debit);
		AddDebitForm addDebitForm = new AddDebitForm();
		model.addAttribute("addDebitForm", addDebitForm);
		Account a = accountService.getAccountById(accountHolder.getUserId());
		model.addAttribute("account",a);
		return "/debit/addDebit";
	}
	
	@RequestMapping(value = "/debit/getDebitList.htm", method = RequestMethod.GET)
	public String getDebits(ModelMap model, @ModelAttribute("accountholder") AccountHolder accountHolder){
		System.out.println("getUserId is " + accountHolder.getUserId());
		List<Debit> l = debitService.getAllDebits();
		model.addAttribute("debitList", l);
		List<Debit> l2 = debitService.getAllDebitsByAccountId(accountHolder.getUserId());
		model.addAttribute("debitListByAccountId", l2);
		return "/debit/getDebitHistory";
	}

	@RequestMapping(value = "/debit/addDebit.htm", method = RequestMethod.POST)
	public String addDebit(@ModelAttribute("addDebitForm") AddDebitForm addDebitForm,
			@ModelAttribute("debit") Debit debit,
			@ModelAttribute("accountholder") AccountHolder accountHolder,
			@ModelAttribute("account") Account account) {
		debit = updateDebitInfo(debit, accountHolder, addDebitForm, account);
		return "/debit/addDebit";
	}
	
	public Debit updateDebitInfo(Debit debit, AccountHolder accountHolder,
			AddDebitForm addDebitForm, Account account){
		debit.setAccountId(accountHolder.getUserId());
		debit.setAmount(addDebitForm.getAmount());
		debit.setDebitType(addDebitForm.getDebitType());
		debit.setPostedDate(new Date());
		double balance = account.getBalance() - debit.getAmount();
		debit.setBalance(balance);
		account.setBalance(balance);
		debitService.insertDebit(debit);
		accountService.updateAccount(account);		
		return debit;		
	}
	
}
