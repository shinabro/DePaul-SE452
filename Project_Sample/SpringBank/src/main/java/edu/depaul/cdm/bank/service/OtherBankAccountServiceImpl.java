package edu.depaul.cdm.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.cdm.bank.dao.OtherBankAccountDAO;
import edu.depaul.cdm.bank.form.OtherBankAccount;

@Service
public class OtherBankAccountServiceImpl implements
		OtherBankAccountService {

	@Autowired
	private OtherBankAccountDAO otherBankAccountDao;
	
	@Transactional
	public void insert(OtherBankAccount otherBankAccount) {
		otherBankAccountDao.insert(otherBankAccount);
	}

	@Transactional
	public void delete(OtherBankAccount otherBankAccount) {
		otherBankAccountDao.delete(otherBankAccount);
	}

	@Transactional
	public void update(OtherBankAccount otherBankAccount) {
		otherBankAccountDao.update(otherBankAccount);
	}


	public void setOtherBankAccountDao(OtherBankAccountDAO otherBankAccountDao) {
		this.otherBankAccountDao = otherBankAccountDao;
	}

	
	
}
