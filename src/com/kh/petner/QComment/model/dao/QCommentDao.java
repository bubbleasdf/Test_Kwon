package com.kh.petner.QComment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.petner.QComment.model.vo.QComment;

import static com.kh.petner.common.JDBCTemplate.*;

public class QCommentDao {
	
	private Properties prop;
	
	public QCommentDao() {
		prop = new Properties();
		
		String filePath = QCommentDao.class.getResource("/config/comment-query.properties").getPath();
		
		try{
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 댓글 추가
	 * @param con
	 * @param qco
	 * @return
	 */
	public int insertComment(Connection con, QComment qco) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertcomment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qco.getMno());
			pstmt.setString(2, qco.getCcontent());
			pstmt.setString(3, qco.getCname());
			pstmt.setString(4, qco.getCemail());
			if(qco.getRefcno() > 0) {
				pstmt.setInt(5, qco.getRefcno());				
			}else {
				pstmt.setNull(5, java.sql.Types.NULL);
			}
			pstmt.setInt(6, qco.getClevel());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 댓글 리스트
	 * @param con
	 * @param mid
	 * @return
	 */
	public ArrayList<QComment> selectList(Connection con, int mid) {
		ArrayList<QComment> qlist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mid);
			
			rset = pstmt.executeQuery();
			
			qlist = new ArrayList<QComment>();
			
			while(rset.next()) {
				QComment qco = new QComment();
				
				qco.setCno(rset.getInt("CNO"));
				qco.setMno(mid);
				qco.setCcontent(rset.getString("CCONTENT"));
				qco.setCname(rset.getString("CNAME"));
				qco.setCemail(rset.getString("CEMAIL"));
				qco.setCdate(rset.getDate("CDATE"));
				qco.setRefcno(rset.getInt("REF_CNO"));
				qco.setClevel(rset.getInt("CLEVEL"));
				
				qlist.add(qco);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return qlist;
	}

	public int UpdateComment(Connection con, QComment qco) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatecomment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, qco.getCcontent());
			pstmt.setInt(2, qco.getCno());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteComment(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt = con.prepareStatement(sql);
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
