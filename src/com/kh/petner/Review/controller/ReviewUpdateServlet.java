package com.kh.petner.Review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.Review.model.service.ReviewService;
import com.kh.petner.Review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/reviewUp.rv")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		int rmno = Integer.parseInt(request.getParameter("rmno"));
		String rcontent = request.getParameter("rcontent");
		
		Review rv = new Review();
		
		rv.setRno(rno);
		rv.setRmno(rmno);
		rv.setRcontent(rcontent);
		
		int result = new ReviewService().updateReview(rv);
		
		if(result > 0) {
			response.sendRedirect("MarketIN.mk?mno="+rmno);
		}else {
			request.setAttribute("msg", "댓글 수정이 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
