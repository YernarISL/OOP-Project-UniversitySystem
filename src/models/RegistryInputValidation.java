package models;

import java.util.Date;

public interface RegistryInputValidation {
	
	public Date validateDateOfBirth();
	
	public Date validateDateOfYearApp();
	
	public String validateFullName();
	
	public int validateAge();
}
