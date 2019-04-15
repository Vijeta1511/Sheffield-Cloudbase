package com.singlesignin.domain;

/**
 * It maps the user record from database table.
 * @author sanika
 *
 */
public class User {

	private Integer userId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String loginName;
    private String password;
    private String role;
    private Integer loginStatus;
	
    
	public User() {
		
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
	public Integer getLoginStatus() {
		return loginStatus;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", loginName=" + loginName + ", password=" + password + ", role=" + role + ", loginStatus="
				+ loginStatus + "]";
	}
    
    
}
