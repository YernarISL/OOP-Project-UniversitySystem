package controllers;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import models.Course;
import models.Student;
import models.GeneralDB;
import models.BaseState;
import views.StudentView;
import views.CourseView;

public class StudentController {
	private StudentView studentView;
	private CourseView courseView;
	Scanner in = new Scanner(System.in);
	
	public StudentController(StudentView studentView, CourseView courseView) {
		this.studentView = studentView;
		this.courseView = courseView;
	}
	
	public BaseState loginToAccount(Student student) {
		studentView.studentMenu(student);
		return selectStudentAction(student);
	}
	
	public BaseState selectStudentAction(Student student) {
		int option = in.nextInt();
		
		switch (option) {
			case 1:
				studentView.displayMarks(student.viewMarks());
				return BaseState.STUDENT_CABINET;
			case 2:
				if (student.checkForEmptyCourses(student.getSelectedCourses())) {
					System.out.println("No courses");
				} else {
	 				studentView.displayCourses(student.getSelectedCourses());
				}
				return BaseState.STUDENT_CABINET;
			case 3:
				return BaseState.STUDENT_CABINET;
			case 4:
				return BaseState.STUDENT_CABINET;
			case 5:
				return BaseState.STUDENT_CABINET;
			case 6:
				Vector<Course> courses = GeneralDB.getCourses();
				while (true) {
					courseView.registryPanel(courses);
					int courseOption = in.nextInt();
					if (student.selectCourses(courseOption, courses)) {
						System.out.println("Registration for the course was successful!");
						break;
					} else {
						System.out.println("Wrong Input. Try Again");
					}
				}
				return BaseState.STUDENT_CABINET;
			case 7:
				return BaseState.STUDENT_CABINET;
			case 8:
				return BaseState.BACK_TO_MENU;
			default:
				System.out.println("Incorrect input\n");
		}
		return BaseState.BACK_TO_MENU;
	}
	
	public void setRegisterData(String fullName, String username, String password, Date date, Date yearOfApplication) {
		Student.createStudent(fullName, username, password, date, yearOfApplication);
	}
	
	public Student getStudent(String username, String password) {
		return Student.getStudent(username, password);
	}
	
	public String getUsername(String username) {
		return Student.validateUsername(username);
	}
	
	public String getPassword(String password) {
		return Student.validatePassword(password);
	}
	
	public String getFullName(String fullName) {
		return Student.validateFullName(fullName);
	}
	
	public Date getBirthDate(String dateBirth) {
		return Student.validateBirthDate(dateBirth);
	}
	
	public Date getYearAppDate(Date dateBirth, String dateYearApp) {
		return Student.validationYearAppDate(dateBirth, dateYearApp);
	}
	
	public void updateView() { 
		Vector<Student> students = GeneralDB.getStudents(); 
		studentView.displayStudents(students);
	}
	
}
