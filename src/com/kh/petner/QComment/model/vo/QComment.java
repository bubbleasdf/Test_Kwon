package com.kh.petner.QComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class QComment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9058389683614638098L;
	private int cno; // 댓글 pk
	private int mno; // 마켓 id
	private String ccontent; // 댓글 내용
	private String cname; // 댓글 쓴 유저 이름
	private String cemail; // 댓글 쓴 유저 이메일
	private Date cdate; // 댓글 쓴 날짜
	private int refcno; // 대댓글
	private int clevel; // 댓글 레벨
	
	// 기본생성자
	public QComment() {
		super();
	}

	// 매개변수 생성자
	public QComment(int mno, String ccontent, String cname, String cemail, int refcno, int clevel) {
		super();
		this.mno = mno;
		this.ccontent = ccontent;
		this.cname = cname;
		this.cemail = cemail;
		this.refcno = refcno;
		this.clevel = clevel;
	}
	
	public QComment(int cno, int mno, String ccontent, String cname, String cemail, Date cdate, int refcno,
			int clevel) {
		super();
		this.cno = cno;
		this.mno = mno;
		this.ccontent = ccontent;
		this.cname = cname;
		this.cemail = cemail;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
	}
	
	// getter & setter
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getRefcno() {
		return refcno;
	}

	public void setRefcno(int refcno) {
		this.refcno = refcno;
	}

	public int getClevel() {
		return clevel;
	}

	public void setClevel(int clevel) {
		this.clevel = clevel;
	}

	@Override
	public String toString() {
		return "QComment [cno=" + cno + ", mno=" + mno + ", ccontent=" + ccontent + ", cname=" + cname + ", cemail="
				+ cemail + ", cdate=" + cdate + ", refcno=" + refcno + ", clevel=" + clevel + "]";
	}
}
