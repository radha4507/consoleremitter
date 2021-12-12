package com.admindto;

public class Remitter {
	
	private String accountNumber;
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIfsc() {
		return customerIfsc;
	}

	public void setCustomerIfsc(String customerIfsc) {
		this.customerIfsc = customerIfsc;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	private String customerIfsc;
	private String customerAddress;
	private String balance;
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}