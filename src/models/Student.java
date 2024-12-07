package models;

import java.util.Date;
import java.util.Vector;

public class Student {
	private String fullName;
	private Date yearOfApplication;
	private int age;
	private Vector<Course> listOfCourses = new Vector<Course>(); 
	
	public String viewCourses() {
		return "";
	}
	
}
