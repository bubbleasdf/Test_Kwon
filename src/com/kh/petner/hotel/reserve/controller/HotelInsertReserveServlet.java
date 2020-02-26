package com.kh.petner.hotel.reserve.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.hotel.reserve.model.service.HotelReserveService;
import com.kh.petner.hotel.reserve.model.vo.HotelReserve;

/**
 * Servlet implementation class HotelInsertReserveServlet
 */
@WebServlet("/insertReserve.re")
public class HotelInsertReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelInsertReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int marketId = Integer.parseInt(request.getParameter("marketId"));
		System.out.println("marketId: " + marketId);
		String user_Email = request.getParameter("user_Email");
		String user_Name = request.getParameter("user_Name");
		String user_Phone = request.getParameter("user_Phone");
		String s_date = request.getParameter("s_date");
		String e_date = request.getParameter("e_date");
		int marketPrice = Integer.parseInt(request.getParameter("marketPrice"));
		/*int pet_Id = Integer.parseInt(request.getParameter("pet_Id")); */
		String pet_Name = request.getParameter("pet_Name");
		String pet_Type = request.getParameter("pet_Type");
		String status = request.getParameter("status");
		int sum_price = Integer.parseInt(request.getParameter("sum_price")); 
		
		Date Ss_date = null;
		Date Ee_date = null; 
		
		if(s_date != null && s_date!="") {
			String[] dateArr = s_date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i=0 ; i<intArr.length ; i++) {
				intArr[i]=Integer.parseInt(dateArr[i]);
			}
			
			Ss_date = new Date(new GregorianCalendar(intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());
			
			
		}else {
			Ss_date = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		if(e_date != null && e_date!="") {
			String[] dateArr = e_date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i=0 ; i<intArr.length ; i++) {
				intArr[i]=Integer.parseInt(dateArr[i]);
			}
			
			Ee_date = new Date(new GregorianCalendar(intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());
			
			
		}else {
			Ee_date = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		HotelReserve hr = new HotelReserve(); 
		
		hr.setMarketId(marketId);
		hr.setUser_Email(user_Email);
		hr.setUser_Name(user_Name);
		hr.setUser_Phone(user_Phone);
		hr.setS_date(Ss_date);
		hr.setE_date(Ee_date);
		hr.setMarketPrice(marketPrice);
/*		hr.setPet_Id(pet_Id);*/
		hr.setPet_Name(pet_Name);
		hr.setPet_Type(pet_Type);
		hr.setStatus(status);
		hr.setSum_price(sum_price);
		
		System.out.println(hr);
		int result = new HotelReserveService().insertHotelReserve(hr);
		
		if(result > 0) {
			response.sendRedirect("views/hotel/hotel_reserveSuccess.jsp");
		}else {
			request.setAttribute("msg", "호텔 예약 실패");
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
