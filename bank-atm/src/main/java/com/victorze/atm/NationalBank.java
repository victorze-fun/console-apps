package com.victorze.atm;

import java.util.ArrayList;
import java.util.List;

public class NationalBank {
	
	private static final int START_TRANSACTION = 1;
	private static final int EXIT_APP = 2;
	private static final int OPTION_SEE_BALANCE = 1;
	private static final int OPTION_DEPOSIT = 2;
	private static final int OPTION_WITHDRAWAL = 3;
	private static final int OPTION_EXIT = 4;
	
	private List<Account> accounts = new ArrayList<>();
	private ATMScreen atm = new ATMScreen();

	public void execute() {

		Account account;
		testAccounts();
		
		while (true) {
	    	atm.showStartMenu();
	    	int optionStart = atm.readOption();
	    	if (optionStart == EXIT_APP) {
	    		atm.msgExitApp();
	    		return;
	    	} else if (optionStart == START_TRANSACTION) {
	    		account = checkAccess();

		    	while (true) {
		    		atm.showMainMenu();
		    		int option = atm.readOption();
		        	if (option == OPTION_EXIT) {
		        		break;
		        	}
		        	processOperation(account, option);
		    	}
	    	} else {
	    		atm.msgInvalidCode();
	    		atm.pressEnterContinue();
	    	}
		}
	}

	private Account checkAccess() {
		Account verifiedAccount = null;
		do {
			String cardNumber = atm.readCardNumber();
			String pinCode = atm.readPinCode();
			for (Account account : accounts) {
				if (account.checkAccount(cardNumber, pinCode)) {
					verifiedAccount = account;
				}
			}
			if (verifiedAccount == null) {
				atm.msgInvalidCard();
			}
		} while(verifiedAccount == null);
		return verifiedAccount;
	}
	
	private void processOperation(Account account, int option) {
		if (option == OPTION_SEE_BALANCE) {
			atm.seeBalance(account.getBalance());
			atm.pressEnterContinue();
		} else if (option == OPTION_DEPOSIT) {
			double amount = atm.readAmountDeposit();
			account.deposit(amount);
			atm.msgSuccessfullyAmount(amount);
			atm.seeBalance(account.getBalance());
			atm.pressEnterContinue();
		} else if (option == OPTION_WITHDRAWAL) {
			double amount = atm.readAmountWithdrawal();
			if (account.withdrawal(amount)) {
				atm.msgSuccessfullyWithdrawal(amount);
				atm.seeBalance(account.getBalance());
				atm.pressEnterContinue();
			} else {
				atm.msgInsufficientFunds();
				atm.seeBalance(account.getBalance());
				atm.pressEnterContinue();
			}
		}
	}
	
	private void testAccounts() {
		accounts.add(new Account("123", "111111", 2000));
		accounts.add(new Account("678", "222222", 1000));
	}
}
