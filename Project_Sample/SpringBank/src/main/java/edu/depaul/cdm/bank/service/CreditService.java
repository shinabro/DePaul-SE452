package edu.depaul.cdm.bank.service;

import java.util.List;

import edu.depaul.cdm.bank.form.Credit;

public interface CreditService 
{
	public int insert(Credit credit);
	public void insert(List<Credit> listCredits);
	public Credit getCreditByCreditID(int creditID);
	public List<Credit> getAllCredit();
	public Credit getCreditByAccountID(int accountID);
	public List getAllCreditsByAccountID(int accountID);
	public double getBalanceByAccountID(int accountID);
	public void update(Credit credit);
	public void delete(int creditID);
	public void delete(Credit credit);
}
