package controllers;

import java.util.Scanner;

import views.RegistryView;

public class RegistryController {
	Scanner in = new Scanner(System.in);
	private RegistryView rv;
	private TeacherController tc;
	
	public RegistryController(RegistryView registryView, TeacherController teacherController) {
		this.rv = registryView;
		this.tc = teacherController;
	}
	
	public void updateView() {
		rv.printRegistryRole();
		selectRegistryRole();
	}
	
	public void selectRegistryRole() {
		int regRole = in.nextInt();
		switch(regRole) {
			case 1:
				studentRegistry();
				break;
			case 2:
				teacherRegistry();
				break;
			case 3:
				break;
		}
	}
	
	private void teacherRegistry() {
		tc.createTeacher(rv.enterFullName(), rv.enterDateBirth(), rv.enterUsername(), rv.enterPassword());
	}

	private void studentRegistry() {
		// TODO Auto-generated method stub
		
	}

	public TeacherController getTeacherController() {
		return tc;
	}
	

}
