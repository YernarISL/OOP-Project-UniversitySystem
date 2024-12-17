package controllers;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;


import models.Teacher;
import models.BaseState;
import models.GeneralDB;
import views.TeacherView;

public class TeacherController { 
	private TeacherView teacherView;
	Scanner in = new Scanner(System.in);
	
	public TeacherController(TeacherView teacherView) {
		this.teacherView = teacherView;
	}
	
	public BaseState loginToAccount(Teacher teacher) {
		teacherView.teacherMenu(teacher);
		return selectTeacherAction();
	}
	
	public BaseState selectTeacherAction() {
		int option = in.nextInt();
		switch (option) {
			case 1:
				return BaseState.TEACHER_CABINET;
			case 2:
				return BaseState.TEACHER_CABINET;
			case 3:
				return BaseState.TEACHER_CABINET;
			case 4:
				return BaseState.TEACHER_CABINET;
			case 5:
				return BaseState.TEACHER_CABINET;
			case 6:
				return BaseState.BACK_TO_MENU;
			default:
				System.out.println("Incorrect input. Try again");
				return BaseState.TEACHER_CABINET;
		}
	}
	
	public void setRegisterData(String fullName, Date birthDate, String username, String password) {
		Teacher.createTeacher(fullName, birthDate, username, password);
	}
	
	public Teacher getTeacher(String username, String password) {
		return Teacher.getTeacher(username, password);
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
	
	public String getUsername(String username) {
		return Teacher.validateUsername(username);
	}
	
	public String getFullName(String fullName) {
		return Teacher.validateFullName(fullName);
	}
	
	public String getPassword(String password) {
		return Teacher.validatePassword(password);
	}
	
	public Date getBirthDate(String dateBirth) {
		return Teacher.validateDate(dateBirth);
	}
	
	public void updateView() {
		Vector<Teacher> teachers = GeneralDB.getTeachers();
		teacherView.displayTeachers(teachers);
	}


	
//	public void addInitTeachers() {
//		GeneralDB.teachers.add(new Teacher("Yerik", "5678trum", "Yernazar Shelek", new Date()));
//		GeneralDB.teachers.add(new Teacher("Pivozavr", "pg12", "Axa Kaizar", new Date()));
//	}
}
