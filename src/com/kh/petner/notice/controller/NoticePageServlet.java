package com.kh.petner.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.notice.model.service.NoticeService;
import com.kh.petner.notice.model.vo.Notice;
import com.kh.petner.notice.model.vo.NoticePageInfo;

/**
 * Servlet implementation class NoticePageServlet
 */
@WebServlet("/NoticeList.go")
public class NoticePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Notice> list =null;
		NoticeService ns = new NoticeService();
		
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
		int listCount = ns.getlistCount();
		
		System.out.println(listCount);
		
		maxPage = (int)((double)listCount/limit +0.9);
		
		startPage = ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		
		endPage = startPage +limit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = ns.noticePage(currentPage, limit);
		
			String page="";
		
		if(list != null) {
			page="views/notice/noticeList.jsp";
			request.setAttribute("list", list);
			
			NoticePageInfo npi = new NoticePageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			request.setAttribute("npi", npi);
			
		}else {
			page = "views/common/errorPage.jsp";
			 request.setAttribute("list", list);
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
