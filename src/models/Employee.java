package models;

import java.util.Date;

public abstract class Employee extends User {
	private String fullName;
	private String employeeID;
	private Date dateOfBirth;
	
	public Employee(String username, String password, String fullname, Date dateOfBirth) {
		super(username, password);
		this.setFullname(fullname);
		this.setDateOfBirth(dateOfBirth);
	}
	
	public void sendMessage(String message, User user) {
		
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullname(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
