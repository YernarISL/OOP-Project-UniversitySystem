package models;

import java.util.Date;

public class Teacher extends Employee {

	public Teacher(String username, String password, String fullname, Date dateOfBirth) {
		super(username, password, fullname, dateOfBirth);
	}
	
	public String toString() {
		return "Full name: " + getFullName() + "\n" + "Username: " + getUsername();
	}
	
}
