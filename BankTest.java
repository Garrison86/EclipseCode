import java.io.*;
import Utilities.*;
/* Student: Michael Garrison
 * Assignment: Lab 6 Banking System III
 * Course: CST8132 300
 * Professor: Michel Choueiry
 * Date: April 3, 2022
 *  @author Garrison
 */
public class BankTest {

	public static void main(String[] args) throws IOException, Exception {
		
		
		UserInput in = new UserInput();
		System.out.println("Please enter the Banks Name: ");
		String bankName = in.stringInput();
		System.out.println("Enter the amount of account holders: ");
		int accHolders = in.integerInput();
		Bank bank = new Bank(bankName, accHolders);
		
		int option=0;
		
		do {
			System.out.println("1. Read Account\n"
					+ "2. Run Monthly Process\n"
					+ "3. Print all Accounts\n"
					+ "4. Read data from file\n" 
					+ "5. Write data to file\n"
					+ "6. Exit\n");
			System.out.println("Enter your Option: ");

		option = in.menuMainInput();
		switch (option) {
			
			case (1):// Read Account
				System.out.println("Read Account ");
				bank.readAccountDetails();
				break;
			case (2):// Run Monthly Process
				if(!bank.doesAccountExsits()) {
					System.out.println("no account to process");
					break;
				}
				System.out.println("Run Monthly Process selected");
				bank.monthlyProcess();
			
				break;
			case (3): // Print all Accounts
				System.out.println("Print all accounts selected");
				bank.printAccountDetails();
				
				break;
			case (4):// Read data from file
				try {
					if(!bank.doesAccountExsits()) {
						System.out.println("No accounts to display");
						break;
					}else {
				System.out.println("***accounts read from file***");
				bank.readFileSerialized();
				bank.readFromFile();
				bank.cVSReadFile();
					}
				}catch(IOException iOE) {
					System.out.println("I O Exception ");
				}
				break;
			case (5):// Write data to file
				try {
					if(!bank.doesAccountExsits()) {
						System.out.println("**** Invalid menu selection, please try again. ****");
						break;
					}else {
				System.out.println("****all accounts written to file****");
				bank.writeSerializedFile(); // takes in one Arraylist object at a time.
//				bank.writeToFileSerialized(); // takes in entire collection of ArrayList Object at once
				bank.writeToFile();
				bank.cVSWriteFile();
					}
				}catch(Exception e) {
					System.out.println("Exception caught");
				}
				break;
			case (6):// Exit	
				System.out.println("...Exiting ...Bye...");
			break;
			default:
				System.out.println("Not a proper selection... try again.");
			}
		}while(option !=6);
	}
}
