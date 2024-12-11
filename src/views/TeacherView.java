package views;

import java.util.Vector;

import models.Teacher;

public class TeacherView {
	
	public TeacherView() {
		
	}
	
	public void teacherMenu() {
		System.out.println();
	}
	
	public void displayTeachers(Vector<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}
