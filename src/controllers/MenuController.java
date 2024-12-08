package controllers;

import java.util.Scanner;


public class MenuController {
	private RegistryController registryController;
	private LoginController loginController;
	Scanner in = new Scanner(System.in);
			
	public MenuController(RegistryController rc, LoginController lc) {
		this.registryController = rc;
		this.loginController = lc;
	}
	
	public void selectMenuAction() {
		int menuOption = in.nextInt();
		switch(menuOption) {
			case 1:
				loginController.updateView();
				break;
			case 2:
				registryController.updateView();
				break;
			case 3:
				break;
		}
	}
	
	public void updateView() {
		
	}
}
