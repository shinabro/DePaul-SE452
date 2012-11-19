package edu.depaul.cdm.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.OtherBankAccount;
import edu.depaul.cdm.bank.service.OtherBankAccountService;


@Controller
@RequestMapping("/account_holder/addOtherBankAccount.htm")
@SessionAttributes("accountholder")
//This servlet assumes that it is contained in the HttpSession attributes
public class OtherBankAccountController {
	
	@Autowired
	private OtherBankAccountService otherBankAccountService;

	public void setOtherBankAccountService(
			OtherBankAccountService otherBankAccountService) {
		this.otherBankAccountService = otherBankAccountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAddOtherBankAccount(@ModelAttribute("accountholder") AccountHolder accountHolder, ModelMap model){
		OtherBankAccount otherBankAccount = new OtherBankAccount();
		otherBankAccount.setAccountHolder(accountHolder);
		model.addAttribute("otherBankAccount", otherBankAccount);
		model.addAttribute("accountholder", accountHolder);
		return "/account_holder/addOtherBankAccount";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addOtherBankAccount(@ModelAttribute("otherBankAccount") OtherBankAccount otherBankAccount, @ModelAttribute("accountholder") AccountHolder accountHolder){
		System.out.println(accountHolder.getUserId());
		otherBankAccount.setAccountHolder(accountHolder);
		otherBankAccountService.insert(otherBankAccount);
		return "redirect:/user_home/userHome.htm";
	}
	
}
