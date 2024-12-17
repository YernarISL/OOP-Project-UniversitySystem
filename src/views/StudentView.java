package views;

import java.util.Vector;

import models.Course;
import models.Student;

public class StudentView {
	public StudentView() {
		
	}
	
	public void studentMenu(Student student) {
		System.out.println("Welcome, " + student.getFullName());
		System.out.println("===========================================================");
		System.out.println("1.View marks\n2.View courses\n3.View transcript\n4.View info about teacher");
		System.out.println("5.View your organizations\n6.Register for courses\n7.Rate teachers\n8.Log out");
		System.out.println("===========================================================");
		System.out.print("Enter your choice: ");
	}
	
	public void displayCourses(Vector<Course> selectedCourses) {
		for (Course course : selectedCourses) {
			System.out.println(course);
		}
	}
	
	public void displayMarks(String marks) {
		System.out.println(marks);
	}
	
	public void displayStudents(Vector<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	
	
}
