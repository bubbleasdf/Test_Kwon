package com.kh.petner.Review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.petner.Review.model.dao.ReviewDao;
import com.kh.petner.Review.model.vo.Review;
import static com.kh.petner.common.JDBCTemplate.*;
public class ReviewService {
	private ReviewDao rvDao = new ReviewDao();
	
	
	/**
	 * 후기 댓글 추가
	 * @param rv
	 * @return
	 */
	public int insertReview(Review rv) {
		Connection con = getConnection();
		
		int result = rvDao.insertReview(con, rv);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	/**
	 * 후기 댓글 리스트
	 * @param mid
	 * @return
	 */
	public ArrayList<Review> selectList(int mid) {
		Connection con = getConnection();
		
		ArrayList<Review> rlist = rvDao.selectList(con, mid);
		
		close(con);
		return rlist;
	}

	/**
	 * 후기 삭제
	 * @param rno
	 * @return
	 */
	public int deleteReview(int rno) {
		Connection con = getConnection();
		int result = rvDao.deleteReview(con, rno);
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	/**
	 * 후기 수정
	 * @param rv
	 * @return
	 */
	public int updateReview(Review rv) {
		Connection con = getConnection();
		
		int result = rvDao.updateReview(con, rv);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	/**
	 * 별점 평균
	 * @param mid
	 * @return
	 */
	public int getstar(int mid) {
		Connection con = getConnection();
		// double 값을 반올림해서 int로 변환
		double result = rvDao.getstar(con, mid);
		int star = (int)(Math.round(result));
		
		close(con);
		return star;
	}


}
