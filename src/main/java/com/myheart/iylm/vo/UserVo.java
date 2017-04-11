package com.myheart.iylm.vo;

import java.util.Date;

/**
 * <pre>
 * Class Name  : UserVo.java
 * Description :
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 4. 2.   지선학              최초생성
 * </pre>
 *
 * @author 지선학
 * @since 2017. 4. 2.
 * @version 1.0
 *
 * Copyright (C) 2017 by MYHEART All right reserved.
 */

public class UserVo {

	//사용자 번호
	private int userNo;
	//사용자 ID
	private String userId;
	//SNS 고유 ID
	private String snsId;
	//SNS 유형
	private String snsType;
	//사용자 이름
	private String userName;
	//패스워드
	private String password;
	//폰 번호
	private String phoneNum;
	//이메일
	private String email;
	//등록일자
	private Date reqDt;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

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

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userId=" + userId + ", snsId=" + snsId + ", snsType=" + snsType
				+ ", userName=" + userName + ", password=" + password + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", reqDt=" + reqDt + "]";
	}

}
