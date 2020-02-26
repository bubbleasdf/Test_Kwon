package com.kh.petner.market.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class HotelReserve implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1056350925627519945L;
	private int reserveId;   	// 예약 고유 번호
	private int marketId;  		// 매장 id
	private String userEmail; 	// 예약자 Email 
	private String userName;  	// 예약자 이름
	private String userPhone; 	// 유저 전화번호
	private String marketName;  // 마켓 이름
	private String marketPhone; // 마켓 전화번호
	private Date s_date; 	  	// 예약 시작 날짜
	private Date e_date;      	// 예약 종료 날짜
	private int marketPrice;  	// 1박 당 예약요금
	private int petId;			// pet 고유번호
	private String petName;   	// pet이름
	private String petType;   	// pet타입
	private String status;    	// 예약 상태(예약완료, 결제완료 등)
	private int term;			// 총 예약 기간 (2일 3일 등)


	
	public HotelReserve() {
	}


	public HotelReserve(int reserveId, int marketId, String userEmail, String userName, String userPhone, Date s_date,
			Date e_date, int marketPrice, String petName, String petType, String status) {
		super();
		this.reserveId = reserveId;
		this.marketId = marketId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPhone = userPhone;
		this.s_date = s_date;
		this.e_date = e_date;
		this.marketPrice = marketPrice;
		this.petName = petName;
		this.petType = petType;
		this.status = status;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}
	
	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketPhone() {
		return marketPhone;
	}

	public void setMarketPhone(String marketPhone) {
		this.marketPhone = marketPhone;
	}
	
	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}


	@Override
	public String toString() {
		return "HotelReserve [marketId=" + marketId + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", s_date=" + s_date + ", e_date=" + e_date + ", marketPrice="
				+ marketPrice + ", petName=" + petName + ", petType=" + petType + ", status=" + status + "]";
	}

}
