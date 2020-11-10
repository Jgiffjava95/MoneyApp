package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class prompt {

	private mockDB db = new mockDB();
	private Scanner listener = new Scanner(System.in);

	public void start() {
		System.out.println("***Welcome to Money App!***");
		initialMenuSelections();
	}

	private int intListener() {
		int intListener = Integer.parseInt(listener.nextLine());
		return intListener;
	}

	private String stringListener() {
		String stringListener = listener.nextLine();
		return stringListener;
	}

	private void initialMenuSelections() {
		while (true) {
			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("1. Log In");
			System.out.println("2. Create Account");
			System.out.println("3. Close Program");
			switch (intListener()) {

			case 1:
				loginUser();
				break;
			case 2:
				createAccount();
				break;
			case 3:
				end();
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			}
		}
	}

	private void createAccount() {
		System.out.println("***Create Account***");
		String userName = createUserName();
		String password = createPassword();

		db.createAccount(userName, password);
	}

	private String createUserName() {
		while (true) {
			System.out.println("Create Username.");
			String userName = listener.nextLine();
			if (validateUserNameCreate(userName) == true) {
				return userName;
			}
			continue;
		}
	}

	private String createPassword() {
		while (true) {
			System.out.println("Create Password.");
			String password = listener.nextLine();

			System.out.println("Enter Password Again.");
			String passwordCheck = listener.nextLine();

			if (validatePasswordCreate(password, passwordCheck) == true) {
				return password;
			}
			continue;
		}
	}

	private void end() {
		System.out.println("***Program Closed***");
		System.exit(0);
	}

	private boolean validateUserNameCreate(String userName) {
		if (userName.length() <= 20 && userName.length() >= 3) {
			return true;
		}
		System.out.println("Username must be longer than 3 but no longer than 20 characters.");
		return false;
	}

	private boolean validatePasswordCreate(String password, String passwordCheck) {
		if (password.equals(passwordCheck)) {
			if (password.length() <= 20) {
				return true;
			} else {
				System.out.println("Password must not be longer than 20 characters.");
				return false;
			}
		}
		System.out.println("Entered Passwords do not match.");
		return false;
	}

	private void loginUser() {
		ArrayList<Account> allAccounts = new ArrayList<Account>(db.getAccounts());

		while (true) {

			System.out.println("***Login***");
			System.out.println("Enter Username.");
			String userName = listener.nextLine();
			System.out.println("Enter Password.");
			String password = listener.nextLine();

			for (Account i : allAccounts) {
				if (userName.equals(i.userName)) {
					if (password.equals(i.password)) {
						System.out.println("Login Successful, Welcome " + i.userName + "!");
						userMenu(i);
					}
				}
			}
			System.out.println("Invalid Username or Password.");
			continue;
		}
	}

	private void userMenu(Account i) {
		while (true) {

			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("1. Check Balance");
			System.out.println("2. Send Money");
			System.out.println("3. Send History");
			System.out.println("4. Recieve History");
			System.out.println("5. Log Out");

			switch (intListener()) {

			case 1:
				System.out.println("Account Balance: $" + i.accountBalance);
				continue;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				start();
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			}
		}

	}

}
