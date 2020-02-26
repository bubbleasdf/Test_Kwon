package com.kh.petner.hotel.reserve.model.dao;

import static com.kh.petner.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.petner.hotel.reserve.model.vo.HotelReserve;
import com.kh.petner.market.model.vo.MarketDetail;
import com.kh.petner.member.pet.model.vo.Pet;

public class HotelReserveDao {
	
	private Properties prop; 
	
	public HotelReserveDao() {
		prop = new Properties();
		
		String filePath = HotelReserveDao.class.getResource("/config/hotelreserve-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 송현아_호텔 예약 인서트 
	 * @param con
	 * @param hr
	 * @return
	 */
	public int insertHotelReserve(Connection con, HotelReserve hr) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("hotelInsertreserve"); 
		
		try {
			pstmt = con.prepareStatement(sql); 
			
			pstmt.setInt(1, hr.getMarketId());
			pstmt.setString(2, hr.getUser_Email());
			pstmt.setString(3, hr.getUser_Name());
			pstmt.setString(4, hr.getUser_Phone());
			pstmt.setDate(5, hr.getS_date());
			pstmt.setDate(6, hr.getE_date());
			pstmt.setInt(7, hr.getMarketPrice());
			pstmt.setInt(8, hr.getPet_Id());
			pstmt.setString(9, hr.getPet_Name());
			pstmt.setString(10, hr.getPet_Type());
			pstmt.setString(11, hr.getStatus());
			pstmt.setInt(12, hr.getSum_price());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public MarketDetail selectMarket(Connection con, int marketId) {
		MarketDetail marD = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("selectMarket"); 
		
		try {
			pstmt = con.prepareStatement(sql); 
			
			pstmt.setInt(1, marketId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				marD = new MarketDetail(); 
				marD.setMarketId(marketId);
				marD.setMarketName(rset.getString("MARKET_NAME"));
				marD.setMarketPrice(rset.getInt("MARKET_PRICE"));
				
				System.out.println("marD Dao:" + marD);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt); 
			}
		return marD;
	}

	/**
	 *  펫 정보 불러오기
	 * @param con
	 * @param userEmail
	 * @return
	 */
	public Pet selectPet(Connection con, String userEmail) {
		Pet pet = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPet");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userEmail);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pet = new Pet();
				pet.setPetId(rset.getInt("PET_ID"));
				pet.setPetName(rset.getString("PET_NAME"));
				pet.setPetType(rset.getString("PET_TYPE"));
				pet.setUserEmail(rset.getString("USER_EMAIL"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		

		return pet;
	}

	
	
/*	public Pet selectPet(Connection con, String userEmail) {
		Pet p = null; 
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		
		String sql = prop.getProperty("selectPet"); 
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userEmail);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Pet(); 
				p.setUserEmail(rset.getString("USER_EMAIL"));
				p.setPetName(rset.getString("PET_NAME"));
				p.setPetType(rset.getString("PET_TYPE"));
				p.setPetId(rset.getInt("PET_ID"));
				
				System.out.println("[Dao]pet:" + p);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt); 
		}
		return p;
	}*/
}
