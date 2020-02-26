package com.kh.petner.QComment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.QComment.model.dao.QCommentDao;
import com.kh.petner.QComment.model.vo.QComment;

import static com.kh.petner.common.JDBCTemplate.*;

public class QCommentService {
	private QCommentDao qcDao = new QCommentDao();


	/**
	 * 댓글 추가
	 * @param qco
	 * @return
	 */
	public int insertComment(QComment qco) {
		Connection con = getConnection();
		
		int result = qcDao.insertComment(con, qco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	/**
	 * 댓글 리스트
	 * @param mid
	 * @return
	 */
	public ArrayList<QComment> selectList(int mid) {
		Connection con = getConnection();
		
		ArrayList<QComment> qlist = qcDao.selectList(con, mid);
		
		close(con);
		return qlist;
	}

	/**
	 * 댓글 업데이트
	 * @param qco
	 * @return
	 */
	public int UpdateComment(QComment qco) {
		Connection con = getConnection();
		
		int result = qcDao.UpdateComment(con, qco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int DeleteComment(int cno) {
		Connection con = getConnection();
		
		int result = qcDao.deleteComment(con, cno);
		
		if(result > 0) commit(con);
		else rollback(con);

		close(con);
		
		return result;
	}





}
