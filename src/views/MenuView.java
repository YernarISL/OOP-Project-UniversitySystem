package views;

public class MenuView {

	public void printHeader() {
		System.out.println("Welcome to Information System Research-Oriented University!");
		System.out.println("===========================================================");
	}
	
	public void menuSelection() {
		System.out.println("1.Login\n2.Register\n3.Exit\n4.Show teachers\n5.Show students\n6.Show managers");
		System.out.println("===========================================================");
		System.out.print("Enter your choice: ");
	}
	
	public void printRegistryRole() {
		System.out.println("Sign in as: ");
		System.out.println("===========================================================");
		System.out.println("1.Student\n2.Teacher\n3.Manager\n4.Exit");
	}
	
	public void printLoginRole() {	
		System.out.println("Log in as: ");
		System.out.println("===========================================================");
		System.out.println("1.Student\n2.Teacher\n3.Manager");
	}
	
}
