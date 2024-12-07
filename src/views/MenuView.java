package views;

import java.util.Scanner;

import controllers.RegistryController;
import controllers.LoginController;

public class MenuView {
	Scanner in = new Scanner(System.in);
	LoginController loginController = new LoginController();
	RegistryController registryController = new RegistryController();
	
	public void printHeader() {
		System.out.println("Welcome to Information System Research-Oriented University!");
		System.out.println("===========================================================");
	}
	
	public void menuSelection() {
		System.out.println("1.Login\n2.Register\n3.Exit");
		System.out.println("===========================================================");
		System.out.print("Enter your choice: ");
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
	
}
