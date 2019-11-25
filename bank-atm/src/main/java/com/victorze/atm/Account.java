package com.victorze.atm;

public class Account {

	private String cardNumber;
	private String pinCode;
	private double balance;

	public Account(String cardNumber, String pinCode, double balance) {
		this.cardNumber = cardNumber;
		this.pinCode = pinCode;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public boolean withdrawal(double amount) {
		if (amount > balance) {
			return false;
		} else {
			balance -= amount;
			return true;
		}
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean checkAccount(String cardNumber, String pinCode) {
		return this.cardNumber.equals(cardNumber) && this.pinCode.equals(pinCode);
	}
}
