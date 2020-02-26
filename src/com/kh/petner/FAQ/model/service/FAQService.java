package com.kh.petner.FAQ.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import static com.kh.petner.common.JDBCTemplate.*;

import com.kh.petner.FAQ.model.dao.FAQDao;
import com.kh.petner.FAQ.model.vo.FAQ;
import com.kh.petner.QNA.model.vo.QNA;
import com.sun.media.sound.PortMixerProvider;

public class FAQService {

	private FAQDao fDao = new FAQDao();

	public ArrayList<FAQ> FAQlist() {

		Connection con = getConnection();

		ArrayList<FAQ> list = fDao.FAQlist(con);
		
		close(con);
		
		return list;
		

	}

	public int FAQdelete(int fno) {
		Connection con = getConnection();
		
		
		int result = fDao.FAQdelete(con ,fno);
		
		if(result > 0) {
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		return result;
	}


	public FAQ FAQupdatfno(int fno) {
		Connection con = getConnection();
		
		FAQ f = fDao.FAQselectOne(con, fno);
		
		
		
		close(con);
		
		
		return f;
	}

	public int FAQupdate(FAQ f) {
		Connection con = getConnection();
		
		int result = fDao.FAQupdate(con, f);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

	public int FAQInsert(FAQ f, int Condition) {
		Connection con = getConnection();
		
		int result = fDao.FAQInsert(con, f, Condition);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

}
