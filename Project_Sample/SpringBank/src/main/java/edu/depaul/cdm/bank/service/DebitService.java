package edu.depaul.cdm.bank.service;

import java.util.List;

import edu.depaul.cdm.bank.form.Debit;

public interface DebitService {
	public void insertDebit(List<Debit> listDebits);
	public int insertDebit(Debit d);
	public List getAllDebits();
	public List getAllDebitsByAccountId(int accountId);
	public double getBalanceByAccountId(int accountId);
}
