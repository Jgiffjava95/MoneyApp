package mainPackage;

public class Transaction {
	
	private String sender;
	private String reciever;
	private int ammountTransfered;
	//Going to add DateTime variable later.
	
	public Transaction(String sender, String reciever, int ammountTransfered) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.ammountTransfered = ammountTransfered;
	}
	
}
