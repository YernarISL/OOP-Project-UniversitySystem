package views;

import java.util.Vector;

import models.Student;

public class StudentView {
	public StudentView() {
		
	}

	public void displayStudents(Vector<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
}
