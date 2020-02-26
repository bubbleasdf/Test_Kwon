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
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/reviewIn.rv")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rmno = Integer.parseInt(request.getParameter("rmno"));
		String rcontent = request.getParameter("rmessage");
		String rname = request.getParameter("rname");
		String remail = request.getParameter("remail");
		// null 값 때문에 값이변경되지 않으면 이렇게 해줘야 한다.
		int rstar = 0;
		if(request.getParameter("rstar") != null) {
			rstar = Integer.parseInt(request.getParameter("rstar"));
		}
		int refrno = 0;
		if(request.getParameter("refrno") != null) {
			refrno = Integer.parseInt(request.getParameter("refrno"));
		}
		int rlevel = 0;
		if(request.getParameter("rlevel") != null) {
			rlevel = Integer.parseInt(request.getParameter("rlevel"));
		}
		Review rv = new Review(rmno,rcontent,rname,remail,rstar,refrno,rlevel);
		
		int result = new ReviewService().insertReview(rv);
		
		
		if(result > 0) {
			response.sendRedirect("MarketIN.mk?mno="+rmno);
		}else {
			request.setAttribute("msg", "댓글 작성이 실패하였습니다.");
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
