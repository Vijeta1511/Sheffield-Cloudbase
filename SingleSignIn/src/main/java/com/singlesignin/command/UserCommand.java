package com.singlesignin.command;

import com.singlesignin.domain.User;

/**
 * This class takes the registration information from Controller to View and vice versa.
 * It contains getters and setters for variables required in Registration form.
 * @author sanika
 */

public class UserCommand {

	User user;  

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private Integer userId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String loginName;
    private String password;
    private String role;
    private Integer loginStatus;
    
    @Override
	public String toString() {
		return "UserCommand [user=" + user + ", userId=" + userId + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", loginName=" + loginName + ", password=" + password + ", role="
				+ role + ", loginStatus=" + loginStatus + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	
}