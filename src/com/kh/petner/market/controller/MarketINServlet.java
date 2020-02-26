package com.kh.petner.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QComment.model.service.QCommentService;
import com.kh.petner.QComment.model.vo.QComment;
import com.kh.petner.Review.model.service.ReviewService;
import com.kh.petner.Review.model.vo.Review;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.Market;
import com.kh.petner.market.model.vo.MarketDetail;

/**
 * Servlet implementation class MarketINServlet
 */
@WebServlet("/MarketIN.mk")
public class MarketINServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketINServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mno"));
		/*int mid = 10001;*/
		// 마켓 정보 조회
		System.out.println("servlet marketId : " + mid);
		Market mk = new MarketService().MarketIn(mid);
		// 마켓 디테일 정보 조회
		MarketDetail md = new MarketService().marketmd(mid);
		// 문의 댓글 조회
		ArrayList<QComment> qlist = new QCommentService().selectList(mid);
		// 후기 댓글 조회
		ArrayList<Review> rlist = new ReviewService().selectList(mid);
		
		// 별점
		int star = new ReviewService().getstar(mid);
		
		System.out.println("[Servlet]market : " + mk);
		System.out.println("qlist: " + qlist);
		System.out.println("rlist: " + rlist);
		
		String page = "";
		
		if(mk != null) {
			page = "views/hotel/hotel_information.jsp";
			request.setAttribute("market", mk);
			request.setAttribute("marketDetail", md);
			request.setAttribute("qlist", qlist);
			request.setAttribute("rlist", rlist);
			request.setAttribute("star", star);
			
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "가게 상세 보기 실패!!!");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
