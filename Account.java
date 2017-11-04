package bankAccuontApp;

public abstract class Account implements IBaseRate{
	//list common properties before saving and checking accounts
	private String sName;
	private String sSN;
	private double dBalance;
	
	static int index = 10000;
	protected String sAccountNum;
	protected double dRate;
	
	//constructor to set base properties and initialize the account
	public Account(String sName, String sSN, double dInitDeposit) {
		this.sName = sName;
		this.sSN = sSN;
		this.dBalance = dInitDeposit;
		
		//set account number
		this.index++;
		this.sAccountNum = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String sLastTwoSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int iUniqueID = index;
		int iRandomNum = (int)(Math.random() * Math.pow(10, 3));
		
		return sLastTwoSSN + iUniqueID + iRandomNum;
	}
	
	public void compound() {
		double dAccruedInterest = this.dBalance * (dRate/100);
		this.dBalance = this.dBalance + dAccruedInterest;
		System.out.println("Accrued Interest: $" + dAccruedInterest);
		printBalance();
	}
	
	//list of common methods - transactions
	public void deposit(double dAmount) {
		this.dBalance = this.dBalance + dAmount;
		System.out.println("Depositing $" + dAmount);
		printBalance();
	}
	
	public void withdraw(double dAmount) {
		this.dBalance = this.dBalance - dAmount;
		System.out.println("Withdrawing $" + dAmount);
		printBalance();
	}
	
	public void transfer(String sToWhere, double dAmount) {
		withdraw(dAmount);
		System.out.println("Transfering $" + dAmount + " to " + sToWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your Balance is now: $" + this.dBalance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + sName + 
				"\nACCOUNT NUMBER: " + sAccountNum + 
				"\nBALACE: $" + dBalance + 
				"\nRate: " + dRate + "%"
				);
	}
	
}
