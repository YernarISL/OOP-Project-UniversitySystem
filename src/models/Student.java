package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Pattern;

import views.InputView;

public class Student extends User {
	private static final long serialVersionUID = -4280982078902198112L;
	private String fullName;
	private Date dateYearApp;
	private Date dateBirth;
	private int age;
	private Vector<Course> listOfCourses = new Vector<Course>(); 
	
	public Student(String fullName, String username, String password, Date dateBirth, Date dateYearApp) {
		super(username, password);
		this.fullName = fullName;
		this.dateBirth = dateBirth;
		this.dateYearApp = dateYearApp;
		setAge();
	}
	
	public void registerForCourses(Vector<Course> courses) {
		boolean approved = false; /// Manager action
		if (approved) {
			// update students transcript and journal
		} else {
			// something need to change
		}
	} 
	
	
	public String viewMarks() {
		return "There are marks!";
	}
	
	
	public String viewCourses() {
		return "";
	}
	
	public void getInfoAboutCourse() {
		
	}
	
	public static void createStudent(String fullName, String username, String password, Date date, Date yearOfApplication) {
		Student student = new Student(fullName, username, password, date, yearOfApplication);
		Vector<Student> students = GeneralDB.getStudents();
		students.add(student);
		GeneralDB.students = students;
		GeneralDB.saveStudents();
	}
	
	// The method is responsible for searching the course according to user input
	public boolean selectCourses(int option, Vector<Course> courses) {
		Vector<Course> selectedCourses = new Vector<Course>();
		boolean selected = false;
		int coursesCount = courses.size();
		while (true) { 
			for (int i = 0; i < coursesCount; i++) {
				if (option == (i + 1)) {
					Course course = courses.get(i);
					selectedCourses.add(course);
					selected = true;
				}
			}
			if (selected) {
				saveSelectedCourses(selectedCourses);			
				break;
			} 
		}
		return selected;
	}
	
	public int calculateAge() {
		Calendar birthCalendar = new GregorianCalendar();
		Calendar currCalendar = Calendar.getInstance();
		birthCalendar.setTime(dateBirth);
		int birthMonth = birthCalendar.get(Calendar.MONTH);
		int currMonth = currCalendar.get(Calendar.MONTH);
		int age = currCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
		if (birthMonth < currMonth) {
			return age;
		} else {
			return age - 1;
		}
		
	}
	
	public void saveSelectedCourses(Vector<Course> selectedCourses) {
		ReadAndWrite.serialize(selectedCourses, GeneralDB.getPath() + "studentSelectedCourses.txt");
	}
	
	public Vector<Course> getSelectedCourses() {
		Object obj = ReadAndWrite.deserialize(GeneralDB.getPath() + "studentSelectedCourses.txt");
		if (obj instanceof Vector) {
			return (Vector<Course>) obj;
		}
		return null;
	}
	
	public static Student checkExistance(Vector<Student> students, String username, String password) {
		for (Student student : students) {
			if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
				return student;
			}
		}
		return null;
	}
	
	public static Student getStudent(String username, String password) {
		Student student;
		while (true) {
			student = checkExistance(GeneralDB.getStudents(), username, password);
			if (student != null) {
				break;
			} 
			System.out.println("Invalid username or password. Try again");
			username = InputView.getUsername();
			password = InputView.getPassword();
		}
		return student;
	}
	
	public boolean checkForEmptyCourses(Vector<Course> selectedCourses) {
		if (selectedCourses.isEmpty()) {
			return true;
		}
		return false;
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
	
	public static Date validationYearAppDate(Date dateBirth, String dateInput) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dateYearApp;
		while (true) {
			try {
				dateYearApp = formatter.parse(dateInput);
				if (dateYearApp.before(new Date()) && dateBirth.before(dateYearApp)) {
					break;
				} else {
					System.out.println("Invalid input");
				}
			} catch (ParseException pe) {
				System.out.println("Invalid input. Example: 04-01-2021.\nPlease try again.");
			}
			dateInput = InputView.getYearAppDate();
		}
		return dateYearApp;
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
	
	@Override
	public String toString() {
		String border = "-----------------------------------------------------------";
		return border + "\n" + "Full name: " + fullName + "\n" + "Username: " + getUsername() + "\n" + "Age: " + 
				age + "\n" + border; 
	}
	
	public String getFullName() {
		return fullName;
	}

	public Date getDateYearApp() {
		return dateYearApp;
	}

	public int getAge() {
		return age;
	}

	public void setAge() {
		this.age = calculateAge();
	}

	public Vector<Course> getListOfCourses() {
		return listOfCourses;
	}
	
	public void setListOfCourses(Vector<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}

	public Date getDateBirth() {
		return dateBirth;
	}
	
}
