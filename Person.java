import java.io.Serializable;
import Utilities.UserInput;

/* Student: Michael Garrison
 * Assignment: Lab 6 Banking System III
 * Course: CST8132 300
 * Professor: Michel Choueiry
 * Date: April 3, 2022
 *  @author Garrison
 */
public class Person implements Serializable  {
private static final long serialVersionUID = 123;
private String firstName;
private String lastName;
private String eMail;
private long phoneNumber;
UserInput in = new UserInput();

	Person(String fN, String lN, String eM, long pN){
		this.firstName=fN;
		this.lastName=lN;
		this.eMail=eM;
		this.phoneNumber=pN;
	}
//==============Getters======================

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getName() {
		return firstName+" "+lastName;
	}
	
//===============Person=Reader=====================
	
	public void readPerson() {
		System.out.println("Enter first name: ");
		this.firstName = in.stringInput();
		System.out.println("Enter last name: ");
		this.lastName=in.stringInput();
		System.out.println("Enter eMail address: ");
		this.eMail=in.stringInput();
		System.out.println("Enter phone number: ");
		this.phoneNumber=in.longInput();
		new Person(firstName, lastName, eMail, phoneNumber);
	}
}
