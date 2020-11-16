package mainPackage;

import java.util.ArrayList;

class Account {
	
		private int accountId;
		private String userName;
		private String password;
		private double accountBalance;
		private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
		private ArrayList<String> knownAccounts = new ArrayList<String>();
		
	public Account(int accountId, String userName, String password, double accountBalance) {
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
		this.accountBalance = accountBalance;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactionHistory;
	}

	public void setTransactions(Transaction transaction) {
		transactionHistory.add(transaction);
	}
	public ArrayList<String> getKnownAccounts() {
		return this.knownAccounts;
	}

	public void setKnownAccounts(String knownAccount) {
		this.knownAccounts.add(knownAccount);
	}
	
	
	
	

}
