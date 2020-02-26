package com.kh.petner.FAQ.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.petner.common.JDBCTemplate.*;

import com.kh.petner.FAQ.model.vo.FAQ;
import com.kh.petner.QNA.model.vo.QNA;


public class FAQDao {
	
	private Properties prop;

	public FAQDao() {
		
			prop = new Properties();
		
		String filePath = FAQ.class.getResource("/config/FAQ-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}

	public ArrayList<FAQ> FAQlist(Connection con) {
		
		ArrayList<FAQ> list = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("FAQlist");
		
		try {
			
			list = new ArrayList<FAQ>();
			
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				FAQ f = new FAQ();
				f.setFno(rset.getInt("FNO"));
				f.setFtype(rset.getInt("ftype"));
				f.setTitle(rset.getString("title"));
				f.setContent(rset.getString("content"));
				
				
				list.add(f);
				
			}
			System.out.println(list);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		return list;
	}

	public int FAQdelete(Connection con, int fno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("FAQdelete");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fno);
			
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int FAQupdate(Connection con, FAQ f) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("FAQupdate");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, f.getTitle());
			pstmt.setString(2, f.getContent());
			pstmt.setInt(3, f.getFno());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public FAQ FAQselectOne(Connection con, int fno) {
		FAQ f = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql= prop.getProperty("FAQSelectOne");
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, fno);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				f=new FAQ();
				f.setFno(rset.getInt("FNO"));
				f.setFtype(rset.getInt("ftype"));
				f.setTitle(rset.getString("title"));
				f.setContent(rset.getString("content"));
				
			}
			System.out.println(f);
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		return f;
	}

	public int FAQInsert(Connection con, FAQ f,int Condition) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("FAQInsert");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Condition);
			pstmt.setString(2, f.getTitle());
			pstmt.setString(3, f.getContent());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
