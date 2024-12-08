package views;

import java.util.Scanner;

public class MenuView {
	Scanner in = new Scanner(System.in);
	
	public void printHeader() {
		System.out.println("Welcome to Information System Research-Oriented University!");
		System.out.println("===========================================================");
	}
	
	public void menuSelection() {
		System.out.println("1.Login\n2.Register\n3.Exit");
		System.out.println("===========================================================");
		System.out.print("Enter your choice: ");
	}
	
}
