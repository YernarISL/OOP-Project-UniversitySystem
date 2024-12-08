package controllers;

import views.LoginView;

public class LoginController {
	private LoginView loginView;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}
	
	public void updateView() {
		loginView.printLoginPanel();
	}
}
