package com.kh.petner.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.AdminMain;

/**
 * Servlet implementation class AdminStartServlet
 */
@WebServlet("/adStart.ad")
public class AdminStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminMain am = null;
		String page = "";

		try {
			am = new MarketService().countMarket();
			page = "views/admin/admin2.jsp";
			request.setAttribute("am", am);
		} catch (MarketException e) {
			request.setAttribute("msg", "메인 못불러옴 ");
			request.setAttribute("exception", e);
			page = "views/common/errorPage.jsp";
		}
		
//		if(am != null) {
//			page = "views/admin/admin2.jsp";
//			request.setAttribute("am", am);
//		} else {
//			page = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "메인 못불러옴 ");
//		}

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
