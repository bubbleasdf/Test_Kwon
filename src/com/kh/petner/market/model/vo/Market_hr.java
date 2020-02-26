package com.kh.petner.market.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Market_hr implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1963761637303018573L;

	private String marketId;      // 매장별 id
	private String marketEmail;   // 매장 이메일
	private String marketPwd;     // 매장 비밀번호
	private String marketType;    // 매장 타입
	private String marketName;    // 매장 이름
	private String marketAddress; // 매장 주소
	private String marketTime;    // 매장 이용시간(open~close)
	private String marketDayoff;  // 매장 휴무일
	private String marketscore;   // 매장 별점
	private String marketPhoto;   // 매장 사진
	private Date marketdate;      // 매장 등록일
	
	// 기본생성자
	public Market_hr() {
		super();
	}
	
	// 매개변수 생성자(date없는거)
	public Market_hr(String marketId, String marketEmail, String marketPwd, String marketType, String marketName,
			String marketAddress, String marketTime, String marketDayoff, String marketscore, String marketPhoto) {
		super();
		marketId = marketId;
		marketEmail = marketEmail;
		marketPwd = marketPwd;
		marketType = marketType;
		marketName = marketName;
		marketAddress = marketAddress;
		marketTime = marketTime;
		marketDayoff = marketDayoff;
		marketscore = marketscore;
		marketPhoto = marketPhoto;
	}

	// 매개변수 생성자(date있는거)
	public Market_hr(String marketId, String marketEmail, String marketPwd, String marketType, String marketName,
			String marketAddress, String marketTime, String marketDayoff, String marketscore, String marketPhoto,
			Date marketdate) {
		super();
		marketId = marketId;
		marketEmail = marketEmail;
		marketPwd = marketPwd;
		marketType = marketType;
		marketName = marketName;
		marketAddress = marketAddress;
		marketTime = marketTime;
		marketDayoff = marketDayoff;
		marketscore = marketscore;
		marketPhoto = marketPhoto;
		marketdate = marketdate;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getMarketEmail() {
		return marketEmail;
	}

	public void setMarketEmail(String marketEmail) {
		this.marketEmail = marketEmail;
	}

	public String getMarketPwd() {
		return marketPwd;
	}

	public void setMarketPwd(String marketPwd) {
		this.marketPwd = marketPwd;
	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketAddress() {
		return marketAddress;
	}

	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}

	public String getMarketTime() {
		return marketTime;
	}

	public void setMarketTime(String marketTime) {
		this.marketTime = marketTime;
	}

	public String getMarketDayoff() {
		return marketDayoff;
	}

	public void setMarketDayoff(String marketDayoff) {
		this.marketDayoff = marketDayoff;
	}

	public String getMarketscore() {
		return marketscore;
	}

	public void setMarketscore(String marketscore) {
		this.marketscore = marketscore;
	}

	public String getMarketPhoto() {
		return marketPhoto;
	}

	public void setMarketPhoto(String marketPhoto) {
		this.marketPhoto = marketPhoto;
	}

	public Date getMarketdate() {
		return marketdate;
	}

	public void setMarketdate(Date marketdate) {
		this.marketdate = marketdate;
	}

	@Override
	public String toString() {
		return "Market_hr [marketId=" + marketId + ", marketEmail=" + marketEmail + ", marketPwd=" + marketPwd
				+ ", marketType=" + marketType + ", marketName=" + marketName + ", marketAddress=" + marketAddress
				+ ", marketTime=" + marketTime + ", marketDayoff=" + marketDayoff + ", marketscore=" + marketscore
				+ ", marketPhoto=" + marketPhoto + ", marketdate=" + marketdate + "]";
	}

	
	
}
