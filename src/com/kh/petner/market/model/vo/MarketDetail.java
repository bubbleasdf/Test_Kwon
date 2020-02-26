package com.kh.petner.market.model.vo;

import java.io.Serializable;

public class MarketDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2824195414268411713L;

	private int marketId;          		// 매장별 id
	private String marketName;			// 매장 이름 (디테일 판에 
	private String marketCheck;       	// 매장 특징
	private String marketSubPhoto01;	// 매장 서브사진 3개
	private String marketSubPhoto02; 
	private String marketSubPhoto03; 
	private String marketSub;         	// 매장가는길(지하철)
	private String marketBus;         	// 매장가는길(버스)
	private String marketCar;         	// 매장가는길(자가용)
	private int marketPrice;			// 호텔일 경우 1박당 요금
	private String marketIntro;			// 간단한 매장 소개(상세소개 페이지 밑에 들어갑니다)
	private double mapx;				// 지도의 x값?
	private double mapy;				// 지도의 y값
	
	// 기본 생성자
	public MarketDetail() {
		super();
	}

	public MarketDetail(int marketId, String marketName, String marketCheck, String marketSubPhoto01, 
			String marketSubPhoto02, String marketSubPhoto03, String marketSub,
			String marketBus, String marketCar, int marketPrice, String marketIntro, double mapx, double mapy) {
		super();
		this.marketId = marketId;
		this.marketName = marketName;
		this.marketCheck = marketCheck;
		this.marketSubPhoto01 = marketSubPhoto01;
		this.marketSubPhoto02 = marketSubPhoto02;
		this.marketSubPhoto03 = marketSubPhoto03;
		this.marketSub = marketSub;
		this.marketBus = marketBus;
		this.marketCar = marketCar;
		this.marketPrice = marketPrice;
		this.marketIntro = marketIntro;
		this.mapx = mapx;
		this.mapy = mapy;
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

	public String getMarketCheck() {
		return marketCheck;
	}

	public void setMarketCheck(String marketCheck) {
		this.marketCheck = marketCheck;
	}


	public String getMarketSubPhoto01() {
		return marketSubPhoto01;
	}

	public void setMarketSubPhoto01(String marketSubPhoto01) {
		this.marketSubPhoto01 = marketSubPhoto01;
	}

	public String getMarketSubPhoto02() {
		return marketSubPhoto02;
	}

	public void setMarketSubPhoto02(String marketSubPhoto02) {
		this.marketSubPhoto02 = marketSubPhoto02;
	}

	public String getMarketSubPhoto03() {
		return marketSubPhoto03;
	}

	public void setMarketSubPhoto03(String marketSubPhoto03) {
		this.marketSubPhoto03 = marketSubPhoto03;
	}

	public String getMarketSub() {
		return marketSub;
	}

	public void setMarketSub(String marketSub) {
		this.marketSub = marketSub;
	}

	public String getMarketBus() {
		return marketBus;
	}

	public void setMarketBus(String marketBus) {
		this.marketBus = marketBus;
	}

	public String getMarketCar() {
		return marketCar;
	}

	public void setMarketCar(String marketCar) {
		this.marketCar = marketCar;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getMarketIntro() {
		return marketIntro;
	}

	public void setMarketIntro(String marketIntro) {
		this.marketIntro = marketIntro;
	}

	public double getMapx() {
		return mapx;
	}

	public void setMapx(double mapx) {
		this.mapx = mapx;
	}

	public double getMapy() {
		return mapy;
	}

	public void setMapy(double mapy) {
		this.mapy = mapy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MarketDetail [marketId=" + marketId + ", marketName=" + marketName + ", marketCheck=" + marketCheck
				+ ", marketSubPhoto01=" + marketSubPhoto01
				+ ", marketSubPhoto02=" + marketSubPhoto02 + ", marketSubPhoto03=" + marketSubPhoto03 + ", marketSub="
				+ marketSub + ", marketBus=" + marketBus + ", marketCar=" + marketCar + ", marketPrice=" + marketPrice
				+ ", marketIntro=" + marketIntro + ", mapx=" + mapx + ", mapy=" + mapy + "]";
	}


	
	

}
