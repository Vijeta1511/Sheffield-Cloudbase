package com.singlesignin.command;

/**
 * This class takes login data from Controller to View and vice versa.
 * It contains getters and setters for variables required in Login form.
 * @author sanika
 */

public class LoginCommand {
	
	@Override
	public String toString() {
		return "LoginCommand [loginName=" + loginName + ", password=" + password + "]";
	}
	private String loginName;
	private String password;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}


