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
import com.kh.petner.market.model.vo.HotelReserve;

/**
 * Servlet implementation class ReserveListServlet
 */
@WebServlet("/reserveList.ad")
public class ReserveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HotelReserve> list = new ArrayList<>();
		
		MarketService ms = new MarketService();
		String page = "";
		
		try {
			list = ms.reserveList();
			page = "views/admin/admin_reserve_table.jsp";
			request.setAttribute("list", list);
		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "예약 목록을 불러오는데 실패했습니다. 관리자를 찾아주는데 관리자는 나잖아?");
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
