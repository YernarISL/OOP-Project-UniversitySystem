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
	
	private RegistryView registryView;
	
	public RegistryController (RegistryView registryView) {
		this.registryView = registryView;
	}
	
	@Override
	public Date validateDateOfBirth() {
		Date date;
		while (true) {
			try {
				date = formatter.parse(registryView.dateBirth());
				break;
			} catch (ParseException e) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
		}
		return date;
	}
	
	@Override
	public Date validateDateOfYearApp() {
		Date date;
		while (true) {
			try {
				date = formatter.parse(registryView.dateYearApp());
				break;
			} catch (ParseException e) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
		}
		return date;
	}
	
	@Override
	public String validateFullName(String fullName) {
		while (true) {
			if (!fullName.isEmpty()) {
				break;
			} else {
				System.out.println("Full name cannot be empty.");
				fullName = registryView.fullName();
			}
		}
		return fullName;
	}

	@Override
	public String validatePassword(String password) {
		while (true) {
			if (password.length() >= 6) {
				break;
			} else {
				System.out.println("Password should be 6 characters at a minimum.");
				password = registryView.password();
			}
		}
		return password;
	}

	@Override
	public String validateUsername(String username) {
		while (true) {
			if (!username.isEmpty()) {
				break;
			} else {
				System.out.println("Username cannot be empty.");
				username = registryView.username();
			}
		}
		return username;
	}
	
	@Override
	public int validateAge(int age) {
		while (true) {
			if (age >= 0 && age <= 120) {
				break;
			} else {
				System.out.println("Invalid Input.");
				age = registryView.age();
			}
		}
		return age;
	}
	
}
