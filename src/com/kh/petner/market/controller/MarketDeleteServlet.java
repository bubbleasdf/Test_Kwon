package com.kh.petner.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;

/**
 * Servlet implementation class MarketDeleteServlet
 */
@WebServlet("/deleteMarket.ad")
public class MarketDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marketId = Integer.parseInt(request.getParameter("marketId"));
		String status = request.getParameter("status");
		System.out.println("servlet Status : " + status);
		
		if("N".equals(status)) {
			status = "Y";
		} else if("Y".equals(status)) {
			status = "N";
		}
		

		int result = 0;
		try {
			result = new MarketService().deleteMarket(marketId, status);
			response.sendRedirect("/PETNER/marketList.ad");
		} catch (MarketException e) {
			request.setAttribute("msg", "마켓 삭제 실패");
			request.setAttribute("exceptioin", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);

		}
		
//		if(result > 0) {
//			response.sendRedirect("/PETNER/marketList.ad");
//		} else {
//			request.setAttribute("msg", "마켓 삭제 실패");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
