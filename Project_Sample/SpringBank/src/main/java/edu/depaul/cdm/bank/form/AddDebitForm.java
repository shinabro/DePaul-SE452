package edu.depaul.cdm.bank.form;

public class AddDebitForm {
	private String debitType;
	private double amount;
	private double balance;

	public String getDebitType() {
		return debitType;
	}

	public void setDebitType(String debitType) {
		this.debitType= debitType;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount= amount;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance= balance;
	}
}
