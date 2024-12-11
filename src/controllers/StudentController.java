package controllers;

import java.util.Date;
import java.util.Vector;

import models.Course;
import models.Student;
import models.GeneralDB;

import views.StudentView;

public class StudentController {
	private StudentView studentView;
	
	public StudentController(StudentView studentView) {
		this.studentView = studentView;
	}
	
	public void createStudent(String fullName, String username, String password, Date date, Date yearOfApplication, int age) {
		Student student = new Student(fullName, username, password, date, yearOfApplication, age);
		GeneralDB.students.add(student);
		GeneralDB.saveStudents();
	}
	
	public void updateStudentView() {
		Vector<Student> students = (Vector<Student>) getStudents(); 
		studentView.displayStudents(students);
	}
	
	public Object getStudents() {
		return GeneralDB.deserialize("studentsList.txt");
	}
}
