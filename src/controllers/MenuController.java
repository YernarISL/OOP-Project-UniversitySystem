package controllers;

import java.util.Date;
import java.util.Scanner;

import views.MenuView;
import views.LoginView;
import views.RegistryView;

public class MenuController {
	private TeacherController teacherController;
	private StudentController studentController;
	private RegistryView registryView = new RegistryView();
	private LoginView loginView = new LoginView();
	private MenuView menuView;
	Scanner in = new Scanner(System.in);
	private RegistryController registryController = new RegistryController(registryView);

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
//				loginController.updateView();
				break;
			case 2:
				registryView.printRegistryRole();
				selectRole();
				break;
			case 3:
				break;
		}
	}
	
	public void selectRole() {
		int regRole = in.nextInt();
		String validFullName, validUsername, validPassword;
		Date validDateBirth, validDateYearApp;
		int validAge;
		switch(regRole) {
			case 1:
				validFullName = registryController.validateFullName();
				validUsername = registryController.validateUsername();
				validPassword = registryController.validatePassword();
				validDateBirth = registryController.validateDateOfBirth();
				validDateYearApp = registryController.validateDateOfYearApp();
				validAge = registryController.validateAge();
				
				studentController.createStudent(validFullName, validUsername, validPassword, validDateBirth, validDateYearApp, validAge);
				break;
			case 2:
				validFullName = registryController.validateFullName();
				validUsername = registryController.validateUsername();
				validPassword = registryController.validatePassword();
				validDateBirth = registryController.validateDateOfBirth();
				
				teacherController.createTeacher(validFullName, validDateBirth, validUsername, validPassword);
				updateView();
			case 3:
				break;
		}
	}
}
