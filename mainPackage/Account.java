package mainPackage;

import java.util.ArrayList;

class Account {

	private int accountId;
	private String userName;
	private String password;
	private int accountBalance;
	private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
	private ArrayList<String> knownAccounts = new ArrayList<String>();

	public Account(int accountId, String userName, String password, int accountBalance) {
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

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
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

		if (knownAccounts.size() == 0) {
			knownAccounts.add(knownAccount);
		} else {

			for (String i : knownAccounts) {
				if (i.toString().equals(knownAccount)) {
					break;
				} else {
					knownAccounts.add(knownAccount);
				}
			}
		}
	}

}
