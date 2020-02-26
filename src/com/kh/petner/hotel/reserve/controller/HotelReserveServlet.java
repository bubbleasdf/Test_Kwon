package com.kh.petner.hotel.reserve.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.hotel.reserve.model.service.HotelReserveService;
import com.kh.petner.market.model.vo.MarketDetail;
import com.kh.petner.member.model.vo.Member;
import com.kh.petner.member.pet.model.vo.Pet;

/**
 * Servlet implementation class HotelReserveServlet
 */
@WebServlet("/hotelReserve.re")
public class HotelReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*// user정보 
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Member m = (Member)session.getAttribute("member"); 
			session.setAttribute("member", m);
			response.sendRedirect("insertReserve.re");
		}else {
			response.sendRedirect("/PETNER/index.jsp");
		}*/
		
		// marketdetail , pet 불러오기 
		int marketId = Integer.parseInt(request.getParameter("marketId")); 
		System.out.println("marketId:" + marketId);
		
		String userEmail = request.getParameter("userEmail"); 
		System.out.println("[Servlet 시작]userEmail:" + userEmail);
		
		HotelReserveService hrs = new HotelReserveService();  
		
		MarketDetail marD = hrs.selectMarket(marketId); 
		
		if(marD != null) {
			
			request.setAttribute("MarketDetail", marD);
			System.out.println("[servlet] MarketDetail : " + marD);	
			
			Pet hotelRevPet = hrs.selectPet(userEmail); 
			request.setAttribute("hotelRevPet,", hotelRevPet);
			System.out.println("[servlet] pet : " + hotelRevPet);
			
		}else {
			response.sendRedirect("/PETNER/index.jsp");
		}
		
		request.getRequestDispatcher("views/hotel/hotel_reservation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
