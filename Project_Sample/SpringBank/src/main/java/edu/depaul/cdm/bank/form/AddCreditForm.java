package edu.depaul.cdm.bank.form;

public class AddCreditForm 
{
	private String creditType;
	private double amount;
	private double balance;

	public String getCreditType() 
	{
		return creditType;
	}

	public void setCreditType(String creditType) 
	{
		this.creditType= creditType;
	}
	
	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount= amount;
	}
	
	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance= balance;
	}
}
