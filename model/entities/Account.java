package model.entities;

import model.exceptions.AccountExampleExceptions;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit)
			throws AccountExampleExceptions {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		
		if (amount > balance)
			throw new AccountExampleExceptions("Witthdraw Error: Not enough balance");
		
		if (amount > withdrawLimit)
			throw new AccountExampleExceptions("Witthdraw Error: The amount exceeds withdraw daily limit!");

		

		balance -= amount;
	}
}
