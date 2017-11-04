package bankAccuontApp;

public class Checking extends Account{
	//list the properties specific to Checking account
	private int iDebitCardNum;
	private int iDebitCardPIN;
	
	//constructor to initialize checking account properties
	public Checking(String sName, String sSN, double dInitDeposit) {
		super(sName, sSN, dInitDeposit);
		sAccountNum = "2" + sAccountNum;
		setDebitCard();
	}
	
	public void setRate() {
		dRate = getBaseRate() * .15;
	}
	
	private void setDebitCard() {
		this.iDebitCardNum = (int) (Math.random() * Math.pow(10, 12)); 
		this.iDebitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	//list any methods specific to the checking account
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();   //run Account.showInfo()
		System.out.println(
				" Your Checking Account Features" + 
				"\n Debit Card Number: " + iDebitCardNum +
				"\n Debit Card PIN: " + iDebitCardPIN
				);
	}
}
