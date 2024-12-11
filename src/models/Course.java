package models;

import java.util.Vector;

public class Course {
	private int credits;
	private Vector<Teacher> listOfTeachers = new Vector<Teacher>();
	private Vector<Student> listOfStudents = new Vector<Student>();
	
	public Course(int credits, Vector<Teacher> listOfTeachers, Vector<Student> listOfStudents) {
		this.credits = credits;
		this.listOfStudents = listOfStudents;
		this.listOfTeachers = listOfTeachers;
	}
}
