package com.paymentMicroservice.domain;

public class User {
	private Integer user_id;
	private String name;
	private Integer phone_number;
	private String email_id;
	private String address;
	private String user_name;
	private String password;
	private Integer role;
	private Integer loginStatus;
	
	//Constructor
	public User() {
		
	}
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}
	
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	
	public Integer getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	
}
