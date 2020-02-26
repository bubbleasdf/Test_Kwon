package com.kh.petner.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.HotelReserve;

/**
 * Servlet implementation class ReserveList
 */

@WebServlet("/rList.me")
public class ReserveList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		System.out.println("ReserveList userEmail : " +userEmail);
		ArrayList<HotelReserve> list = new ArrayList<>();
		
		MarketService ms = new MarketService();
		String page = "";

		HttpSession session = request.getSession();
		
		try {
			list = ms.mReserveList(userEmail);
			//page = "views/admin/admin_reserve_table.jsp";

			System.out.println("최종 request에 set할 list : "+list);
			session.setAttribute("rList", list);
			
			
			
		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "예약 목록을 불러오는데 실패했습니다. 관리자를 찾아주는데 관리자는 나잖아?");
			request.setAttribute("exception", e);
			request.getRequestDispatcher(page).forward(request, response);
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
