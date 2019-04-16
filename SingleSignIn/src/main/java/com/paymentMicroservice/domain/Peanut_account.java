package com.paymentMicroservice.domain;

public class Peanut_account {

	
	private Integer acc_id; //PK
	private Integer available_peanuts;
	private Integer userId;  //FK
	
	//Constructor
	public Peanut_account() {
		
	}
	
	public Integer getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}
	
	
	public Integer getAvailable_peanuts() {
		return available_peanuts;
	}
	public void setAvailable_peanuts(Integer available_peanuts) {
		this.available_peanuts = available_peanuts;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
}
