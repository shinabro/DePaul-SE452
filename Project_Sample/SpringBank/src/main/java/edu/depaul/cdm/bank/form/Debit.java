package edu.depaul.cdm.bank.form;

import java.util.Date;

public class Debit {

	private int debitId;
	private int accountId;
	private double amount;
	private Date postedDate;
	private String debitType;
	private double balance;
	
	public Debit()
	{
		// Zero argument constructor
	}
	
	public Debit(int accountId, double amount, Date postedDate, String debitType, double balance)
	{
		this.accountId = accountId;
		this.amount = amount;
		this.postedDate = postedDate;
		this.debitType = debitType;
		this.balance = balance;
	}	
	
	public int getDebitId() {
		return debitId;
	}
	
	public void setDebitId(int debitId) {
		this.debitId = debitId;
	}
	
	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


	public String getDebitType() {
		return debitType;
	}


	public void setDebitType(String debitType) {
		this.debitType = debitType;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
