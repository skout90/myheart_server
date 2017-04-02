package com.myheart.iylm.dto;

import java.util.Date;

public class UserVo {
	
	private String userId;
	private String snsId;
	private String snsType;
	private String userName;
	private String password;
	private String phoneNum;
	private String email;
	private Date reqDt;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public String getSnsType() {
		return snsType;
	}
	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getReqDt() {
		return reqDt;
	}
	public void setReqDt(Date reqDt) {
		this.reqDt = reqDt;
	}

}
