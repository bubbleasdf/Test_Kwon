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
import com.kh.petner.notice.model.vo.Faq;

/**
 * Servlet implementation class FaqListServlet
 */
@WebServlet("/listFaq.ad")
public class FaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Faq 리스트 불러오기
		ArrayList<Faq> list = new ArrayList<>();
		String page = "";
		
		try {
			list = new MarketService().faqList();
			page = "views/admin/admin_faq_table.jsp";
			request.setAttribute("list", list);
		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "FAQ 리스트를 불러오는데 실패했습니다");
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
