package views;

import java.util.Vector;

import models.Teacher;

public class TeacherView {
	
	public TeacherView() {
		
	}
	
	public void teacherMenu(Teacher teacher) {
		System.out.println("Welcome, " + teacher.getFullName());
		System.out.println("===========================================================");
		System.out.println("1.View Courses\n2.Manage Courses\n3.View info about student\n4.Put marks\n5.Send message");
	}
	
	public void displayTeachers(Vector<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}
