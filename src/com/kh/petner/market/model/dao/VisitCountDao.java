package com.kh.petner.market.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.kh.petner.market.model.vo.VisitCount;

import java.sql.Connection;
import static com.kh.petner.common.JDBCTemplate.*;

public class VisitCountDao {
	private static VisitCountDao instance;

	// 싱글톤 패턴
	private VisitCountDao() {
	}

	public static VisitCountDao getInstance() {
		if (instance == null)
			instance = new VisitCountDao();
		return instance;
	}

	/**
	 * 총방문자수를 증가시킨다.
	 */
	public void setTotalCount() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// 쿼리생성
			// 총 방문자수를 증가시키기 위해 테이블에 현재 날짜 값을 추가시킨다.
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO VISIT (V_DATE) VALUES (sysdate)");

			// 커넥션을 가져온다.
			conn = getConnection();

			// 자동 커밋을 false로 한다.
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql.toString());
			// 쿼리 실행
			pstmt.executeUpdate();
			// 완료시 커밋
			conn.commit();

//		} catch (ClassNotFoundException | NamingException | SQLException sqle) {
		} catch (Exception sqle) {
			// 오류시 롤백
			conn.rollback();
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				if (pstmt != null) {
					close(pstmt);
					pstmt = null;
				}
				if (conn != null) {
					close(conn);
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end setTotalCount()

	/**
	 * 총 방문자수를 가져온다.
	 * 
	 * @return totalCount : 총 방문자 수
	 */
	public int getTotalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;

		try {

			// 테이블의 테이터 수를 가져온다.
			// 데이터 수 = 총 방문자 수
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(*) AS TotalCnt FROM VISIT");

			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();

			// 방문자 수를 변수에 담는다.
			if (rset.next())
				totalCount = rset.getInt("TotalCnt");

			return totalCount;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end getTotalCount()

	/**
	 * 오늘 방문자 수를 가져온다.
	 * 
	 * @return todayCount : 오늘 방문자
	 */
	public int getTodayCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int todayCount = 0;

		try {

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(*) AS TodayCnt FROM VISIT");
			sql.append(" WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate, 'YYYY-MM-DD')");

			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();

			// 방문자 수를 변수에 담는다.
			if (rset.next())
				todayCount = rset.getInt("TodayCnt");

			return todayCount;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}// end getTodayCount()

	public VisitCount getAllcount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int todayCount = 0;
		VisitCount vCount = null;

		try {

			StringBuffer sql = new StringBuffer();
//			sql.append("SELECT COUNT(*) AS TodayCnt FROM VISIT");
//			sql.append(" WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate, 'YYYY-MM-DD')");
			
			sql.append("SELECT (SELECT COUNT(*) FROM VISIT), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate,'YYYY-MM-DD')), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-1 ,'YYYY-MM-DD'), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-2 ,'YYYY-MM-DD')), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-3 ,'YYYY-MM-DD')), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-4 ,'YYYY-MM-DD')), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-5 ,'YYYY-MM-DD')), ");
	        sql.append("(SELECT COUNT(*) FROM VISIT  WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate-6 ,'YYYY-MM-DD')) ");
        	sql.append(" FROM dual");

			
			

			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();

			// 방문자 수를 변수에 담는다.
			if (rset.next())
				vCount = new VisitCount();
				vCount.setTotalCnt(rset.getInt(1));
				vCount.setTodayCnt(rset.getInt(2));
				vCount.setOneAgo(rset.getInt(3));
				vCount.setTwoAgo(rset.getInt(4));
				vCount.setThreeAgo(rset.getInt(5));
				vCount.setFourAgo(rset.getInt(6));
				vCount.setFiveAgo(rset.getInt(7));
				vCount.setSixAgo(rset.getInt(8));

			return vCount;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			// Connection, PreparedStatement를 닫는다.
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
