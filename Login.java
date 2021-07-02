package com.flight;


public class Login {

	
	private String userName = "ABC";
	private String password = "XYZ";
	
	public boolean getLogin(String userName, String password) {
		
		if(userName.equals(this.userName) && password.equals(this.password)) {
			return true;
		}
		
		
		return false;
		
	}
}
