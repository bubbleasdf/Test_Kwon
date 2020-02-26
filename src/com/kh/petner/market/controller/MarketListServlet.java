package com.kh.petner.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.Market;

/**
 * Servlet implementation class MarketListServlet
 */
@WebServlet("/marketList.ad")
public class MarketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리스트 출력
		System.out.println("[Servlet 실행]");
		ArrayList<Market> list = new ArrayList<>();
		
		MarketService ms = new MarketService();
		String page = "";
		
		try {
			list = ms.selectMarketList();
			page = "views/admin/admin_market_table.jsp";
			request.setAttribute("list", list);

		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "상점 리스트 불러오기 에러");
			request.setAttribute("exception", e);
		}
		
//		for(Market m : list) {
//			System.out.println(m);
//		}
		
//		if(list != null) {
//			page = "views/admin/admin_market_table.jsp";
//			request.setAttribute("list", list);
//		} else {
//			page = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "상점 리스트 불러오기 에러");
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
