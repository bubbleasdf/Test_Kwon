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
import com.kh.petner.market.model.vo.AuditLog;

/**
 * Servlet implementation class AuditLogServlet
 */
@WebServlet("/auditLog.ad")
public class AuditLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditLogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AuditLog> list = new ArrayList<>();
		String page = "";
		
		try {
			list = new MarketService().selectLogList();
			page = "views/admin/admin_log_table.jsp";
			request.setAttribute("list", list);
		} catch (MarketException e) {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "로그 페이지 불러오기 실패! 이거 로그에 똑독히 적어놔라잉");
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
