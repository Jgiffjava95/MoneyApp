package mainPackage;

import java.util.ArrayList;

import mainPackage.MoneyAppEnums.accountTypes;

public class mockDB {

	private ArrayList<Account> accounts = new ArrayList<Account>();
	private static int accountId;

	public static int getNextKey() {
		accountId += 1;
		return accountId;
	}

	public void createAccount(String userName, String password) {
		Account createdUserAccount = new Account(getNextKey(), userName, password, 1000.00, accountTypes.Bronze);
		accounts.add(createdUserAccount);
	}
	
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> allAccounts = new ArrayList<Account>();
		for (Account i : accounts) {
			allAccounts.add(i);
		}
		return allAccounts;
	}
}
