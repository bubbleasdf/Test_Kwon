package com.kh.petner.market.model.vo;

import java.io.Serializable;

public class VisitCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4559842834707969605L;
	
	private int totalCnt;
	private int todayCnt;
	private int oneAgo;
	private int twoAgo;
	private int threeAgo;
	private int fourAgo;
	private int fiveAgo;
	private int sixAgo;

	@Override
	public String toString() {
		return "VisitCount [totalCnt=" + totalCnt + ", todayCnt=" + todayCnt + ", oneAgo=" + oneAgo + ", twoAgo="
				+ twoAgo + ", threeAgo=" + threeAgo + ", fourAgo=" + fourAgo + ", fiveAgo=" + fiveAgo + ", sixAgo="
				+ sixAgo + "]";
	}

	public VisitCount() {
	}
	
	public VisitCount(int totalCnt, int todayCnt, int oneAgo, int twoAgo, int threeAgo, int fourAgo, int fiveAgo,
			int sixAgo) {
		this.totalCnt = totalCnt;
		this.todayCnt = todayCnt;
		this.oneAgo = oneAgo;
		this.twoAgo = twoAgo;
		this.threeAgo = threeAgo;
		this.fourAgo = fourAgo;
		this.fiveAgo = fiveAgo;
		this.sixAgo = sixAgo;
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
