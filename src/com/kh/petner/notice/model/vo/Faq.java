package com.kh.petner.notice.model.vo;

import java.io.Serializable;

public class Faq implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -962195003996180954L;
	private int fno;
	private int fType;
	private String fType2;
	private String title;
	private String content;
	
	public Faq() {}
	
	public Faq(int fno, int fType, String fType2, String title, String content) {
		this.fno = fno;
		this.fType = fType;
		this.fType2 = fType2;
		this.title = title;
		this.content = content;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getfType() {
		return fType;
	}

	public void setfType(int fType) {
		this.fType = fType;
	}

	public String getfType2() {
		return fType2;
	}

	public void setfType2(String fType2) {
		this.fType2 = fType2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Faq [fno=" + fno + ", fType=" + fType + ", fType2=" + fType2 + ", title=" + title + ", content="
				+ content + "]";
	}

	
	
	
	
	

}
