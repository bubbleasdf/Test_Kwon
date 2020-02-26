package com.kh.petner.member.pet.model.service;

import static com.kh.petner.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.member.pet.model.dao.PetDao;
import com.kh.petner.member.pet.model.vo.Pet;

public class PetService {
	private PetDao pDao = new PetDao();
	
	
	public int insertPet(Pet p) {
		int result =0;
		Connection con = getConnection();
		
		result = pDao.insertPet(con,p);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	public Pet selectOne(String petName) {
		Pet p=null;
		Connection con = getConnection();
		
		p=pDao.selectOne(con, petName);
		
		if(p!=null) {
			System.out.println("SERVICE COMMIT");
			commit(con);
		}else {
			System.out.println("SERVICE ROLLBACK");
			rollback(con);
		}
		
		close(con);
		return p;
	}
	
	public ArrayList<Pet> ListPet(String userEmail) {
		Connection con = getConnection();
		ArrayList<Pet> plist = null;
		
		plist=pDao.ListPet(con, userEmail);
		
		close(con);
		return plist;
	}
	
	public int updatePet(Pet p) {
		int result=0;
		Connection con = getConnection();
		
		result = pDao.updatePet(con, p);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	public int deletePet(String petName) {
		int result=0;
		
		Connection con = getConnection();
		
		result = pDao.deletePet(con, petName);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
	public int countPet(String userEmail) {
		int result=0;
		Connection con =getConnection();
		
		result = pDao.countPet(con, userEmail);
		
		close(con);
		
		return result;
	}

}
