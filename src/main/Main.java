package main;

import controllers.MenuController;
import controllers.RegistryController;
import controllers.LoginController;
import controllers.TeacherController;
import views.BaseView;
import views.RegistryView;
import views.LoginView;
import views.TeacherView;

public class Main {
	public static void main(String[] args) {
		BaseView baseView = new BaseView();
		RegistryView registryView = new RegistryView();
		LoginView loginView = new LoginView();
		TeacherView teacherView = new TeacherView();
		
		
		
		LoginController loginController = new LoginController(loginView);
		TeacherController teacherController = new TeacherController(teacherView);
		RegistryController registryController = new RegistryController(registryView, teacherController);
		MenuController menuController = new MenuController(registryController, loginController);
		
		
		
		baseView.printMenuView();
		menuController.selectMenuAction();
		teacherController.updateTeacherView();
	}

}
