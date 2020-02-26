package com.kh.petner.hotel.reserve.model.vo;

import java.io.Serializable;
import java.sql.Date;

import com.kh.petner.market.model.vo.Market;

public class HotelReserve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3631254900418665838L;
	
	private int reserveId;   // 예약 번호 
	private int marketId;  	  // 매장 번호 
	private String user_Email; // 예약자 id 
	private String user_Name;  // 예약자 이름 
	private String user_Phone; // 예약자 핸드폰 번호
	private Date s_date; 	  // 예약 시작 날짜
	private Date e_date;      // 예약 종료 날짜
	private int marketPrice;  // 1박 당 예약요금 
	private int pet_Id;        // pet id 
	private String pet_Name;   // pet이름
	private String pet_Type;   // pet타입 
	private String status;    // 예약 상태 
	private int sum_price;    // 총 예약금액 
	
	public HotelReserve() {}

	public HotelReserve(int reserveId, int marketId, String user_Email, String user_Name, String user_Phone,
			Date s_date, Date e_date, int marketPrice, int pet_Id, String pet_Name, String pet_Type, String status,
			int sum_price) {
		super();
		this.reserveId = reserveId;
		this.marketId = marketId;
		this.user_Email = user_Email;
		this.user_Name = user_Name;
		this.user_Phone = user_Phone;
		this.s_date = s_date;
		this.e_date = e_date;
		this.marketPrice = marketPrice;
		this.pet_Id = pet_Id;
		this.pet_Name = pet_Name;
		this.pet_Type = pet_Type;
		this.status = status;
		this.sum_price = sum_price;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public String getUser_Email() {
		return user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getUser_Phone() {
		return user_Phone;
	}

	public void setUser_Phone(String user_Phone) {
		this.user_Phone = user_Phone;
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

	public int getPet_Id() {
		return pet_Id;
	}

	public void setPet_Id(int pet_Id) {
		this.pet_Id = pet_Id;
	}

	public String getPet_Name() {
		return pet_Name;
	}

	public void setPet_Name(String pet_Name) {
		this.pet_Name = pet_Name;
	}

	public String getPet_Type() {
		return pet_Type;
	}

	public void setPet_Type(String pet_Type) {
		this.pet_Type = pet_Type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSum_price() {
		return sum_price;
	}

	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}

	@Override
	public String toString() {
		return "HotelReserve [reserveId=" + reserveId + ", marketId=" + marketId + ", user_Email=" + user_Email
				+ ", user_Name=" + user_Name + ", user_Phone=" + user_Phone + ", s_date=" + s_date + ", e_date="
				+ e_date + ", marketPrice=" + marketPrice + ", pet_Id=" + pet_Id + ", pet_Name=" + pet_Name
				+ ", pet_Type=" + pet_Type + ", status=" + status + ", sum_price=" + sum_price + "]";
	}

	

	
}
