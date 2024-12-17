package controllers;

import java.util.Date;
import java.util.Scanner;

import models.Manager;
import models.Teacher;
import models.Student;
import models.BaseState;

import views.MenuView;
import views.InputView;

public class MenuController {
	private TeacherController teacherController;
	private StudentController studentController;
	private ManagerController managerController;
	private MenuView menuView;
	
	private boolean running = true;
	
	Scanner in = new Scanner(System.in);
	
	public MenuController(MenuView menuView, TeacherController teacherController, StudentController studentController, ManagerController managerController) {
		this.teacherController = teacherController;
		this.studentController = studentController;
		this.managerController = managerController;
		this.menuView = menuView;
	}
	
	public void selectMenuAction() {
		while (running) {
			menuView.printHeader();
			menuView.menuSelection();
			int menuOption = in.nextInt();
			switch(menuOption) {
				case 1:
					menuView.printLoginRole();
					selectLoginRole();
					break;
				case 2:
					menuView.printRegistryRole();
					selectRegistryRole();
					break;
				case 3:
					running = false;
					break;
				case 4:
					teacherController.updateView();
					break;
				case 5:
					studentController.updateView();
					break;
				case 6:
					managerController.updateView();
				default:
					System.out.println("Incorrect Input. Try again");
					break;
			}
		}
	}
	
	public void selectRegistryRole() {
		int regRole = in.nextInt();
		String fullName, username, password;
		Date dateBirth, dateYearApp;
		switch(regRole) {
			case 1:
				fullName = studentController.getFullName(InputView.getFullName());
				
				username = studentController.getUsername(InputView.getUsername());
				
				password = studentController.getPassword(InputView.getPassword());
				
				dateBirth = studentController.getBirthDate(InputView.getBirthDate());
				
				dateYearApp = studentController.getYearAppDate(dateBirth, InputView.getYearAppDate());
				
				studentController.setRegisterData(fullName, username, password, dateBirth, dateYearApp);
				
				selectMenuAction();
				break;
			case 2:
				fullName = teacherController.getFullName(InputView.getFullName());
				
				username = teacherController.getUsername(InputView.getUsername());
				
				password = teacherController.getPassword(InputView.getPassword());
				
				dateBirth = teacherController.getBirthDate(InputView.getBirthDate());
				
				teacherController.setRegisterData(fullName, dateBirth, username, password);
				
				selectMenuAction();
				break;
			case 3:
				fullName = managerController.getFullName(InputView.getFullName());

				username = managerController.getUsername(InputView.getUsername());
				
				password = managerController.getPassword(InputView.getPassword());

				dateBirth = managerController.getBirthDate(InputView.getBirthDate());
				
				managerController.setRegisterData(fullName, dateBirth, username, password);
				
				selectMenuAction();
				break;
			case 4:
				break;
			default:
				System.out.println("Incorrect Input. Try again");
				selectRegistryRole();
				break;
		}
	}
	
	public void selectLoginRole() {
		int logRole = in.nextInt();
		String username, password;
		BaseState state;
		switch (logRole) {
			case 1: 
				username = studentController.getUsername(InputView.getUsername());
				
				password = studentController.getPassword(InputView.getPassword());
				
				Student student = studentController.getStudent(username, password);
				
				state = studentController.loginToAccount(student);
				
				while (true) {
					if (state == BaseState.BACK_TO_MENU) {
						break;
					} else if (state == BaseState.STUDENT_CABINET) {
						state = studentController.loginToAccount(student);
					}
				}
				selectMenuAction();
				break;
			case 2:
				username = teacherController.getUsername(InputView.getUsername());
				
				password = teacherController.getPassword(InputView.getPassword());
				
				Teacher teacher = teacherController.getTeacher(username, password);
				
				state = teacherController.loginToAccount(teacher);
				
				while (true) {
					if (state == BaseState.BACK_TO_MENU) {
						break;
					} else if (state == BaseState.TEACHER_CABINET) {
						state = teacherController.loginToAccount(teacher);
					}
				}
				selectMenuAction();
				break;
			case 3:
				username = managerController.getUsername(InputView.getUsername());
				
				password = managerController.getPassword(InputView.getPassword());
				
				Manager manager = managerController.getManager(username, password);
				
				state = managerController.loginToAccount(manager);
				
				while (true) {
					if (state == BaseState.BACK_TO_MENU) {
						break;
					} else if (state == BaseState.MANAGER_CABINET) {
						state = managerController.loginToAccount(manager);
					}
				}
				selectMenuAction();
				break;
			case 4:
				selectMenuAction();
				break;
			default:
				System.out.println("Incorrect Input. Try again");
				selectLoginRole();
				break;
		}
	}
	

}
