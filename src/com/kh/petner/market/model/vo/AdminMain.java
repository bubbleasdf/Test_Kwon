package com.kh.petner.market.model.vo;

import java.io.Serializable;

public class AdminMain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3010565498269266693L;
	private int sumMarket;	// 전체 매장 수
	private int hotel;		// 호텔 수
	private int beauty;		// 미용 수
	private int hospital;	// 병원 수
	private int sumMember;	// 회원 수
	// 접속자 수를 위한 녀석입니다
	private int totalCnt;
	private int todayCnt;
	private int oneAgo;
	private int twoAgo;
	private int threeAgo;
	private int fourAgo;
	private int fiveAgo;
	private int sixAgo;
	// 예약 건 수
	private int rsvCnt;
	// 펫 등록 수
	private int petCnt;

	
	
	public int getPetCnt() {
		return petCnt;
	}

	public void setPetCnt(int petCnt) {
		this.petCnt = petCnt;
	}

	public int getRsvCnt() {
		return rsvCnt;
	}

	public void setRsvCnt(int rsvCnt) {
		this.rsvCnt = rsvCnt;
	}



	public AdminMain() {
		super();
	}
	
	public AdminMain(int sumMarket, int hotel, int beauty, int hospital, int sumMember, int totalCnt, int todayCnt,
			int oneAgo, int twoAgo, int threeAgo, int fourAgo, int fiveAgo, int sixAgo, int rsvCnt, int petCnt) {
		this.sumMarket = sumMarket;
		this.hotel = hotel;
		this.beauty = beauty;
		this.hospital = hospital;
		this.sumMember = sumMember;
		this.totalCnt = totalCnt;
		this.todayCnt = todayCnt;
		this.oneAgo = oneAgo;
		this.twoAgo = twoAgo;
		this.threeAgo = threeAgo;
		this.fourAgo = fourAgo;
		this.fiveAgo = fiveAgo;
		this.sixAgo = sixAgo;
		this.rsvCnt = rsvCnt;
		this.petCnt = petCnt;
	}

	@Override
	public String toString() {
		return "AdminMain [sumMarket=" + sumMarket + ", hotel=" + hotel + ", beauty=" + beauty + ", hospital="
				+ hospital + ", sumMember=" + sumMember + ", totalCnt=" + totalCnt + ", todayCnt=" + todayCnt
				+ ", oneAgo=" + oneAgo + ", twoAgo=" + twoAgo + ", threeAgo=" + threeAgo + ", fourAgo=" + fourAgo
				+ ", fiveAgo=" + fiveAgo + ", sixAgo=" + sixAgo + ", rsvCnt=" + rsvCnt + ", petCnt=" + petCnt + "]";
	}

	public int getSumMarket() {
		return sumMarket;
	}

	public void setSumMarket(int sumMarket) {
		this.sumMarket = sumMarket;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getBeauty() {
		return beauty;
	}

	public void setBeauty(int beauty) {
		this.beauty = beauty;
	}

	public int getHospital() {
		return hospital;
	}

	public void setHospital(int hospital) {
		this.hospital = hospital;
	}

	public int getSumMember() {
		return sumMember;
	}

	public void setSumMember(int sumMember) {
		this.sumMember = sumMember;
	}
	
	

	
	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getTodayCnt() {
		return todayCnt;
	}

	public void setTodayCnt(int todayCnt) {
		this.todayCnt = todayCnt;
	}

	public int getOneAgo() {
		return oneAgo;
	}

	public void setOneAgo(int oneAgo) {
		this.oneAgo = oneAgo;
	}

	public int getTwoAgo() {
		return twoAgo;
	}

	public void setTwoAgo(int twoAgo) {
		this.twoAgo = twoAgo;
	}

	public int getThreeAgo() {
		return threeAgo;
	}

	public void setThreeAgo(int threeAgo) {
		this.threeAgo = threeAgo;
	}

	public int getFourAgo() {
		return fourAgo;
	}

	public void setFourAgo(int fourAgo) {
		this.fourAgo = fourAgo;
	}

	public int getFiveAgo() {
		return fiveAgo;
	}

	public void setFiveAgo(int fiveAgo) {
		this.fiveAgo = fiveAgo;
	}

	public int getSixAgo() {
		return sixAgo;
	}

	public void setSixAgo(int sixAgo) {
		this.sixAgo = sixAgo;
	}



	

}
