package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;

import views.InputView;

public class Teacher extends Employee {

	private static final long serialVersionUID = -627118249310372006L;
	
	public Teacher(String username, String password, String fullname, Date dateOfBirth) {
		super(username, password, fullname, dateOfBirth);
	}
	
	public static void createTeacher(String fullName, Date dateInput, String username, String password) {
		Teacher teacher = new Teacher(username, password, fullName, dateInput);
		Vector<Teacher> teachers = GeneralDB.getTeachers();
		teachers.add(teacher);
		GeneralDB.teachers = teachers;
		GeneralDB.saveTeachers();
	}
	
	public static Teacher getTeacher(String username, String password) {
		Teacher teacher;
		while (true) {
			teacher = checkExistance(GeneralDB.getTeachers(), username, password);
			if (teacher != null) {
				break;
			} 
			System.out.println("Invalid username or password. Try again");
			username = InputView.getUsername();
			password = InputView.getPassword();
		}
		return teacher;
	}
	
	public static Teacher checkExistance(Vector<Teacher> teachers, String username, String password) {
		for (Teacher teacher : teachers) {
			if (teacher.getUsername().equals(username) && teacher.getPassword().equals(password)) {
				return teacher;
			}
		}
		return null;
	}
	
	public void validateData(String username, String fullName, String password) {
		validateUsername(username);
	}
	
	public static String validateUsername(String username) {
		while (true) {
			if (!username.isEmpty()) {
				break;
			} 
			System.out.println("The username cannot be empty");
			username = InputView.getUsername();
		}
		return username;
	}
	
	public static String validateFullName(String fullName) {
		while (true) {
			if (Pattern.matches("^[\\p{L}\\. \'-]+$", fullName)) {
				break;
			} 
			System.out.println("Incorrect input. Try again");
			fullName = InputView.getFullName();
		}
		return fullName;
	}
	
	public static String validatePassword(String password) {
		while (true) {
			if (password.length() >= 6) {
				break;
			}
			System.out.println("A password should contains at least 6 letters");
			password = InputView.getPassword();
		}
		return password;
	}
	
	public static Date validateDate(String dateInput) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateBirth;
		while (true) {
			try {
				dateBirth = formatter.parse(dateInput);
				break;
			} catch (ParseException pe) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
			dateInput = InputView.getBirthDate();
		}
		return dateBirth;
	}
	
	@Override
	public String toString() {
		String border = "-----------------------------------------------------------";
		return border + "\n" + "Full name: " + getFullName() + "\n" + "Username: " + getUsername() + "\n" + border;
	}
	
}
