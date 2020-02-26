package com.kh.petner.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Qna implements Serializable{
		
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 8296345724365612200L;
	private int qno;
	private int rnum;
	private String qtitle;
	private String qcontent;
	private String qemail;
	private Date ndate;
	
	public Qna() {
		super();
	}
	
	public Qna(int qno, int rnum, String qtitle, String qcontent, String qemail, Date ndate) {
		super();
		this.qno = qno;
		this.rnum = rnum;
		this.qtitle = qtitle;
		this.qcontent = qcontent;
		this.qemail = qemail;
		this.ndate = ndate;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public String getQemail() {
		return qemail;
	}

	public void setQemail(String qemail) {
		this.qemail = qemail;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	@Override
	public String toString() {
		return "Qna [qno=" + qno + ", rnum=" + rnum + ", qtitle=" + qtitle + ", qcontent=" + qcontent + ", qemail="
				+ qemail + ", ndate=" + ndate + "]";
	}

	
}
	
	