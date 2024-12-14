package controllers;

import views.LoginView;
import views.MenuView;
import views.RegistryView;
import views.StudentView;
import views.TeacherView;
import views.CourseView;

public class BaseController {
	
	RegistryView registryView = new RegistryView();
	LoginView loginView = new LoginView();
	TeacherView teacherView = new TeacherView();
	StudentView studentView = new StudentView();
	MenuView menuView = new MenuView();
	CourseView courseView = new CourseView();
	
	TeacherController teacherController = new TeacherController(teacherView);
	StudentController studentController = new StudentController(studentView, courseView);
	
	CourseController courseController = new CourseController();
	
	MenuController menuController = new MenuController(menuView, teacherController, studentController);
	
	public void displayMenu() {
		menuController.updateView();
	}
	
	public void insertInitData() {
		teacherController.addInitTeachers();
		courseController.addInitCourses();
	}
}
