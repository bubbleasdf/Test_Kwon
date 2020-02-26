package com.kh.petner.QNAComment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.petner.common.JDBCTemplate.*;

import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.QNAComment.model.dao.QNACommentDao;
import com.kh.petner.QNAComment.model.vo.QNAComment;

public class QNACommentService {
	
	private QNACommentDao qcDao = new QNACommentDao();

	public ArrayList<QNAComment> selectList(int qno) {
		Connection con = getConnection();
		
		ArrayList<QNAComment> clist = qcDao.selectList(con,qno);
		
		close(con);
		
		return clist;
	}

	public int insertComment(QNAComment qc) {
		Connection con = getConnection();
		
		int result = qcDao.QNAinsertComment(con, qc);
		
		if(result >0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int QNAUpdateComment(QNAComment qc) {
		Connection con = getConnection();
		
		int result = qcDao.QNAUpdateComment(con, qc);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int QNADeleteComment(int cno) {
		Connection con = getConnection();
		
		int result = qcDao.QNADeleteComment(con, cno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
