package controllers;

import views.ManagerView;
import views.MenuView;
import views.StudentView;
import views.TeacherView;
import views.CourseView;

public class BaseController {
	
	
	TeacherView teacherView = new TeacherView();
	StudentView studentView = new StudentView();
	ManagerView managerView = new ManagerView();
	
	MenuView menuView = new MenuView();
	CourseView courseView = new CourseView();
	
	ManagerController managerController = new ManagerController(managerView);
	TeacherController teacherController = new TeacherController(teacherView);
	StudentController studentController = new StudentController(studentView, courseView);
	
	CourseController courseController = new CourseController();
	
	MenuController menuController = new MenuController(menuView, teacherController, studentController, managerController);
	
	public void displayMenu() {
		menuController.selectMenuAction();
	}
	
	public void insertInitData() {
		courseController.addInitCourses();
	}
}
