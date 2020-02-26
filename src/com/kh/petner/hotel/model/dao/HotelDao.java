package com.kh.petner.hotel.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;


import com.kh.petner.hotel.model.vo.Hotel;

import com.kh.petner.market.model.vo.Market;

import static com.kh.petner.common.JDBCTemplate.*;
public class HotelDao {
	
	private Properties prop;
	
	public HotelDao() {
		prop = new Properties();
		
		String filePath = Hotel.class.getResource("/config/hotel-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getListCount(Connection con, String Market) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		System.out.println("1Market : " + Market);
		try {
			
			pstmt = con.prepareStatement(sql);
			
			
			System.out.println("2Market : " + Market);
			pstmt.setString(1, Market);
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
	
	public ArrayList<Market> selectList(Connection con, int currentPage, int limit, String Market, String temp) {
		ArrayList<Market> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		if(temp != null) {
			if(temp.equals("temp2")) {
				sql = prop.getProperty("selectList_temp2");
			}else if(temp.equals("temp3")) {
				sql = prop.getProperty("selectList_temp3");
			}else {
				sql = prop.getProperty("selectList_temp1");
			}
		}else {
			sql = prop.getProperty("selectList_temp1");
		}
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit + 1; // 1, 11 
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, Market);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			System.out.println("Hotel Dao selectList(전체 보기) Market : " + Market);
			System.out.println("Hotel Dao selectList(전체 보기) endRow : " + endRow);
			System.out.println("Hotel Dao selectList(전체 보기) startRow : " + startRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Market>();
			
			while(rset.next()) {
				Market h = new Market();
				
				h.setMarketId(rset.getInt("MARKET_ID"));
				h.setMarketName(rset.getString("MARKET_NAME"));
//				h.setMarketPwd(rset.getString("MARKET_PASSWORD"));
//				h.setMarketEmail(rset.getString("MARKET_EMAIL"));
//				h.setMarketType(rset.getString("MARKET_TYPE"));
//				h.setMarketTel(rset.getString("MARKET_TEL"));
//				h.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
//				h.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				h.setMarketPlace(rset.getString("MARKET_PLACE"));
				h.setMarketMainPhoto(rset.getString("MARKET_MAINPHOTO"));
				h.setMarketStar(rset.getInt("A_RSTAR"));
				h.setReviewCount(rset.getInt("REVIEWCOUNT"));
				System.out.println("%%%%%%% :" + rset.getInt("REVIEWCOUNT"));
				list.add(h);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("sikim HotelDao selectList(전체 불러오기) : " + list);
		return list;
	}
	
	public ArrayList<Market> searchHotelLocation(Connection con, String[] locationArr, String Market) {
		ArrayList<Market> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		sql = prop.getProperty("searchLocationGroupFirst");
		
		try {
			pstmt = con.prepareStatement(sql);
			list = new ArrayList<Market>();
			for(int i=0; i<locationArr.length; i++) {
				
				pstmt.setString(1, Market);
				pstmt.setString(2, locationArr[i]);
				pstmt.setString(3, locationArr[i]);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Market h = new Market();
					
//					h.setMarketId(rset.getInt("MARKET_ID"));
					h.setMarketName(rset.getString("MARKET_NAME"));
//					h.setMarketPwd(rset.getString("MARKET_PASSWORD"));
//					h.setMarketEmail(rset.getString("MARKET_EMAIL"));
//					h.setMarketType(rset.getString("MARKET_TYPE"));
//					h.setMarketTel(rset.getString("MARKET_TEL"));
//					h.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
//					h.setMarketAddress(rset.getString("MARKET_ADDRESS"));
					h.setMarketPlace(rset.getString("MARKET_PLACE"));
					h.setMarketMainPhoto(rset.getString("MARKET_MAINPHOTO"));
					h.setMarketStar(rset.getInt("A_RSTAR"));
					h.setReviewCount(rset.getInt("REVIEWCOUNT"));
					
					list.add(h);
				}
			}	
			

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("sikim Hotel Dao searchHotelLocation list : " + list.size());
		return list;
	}
	
	public int getListCountHotelName(Connection con, String name, String Market) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCountHotelName");
		
		try {
			System.out.println("sikim getListCountHotelName try 들어옴 ");
			pstmt = con.prepareStatement(sql);
			
			if(name.equals("null")) name = "";
			
			pstmt.setString(1, Market);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			pstmt.setString(4, name);
			System.out.println("sikim getListCountHotelName name : " + name);
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
	
	public ArrayList<Market> searchHotelName(Connection con, String name,int currentPage, int limit, String Market) {
		ArrayList<Market> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		sql = prop.getProperty("searchHotelName");
		System.out.println("sikim HotelDao searchHotelName sql : " + sql);
		try {
			System.out.println("sikim HotelDao searchHotelName try문 들어옴 ");
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit + 1; // 1, 11 
			int endRow = startRow + limit -1;
			System.out.println("sikim HotelDao searchHotelName startRow : " + startRow);
			System.out.println("sikim HotelDao searchHotelName endRow : " + endRow);
			System.out.println("sikim HotelDao searchHotelName name : " + name);
			System.out.println("sikim HotelDao searchHotelName Market : " + Market);
			pstmt.setString(1, Market);
			pstmt.setString(2, name);
			pstmt.setString(3, name);
			pstmt.setString(4, name);
			pstmt.setInt(5, endRow);
			pstmt.setInt(6, startRow);
			
			rset = pstmt.executeQuery();
			System.out.println("sikim HotelDao searchHotelName rset : " + rset);
			list = new ArrayList<Market>();
			while(rset.next()) {
				System.out.println("sikim HotelDao searchHotelName rset.next() while문 들어옴 ");
				Market h = new Market();
								
				h.setMarketId(rset.getInt("MARKET_ID"));
				h.setMarketName(rset.getString("MARKET_NAME"));
//				h.setMarketPwd(rset.getString("MARKET_PASSWORD"));
//				h.setMarketEmail(rset.getString("MARKET_EMAIL"));
//				h.setMarketType(rset.getString("MARKET_TYPE"));
//				h.setMarketTel(rset.getString("MARKET_TEL"));
//				h.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
//				h.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				h.setMarketPlace(rset.getString("MARKET_PLACE"));
				h.setMarketMainPhoto(rset.getString("MARKET_MAINPHOTO"));
				h.setMarketStar(rset.getInt("A_RSTAR"));
				h.setReviewCount(rset.getInt("REVIEWCOUNT"));
				
				list.add(h);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("Hotel Dao searchHotelName list : " +list);
		return list;
	}


	public double getstar(Connection con) {
		double result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getstar");
		
		try {
			pstmt = con.prepareStatement(sql);
			
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

































