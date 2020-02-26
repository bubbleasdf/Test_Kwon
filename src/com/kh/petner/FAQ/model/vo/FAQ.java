package com.kh.petner.FAQ.model.vo;

public class FAQ {
	
	private int fno;
	private int ftype;
	private String title;
	private String content;
	
	
	public FAQ() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FAQ(int fno, int ftype, String title, String content) {
		super();
		this.fno = fno;
		this.ftype = ftype;
		this.title = title;
		this.content = content;
	}


	public int getFno() {
		return fno;
	}


	public void setFno(int fno) {
		this.fno = fno;
	}


	public int getFtype() {
		return ftype;
	}


	public void setFtype(int ftype) {
		this.ftype = ftype;
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
		return "FAQ [fno=" + fno + ", ftype=" + ftype + ", title=" + title + ", content=" + content + "]";
	}
	
	

}
