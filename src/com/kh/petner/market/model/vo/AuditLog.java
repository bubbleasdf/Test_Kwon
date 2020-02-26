package com.kh.petner.market.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AuditLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 804659961362158415L;
	private int logNo;
	private String LogDate;
	private String logSql;
	private String methodName;
	private String doit;
	
	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLogNo() {
		return logNo;
	}

	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}

	public String getLogDate() {
		return LogDate;
	}

	public void setLogDate(String logDate) {
		LogDate = logDate;
	}

	public String getLogSql() {
		return logSql;
	}

	public void setLogSql(String logSql) {
		this.logSql = logSql;
	}


	public String getDoit() {
		return doit;
	}

	public void setDoit(String doit) {
		this.doit = doit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public AuditLog(int logNo, String logDate, String logSql, String methodName, String doit) {
		super();
		this.logNo = logNo;
		LogDate = logDate;
		this.logSql = logSql;
		this.methodName = methodName;
		this.doit = doit;
	}

	@Override
	public String toString() {
		return "AuditLog [logNo=" + logNo + ", LogDate=" + LogDate + ", logSql=" + logSql + ", methodName=" + methodName
				+ ", doit=" + doit + "]";
	}

	
	

}
