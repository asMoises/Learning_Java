package entities;

public class Account {
	private int number;
	private String holder;
	private double balance;

	public Account(String holder, int number) {
		this.holder = holder;
		this.number = number;
	}

	public Account(String holder, int number, double initialDeposit) {
		this.holder = holder;
		this.number = number;
		deposit(initialDeposit);
	}

	public void deposit(double amount) {
		balance += amount;

	}

	public void withdraw(double amount) {
		balance -= amount + 5.0;
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() { // sobreposição do toString da classe object
		return "Account data:\nAccount: " + getNumber() + ", Holder: " + getHolder() + ", Balance: "
				+ String.format("%.2f", getBalance());
	}

}
