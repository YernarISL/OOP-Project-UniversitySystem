package controllers;

import views.RegistryView;

public class RegistryController {
	RegistryView registryView = new RegistryView();
	
	public void updateView() {
		registryView.printRegistryRole();
	}
}
