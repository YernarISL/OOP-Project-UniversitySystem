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
	
	public void logInToAccount(Teacher teacher) {
		teacherView.teacherMenu(teacher);
	}
	
	public Teacher checkForExistance(Vector<Teacher> teachers, String username) {
		for (Teacher teacher : teachers) {
			if (teacher.getUsername().equals(username)) {
				return teacher;
			}
		}
		return null;
	}
	
	public boolean checkPasswordMatching(Vector<Teacher> teachers, String username, String password) {
		if (checkForExistance(teachers, username).getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	
	public void updateView() {
		Vector<Teacher> teachers = GeneralDB.getTeachers();
		teacherView.displayTeachers(teachers);
	}
	
	public void addInitTeachers() {
		GeneralDB.teachers.add(new Teacher("Yerik", "5678trum", "Yernazar Shelek", new Date()));
		GeneralDB.teachers.add(new Teacher("Pivozavr", "pg12", "Axa Kaizar", new Date()));
	}
}
