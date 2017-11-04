package bankAccuontApp;

public class Savings extends Account{
	//list properties specific to the saving account
	private int iSafetyDepositBoxID;
	private int iSafetyDepositBoxKey;
	
	//constructor to initialize settings for the Savings properties
	public Savings(String sName, String sSN, double dInitDeposit) {
		super(sName, sSN, dInitDeposit);
		sAccountNum = "1" + sAccountNum;
		this.setSafetyDeposBox();
	}
	
	public void setRate() {
		dRate = getBaseRate() - .25;
	}
	
	private void setSafetyDeposBox() {
		this.iSafetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		this.iSafetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));		
	}
	
	//list any methods specific to Savings account
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();   //run Account.showInfo()
		System.out.println(
				" Your Saving Account Features" + 
				"\n Safety Deposit Box ID: " + iSafetyDepositBoxID +
				"\n Safety Deposit Box Key: " + iSafetyDepositBoxKey 
				);
	}
}
