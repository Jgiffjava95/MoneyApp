package mainPackage;

import mainPackage.MoneyAppEnums.accountTypes;

class Account {
	
	public Account(int accountId, String userName, String password, double accountBalance, accountTypes accountType) {
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}
	
	//Variables
	
	protected int accountId;
	protected String userName;
	protected String password;
	protected double accountBalance;
	protected accountTypes accountType;
	
	//Getters & Setters

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
	
	public accountTypes getAccountType() {
		return accountType;
	}

	public void setAccountTypeBronze(accountTypes accountType) {
		this.accountType = accountType.Bronze;
	}
	
	public void setAccountTypeSilver(accountTypes accountType) {
		this.accountType = accountType.Silver;
	}
	
	public void setAccountTypeGold(accountTypes accountType) {
		this.accountType = accountType.Gold;
	}
	
	//Methods
	
	public void displayAccountData() {
		System.out.println("User Name: " + userName + "\n" +
						   "Password: " + password + "\n" +
						   "Account Balance: " + accountBalance + "\n" +
						   "Wallet Balance: " + "\n" +
						   "User Type: " + accountType);
	}

}
