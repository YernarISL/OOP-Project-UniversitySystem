package controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Teacher;
import models.GeneralDB;
import models.InputValidation;
import views.RegistryView;

public class TeacherController implements InputValidation {
	private RegistryView registryView;  
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public TeacherController(RegistryView registryView) {
		this.registryView = registryView;
	}
	
	public void createTeacher(String fullName, String dateInput, String username, String password) {
		Teacher teacher = new Teacher(username, password, fullName, new Date(1, 2, 2021));
		GeneralDB.teachers.add(teacher);
	}
	
	public Date getValidDate(String dateInput) {
		try {
			Date date = formatter.parse(dateInput);
			return date;
		} catch (ParseException e){
			System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
		}
		return null;
	}

	
	@Override
	public void validateDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validatePassword(String password) {
		if (password.length() >= 12) {
			return true;
		} else return false;
		
	}

	@Override
	public boolean validateUsername(String username) {
		return false;
		
	}

	@Override
	public boolean validateFullName(String fullName) {
		return false;
		
	}
	
}
