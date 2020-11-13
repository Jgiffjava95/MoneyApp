package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class prompt {

	private accountDB db = new accountDB();
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

		db.post(userName, password);
	}

	private String createUserName() {
		while (true) {
			System.out.println("Create Username.");
			String userName = stringListener();
			if (validateUserNameCreate(userName) == true) {
				return userName;
			}
			continue;
		}
	}

	private String createPassword() {
		while (true) {
			System.out.println("Create Password.");
			String password = stringListener();

			System.out.println("Enter Password Again.");
			String passwordCheck = stringListener();

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

		ArrayList<Account> accounts = db.get();

		if (userName.length() <= 20 && userName.length() >= 3) {
			for (Account i : accounts) {
				if (i.getUserName().equals(userName)) {
					System.out.println(userName + " is already taken.");
					return false;
				}
			}
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
		ArrayList<Account> allAccounts = new ArrayList<Account>(db.get());

		while (true) {

			System.out.println("***Login***");
			System.out.println("Enter Username.");
			String userName = listener.nextLine();
			System.out.println("Enter Password.");
			String password = listener.nextLine();

			for (Account i : allAccounts) {
				if (userName.equals(i.getUserName())) {
					if (password.equals(i.getPassword())) {
						System.out.println("Login Successful, Welcome " + i.getUserName() + "!");
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
			System.out.println("3. Transaction History");
			System.out.println("4. Known Accounts");
			System.out.println("5. Log Out");

			switch (intListener()) {

			case 1:
				System.out.println("Account Balance: $" + i.getAccountBalance());
				continue;
			case 2:
				createTransactionWithUser();
				continue;
			case 3:
				continue;
			case 4:
				continue;
			case 5:
				start();
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			}
		}

	}

	private void createTransactionWithUser() {
		while (true) {
			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("Who would you like to send to?");
			System.out.println("1. Enter Username Manually");
			System.out.println("2. Known Accounts");
			System.out.println("0. Go Back");

			switch (intListener()) {

			case 1:
				searchUsername();
				break;
			case 2:
				selectViaKnownAccounts();
				break;
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			case 0:
				return;
			}
		}

	}

	private void selectViaKnownAccounts() {
		// TODO Auto-generated method stub

	}

	private void searchUsername() {
		// TODO Auto-generated method stub

	}

}
