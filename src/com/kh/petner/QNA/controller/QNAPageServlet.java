package com.kh.petner.QNA.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.QNA.model.vo.QNAPageinfo;

;

/**
 * Servlet implementation class NoticePageServlet
 */
@WebServlet("/QNAlist.go")
public class QNAPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QNAPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <QNA> list =null;
		QNAService qs = new QNAService();
		
		int startPage;
		
		int endPage;
		
		int maxPage;
		
		int currentPage;
		
		int limit;
		
		currentPage= 1;
		
		limit = 5;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		int listCount = qs.getlistCount();
		
		
		maxPage = (int)((double)listCount/limit +0.9);
		
		startPage = ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		
		endPage = startPage +limit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = qs.QNAPage(currentPage, limit);
		
			String page="";
		
		if(list != null) {
			page="views/QNA/QNAList.jsp";
			request.setAttribute("list", list);
			
			QNAPageinfo qpi = new QNAPageinfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			request.setAttribute("qpi", qpi);
			
		}else {
			page = "views/common/errorPage.jsp";
			 request.setAttribute("list", list);
		}
		
		request.getRequestDispatcher(page).forward(request, response);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
