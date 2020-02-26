package com.kh.petner.Review.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.petner.Review.model.vo.Review;
import static com.kh.petner.common.JDBCTemplate.*;

public class ReviewDao {
	
	private Properties prop;
	
	public ReviewDao() {
		prop = new Properties();
		
		String filePath = ReviewDao.class.getResource("/config/comment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 리뷰 추가
	 * @param con
	 * @param rv
	 * @return
	 */
	public int insertReview(Connection con, Review rv) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertreview");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rv.getRmno());
			pstmt.setString(2, rv.getRcontent());
			pstmt.setString(3, rv.getRname());
			pstmt.setString(4, rv.getRemail());
			pstmt.setInt(5, rv.getRstar());
			if(rv.getRefrno() > 0) {
				pstmt.setInt(6, rv.getRefrno());
			}else {
				pstmt.setNull(6, java.sql.Types.NULL);
			}
			pstmt.setInt(7, rv.getRlevel());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 리뷰 리스트
	 * @param con
	 * @param mid
	 * @return
	 */
	public ArrayList<Review> selectList(Connection con, int mid) {
		ArrayList<Review> rlist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectlist");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rset = pstmt.executeQuery();
			
			rlist = new ArrayList<Review>();
			
			while(rset.next()) {
				Review rv = new Review();
				
				rv.setRno(rset.getInt("RNO"));
				rv.setRmno(rset.getInt("RMNO"));
				rv.setRcontent(rset.getString("RCONTENT"));
				rv.setRname(rset.getString("RNAME"));
				rv.setRemail(rset.getString("REMAIL"));
				rv.setRstar(rset.getInt("RSTAR"));
				rv.setRdate(rset.getDate("RDATE"));
				rv.setRefrno(rset.getInt("REF_RNO"));
				rv.setRlevel(rset.getInt("RLEVEL"));
				
				rlist.add(rv);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}
	/**
	 * 리뷰 삭제
	 * @param con
	 * @param rno
	 * @return
	 */
	public int deleteReview(Connection con, int rno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletereview");
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 리뷰 수정
	 * @param con
	 * @param rv
	 * @return
	 */
	public int updateReview(Connection con, Review rv) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatereview");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, rv.getRcontent());
			pstmt.setInt(2, rv.getRno());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 별점 평균
	 * @param con
	 * @param mid
	 * @return
	 */
	public double getstar(Connection con, int mid) {
		double result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getstar");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getDouble(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

}
