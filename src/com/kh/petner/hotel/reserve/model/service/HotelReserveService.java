package com.kh.petner.hotel.reserve.model.service;

import static com.kh.petner.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.petner.hotel.reserve.model.dao.HotelReserveDao;
import com.kh.petner.hotel.reserve.model.vo.HotelReserve;
import com.kh.petner.market.model.vo.MarketDetail;
import com.kh.petner.member.pet.model.vo.Pet;

public class HotelReserveService {
	
	private HotelReserveDao hrDao = new HotelReserveDao(); 

	/**
	 * 송현아_호텔 예약 정보 인서트 
	 * @param hr
	 * @return
	 */
	public int insertHotelReserve(HotelReserve hr) {
		
		Connection con = getConnection(); 
		
		int result = hrDao.insertHotelReserve(con,hr);
		
		if(result > 0) commit(con);
		else rollback(con); 
		
		close(con);
		
		return result;
	}

	public MarketDetail selectMarket(int marketId) {
		
		Connection con = getConnection(); 
		
		MarketDetail marD = hrDao.selectMarket(con,marketId); 
		
		close(con); 
		
		return marD;
	}

	public Pet selectPet(String userEmail) {
		
		Connection con = getConnection(); 
		
		Pet p = hrDao.selectPet(con,userEmail); 
		
		close(con);
		
		return p;
	}


}
