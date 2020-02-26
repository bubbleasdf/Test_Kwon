package com.kh.petner.QNAComment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.petner.common.JDBCTemplate.*;

import com.kh.petner.QNAComment.model.vo.QNAComment;

public class QNACommentDao {
	private Properties prop;
	

	public QNACommentDao() {
		prop = new Properties();
		String filePath = QNACommentDao.class.getResource("/config/QNAcomment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public int QNAinsertComment(Connection con, QNAComment qc) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qc.getQno());
			pstmt.setString(2, qc.getCemail());
			pstmt.setString(3, qc.getCcontent());
			
			
			if(qc.getRefcno() > 0) {
	            pstmt.setInt(4, qc.getRefcno());
	         } else { // 값이 있으면 넣어주고 없으면 NULL을 넣어주겠다.
	            pstmt.setNull(4, java.sql.Types.NULL);
	         }
	         
	         pstmt.setInt(5, qc.getClevel());
	         
	         result = pstmt.executeUpdate();
	         
	      } catch(SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      
	      return result;
	   }

	public ArrayList<QNAComment> selectList(Connection con, int qno) {
		
		ArrayList<QNAComment> clist = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rset=pstmt.executeQuery();
			clist = new ArrayList<QNAComment>();
			   
			   while(rset.next()) {
				   
				   QNAComment qc = new QNAComment();
				   
				   qc.setCno(rset.getInt("cno"));
				   qc.setQno(qno);
				   qc.setCemail(rset.getString("cemail"));
				   qc.setCcontent(rset.getString("CCONTENT"));
				   qc.setCdate(rset.getDate("cdate"));
				   qc.setRefcno(rset.getInt("ref_cno"));
				   qc.setClevel(rset.getInt("clevel"));
				   
				   clist.add(qc);
				
			   }
			   
			   }catch(SQLException e) {
				   e.printStackTrace();
			   }finally {
				   close(rset);
				   close(pstmt);
			   }
		
		
		return clist;
	}

	public int QNAUpdateComment(Connection con, QNAComment qc) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("UpdateComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, qc.getCcontent());
			pstmt.setInt(2, qc.getCno());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int QNADeleteComment(Connection con, int cno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("DeleteComment");
		
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
