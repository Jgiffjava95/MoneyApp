package mainPackage;

import java.util.ArrayList;

public class accountDB {

	private ArrayList<Account> accounts = new ArrayList<Account>();
	private static int accountId;

	public static int getNextKey() {
		accountId += 1;
		return accountId;
	}

	public void post(String userName, String password) {
		Account createdUserAccount = new Account(getNextKey(), userName, password, 1000.00);
		accounts.add(createdUserAccount);
	}

	public ArrayList<Account> get() {
		ArrayList<Account> allAccounts = new ArrayList<Account>();
		for (Account i : accounts) {
			allAccounts.add(i);
		}
		return allAccounts;
	}

}
