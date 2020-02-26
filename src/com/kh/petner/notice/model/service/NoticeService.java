package com.kh.petner.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.notice.model.dao.NoticeDao;
import com.kh.petner.notice.model.vo.Notice;
import static com.kh.petner.common.JDBCTemplate.*;

public class NoticeService {
	
	private NoticeDao nDao = new NoticeDao();
	
	

	public ArrayList<Notice> selectList() {
		Connection con = getConnection();
		
		ArrayList<Notice> list =nDao.selectList(con);
		
		close(con);
		
		return list;
		
	}






	public int InsertNotice(Notice n) {
		Connection con = getConnection();
		
		int result = nDao.InsertNotice(con, n);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}



	public Notice noticeDetail(int nno) {
		
		Connection con = getConnection();
		
		Notice n = nDao.noticeDetail(con , nno);
		
		if(n!=null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return n;
	}






	public Notice updatenno(int nno) {
		
		Connection con = getConnection();
		Notice n = nDao.noticeDetail(con, nno);
		
		close(con);
		
		return n;
	}






	public int Nupdate(Notice n) {
		
		Connection con = getConnection();
		int result = nDao.Nupdate(con , n);
		
		if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		
		return result;
	}






	public int Ndelete(int nno) {
		
		Connection con = getConnection();
		
		int result = nDao.Ndelete(con , nno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}







	public ArrayList<Notice> noticePage(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.noticePage(con, currentPage, limit);
		
		
		close(con);
		
		
		return list;
	}






	public int getlistCount() {
		Connection con = getConnection();
		int pageCount = nDao.getlistCount(con);
		
		close(con);
		
		return pageCount;
	}

}
