package com.kh.petner.hotel.model.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.kh.petner.hotel.model.dao.HotelDao;
import com.kh.petner.hotel.model.vo.Hotel;

import com.kh.petner.market.model.vo.Market;

import static com.kh.petner.common.JDBCTemplate.*;

public class HotelService {

	private HotelDao hDao = new HotelDao();
	
	public int getListCount(String Market) {
		
		Connection con = getConnection();
		
		int listCount = hDao.getListCount(con,Market);
	
		close(con);
		
		return listCount;
	}
	
	public ArrayList<Market> selectList(int currentPage, int limit, String Market, String temp) {
		Connection con = getConnection();
		ArrayList<Market> list = hDao.selectList(con,currentPage,limit, Market, temp);
		
		close(con);
		
		return list;
		
	}
	
	public ArrayList<Market> searchHotelLocation(String[] locationArr, String Market) {
		Connection con = getConnection();
		ArrayList<Market> list = null;
		
		if(!(locationArr[0].equals("undefined"))) {
			System.out.println("locationArr.length : " +locationArr.length);
			System.out.println("#####################3333");
			list = hDao.searchHotelLocation(con,locationArr, Market);
		}else  {
			System.out.println("#####################");
			String temp = null;
			int currentPage = 1;
			int limit = 100;
			list = hDao.selectList(con,currentPage,limit, Market, temp);
		}
		close(con);
		
		return list;
	}
	
	public int getListCountHotelName(String name, String Market) {
	
		Connection con = getConnection();
		
		int listCount = hDao.getListCountHotelName(con,name, Market);
	
		close(con);
		
		return listCount;
	}
	
	public ArrayList<Market> searchHotelName(String name,int currentPage, int limit, String Market) {
		Connection con = getConnection();
		ArrayList<Market> list = null;
		System.out.println("name.length(): " + name.length());
		System.out.println("name : " + name);
		if(name.length() > 0 && !(name.equals("null"))) {
			System.out.println("@@@@@@@@@@@@@@@@@@@");
			list = hDao.searchHotelName(con,name,currentPage,limit, Market);
			
		}else  {
			System.out.println("#####################");
			String temp = null;
			list = hDao.selectList(con,currentPage,limit, Market, temp);
			
		}
		
		close(con);
		
		return list;
	}

	public int getstar() {
		Connection con = getConnection();
		// double 값을 반올림해서 int로 변환
		double result = hDao.getstar(con);
		int star = (int)(Math.round(result));
		
		close(con);
		return star;
	}

	
}
