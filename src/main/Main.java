package main;

import controllers.MenuController;
import controllers.RegistryController;
import controllers.LoginController;
import controllers.TeacherController;
import views.BaseView;
import views.RegistryView;
import views.LoginView;

public class Main {
	public static void main(String[] args) {
		BaseView baseView = new BaseView();
		RegistryView registryView = new RegistryView();
		LoginView loginView = new LoginView();
		
		TeacherController teacherController = new TeacherController(registryView);
		RegistryController registryController = new RegistryController(registryView, teacherController);
		LoginController loginController = new LoginController(loginView);
		
		MenuController menuController = new MenuController(registryController, loginController);
		
		
		baseView.printMenuView();
		menuController.selectMenuAction();
	}

}
