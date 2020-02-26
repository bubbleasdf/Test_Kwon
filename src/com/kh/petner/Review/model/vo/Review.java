package com.kh.petner.Review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7458100928573372459L;
	private int rno; // 후기 pk
	private int rmno; // 후기에서 사용하는 마켓 id
	private String rcontent; // 후기 내용
	private String rname; // 후기 쓴 유저 이름
	private String remail; // 후기 쓴 유저 이메일
	private int rstar; // 후기에 넣은 별점
	private Date rdate; // 후기 쓴 날짜
	private int refrno; // 후기 댓글에 대한 답글
	private int rlevel; // 답글인지 아닌지
	
	// 기본생성자
	public Review() {
		super();
	}
	// 매개변수 생성자
		
	public Review(int rmno, String rcontent, String rname, String remail, int rstar, int refrno, int rlevel) {
		super();
		this.rmno = rmno;
		this.rcontent = rcontent;
		this.rname = rname;
		this.remail = remail;
		this.rstar = rstar;
		this.refrno = refrno;
		this.rlevel = rlevel;
	}
	
	public Review(int rno, int rmno, String rcontent, String rname, String remail, int rstar, Date rdate, int refrno,
			int rlevel) {
		super();
		this.rno = rno;
		this.rmno = rmno;
		this.rcontent = rcontent;
		this.rname = rname;
		this.remail = remail;
		this.rstar = rstar;
		this.rdate = rdate;
		this.refrno = refrno;
		this.rlevel = rlevel;
	}
	
	// getter & setter
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getRmno() {
		return rmno;
	}
	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public int getRstar() {
		return rstar;
	}
	public void setRstar(int rstar) {
		this.rstar = rstar;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getRefrno() {
		return refrno;
	}
	public void setRefrno(int refrno) {
		this.refrno = refrno;
	}
	public int getRlevel() {
		return rlevel;
	}
	public void setRlevel(int rlevel) {
		this.rlevel = rlevel;
	}
	
	// toString 
	@Override
	public String toString() {
		return "Review [rno=" + rno + ", rmno=" + rmno + ", rcontent=" + rcontent + ", rname=" + rname + ", remail="
				+ remail + ", rstar=" + rstar + ", rdate=" + rdate + ", refrno=" + refrno + ", rlevel=" + rlevel
				+ "]";
	}
	
	
	

}
