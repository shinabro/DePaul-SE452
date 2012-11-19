package edu.depaul.cdm.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.form.AccountHolderLogin;
import edu.depaul.cdm.bank.service.AccountHolderService;

@Controller
@RequestMapping()
@SessionAttributes("accountholder")
public class AccountHolderController {

	private AccountHolderService accountHolderService;
	@Autowired
	public void setAccountHolderService(AccountHolderService accountHolderService){
		this.accountHolderService = accountHolderService;
	}

	@RequestMapping(value = "/account_holder/accountHolderRegister.htm", method = RequestMethod.GET)
	public String showAddAccountHolder(ModelMap model){
		AccountHolder accountHolder = new AccountHolder();
		model.addAttribute("accountholder", accountHolder);
		return "/account_holder/addAccountHolder";
	}
	
	@RequestMapping(value = "/account_holder/accountHolderRegister.htm", method = RequestMethod.POST)
	public String addAccountHolder(@ModelAttribute("accountholder") AccountHolder accountHolder, ModelMap modelMap) {
		modelMap.addAttribute("accountholder", accountHolder);
		modelMap.addAttribute("accountHolderLogin", new AccountHolderLogin());
		return "redirect:/account_holder/createLoginCredentials.htm";
	}
	
	
	
	@RequestMapping(value = "/account_holder/createLoginCredentials.htm", method = RequestMethod.GET)
	public String createLoginCredentials(ModelMap modelMap) {
		modelMap.addAttribute("accountHolderLogin", new AccountHolderLogin());
		return "/account_holder/createLoginCredentials";
	}
	
	@RequestMapping(value = "/account_holder/createLoginCredentials", method = RequestMethod.POST)
	public String accountSuccess(@ModelAttribute("accountholder") AccountHolder accountHolder, @ModelAttribute("accountHolderLogin") AccountHolderLogin accountHolderLogin){
		accountHolderLogin.setEnabled(1);
		accountHolderLogin.setAuthority("ROLE_USER");
		accountHolderLogin.setAccountHolder(accountHolder);
		accountHolder.setAccountHolderLogin(accountHolderLogin);
		accountHolderService.insert(accountHolder);
		return "redirect:/user_home/userHome.htm";
	}
	
	
	
	@RequestMapping(value = "/account_holder/editPersonalInformation.htm", method = RequestMethod.GET)
	public String displayEditInfo(ModelMap modelMap){
		return "/account_holder/editPersonalInformation";
	}
	
	@RequestMapping(value = "/account_holder/editPersonalInformation.htm", method = RequestMethod.POST)
	public String displayEditInfo(ModelMap modelMap, @ModelAttribute("accountholder") AccountHolder accountHolder){
		accountHolderService.update(accountHolder);
		return "redirect:/user_home/userHome.htm";
	}

	
}
