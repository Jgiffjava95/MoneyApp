package mainPackage;

public class Transaction {
	
	private String sender;
	private String reciever;
	private double ammountTransfered;
	//Going to add DateTime variable later.
	
	public Transaction(String sender, String reciever, double ammountTransfered) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.ammountTransfered = ammountTransfered;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public double getAmmountTransfered() {
		return ammountTransfered;
	}

	public void setAmmountTransfered(double ammountTransfered) {
		this.ammountTransfered = ammountTransfered;
	}
	
	
	
}
