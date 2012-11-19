package edu.depaul.cdm.bank.dao;

import java.util.List;

import edu.depaul.cdm.bank.form.Account;
import edu.depaul.cdm.bank.form.Debit;

public interface DebitDAO {
	public void insert(List<Debit> listDebits);
	public int insert(Debit d);
	public List<Debit> findAll();
	public List<Debit> findAllByAccountId(int accountId);
	public Account getAccountByAccountId(int accountId);
}
