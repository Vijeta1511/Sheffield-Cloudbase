package com.paymentMicroservice.domain;

public class Transaction {

	private Integer trans_id; //PK
	private Integer userId;  //FK
	private Integer appId;  //FK
	private Integer accId;  //FK
	
	//Constructor
	public Transaction() {
		
	}
	
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	
	
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	
	
	
	
}
