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

/**
 * Servlet implementation class QNASearchServlet
 */
@WebServlet("/QNASearch.go")
public class QNASearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNASearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String caregory = request.getParameter("caregory");
		String keyword = request.getParameter("searchValue");
		
		
		ArrayList<QNA> list = null;
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
		
		int listCount = qs.getSearchlistCount(caregory, keyword);
		
		maxPage = (int)((double)listCount/limit +0.9);
		
		startPage = ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		
		endPage = startPage +limit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
	
		
		list = qs.searchListQna(caregory, keyword, currentPage, limit);
		
		System.out.println(list);
		
		String page="";
		if(list!=null) {
			page="views/QNA/QNAList.jsp";
			request.setAttribute("searchList", list);
			request.getSession().setAttribute("caregory", caregory);
			request.getSession().setAttribute("keyword", keyword);
			
			QNAPageinfo qpi = new QNAPageinfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			request.setAttribute("qpi", qpi);
			
			
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "검색 실패");
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
