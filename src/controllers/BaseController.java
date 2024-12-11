package controllers;

import views.LoginView;
import views.MenuView;
import views.RegistryView;
import views.StudentView;
import views.TeacherView;

public class BaseController {
	
	RegistryView registryView = new RegistryView();
	LoginView loginView = new LoginView();
	TeacherView teacherView = new TeacherView();
	StudentView studentView = new StudentView();
	MenuView menuView = new MenuView();
	
	TeacherController teacherController = new TeacherController(teacherView);
	StudentController studentController = new StudentController(studentView);
	
	LoginController loginController = new LoginController(loginView);
	MenuController menuController = new MenuController(menuView, teacherController, studentController);
	

	
	public void displayMenu() {
		menuController.updateView();
	}
}
