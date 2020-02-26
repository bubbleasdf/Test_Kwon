package com.kh.petner.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MemberDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2563506129015102959L;
	
	private String userName;
	private String userEmail;
	private String userPhone;
	private int userRoles;
	private String userRoleName;
	private String petName;

	private String petType;
	private String petProfile;
	private Date enDate;
	
	public int getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(int userRoles) {
		this.userRoles = userRoles;
	}
	public MemberDetail(String userName, String userEmail, String userPhone, String petName, String petProfile,
			Date enDate) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.petName = petName;
		this.petProfile = petProfile;
		this.enDate = enDate;
	}
	public MemberDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetProfile() {
		return petProfile;
	}
	public void setPetProfile(String petProfile) {
		this.petProfile = petProfile;
	}
	public Date getEnDate() {
		return enDate;
	}
	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Override
	public String toString() {
		return "MemberDetail [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", petName=" + petName + ", petProfile=" + petProfile + ", enDate=" + enDate + "]";
	}
	
	

}
