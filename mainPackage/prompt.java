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
		try {
			int intListener = Integer.parseInt(listener.nextLine());
			return intListener;
		} catch (NumberFormatException e) {
			System.out.println("That is not a number");
		}
		return 0;
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
		System.out.println("Enter 0 into Username or password field to back out.");
		String userName = createUserName();
		String password = createPassword();

		db.post(userName, password);
	}

	private String createUserName() {
		while (true) {
			System.out.println("Create Username.");
			String userName = stringListener();
			if (userName.equals("0")) {
				initialMenuSelections();
			}
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

			if (password.equals("0")) {
				initialMenuSelections();
			}

			System.out.println("Enter Password Again.");
			String passwordCheck = stringListener();

			if (passwordCheck.equals("0")) {
				initialMenuSelections();
			}

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

		ArrayList<Account> Accounts = new ArrayList<Account>(db.get());

		if (userName.length() <= 20 && userName.length() >= 3) {
			for (Account i : Accounts) {
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

		while (true) {

			ArrayList<Account> Accounts = new ArrayList<Account>(db.get());

			System.out.println("***Login***");
			System.out.println("Enter 0 into Username or password field to back out.");
			System.out.println("Enter Username.");
			String userName = listener.nextLine();

			if (userName.equals("0")) {
				initialMenuSelections();
			}
			System.out.println("Enter Password.");
			String password = listener.nextLine();

			if (password.equals("0")) {
				initialMenuSelections();
			}

			for (Account i : Accounts) {
				if (userName.equals(i.getUserName())) {
					if (password.equals(i.getPassword())) {
						System.out.println("Login Successful, Welcome " + i.getUserName() + "!");
						userMenu(i);
					}
				}
			}
			System.out.println("Invalid Username or Password.");
			return;
		}
	}

	private void userMenu(Account user) {
		while (true) {

			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("1. Check Balance");
			System.out.println("2. Send Money");
			System.out.println("3. Transaction History");
			System.out.println("4. Known Accounts");
			System.out.println("5. Log Out");

			switch (intListener()) {

			case 1:
				System.out.println("Account Balance: $" + user.getAccountBalance());
				continue;
			case 2:
				createTransactionWithUser(user);
				continue;
			case 3:
				transactionHistoryDisplay(user);
				continue;
			case 4:
				knownAccountsDisplay(user);
				continue;
			case 5:
				start();
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			}
		}

	}

	private void knownAccountsDisplay(Account user) {

		if (user.getKnownAccounts().size() == 0) {
			System.out.println("You have no known accounts.");
		}

		for (String i : user.getKnownAccounts()) {
			System.out.println("Username: " + i);
		}
		return;

	}

	private void transactionHistoryDisplay(Account user) {

		if (user.getTransactions().size() == 0) {
			System.out.println("You have no previous transactions.");
		}

		for (Transaction i : user.getTransactions()) {
			System.out.println("Sender: " + i.getSender() + " Reciever: " + i.getReciever() + " Ammount: $"
					+ i.getAmmountTransfered());
		}
		return;
	}

	private void createTransactionWithUser(Account user) {
		while (true) {
			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("Who would you like to send to?");
			System.out.println("1. Enter Username Manually");
			System.out.println("2. Known Accounts");
			System.out.println("0. Go Back");

			switch (intListener()) {

			case 1:
				searchUsername(user);
				break;
			case 2:
				selectViaKnownAccounts(user);
				break;
			default:
				System.out.println("Please Enter a valid option.");
				continue;
			case 0:
				return;
			}
		}

	}

	private void selectViaKnownAccounts(Account user) {
		ArrayList<Account> Accounts = new ArrayList<Account>(db.get());

		if (user.getKnownAccounts().size() == 0) {
			System.out.println("You have no known accounts.");
			return;
		}

		while (true) {
			System.out.println("Please SELECT an OPTION by entering a coresponding NUMBER.");
			System.out.println("0. Exit");
			for (String i : user.getKnownAccounts()) {
				int index = 1;
				System.out.println(index + ". " + i);
				index += 1;
			}
			int selection = intListener();

			if (selection == 0) {
				return;
			} else if (selection > 0) {
				selection -= 1;
			}

			if (selection > user.getKnownAccounts().size() - 1) {
				System.out.println("Please Enter a valid option.");
			} else {
				String knownUserName = user.getKnownAccounts().get(selection);
				for (Account i : Accounts) {
					if (knownUserName.equals(i.getUserName())) {
						sendAmount(user, i);
					}
				}
			}
		}
	}

	private void searchUsername(Account user) {

		ArrayList<Account> Accounts = new ArrayList<Account>(db.get());

		while (true) {
			System.out.print("Enter the Username you want to send to.");
			String userName = stringListener();
			for (Account i : Accounts) {
				if (userName.equals(i.getUserName())) {
					sendAmount(user, i);
				}
			}
			System.out.println("Unkown user: " + userName);
			break;
		}
	}

	private void sendAmount(Account user, Account reciever) {
		while (true) {
			System.out.print("How much would you like to send?");
			int transferAmount = intListener();
			
			if (transferAmount == 0) {
				System.out.println("Cannot send $0.");
				return;
			}
			
			if (validateTransferAmount(transferAmount, user) == true) {

				user.setAccountBalance(user.getAccountBalance() - transferAmount);
				reciever.setAccountBalance(reciever.getAccountBalance() + transferAmount);

				Transaction currentTransaction = new Transaction(user.getUserName(), reciever.getUserName(),
						transferAmount);

				user.setTransactions(currentTransaction);
				reciever.setTransactions(currentTransaction);

				user.setKnownAccounts(reciever.getUserName());
				reciever.setKnownAccounts(user.getUserName());

				System.out.println(transferAmount + " has been sent to " + reciever.getUserName() + ".");

				userMenu(user);
			}
			System.out.println("You do not have enough money to send that amount.");
		}
	}

	private boolean validateTransferAmount(double transferAmount, Account user) {
		if (transferAmount > user.getAccountBalance()) {
			return false;
		}
		return true;
	}

}
