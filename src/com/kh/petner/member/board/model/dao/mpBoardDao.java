package com.kh.petner.member.board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.petner.member.board.model.vo.mpBoard;

import static com.kh.petner.common.JDBCTemplate.close;

public class mpBoardDao {
	
	Properties prop;
	
	public mpBoardDao() {
		prop=new Properties();
		String filePath = mpBoardDao.class.getResource("/config/mpBoard-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getListCount(Connection con) {
		int listCount=0;
		Statement stmt =null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");
		
		try {
			stmt=con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset); close(stmt);
		}
		
		
		return listCount;
	}

	public ArrayList<mpBoard> selectList(int currentPage, int limit, Connection con, String type) {
		ArrayList<mpBoard> blist =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		//string으로 받아온 값을 int로 변경
		int type_ = Integer.parseInt(type);
		
		try {
			System.out.println("DAO 시작 ");
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage-1)*limit+1;
			int endRow=startRow+limit-1;
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, type_);
			
			
			System.out.println("DAO pstmt.set완료 : "+sql);
			rset=pstmt.executeQuery();
			System.out.println("DAO selectList executeQuery : "+ sql);
			blist=new ArrayList<mpBoard>();
			
			while(rset.next()) {
				System.out.println("DAO selectList while문 반복");
				mpBoard b = 
						new mpBoard(rset.getInt("B_NO")
												, rset.getInt("B_TYPE") 
												, rset.getString("B_TITLE")
												, rset.getString("B_CONTENT")
												, rset.getString("USER_EMAIL")
												, rset.getInt("B_COUNT")
												, rset.getString("B_FILE")
												, rset.getDate("B_DATE")
												, rset.getString("B_STATUS")
												, rset.getInt("B_STARCOUNT")
											);
				
				blist.add(b);
			}//while
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset); close(pstmt);
		}
		
		
		System.out.println("DAO selectList return : "+ blist);
		return blist;
	}

	public int insertmpBoard(Connection con, mpBoard b) {
		int result=0;
		String sql = prop.getProperty("insertmpBoard");
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("bDAO try");
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, b.getBtype());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getBcontent());
			pstmt.setString(4, b.getBwriter());
			pstmt.setString(5, b.getBoardfile());
			
			System.out.println("bDAO try before execute");
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("bDAO return : "+result);
		return result;
	}

	public mpBoard selectBoard(Connection con, int bno) {
		mpBoard b=null;
		
		String sql = prop.getProperty("selectOne");
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		
		try {
			System.out.println("mpBoard DAO try bno :"+bno);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("DAO if문 시작 mpBoard 생성");
				b=new mpBoard(
								bno
								, rset.getInt("B_TYPE")
								, rset.getString("B_title")
								, rset.getString("B_CONTENT")
								, rset.getString("USER_EMAIL")
								, rset.getInt("B_COUNT")
								, rset.getString("B_FILE")
								, rset.getDate("B_DATE")
								, rset.getString("B_STATUS")
								, rset.getInt("B_STARCOUNT")
						);
				
			}//if
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset); close(pstmt);
		}
		
		System.out.println("DAO END return b : "+ b);
		
		return b;
	}

	public int updatempBoard(Connection con, mpBoard b) {
		int result=0;
		String sql=prop.getProperty("updatempBoard");
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, b.getBtype());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getBcontent());
			pstmt.setString(4, b.getBwriter());
			
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); 
		}
		
		
		System.out.println("mpDao return result : "+result);
		return result;
	}

}
