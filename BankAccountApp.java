package bankAccuontApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		Checking checkAccount;
		Savings savingAccount;
		String sFile;
		String sName;
		String sSN;
		String sAccountType;
		double dInitDeposit;
		
		sFile = "E:\\Java Projects\\NewBankAccounts.csv";
		
		//read a CSV file then create new accounts cased on that data
		List<String[]> newAccountHolders = utilities.CSVReader.readCSV(sFile);
		
		//cycle the list of account holders
		for (String[] accountHolder : newAccountHolders) {
			sName = accountHolder[0];
			sSN = accountHolder[1];
			sAccountType = accountHolder[2];
			dInitDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(sName + " " + sSN + " " + sAccountType + " $" + dInitDeposit);
			
			if (sAccountType.equals("Savings")) {
				//create new saving account
				savingAccount = new Savings(sName, sSN, dInitDeposit);
				accounts.add(savingAccount);
			} 
			else if (sAccountType.equals("Checking")) {
				//create new checking account
				checkAccount = new Checking(sName, sSN, dInitDeposit);
				accounts.add(checkAccount);
			} 
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//output account list
		for (Account acc : accounts) {
			acc.showInfo();
			System.out.println("*********************************");
		}
		
		/*
		//other actions we can do
		accounts.get((int) Math.random() * accounts.size()).deposit(1000);
		accounts.get((int) Math.random() * accounts.size()).withdraw(2300);
		accounts.get((int) Math.random() * accounts.size()).compound();
		*/
			
	}
}
