package controllers;

import views.LoginView;

public class LoginController {
	private LoginView loginView = new LoginView();
	
	public void updateView() {
		loginView.printLoginPanel();
	}
}
