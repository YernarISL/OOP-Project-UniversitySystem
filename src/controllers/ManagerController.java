package controllers;

import java.util.Date;
import java.util.Scanner;

import views.ManagerView;
import models.BaseState;
import models.Manager;

public class ManagerController {
	private ManagerView managerView;
	Scanner in = new Scanner(System.in);
	
	public ManagerController(ManagerView managerView) {
		this.managerView = managerView;
	}
	
	public void setRegisterData(String fullName, Date dateBirth, String username, String password) {
		Manager.createManager(fullName, username, password, dateBirth);
	}
	
	public BaseState loginToAccount(Manager manager) {
		managerView.ManagerMenu(manager);
		return selectManagerAction(manager);
	}
	
	public BaseState selectManagerAction(Manager manager) {
		managerView.ManagerMenu(manager);
		int option = in.nextInt();
		
		switch (option) {
			case 1:
				manager.changeAccessCourse();
				return BaseState.MANAGER_CABINET;
			case 2:
				return BaseState.MANAGER_CABINET;
			case 3:
				return BaseState.MANAGER_CABINET;
			case 4:
				return BaseState.MANAGER_CABINET;
			case 5:
				return BaseState.MANAGER_CABINET;
			case 6:
				return BaseState.MANAGER_CABINET;
			case 7:
				return BaseState.MANAGER_CABINET;
			case 8:
				return BaseState.MANAGER_CABINET;
			case 9:
				return BaseState.BACK_TO_MENU;
			default:
				System.out.println("Incorrect input. Try again");
				return BaseState.MANAGER_CABINET;
		}
	}
	
	public Manager getManager(String username, String password) {
		return Manager.getManager(username, password);
	}
	
	public String getFullName(String fullName) {
		return Manager.validateFullName(fullName);
	}
	
	public Date getBirthDate(String dateBirth) {
		return Manager.validateBirthDate(dateBirth);
	}
	
	public String getUsername(String username) {
		return Manager.validateUsername(username);
	}
	
	public String getPassword(String password) {
		return Manager.validatePassword(password);
	}
	
	public void updateView() {
		managerView.displayManagers();
	}
}
