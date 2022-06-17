import java.io.*;
import java.util.*;
import Utilities.*;

/* Student: Michael Garrison
 * Assignment: Lab 6 Banking System III
 * Course: CST8132 300
 * Professor: Michel Choueiry
 * Date: April 3, 2022
 *  @author Garrison
 */

public class Bank {
	// ArrayList of Account  
	private static ArrayList <Account> account; 
	private String name;
	ChequingAccount chq;
	SavingsAccount sav;
	UserInput in = new UserInput();
	Person p;
	Account acc;
	
	Bank(String name, int num){
		this.name=name;
		Bank.account = new ArrayList<Account>(num);
	}
	
	public void readAccountDetails() {
		int count=1;
		int select=0;
		int newSize = account.size()+1;
		do {
		System.out.println("1. Chequing\n2. Savings");
		select = in.integerInput();
		if(select>3||select<0) {
			System.out.println("incorrect selection");
		} else
		if(select==1) {
			account.add(new ChequingAccount(newSize, p));
			select=0;
		}else
		  if(select==2){
			account.add(new SavingsAccount(newSize, p));
			select=0;
				}
		}while(select!=0);
		System.out.println();
		System.out.println("Details of Account " + (count));
		account.get(account.size()-1).readAccount();
		count++;
	}

	//=============Serialized=Read==================================	
	
	public void readFileSerialized() throws Exception{
		try {
			FileInputStream fileIn = new FileInputStream("AccountsOutput.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
//			for(Account accountRead : account) {    // this has to go
//				System.out.println(accountRead);    // this has to go
//			}	
			in.close();
			fileIn.close();
			System.out.println("Saved to File!");
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found Exception.");	
		} catch (IOException i) {
			System.out.println("I O Exception.");
		}
	}
	//=============Serialize=Write====================================
	
	public void writeToFileSerialized() {
		try {
			FileOutputStream fileIn = new FileOutputStream("AccountsOutput.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileIn);
			for(int i =0; i < account.size(); i++) {
				out.writeObject(account.get(i).toString()); // writes to the file so think about how to write an ArrayList
				}
			out.close();
			fileIn.close();
			System.out.println("Saved to file!!!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found a.k.a \"FileNotFoundException\"");
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}catch(Exception e) {
			System.out.println("what now??? really....");
		}
	}
	//===================File=Reader===================================
	
	public void readFromFile() {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("AccountsSource.txt"));
			String line = account.toString();
			while((line = reader.readLine()) != null) {
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException found");
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}	catch(Exception e) {
			System.out.println("Other exception was caught..");
		}

	}
	//===================File=Writer=======================================
	
	public void writeToFile() throws IOException {
		try { 
			BufferedWriter writer = new BufferedWriter(new FileWriter("AccountsSource.txt"));
	
			for(int i =0; i < account.size(); i++) {
			writer.write( account.get(i).toString()); // writes to the file so think about how to write an ArrayList
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			}
		}
	//=============Print=Title=============================================
	
	public static void printTitle(String name) {
		Titles.printBankTitle(name);
		Titles.printTitle();
	}
	//==============Print=Account=Details=============================
	
	public void printAccountDetails() {
		if (!account.isEmpty()) {
			printTitle(name);
			for (int i = 0; i < account.size(); i++) {
				account.get(i).printAccInfo();
			}
		}else
			System.out.println("No accounts to process");
	}
	//=====================Monthly=Process=============================
	public void monthlyProcess() {
		if (!account.isEmpty()) {
		for(int i =0; i < account.size(); i++) {
			account.get(i).updateBalance();
			}
		}
	}
	//========================CVS=Read=File============================
	
	public void cVSReadFile() {
		String cvsFile = "AccountsSource.csv";
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(cvsFile));
			while((line = reader.readLine()) != null) {
			String[] row = line.split(","); 
			for (String index : row) {
				System.out.printf("%-15s ", index);
			}
			System.out.println();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("I/O Exception");
		} 
	}
	//========================CVS=Write=File===============================
	
	public void cVSWriteFile() {
		String cvsFile = "AccountsSource.csv";
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(cvsFile));
			for(int i =0; i < account.size(); i++) {
				writer.write(account.get(i).toString()); 
			}
				writer.close();
		}catch(IOException e) {
			System.out.println("I/O Exception");
			}
		}
	//================Account=Exsits======================================
	
	public boolean doesAccountExsits() {
		if (account.size() == 0) {
			return false;
		} return true;
	}
	//=============Serialize=Write=Individual=Objects=============================	
	public void writeSerializedFile() {
		try {
			FileOutputStream fileIn = new FileOutputStream("Serialized_Account_Info.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileIn);
			
			for(int i =0; i < account.size(); i++) {
				out.writeObject(account.get(i).accountNum);
				out.writeObject(account.get(i).p);
				out.writeObject(account.get(i).balance); // writes to the file so think about how to write an ArrayList
			}
		
			out.close();
			fileIn.close();
			System.out.println("Saved to file!!!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found Exception");
		} catch (IOException e) {
			System.out.println("I O Exception.");
		}catch(Exception e) {
			System.out.println("what now! really???");
		}
	}
}