package views;

import java.util.Scanner;

public class RegistryView {
	Scanner in = new Scanner(System.in);
	
	public void printRegistryRole() {
		System.out.println("Sign in as: ");
		System.out.println("===========================================================");
		System.out.println("1.Student\n2.Teacher\n3.Manager");
	}

	public String enterFullName() {	
		System.out.println("Enter your fullname: ");
		return in.nextLine();
	}
	
	public String enterUsername() {
		System.out.println("Enter your username: ");
		return in.nextLine();
	}
	
	public String enterPassword() {
		System.out.println("Enter your password: ");
		return in.nextLine();
	}
	
	public String enterDateBirth() {
		System.out.println("Enter your date of birth: ");
		return in.nextLine();
	}
	
}
