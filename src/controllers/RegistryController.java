package controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import models.RegistryInputValidation;
import models.LoginInputValidation;

import views.RegistryView;

public class RegistryController implements RegistryInputValidation, LoginInputValidation  {
	Scanner in = new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private RegistryView rv;
	private TeacherController tc;
	
	public RegistryController(RegistryView registryView, TeacherController teacherController) {
		this.rv = registryView;
		this.tc = teacherController;
	}
	
	public void updateView() {
		rv.printRegistryRole();
		selectRegistryRole();
	}
	
	public void selectRegistryRole() {
		int regRole = in.nextInt();
		switch(regRole) {
			case 1:
				studentRegistry();
				break;
			case 2:
				teacherRegistry();
			case 3:
				break;
		}
	}
	
	public void teacherRegistry() {
		tc.createTeacher(validateFullName(), validateDate(), validateUsername(), validatePassword());
	}

	private void studentRegistry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date validateDate() {
		Date date;
		while (true) {
			try {
				date = formatter.parse(rv.dateBirth());
				break;
			} catch (ParseException e) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
		}
		return date;
	}

	@Override
	public String validateFullName() {
		String fullName = rv.fullName();
		while (true) {
			if (!fullName.isEmpty()) {
				break;
			} else {
				System.out.println("Full name cannot be empty.");
				fullName = rv.fullName();
			}
		}
		return fullName;
	}

	@Override
	public String validatePassword() {
		String password = rv.password();
		while (true) {
			if (password.length() >= 12) {
				break;
			} else {
				System.out.println("Password should be 12 characters at a minimum.");
				password = rv.password();
			}
		}
		return password;
	}

	@Override
	public String validateUsername() {
		String username = rv.username();
		while (true) {
			if (!username.isEmpty()) {
				break;
			} else {
				System.out.println("Username cannot be empty.");
				username = rv.username();
			}
		}
		return username;
	}
	
	public TeacherController getTeacherController() {
		return tc;
	}
}
