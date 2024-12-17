package views;

import java.util.Scanner;

public class InputView {
	private static Scanner in = new Scanner(System.in);
	
	public static String getFullName() {
		System.out.println("Enter your full name: ");
		return in.nextLine();
	}
	
	public static String getUsername() {
		System.out.println("Enter your username: ");
		return in.nextLine();
	}
	
	public static String getPassword() {
		System.out.println("Enter your password: ");
		return in.nextLine();
	}
	
	public static String getBirthDate() {
		System.out.println("Enter your date of birth: ");
		return in.nextLine();
	}
	
	public static String getYearAppDate() {
		System.out.println("Enter your date of year application: ");
		return in.nextLine();
	}
}
