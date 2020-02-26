package com.kh.petner.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.MarketDetail;

/**
 * Servlet implementation class MarketDetailUpdateServlet
 */
@WebServlet("/selectMarketDetail.ad")
public class MarketDetailSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketDetailSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marketId = Integer.parseInt(request.getParameter("marketId"));
		MarketService ms = new MarketService();
		String page ="";
		
		try {
			MarketDetail md = ms.selectMarketDetail(marketId);
			String marketAddress = ms.selectMarketAddress(marketId);
			page = "views/admin/admin_market_detail.jsp";
			request.setAttribute("MarketDetail", md);
			request.setAttribute("marketAddress", marketAddress);
		} catch (MarketException e) {
			page ="views/common/errorPage.jsp";
			request.setAttribute("msg", "마켓 디테일 페이지 불러오는데 실패했습니다");
			request.setAttribute("exception", e);
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
