import java.io.Serializable;
import Utilities.*;

/* Student: Michael Garrison
 * Assignment: Lab 6 Banking System III
 * Course: CST8132 300
 * Professor: Michel Choueiry
 * Date: April 3, 2022
 *  @author Garrison
 */
abstract class Account implements Serializable {
private static final long serialVersionUID = 123;
protected int accountNum;
protected Person p;
protected double balance;
UserInput in = new UserInput();
BankFees bF;
	
Account(int accNum, Person p){
		this.accountNum=accNum;
		this.p=p;
	}
	
	public abstract void updateBalance();

	public void printAccInfo() {
		System.out.printf("%10d | %25s | %25s | %15d | %10.2f\n", 
			accountNum, p.getName(), p.geteMail(),p.getPhoneNumber(), balance);
	}

	@Override
	public String toString() {
		return (accountNum +","+p.getName()+","+p.geteMail()+","+p.getPhoneNumber()+","+balance+"\n");
	}

	public void readAccount() {
		System.out.println("Enter Account Number: ");
		this.accountNum = in.integerInput();
		p = new Person(null, null, null, 0);
		p.readPerson();
		System.out.println("enter balance: ");
		while(balance<=0) {
			this.balance = in.doubleInput();
		}
	}

}

