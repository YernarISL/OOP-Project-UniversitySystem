package models;

import java.util.Date;

public class Employee extends User {
	private String fullname;
	private String employeeID;
	private Date dateOfBirth;
	
	public Employee(String username, String password, String fullname, Date dateOfBirth) {
		super(username, password);
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
	}
	
	public void sendMessage(String message, User user) {
		
	}
}
