package edu.depaul.cdm.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.depaul.cdm.bank.form.AccountHolder;
import edu.depaul.cdm.bank.service.AccountHolderService;


@Controller
@SessionAttributes("accountholder")
public class LoginController {
	
	@Autowired
	private AccountHolderService accountHolderService;

	public void setAccountHolderService(AccountHolderService accountHolderService){
		this.accountHolderService = accountHolderService;
	}
	
	@RequestMapping(value = "/login/loginSuccess.htm", method = RequestMethod.GET)
	public String loginSuccess(ModelMap model){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		AccountHolder accountHolder = accountHolderService.getAccountHolderByUserName(userName);
		model.addAttribute("accountholder", accountHolder);
		return "redirect:/user_home/userHome.htm";
	}
	
	@RequestMapping(value = "/login/login.htm", method = RequestMethod.GET)
	public String displayLogin(ModelMap model){
		return "/login/login";
	}
	
	@RequestMapping(value = "/login/loginFailed.htm", method = RequestMethod.GET)
	public String loginFailed(ModelMap model){
		model.addAttribute("error", "true");
		return "/login/login";
	}
	
	@RequestMapping(value = "/login/logout.htm", method = RequestMethod.GET)
	public String displayLogout(ModelMap model){
		return "/login/login";
	}
}
	
