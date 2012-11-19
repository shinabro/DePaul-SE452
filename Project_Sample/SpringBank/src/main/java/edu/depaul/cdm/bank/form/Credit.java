package edu.depaul.cdm.bank.form;

import java.util.Date;

public class Credit {
	private int creditId;
	private String creditType;
	private int accountId;
	private double amount;
	private Date postedDate;
	private String category;
	private double balance;
	private String description;

	//***************'structors******************
	public Credit()	
	{
		//empty
	}
	
	public Credit( String creditType,
				   int accountId,
				   double amount,
				   Date postedDate, 
				   String category,
				   double balance, 
				   String description )
	{
		this.creditType = creditType;
		this.accountId = accountId;
		this.amount = amount;
		this.postedDate = postedDate;
		this.category = category;
		this.balance = balance;
		this.description = description;
	}	

	public int getCreditId(){
		return creditId;
	}

	public void setCreditId(int creditId){
		this.creditId = creditId;
	}
	
	public String getCreditType() 
	{
		return creditType;
	}

	public void setCreditType(String creditType)
	{
		this.creditType = creditType;
	}

	public int getAccountId(){
		return this.accountId;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public Date getPostedDate(){
		return postedDate;
	}

	public void setPostedDate(Date postedDate){
		this.postedDate = postedDate;
	}

	public String getCategory() 
	{
		return this.category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
