package views;

import java.util.Scanner;

public class LoginView {
	Scanner in = new Scanner(System.in);
	
	public void printLoginRole() {	
		System.out.println("Log in as: ");
		System.out.println("===========================================================");
		System.out.println("1.Student\n2.Teacher\n3.Manager");
	}
	
	public void printLoginPanel() {
		System.out.println("Login to Your Account: ");
		System.out.println("===========================================================");
		
		System.out.print("Username: ");
		String username = in.nextLine();
		
		System.out.print("Password: ");
		String password = in.nextLine();
		
	}

}
