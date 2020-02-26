package com.kh.petner.market.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Market implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1884690988993745693L;
	private int marketId; // 고유번호? 넘버로?
	private String marketName;
	private String marketPwd;
	private String marketEmail;
	private String marketType; 		// 매장 타입
	private String marketTel;       // 매장번호
	private String marketCellPhone; // 매장 휴대번호?
	private String marketAddress;
	private Date enDate;            // 매장 가입일
	private String status;		   	// 삭제여부? 넣어야 되나 ㅋㅋ
	private String marketPlace;		// 강남, 서초 등 검색용 주소
	private String marketMainPhoto;    	// 매장 연락번호
	private int marketStar;
	private int reviewCount;



	@Override
	public String toString() {
		return "Market [marketId=" + marketId + ", marketName=" + marketName + ", marketPwd=" + marketPwd
				+ ", reviewCount="+ reviewCount + ",marketStar=" + marketStar + ", marketEmail=" + marketEmail + ", marketType=" + marketType + ", marketTel=" + marketTel
				+ ", marketCellPhone=" + marketCellPhone + ", marketAddress=" + marketAddress + ", enDate=" + enDate
				+ ", status=" + status + ", marketPlace=" + marketPlace + ", marketMainPhoto=" + marketMainPhoto + "]";
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public int getMarketStar() {
		return marketStar;
	}

	public void setMarketStar(int marketStar) {
		this.marketStar = marketStar;
	}

	public int getMarketId() {
		return marketId;
	}



	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}



	public String getMarketName() {
		return marketName;
	}



	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}



	public String getMarketPwd() {
		return marketPwd;
	}



	public void setMarketPwd(String marketPwd) {
		this.marketPwd = marketPwd;
	}



	public String getMarketEmail() {
		return marketEmail;
	}



	public void setMarketEmail(String marketEmail) {
		this.marketEmail = marketEmail;
	}



	public String getMarketType() {
		return marketType;
	}



	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}



	public String getMarketTel() {
		return marketTel;
	}



	public void setMarketTel(String marketTel) {
		this.marketTel = marketTel;
	}



	public String getMarketCellPhone() {
		return marketCellPhone;
	}



	public void setMarketCellPhone(String marketCellPhone) {
		this.marketCellPhone = marketCellPhone;
	}



	public String getMarketAddress() {
		return marketAddress;
	}



	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}



	public Date getEnDate() {
		return enDate;
	}



	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getMarketPlace() {
		return marketPlace;
	}



	public void setMarketPlace(String marketPlace) {
		this.marketPlace = marketPlace;
	}



	public String getMarketMainPhoto() {
		return marketMainPhoto;
	}



	public void setMarketMainPhoto(String marketMainPhoto) {
		this.marketMainPhoto = marketMainPhoto;
	}



	public Market(int marketId, String marketName, String marketPwd, String marketEmail, String marketType,
			String marketTel, String marketCellPhone, String marketAddress, Date enDate, String status,
			String marketPlace, String marketMainPhoto, int marketStar, int reviewCount) {
		super();
		this.marketId = marketId;
		this.marketName = marketName;
		this.marketPwd = marketPwd;
		this.marketEmail = marketEmail;
		this.marketType = marketType;
		this.marketTel = marketTel;
		this.marketCellPhone = marketCellPhone;
		this.marketAddress = marketAddress;
		this.enDate = enDate;
		this.status = status;
		this.marketPlace = marketPlace;
		this.marketMainPhoto = marketMainPhoto;
		this.marketStar = marketStar;
		this.reviewCount = reviewCount;
	}



	public Market() {}
	// 생성자는 나중에 필요할 때 하나씩 넣어주자
	
	
	
	
	
	

}
