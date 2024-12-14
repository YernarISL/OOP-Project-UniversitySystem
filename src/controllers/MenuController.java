package controllers;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import models.GeneralDB;
import models.Teacher;
import models.Student;
import views.MenuView;
import views.LoginView;
import views.RegistryView;

public class MenuController {
	private TeacherController teacherController;
	private StudentController studentController;
	private RegistryView registryView = new RegistryView();
	private LoginView loginView = new LoginView();
	private MenuView menuView;
	private RegistryController registryController = new RegistryController(registryView);

	Scanner in = new Scanner(System.in);
	
	public MenuController(MenuView menuView, TeacherController teacherController, StudentController studentController) {
		this.teacherController = teacherController;
		this.studentController = studentController;
		this.menuView = menuView;
	}
	
	public void updateView() {
		menuView.printHeader();
		menuView.menuSelection();
		selectMenuAction();
	}
	
	public void selectMenuAction() {
		int menuOption = in.nextInt();
		switch(menuOption) {
			case 1:
				loginView.printLoginRole();
				selectLoginRole();
				break;
			case 2:
				registryView.printRegistryRole();
				selectRegistryRole();
				break;
			case 3:
				break;
			case 4:
				teacherController.updateView();
				break;
			case 5:
				studentController.updateView();
				break;
			default:
				break;
		}
	}
	
	public void selectRegistryRole() {
		int regRole = in.nextInt();
		String fullName, username, password;
		Date dateBirth, dateYearApp;
		int age;
		switch(regRole) {
			case 1:
				fullName = registryView.fullName();
				fullName = registryController.validateFullName(fullName);
				username = registryView.username();
				username = registryController.validateUsername(username);
				password = registryView.password();
				password = registryController.validatePassword(password);
				dateBirth = registryController.validateDateOfBirth();
				dateYearApp = registryController.validateDateOfYearApp();
				age = registryView.age();
				age = registryController.validateAge(age);
				
				studentController.createStudent(fullName, username, password, dateBirth, dateYearApp, age);
				updateView();
				break;
			case 2:
				fullName = registryView.fullName();
				fullName = registryController.validateFullName(fullName);
				username = registryView.username();
				username = registryController.validateUsername(username);
				password = registryView.password();
				password = registryController.validatePassword(password);
				dateBirth = registryController.validateDateOfBirth();
				
				teacherController.createTeacher(fullName, dateBirth, username, password);
				updateView();
				break;
			case 3:
				break;
			case 4:
				teacherController.updateView();
				break;
			default:
				break;
		}
	}
	
	public void selectLoginRole() {
		int logRole = in.nextInt();
		String username;
		String password;
		switch (logRole) {
			case 1: 
				username = registryView.username();
				username = registryController.validateUsername(username);
				password = registryView.password();
				password = registryController.validatePassword(password);
				Student student;
				while (true) {
					student = studentController.checkForExistance(GeneralDB.getStudents(), username);
					if (student != null) {
						boolean isCorrect = studentController.checkPasswordMatching(GeneralDB.getStudents(), username, password);
						if (isCorrect) {
							break;
						} else {
							System.out.println("The password is incorrect");
							password = registryView.password();
							password = registryController.validatePassword(password);
						}
					} else {
						System.out.println("The user doesn't exist");
						username = registryView.username();
						username = registryController.validateUsername(username);
					}
				}
				studentController.logInToAccount(student);
				break;
			case 2:
				username = registryView.username();
				username = registryController.validateUsername(username);
				password = registryView.password();
				password = registryController.validatePassword(password);
				Teacher teacher;
				while (true) {
					teacher = teacherController.checkForExistance(GeneralDB.getTeachers(), username);
					if (teacher != null) {
						boolean isCorrect = teacherController.checkPasswordMatching(GeneralDB.getTeachers(), username, password);
						if (isCorrect) {
							break;
						} else {
							System.out.println("The password is incorrect");
							password = registryView.password();
							password = registryController.validatePassword(password);
						}
					} else {
						System.out.println("The user doesn't exist");
						username = registryView.username();
						username = registryController.validateUsername(username);
					} 
				}
				teacherController.logInToAccount(teacher);
				break;
			case 3:
				break;
			case 4:
				selectMenuAction();
			default:
				break;
		}
	}
}
