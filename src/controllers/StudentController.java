package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import models.Course;
import models.Student;
import models.GeneralDB;

import views.StudentView;
import views.CourseView;

public class StudentController {
	private StudentView studentView;
	private CourseView courseView;
	Scanner in = new Scanner(System.in);
	
	public StudentController(StudentView studentView, CourseView courseView) {
		this.studentView = studentView;
		this.courseView = courseView;
	}
	
	public void createStudent(String fullName, String username, String password, Date date, Date yearOfApplication, int age) {
		Student student = new Student(fullName, username, password, date, yearOfApplication, age);
		GeneralDB.students.add(student);
		GeneralDB.saveStudents();
	}
	
	public void logInToAccount(Student student) {
		studentView.studentMenu(student);
		selectStudentAction();
	}
	
	public void selectStudentAction() {
		int option = in.nextInt();
		
		switch (option) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				HashMap<String, Course> courses = GeneralDB.getCourses();
				courseView.registryMenu(courses);
				break;
			case 7:
				break;
			case 8:
				break;
		}
	}
	
	public Student checkForExistance(Vector<Student> students, String username) {
		for (Student student : students) {
			if (student.getUsername().equals(username)) {
				return student;
			}
		}
		return null;
	}
	
	public boolean checkPasswordMatching(Vector<Student> students, String username, String password) {
		if (checkForExistance(students, username).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public void updateView() {
		Vector<Student> students = GeneralDB.getStudents(); 
		studentView.displayStudents(students);
	}
	
}
