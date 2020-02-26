package com.kh.petner.member.pet.model.dao;

import static com.kh.petner.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.petner.member.pet.model.vo.Pet;

public class PetDao {

	Properties prop;
	
	public PetDao() {
		
		prop=new Properties();
		
		String filePath=PetDao.class.getResource("/config/pet-query.properties").getPath();		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertPet(Connection con, Pet p) {
		int result = 0;
		String sql = prop.getProperty("insertPet");
		PreparedStatement pstmt = null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p.getUserEmail());
			pstmt.setString(2, p.getPetName());
			pstmt.setString(3, p.getPetType());
			pstmt.setDate(4, p.getPetBirth());
			pstmt.setString(5, p.getPetProfile());
			pstmt.setInt(6, p.getPetWeight());
			pstmt.setString(7, p.getPetPic());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Pet selectOne(Connection con, String petName) {
		Pet p=null;
		PreparedStatement pstmt =null;
		ResultSet rset=null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, petName);
			
			System.out.println("DAO - SQL문 실행");
			rset=pstmt.executeQuery();
		
			if(rset.next()) {
				p=new Pet(petName
						, rset.getString("PET_NAME")
						, rset.getString("PET_TYPE")
						, rset.getDate("PET_BIRTH")
						, rset.getString("PET_PROFILE")
						, rset.getInt("PET_WEIGHT")
						, rset.getString("PET_PIC")
						, rset.getString("PET_TOP")
						);
				System.out.println("펫 불러오기 완료 : "+p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return p;
	}

	public ArrayList<Pet> ListPet(Connection con, String userEmail) {
		ArrayList<Pet> plist = new ArrayList<Pet>();
		String sql = prop.getProperty("listPet");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println("pDao 찾아오기 성공 while");
				Pet p=new Pet(userEmail
						, rset.getString("PET_NAME")
						, rset.getString("PET_TYPE")
						, rset.getDate("PET_BIRTH")
						, rset.getString("PET_PROFILE")
						, rset.getInt("PET_WEIGHT")
						, rset.getString("PET_PIC")
						, rset.getString("PET_TOP")
						, rset.getInt("PET_ID")
						);
				
				plist.add(p);
			}//while
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset); close(pstmt);
		}
		
		
		return plist;
	}

	public int updatePet(Connection con, Pet p) {
		int result=0;
		String sql = prop.getProperty("updatePet");
		PreparedStatement pstmt = null;
		
		//picPIc이 null이면 Pic은 변경해주지 않는다. 
		if(p.getPetPic() == null) {
			sql = prop.getProperty("updatePetPic");
		}
		
		try {
			pstmt=con.prepareStatement(sql);
			
			if(p.getPetPic() == null) {
				pstmt.setString(1, p.getPetType());
				pstmt.setDate(2, p.getPetBirth());
				pstmt.setString(3, p.getPetProfile());
				pstmt.setInt(4, p.getPetWeight());
				pstmt.setString(5, p.getPetName());
			}else {
				pstmt.setString(1, p.getPetType());
				pstmt.setDate(2, p.getPetBirth());
				pstmt.setString(3, p.getPetProfile());
				pstmt.setInt(4, p.getPetWeight());
				pstmt.setString(5, p.getPetPic());
				pstmt.setString(6, p.getPetName());
			}
			result=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		
		return result;
	}

	public int deletePet(Connection con, String petName) {
		int result=0;
		String sql = prop.getProperty("deletePet");
		PreparedStatement pstmt = null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, petName);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int countPet(Connection con, String userEmail) {
		int result=0;
		
		String sql = prop.getProperty("countPet");
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			
			System.out.println("DAO countPet before execute");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("DAO countPet in if문");
				result = rset.getInt("1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result값 : "+result);
		return result;
	}

}
