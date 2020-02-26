package com.kh.petner.member.model.service;

import static com.kh.petner.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.petner.member.model.dao.MemberDao;
import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.vo.Member;

public class MemberService{

	private Connection con;
	private MemberDao mDao = new MemberDao();
	
	public Member selectMember(Member m) throws MemberException {
		System.out.println("MemberService selectMember");
		
		con=getConnection();
		System.out.println("MemberService getConnection");
		Member result = mDao.selectMember(con,m);
		
		
		System.out.println("Return : MemberService selectMember : "+ m);
		close(con);
		
		if(result == null) {
			throw new MemberException("회원 이메일 혹은 비밀번호가 올바르지 않습니다.");
		}
		
		return result;
	}

	public int insertMember(Member m) throws MemberException {
		int result=0;
		
		con=getConnection();
		
		System.out.println("service - insertMember : " + m);
		
		result = mDao.insertMember(con,m);
		
		if(result>0) { //성공
			System.out.println("commit : "+result);
			commit(con);
		}else { //실패
			System.out.println("rollback");
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	public int updateMember(Member m) throws MemberException {
		Connection con = getConnection();
		
		int result = 0;
		
		result = mDao.updateMember(con, m);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
		
	}//updateMember

	public int deleteMember(String userEmail) throws MemberException {
		int result=0;
		Connection con = getConnection();
		
		result = mDao.deleteMember(con, userEmail);
		
		if(result>0) commit(con);
		else	rollback(con);
		
		close(con);
		
		return result;
	}

	/**
	 * 유저 권한 변경 서비스
	 * userEmail과 권한값을 받아서 
	 * DAO로 전달해준다
	 * 
	 * @param userEmail
	 * @param userRoles
	 * @return
	 */
	public int chMemberRoles(String userEmail, int userRoles) {
		int result=0;
		Connection con = getConnection();
		
		result = mDao.chMemberRoles(con,userEmail, userRoles);
		
		if(result>0) {
			System.out.println("권한 변경 성공");
			commit(con);
		}
		else {
			System.out.println("권한 변경 실패");
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public Member searchPwd(Member m) throws MemberException {
		Member result = null;
		
		con=getConnection(); 	//Connectin con = getconnection();
		
		result = mDao.searchPwd(con,m);
		
		close(con);
		
		return result;
	}

	public void passwordchange(Member m_Npwd) throws MemberException {
		con = getConnection();
		System.out.println("sikim MemberService passwordchange");
		int result = mDao.passwordchange(con,m_Npwd);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return;
		
	}



}
