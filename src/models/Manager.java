package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;

import views.InputView;


public class Manager extends Employee {
	private static final long serialVersionUID = 8714537064724885281L;
	private ManagerType managerType;
	private static boolean access = false; 
	public Manager(String username, String password, String fullname, Date dateOfBirth) {
		super(username, password, fullname, dateOfBirth);
	}
	
	public void createCourses() {
		
	}
	
	public void addCourses() {
		
	}
	
	public void changeAccessCourse() {
		if (access) {
			access = false;
		} else {
			access = true;
		}
	}
	
	public void saveAccess() {
		saveRegisterAccess(access);
	}
	
	public String accessState(boolean access) {
		if (access) {
			return "Open";
		} else {
			return "Close";
		}
	}
	
	public void approveCourses() {
		   
	}
	
	public void assignCourses() {
		
	}
	
	public static void createManager(String fullName, String username, String password, Date dateBirth) {
		Manager manager = new Manager(username, password, fullName, dateBirth);
		Vector<Manager> managers = GeneralDB.getManagers();
		managers.add(manager);
		GeneralDB.managers = managers;
		GeneralDB.saveManagers();
	}
	
	public String toString() {
		String border = "-----------------------------------------------------------";
		return border + "\n" + "Full name: " + getFullName() + "\n" + "Username: " + getUsername() + "\n" + border;
	}
	
	public static Boolean getAccess() {
		return (Boolean) ReadAndWrite.deserialize(GeneralDB.getPath() + "RegistrationAccess.txt");
	}
	
	public static void saveRegisterAccess(boolean access) {
		ReadAndWrite.serialize(Boolean.valueOf(access), GeneralDB.getPath() + "RegistrationAccess.txt");
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
	
	public static Date validateBirthDate(String dateInput) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateBirth;
		while (true) {
			try {
				dateBirth = formatter.parse(dateInput);
				if (dateBirth.before(new Date())) {
					break;
				} else {
					System.out.println("Invalid input");
				}
			} catch (ParseException pe) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
			dateInput = InputView.getBirthDate();
		}
		return dateBirth;
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
	
	public static Manager checkExistance(Vector<Manager> managers, String username, String password) {
		for (Manager manager : managers) {
			if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
				return manager;
			}
		}
		return null;
	}

	public static Manager getManager(String username, String password) {
		Manager manager;
		while (true) {
			manager = checkExistance(GeneralDB.getManagers(), username, password);
			if (manager != null) {
				break;
			}
			System.out.println("Invalid username or password. Try again");
			username = InputView.getUsername();
			password = InputView.getPassword();
		}
		return manager;
	}	
}
