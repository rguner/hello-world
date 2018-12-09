package model;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private String name;
	private Integer accountId;
	private double balance;
	public List<String> transactions = new ArrayList<>();

	public Account(Integer accountId, String name, double balance) {
		this.accountId = accountId;
		this.name = name;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountId=" + accountId + ", balance=" + balance + ", transactions=" + transactions + "]";
	}

}
