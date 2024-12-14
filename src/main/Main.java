package main;

import controllers.BaseController;
import models.Admin;

public class Main {
	public static void main(String[] args) {
		BaseController baseController = new BaseController();
		baseController.insertInitData();
		baseController.displayMenu();
	}

}
