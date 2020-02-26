package com.kh.petner.member.board.model.service;

import static com.kh.petner.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.member.board.model.dao.mpBoardDao;
import com.kh.petner.member.board.model.vo.mpBoard;

public class mpBoardService {

	private mpBoardDao bDao = new mpBoardDao();
	
	public int getListCount() {
		int listCount=0;
		Connection con = getConnection();
		
		listCount = bDao.getListCount(con);
		
		close(con);
		return listCount;
	}

	public ArrayList<mpBoard> selectList(int currentPage, int limit, String type) {
		ArrayList<mpBoard> blist=null;
		Connection con = getConnection();
		
		blist = bDao.selectList(currentPage, limit, con, type);
		
		System.out.println("Service selectList return : "+ blist);
		
		close(con);
		
		return blist;
	}

	public int insertmpBoard(mpBoard b) {
		int result=0;
		Connection con = getConnection();
		
		result = bDao.insertmpBoard(con, b);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public mpBoard selectBoard(int bno) {
		mpBoard b=null;
		Connection con = getConnection();
		
		b=bDao.selectBoard(con, bno);
		
		close(con);
		
		return b;
	}

	public int updatempBoard(mpBoard b) {
		int result = 0;
		
		Connection con = getConnection();
		
		result=bDao.updatempBoard(con, b);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}//if else
		
		close(con);
		return result;
	}

}
