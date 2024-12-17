package views;

import java.util.Vector;

import models.GeneralDB;
import models.Manager;

public class ManagerView {
	
	public void ManagerMenu(Manager manager) {
		String access = manager.accessState(Manager.getAccess().booleanValue());
		System.out.println("Welcome, " + manager.getFullName());
		System.out.println("===========================================================");
		System.out.println("1.Manage student registration\n2." + access + " access to registration");
		System.out.println("3.View info about students\n4.View info about teachers\n5.Assign courses to a teacher");
		System.out.println("6.Change news\n7.Create statistical report\n8.Open mail\n9.Log out");
		System.out.println("===========================================================");
		System.out.print("Enter your choice: ");
	}
	
	public void displayManagers() {
		Vector<Manager> managers = GeneralDB.getManagers();
		for (Manager manager : managers) {
			System.out.println(manager);
		}
	}
	
}
