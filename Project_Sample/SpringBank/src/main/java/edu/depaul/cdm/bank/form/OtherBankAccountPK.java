package edu.depaul.cdm.bank.form;

import java.io.Serializable;

public class OtherBankAccountPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankRoutingNumber;
	private String accountNumber;
	private AccountHolder accountHolder;
	
	
	public String getBankRoutingNumber() {
		return bankRoutingNumber;
	}
	public void setBankRoutingNumber(String bankRoutingNumber) {
		this.bankRoutingNumber = bankRoutingNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountHolder == null) ? 0 : accountHolder.hashCode());
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime
				* result
				+ ((bankRoutingNumber == null) ? 0 : bankRoutingNumber
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OtherBankAccountPK other = (OtherBankAccountPK) obj;
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bankRoutingNumber == null) {
			if (other.bankRoutingNumber != null)
				return false;
		} else if (!bankRoutingNumber.equals(other.bankRoutingNumber))
			return false;
		return true;
	}

	

	
	
}
