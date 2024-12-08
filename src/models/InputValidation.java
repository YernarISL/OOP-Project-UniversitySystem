package models;

public interface InputValidation {
	public void validateDate();
	
	public boolean validatePassword(String password);
	
	public boolean validateUsername(String username);
	
	public boolean validateFullName(String fullName);
}
