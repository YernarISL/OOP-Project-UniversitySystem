package views;

import java.util.Scanner;

public class RegistryView {
	Scanner in = new Scanner(System.in);
	
	public void printRegistryRole() {
		System.out.println("Sign in as: ");
		System.out.println("===========================================================");
		System.out.println("1.Student\n2.Teacher\n3.Manager");
	}
	
	public void teacherRegistry() {
		System.out.println("Enter your fullname: ");
		String fullName = in.nextLine();
		System.out.println("Password: ");
		String password = in.nextLine();
	}
}
