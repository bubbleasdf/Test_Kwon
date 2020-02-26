package com.kh.petner.member.pet.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Pet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3442168076282237283L;
	private String userEmail;
	private String petName;
	private String petType;
	private Date petBirth;
	private String petProfile;
	private int petWeight;
	private String petPic;
	private String petTop;
	private Date petDate;
	private int petId;
	
	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight,
			String petPic, String petTop, Date petDate, int petId) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
		this.petPic = petPic;
		this.petTop = petTop;
		this.petDate = petDate;
		this.petId = petId;
	}

	public int getPetId() {
		return petId;
	}

	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight,
			String petPic, String petTop, int petId) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
		this.petPic = petPic;
		this.petTop = petTop;
		this.petId = petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight,
			String petPic, String petTop) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
		this.petPic = petPic;
		this.petTop=petTop;
	}

	public Pet() {}

	
	
	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight,
			String petPic, String petTop, Date petDate) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
		this.petPic = petPic;
		this.petTop = petTop;
		this.petDate = petDate;
	}

	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight,
			String petPic) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
		this.petPic = petPic;
	}



	public Pet(String userEmail, String petName, String petType, Date petBirth, String petProfile, int petWeight) {
		super();
		this.userEmail = userEmail;
		this.petName = petName;
		this.petType = petType;
		this.petBirth = petBirth;
		this.petProfile = petProfile;
		this.petWeight = petWeight;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public Date getPetBirth() {
		return petBirth;
	}

	public void setPetBirth(Date petBirth) {
		this.petBirth = petBirth;
	}

	public String getPetProfile() {
		return petProfile;
	}

	public void setPetProfile(String petProfile) {
		this.petProfile = petProfile;
	}

	@Override
	public String toString() {
		return "Pet [userEmail=" + userEmail + ", petName=" + petName + ", petType=" + petType + ", petBirth="
				+ petBirth + ", petProfile=" + petProfile + ", petWeight=" + petWeight + ", petPic=" + petPic + "]";
	}

	public int getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}

	public String getPetPic() {
		return petPic;
	}

	public void setPetPic(String petPic) {
		this.petPic = petPic;
	}

	public String getPetTop() {
		return petTop;
	}

	public void setPetTop(String petTop) {
		this.petTop = petTop;
	}

	public Date getPetDate() {
		return petDate;
	}

	public void setPetDate(Date petDate) {
		this.petDate = petDate;
	}


	
	
}
