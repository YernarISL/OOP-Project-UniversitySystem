package models;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
	private static final long serialVersionUID = -7714649813359724398L;
	private String courseCode;
	private String courseName;
	private int credits;
	private Semester semester; 
	private Vector<Teacher> listOfTeachers = new Vector<Teacher>();
	private Vector<Student> listOfStudents = new Vector<Student>();
	
	public Course(String courseCode, String courseName, int credits, Semester semester) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credits = credits;
		this.semester = semester;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
