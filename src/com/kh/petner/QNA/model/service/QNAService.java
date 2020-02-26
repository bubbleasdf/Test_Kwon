package com.kh.petner.QNA.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.QNA.model.dao.QNADao;
import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.notice.model.dao.NoticeDao;

import static com.kh.petner.common.JDBCTemplate.*;

public class QNAService {
	
	private QNADao qDao = new QNADao();

	

	public int getlistCount() {
		Connection con = getConnection();
		
		int listCount = qDao.listCount(con);
		
		close(con);
		
		return listCount;
	}





	public ArrayList<QNA> QNAPage(int currentPage, int limit) {
			
		Connection con = getConnection();
		
		ArrayList<QNA> list  = qDao.QNAPage(con, currentPage, limit);
		
		
		close(con);
		
		return list;
	}





	public QNA selectOne(int qno) {
		Connection con = getConnection();
		
		QNA q = qDao.selectOne(con, qno);
		
		close(con);
		
		return q;
	}





	public int insertQNA(QNA q) {
		Connection con = getConnection();
		
		int result = qDao.insertQNA(con , q);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}





	public QNA updateqno(int qno) {
		
		Connection con = getConnection();
		
		QNA q = qDao.selectOne(con, qno);
		
		close(con);
		
		
		return q;
	}





	public int Qupdate(QNA q) {
		
		Connection con = getConnection();
		
		int result = qDao.Qupdate(con,q);
		
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}







	public int getSearchlistCount(String caregory, String keyword) {
			
			Connection con = getConnection();
		
			int listCount = qDao.searchListCount(con, caregory, keyword);
		
			close(con);
		
			return listCount;
	
	}





	public ArrayList<QNA> searchListQna(String caregory, String keyword, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<QNA> list = null;
		
		if(caregory.length() >0 ) {
			list = qDao.searchListQna(con, caregory, keyword, currentPage, limit);
		}else {
			list = qDao.QNAPage(con, currentPage, limit);
		}
		
		close(con);
		return list;
	}





	public int QNAdelete(int qno) {
		
		Connection con = getConnection();
		
		int result = qDao.QNAdelete(con, qno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}





	public ArrayList<QNA> QNAuserlist(String userEmail) {
		
		Connection con = getConnection();
		
		ArrayList<QNA> list = qDao.QNAuserList(con, userEmail);
		
		close(con);
		System.out.println("SErvice list : "+list);
		return list;
	}

}
