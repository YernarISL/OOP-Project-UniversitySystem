package controllers;

import java.util.Date;
import java.util.Vector;

import models.Teacher;
import models.GeneralDB;
import views.TeacherView;

public class TeacherController { 
	private TeacherView teacherView;
	
	public TeacherController(TeacherView teacherView) {
		this.teacherView = teacherView;
	}
	
	public void createTeacher(String fullName, Date dateInput, String username, String password) {
		Teacher newTeacher = new Teacher(username, password, fullName, dateInput);
		GeneralDB.teachers.add(newTeacher);
		GeneralDB.saveTeachers();
	}
	
	public void updateTeacherView() {
		Vector<Teacher> teachers = (Vector<Teacher>) getTeachers();
		teacherView.displayTeacher(teachers);
	}
	
	public Object getTeachers() {
		return GeneralDB.deserialize("teachersList.txt");
	}
}
