package views;

import java.util.Vector;

import models.Teacher;

public class TeacherView {
	
	public TeacherView() {
		
	}
	
	public void displayTeacher(Vector<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}
}
