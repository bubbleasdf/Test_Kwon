package com.kh.petner.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.vo.Member;

import static com.kh.petner.common.JDBCTemplate.close;

public class MemberDao {

	private Properties prop;
	
	public MemberDao() {
		prop=new Properties();
		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	} //기본 생성자
	
	public Member selectMember(Connection con, Member m) throws MemberException {
		System.out.println("MemberDao selectMember");
		
		Member result = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		
		try {
			System.out.println("MemberDao selectMember try : "+m.getUserEmail()+" - "+m.getUserPwd());
			
			pstmt=con.prepareStatement(prop.getProperty("selectMember"));
			pstmt.setString(1, m.getUserEmail());
			pstmt.setString(2, m.getUserPwd());
			
			
			rset = pstmt.executeQuery();
			System.out.println("MemberDao selectMember executeQuery ");
			
			
			if(rset.next()) {
				System.out.println("MemberDao selectMember if");
				
				result = new Member(rset.getString("USER_EMAIL")
												, rset.getString("USER_PASSWORD")
												, rset.getString("USER_NAME")
												, rset.getString("USER_PHONE")
												, rset.getInt("USER_ROLES")
												, rset.getDate("USER_ENDATE")
													);
			}//if
			
			
		} catch (Exception e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("DAO return RESULT : "+result);
		
		return result;
	}

	public int insertMember(Connection con, Member m) throws MemberException {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			
			System.out.println("mDao - insertMember : " + m);
			
			pstmt = con.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getUserEmail());
			pstmt.setString(3, m.getUserPwd());
			pstmt.setString(4, m.getUserPhone());
			pstmt.setString(5, m.getUserPwdHintSelect());
			pstmt.setString(6, m.getUserPwdHint());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateMember(Connection con, Member m) throws MemberException {
		int result =0;
		
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getUserName());
			pstmt.setString(3, m.getUserPhone());
			pstmt.setString(4, m.getUserEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
				
				
		return result;
	}

	public int deleteMember(Connection con, String userEmail) throws MemberException {
		int result=0;
		String sql = prop.getProperty("deleteMember");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new MemberException(e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 유저 권한 변경 DAO 
	 * 
	 * 이 부분은 서블릿은 없고 서비스에만 존재하기 때문에
	 * 유저는 접근할 수 없고 
	 * 
	 * 권한변경이 필요한 관리자나 
	 * 펫등록이 되었을 경우 등록된 펫에 대한 권한을 얻기 위해서만 사용한다.
	 * 
	 *  0 디폴트 기본적인 유저의 권한
	 *  1의 자리는 유저의 권한
	 *  10의 자리는 펫의 대한 권한
	 *  100의 자리는 관리자 권한을 나타낸다.
	 *  
	 *  ex)
	 *  70인경우 = 070 -> 관리자 권한은 없고(0), 펫에 대한 모든 권한이 있으며(7), 기본적인 유저의 권한(0)을 가지고 있다. 
	 *  
	 *  777은 최고 관리자 권한
	 *  
	 * @param con
	 * @param userRoles
	 * @return
	 */
	public int chMemberRoles(Connection con, String userEmail, int userRoles) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql = prop.getProperty("chMemberRoles");
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, userRoles);
			pstmt.setString(2, userEmail);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	public Member searchPwd(Connection con, Member m) throws MemberException {
		
		System.out.println("sikim MemberDao selectMember");
		
		Member result = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		try {
			System.out.println("sikim MemberDao selectMember try ");
			
			pstmt=con.prepareStatement(prop.getProperty("SearchEmail"));
			pstmt.setString(1, m.getUserEmail());
					
			rset = pstmt.executeQuery();
			System.out.println("sikim MemberDao selectMember executeQuery ");
					
			if(rset.next()) {
				System.out.println("sikim MemberDao selectMember if");
				
				result = new Member();/*(rset.getString("USER_EMAIL")
												, rset.getString("USER_PASSWORD")
												, rset.getString("userPwdHint")
													);*/
				result.setUserEmail(rset.getString("USER_EMAIL"));
				result.setUserPwdHintSelect(rset.getString("USER_PWD_HINT"));
				result.setUserPwdHint(rset.getString("USER_PWD_HINT2"));
				
			}//if
					
		} catch (Exception e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("sikim MemberDao RESULT : "+result);
		
		return result;
	}

	public int passwordchange(Connection con, Member m_Npwd) throws MemberException {
		
		int result = 0;
		
		PreparedStatement pstmt =null;
		System.out.println("sikim MemberDao passwordchange");
		try {	
			pstmt=con.prepareStatement(prop.getProperty("updateNewPassword"));
			
			pstmt.setString(1, m_Npwd.getUserPwd());
			pstmt.setString(2, m_Npwd.getUserEmail());
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
				throw new MemberException(e.getMessage());
		}finally {

			close(pstmt);
		}
		
		System.out.println("RESULT : "+result);
		
		return result;
	}

}
