package com.kh.petner.QNAComment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class QNAComment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6890231489782684020L;
	
	
	private int cno;
	private int qno;
	private String cemail ;
	private String ccontent;
	private Date cdate;
	private int refcno;
	private int clevel;
	public QNAComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QNAComment(int qno, String cemail, String ccontent, int refcno, int clevel) {
		super();
		this.qno = qno;
		this.cemail = cemail;
		this.ccontent = ccontent;
		this.refcno = refcno;
		this.clevel = clevel;
	}
	public QNAComment(int cno, int qno, String cemail, String ccontent, Date cdate, int refcno, int clevel) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.cemail = cemail;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
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
		return "QNAComment [cno=" + cno + ", qno=" + qno + ", cemail=" + cemail + ", ccontent=" + ccontent + ", cdate="
				+ cdate + ", refcno=" + refcno + ", clevel=" + clevel + "]";
	}
	
	

}
