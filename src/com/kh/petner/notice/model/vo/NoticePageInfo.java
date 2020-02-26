package com.kh.petner.notice.model.vo;

import java.io.Serializable;

public class NoticePageInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6327418315105552767L;
	private int currentPage;
	private int listCount;
	private int limit;
	private int maxPage;
	private int startPage;
	private int endPage;
	public NoticePageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticePageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "NoticePageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	

}
