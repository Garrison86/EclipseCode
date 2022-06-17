import java.io.Serializable;

import Utilities.BankFees;

/* Student: Michael Garrison
 * Assignment: Lab 6 Banking System III
 * Course: CST8132 300
 * Professor: Michel Choueiry
 * Date: April 3, 2022
 *  @author Garrison
 */
public class SavingsAccount extends Account implements Serializable{

	private static final long serialVersionUID = 1L;

	SavingsAccount(int accNum, Person p) {
		super(accNum, p);
	}

	@Override
	public void updateBalance() {
		try{
			if(balance>0) {
				super.balance= balance + (BankFees.ANU_RATE / 12); 
			}
		}catch(Exception e) {
			System.out.println("you dont have enough funds");
		}
	}
}
