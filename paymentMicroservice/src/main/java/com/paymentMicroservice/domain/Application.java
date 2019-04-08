package com.paymentMicroservice.domain;

public class Application {
	private Integer app_id; //PK
	private String name;
	private Integer userId; //FK
	
	//Constructor
	public Application() {
		
	}
	
	public Integer getApp_id() {
		return app_id;
	}
	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}
