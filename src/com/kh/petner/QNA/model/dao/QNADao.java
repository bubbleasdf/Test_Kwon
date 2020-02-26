package com.kh.petner.QNA.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.plaf.synth.SynthSeparatorUI;

import static com.kh.petner.common.JDBCTemplate.*;

import com.kh.petner.QNA.model.vo.QNA;

public class QNADao {
	
	private Properties prop ;

	public QNADao() {
		prop = new Properties();
		
		String filePath = QNA.class.getResource("/config/QNA-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int listCount(Connection con) {
		
		int listCount = 0;
		
		Statement stmt = null; 
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<QNA> QNAPage(Connection con, int currentPage, int limit) {
		
		ArrayList<QNA> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("QNAPage");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit + 1;
			int endRow = startRow +limit -1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<QNA>();
			
			while(rset.next()) {
				QNA a = new QNA();
				
				a.setRnum(rset.getInt("rnum"));
				a.setQno(rset.getInt("qno"));
				a.setQtitle(rset.getString("qtitle"));
				a.setQcontent(rset.getString("qcontent"));
				a.setQemail(rset.getString("qemail"));
				a.setNdate(rset.getDate("qdate"));
				
				list.add(a);
				
				
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		return list;
		}

	public QNA selectOne(Connection con, int qno) {
		
		QNA q = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql= prop.getProperty("QNASelectOne");
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				q=new QNA();
				q.setQno(rset.getInt("QNO"));
				q.setQemail(rset.getString("QEMAIL"));
				q.setQtitle(rset.getString("QTITLE"));
				q.setQcontent(rset.getString("QCONTENT"));
				q.setNdate(rset.getDate("QDATE"));
				
			}
			System.out.println(q);
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return q;
		
	}

	public int insertQNA(Connection con, QNA q) {
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQNA");
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, q.getQtitle());
			pstmt.setString(2, q.getQcontent());
			pstmt.setString(3, q.getQemail());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int Qupdate(Connection con, QNA q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQno");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, q.getQtitle());
			pstmt.setString(2, q.getQcontent());
			pstmt.setInt(3, q.getQno());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int searchListCount(Connection con, String caregory ,String keyword) {
		
		int listCount = 0;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = null;	
		
		switch(caregory) {
		case "email":
			sql = prop.getProperty("searchemailcount");
			break;
		case "title":
			sql = prop.getProperty("searchtitlecount");
			break;
		case "content":
			sql = prop.getProperty("searchcontentcount");
			break;
		}
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			
			rset = pstmt.executeQuery();
					
			
					
			  if(rset.next()) {
					listCount = rset.getInt(1);
				}		
			  
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return listCount;
	}

	public ArrayList<QNA> searchListQna(Connection con, String caregory, String keyword, int currentPage, int limit) {
		
		ArrayList<QNA> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(caregory) {
		case "email":
			sql =prop.getProperty("searchEmailQNA");
			break;
		case "title":
			sql = prop.getProperty("searchTitleQNA");
			break;
		case "content":
			sql = prop.getProperty("searchContentQNA");
			break;
		}
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit + 1;
			int endRow = startRow +limit -1;
			
				pstmt.setString(1, keyword);
				pstmt.setInt(2, endRow);
				pstmt.setInt(3, startRow);
		
			rset = pstmt.executeQuery();
			
			list = new ArrayList<QNA>();
			
			while(rset.next()) {
				QNA a = new QNA();
				
				a.setRnum(rset.getInt("rnum"));
				a.setQno(rset.getInt("qno"));
				a.setQtitle(rset.getString("qtitle"));
				a.setQcontent(rset.getString("qcontent"));
				a.setQemail(rset.getString("qemail"));
				a.setNdate(rset.getDate("qdate"));
				
				list.add(a);
				
				
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		
		
		return list;
	}

	public int QNAdelete(Connection con, int qno) {
		
			int result = 0;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("QNAdelete");	
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	/*
	public ArrayList<QNA> QNAuserList(Connection con, String userEmail) {
		
		ArrayList<QNA> list = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("QNAuserList");
		
		System.out.println("DAO sql : "+ sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			System.out.println("DAO userEmail : "+userEmail);
			pstmt.setString(1, userEmail);
			
			
			rset=pstmt.executeQuery();
			
			list = new ArrayList<QNA>();
			
			System.out.println("rset : "+ rset);
			System.out.println("rset.next : "+ rset.next());
			
			while(rset.next()) {
				
				QNA a = new QNA();
				
				System.out.println("while");	
				
				a.setQno(rset.getInt("qno"));
				a.setQtitle(rset.getString("qtitle"));
				a.setQcontent(rset.getString("qcontent"));
				a.setQemail(rset.getString("qemail"));
				a.setNdate(rset.getDate("qdate"));
				
				list.add(a);
				
			}//while
			
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		
		
		
		System.out.println("DAO return list"+ list);
		return list;
	}
	
	*/
	
	
	public ArrayList<QNA> QNAuserList(Connection con, String userEmail) {
	      
	      ArrayList<QNA> list = null;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset= null;
	      
	      String sql = prop.getProperty("QNAuserList");
	      System.out.println("DAO QNAuserList SQL : "+sql);
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setString(1, userEmail);
	     
	         System.out.println(userEmail);
	         
	         rset = pstmt.executeQuery();
	         
	         list = new ArrayList<QNA>();
	         
	         
	         while(rset.next()) {
	        
	        	 System.out.println("while");
	        	 
	            QNA q = new QNA();
	            
	            q.setQno(rset.getInt("QNO"));
	            q.setQtitle(rset.getString("QTITLE"));
	            q.setQcontent(rset.getString("QCONTENT"));
	            q.setQemail(rset.getString("QEMAIL"));
	            q.setNdate(rset.getDate("QDATE"));
	            
	            list.add(q);
	            
	            
	         }
	      
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return list;
	   }
	
	
	
	
	
	
	
	
	

}
	
	
	


