package com.kh.petner.notice.model.dao;

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

import com.kh.petner.notice.model.vo.Notice;
import com.kh.petner.notice.model.vo.NoticePageInfo;
import com.sun.xml.internal.ws.resources.ProviderApiMessages;

public class NoticeDao {
	private Properties prop;

	public NoticeDao() {

		prop = new Properties();

		String filePath = Notice.class.getResource("/config/notice-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public ArrayList<Notice> selectList(Connection con) {

		ArrayList<Notice> list = null; // 전달할 객체 선언
		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			list = new ArrayList<Notice>();

			while (rset.next()) {
				Notice n = new Notice();
				n.setNno(rset.getInt("nno"));
				n.setNemail(rset.getString("nemail"));
				n.setNtitle(rset.getString("ntitle"));
				n.setnContent(rset.getString("ncontent"));
				n.setnCount(rset.getInt("ncount"));
				n.setNdate(rset.getDate("ndate"));

				list.add(n);

			}
			System.out.println(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	

	public int InsertNotice(Connection con, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("InsertNotice");
		
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, n.getNemail());
			pstmt.setString(2, n.getNtitle());
			pstmt.setString(3, n.getnContent());
			pstmt.setDate(4, n.getNdate());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
}

	

	public Notice noticeDetail(Connection con, int nno) {
		Notice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeDetail");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				n.setNno(rset.getInt("NNO"));
				n.setNemail(rset.getString("NEMAIL"));
				n.setNtitle(rset.getString("NTITLE"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnCount(rset.getInt("NCOUNT"));
				n.setNdate(rset.getDate("NDATE"));
				
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public int Nupdate(Connection con, Notice n) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("Nupdate");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getnContent());
			pstmt.setInt(3, n.getNno());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int Ndelete(Connection con, int nno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("Ndelete");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getlistCount(Connection con) {
		int PageCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				PageCount = rset.getInt(1);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				close(rset);
				close(stmt);
				
			}
		return PageCount;
	}

	public ArrayList<Notice> noticePage(Connection con, int currentPage, int limit) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticePage");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit + 1;
			int endRow = startRow +limit -1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setNno(rset.getInt("nno"));
				n.setPno(rset.getInt("rnum"));
				n.setNtitle(rset.getString("ntitle"));
				n.setNemail(rset.getString("nemail"));
				n.setnContent(rset.getString("ncontent"));
				n.setNdate(rset.getDate("ndate"));				
				
				list.add(n);
				
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
