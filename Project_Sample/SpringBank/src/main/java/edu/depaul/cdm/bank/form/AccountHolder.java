package edu.depaul.cdm.bank.form;

import java.util.HashSet;
import java.util.Set;

public class AccountHolder {

	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String title;
	private String ssn;
	private String mailingAddress;
	private String mailingCity;
	private String mailingState;
	private String mailingZip;
	private String physicalAddress;
	private String physicalCity;
	private String physicalState;
	private String physicalZip;
	private String userPhone;
	private String userEmail;
	private String employerName;
	private String employerPhone;
	private int salary;
	private Set<AccountHolderToAccount> accountHolderToAccounts = new HashSet<AccountHolderToAccount>(0);
	private Set<OtherBankAccount> otherBankAccounts = new HashSet<OtherBankAccount>(0);
	private AccountHolderLogin accountHolderLogin;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getMailingCity() {
		return mailingCity;
	}
	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}
	public String getMailingState() {
		return mailingState;
	}
	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}
	public String getMailingZip() {
		return mailingZip;
	}
	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public String getPhysicalCity() {
		return physicalCity;
	}
	public void setPhysicalCity(String physicalCity) {
		this.physicalCity = physicalCity;
	}
	public String getPhysicalState() {
		return physicalState;
	}
	public void setPhysicalState(String physicalState) {
		this.physicalState = physicalState;
	}
	public String getPhysicalZip() {
		return physicalZip;
	}
	public void setPhysicalZip(String physicalZip) {
		this.physicalZip = physicalZip;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerPhone() {
		return employerPhone;
	}
	public void setEmployerPhone(String employerPhone) {
		this.employerPhone = employerPhone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<AccountHolderToAccount> getAccountHolderToAccounts() {
		return accountHolderToAccounts;
	}
	public void setAccountHolderToAccounts(
			Set<AccountHolderToAccount> accountHolderToAccounts) {
		this.accountHolderToAccounts = accountHolderToAccounts;
	}
	public Set<OtherBankAccount> getOtherBankAccounts() {
		return otherBankAccounts;
	}
	public void setOtherBankAccounts(Set<OtherBankAccount> otherBankAccounts) {
		this.otherBankAccounts = otherBankAccounts;
	}
	public AccountHolderLogin getAccountHolderLogin() {
		return accountHolderLogin;
	}
	public void setAccountHolderLogin(AccountHolderLogin accountHolderLogin) {
		this.accountHolderLogin = accountHolderLogin;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		AccountHolder other = (AccountHolder) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return firstName + " " + lastName + ": ID= " + userId;
	}
}