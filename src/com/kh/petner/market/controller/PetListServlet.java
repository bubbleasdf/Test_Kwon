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
import com.kh.petner.member.pet.model.vo.Pet;

/**
 * Servlet implementation class PetListServlet
 */
@WebServlet("/petList.ad")
public class PetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 펫 리스트를 DB에서 불러와서 펫 목록에 쏴준다
		
		ArrayList<Pet> list = new ArrayList<>();
		
		MarketService ms = new MarketService();
		
		String page = "";
		
		try {
			list = ms.petList();
			page = "views/admin/admin_pet_table.jsp";
			request.setAttribute("list", list);
		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "펫 목록을 불러오는데 실패했습니다");
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
