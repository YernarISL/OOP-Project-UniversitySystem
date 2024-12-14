package models;

import java.util.Date;
import java.util.Vector;

public class Student extends User {
	private static final long serialVersionUID = -4280982078902198112L;
	private String fullName;
	private Date yearOfApplication;
	private Date dateOfBirth;
	private int age;
	private Vector<Course> listOfCourses = new Vector<Course>(); 
	
	public Student(String fullName, String username, String password, Date dateOfBirth, Date yearOfApplication, int age) {
		super(username, password);
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.yearOfApplication = yearOfApplication;
		this.age = age;
	}
	
	public void registerForCourses() {
		viewCourses();
		
	}
	
	public String viewCourses() {
		return "";
	}
	
	@Override
	public String toString() {
		String border = "-----------------------------------------------------------";
		return border + "\n" + "Full name: " + fullName + "\n" + "Username: " + getUsername() + "\n" + "Age: " + 
				age + "\n" + border; 
	}
	
	public String getFullName() {
		return fullName;
	}

	public Date getYearOfApplication() {
		return yearOfApplication;
	}

	public void setYearOfApplication(Date yearOfApplication) {
		this.yearOfApplication = yearOfApplication;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vector<Course> getListOfCourses() {
		return listOfCourses;
	}
	
	public void setListOfCourses(Vector<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
}
