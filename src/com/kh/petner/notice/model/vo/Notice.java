package com.kh.petner.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{

	private static final long serialVersionUID = 2508714298407330456L;
	
	private int nno;
	private int pno;
	private String nemail;
	private String ntitle;
	private String nContent;
	private int nCount;
	private Date ndate;
	
	
	public Notice() {
		
	}


	public Notice(String ntitle, String nContent, int nCount) {
		super();
		this.ntitle = ntitle;
		this.nContent = nContent;
		this.nCount = nCount;
	}


	public Notice(int nno, int pno, String nemail, String ntitle, String nContent, int nCount, Date ndate) {
		super();
		this.nno = nno;
		this.pno = pno;
		this.nemail = nemail;
		this.ntitle = ntitle;
		this.nContent = nContent;
		this.nCount = nCount;
		this.ndate = ndate;
	}


	public int getNno() {
		return nno;
	}


	public void setNno(int nno) {
		this.nno = nno;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getNemail() {
		return nemail;
	}


	public void setNemail(String nemail) {
		this.nemail = nemail;
	}


	public String getNtitle() {
		return ntitle;
	}


	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}


	public String getnContent() {
		return nContent;
	}


	public void setnContent(String nContent) {
		this.nContent = nContent;
	}


	public int getnCount() {
		return nCount;
	}


	public void setnCount(int nCount) {
		this.nCount = nCount;
	}


	public Date getNdate() {
		return ndate;
	}


	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Notice [nno=" + nno +", pno"+ pno +", nemail=" + nemail + ", ntitle=" + ntitle + ", nContent=" + nContent
				+ ", nCount=" + nCount + ", ndate=" + ndate + "]";
	}
	

}
