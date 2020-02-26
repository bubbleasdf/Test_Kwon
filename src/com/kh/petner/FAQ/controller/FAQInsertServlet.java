package com.kh.petner.FAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.FAQ.model.service.FAQService;
import com.kh.petner.FAQ.model.vo.FAQ;

/**
 * Servlet implementation class FAQInsertServlet
 */
@WebServlet("/fInsert.go")
public class FAQInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Condition = Integer.parseInt(request.getParameter("searchCondition"));
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		
		
		FAQ f = new FAQ();
		
		f.setTitle(ftitle);
		f.setContent(fcontent);
		
		
		
		int result = new FAQService().FAQInsert(f, Condition);
		
		if(result > 0) {
			response.sendRedirect("FAQlist.go");
		}else {
			request.setAttribute("msg", "FAQ 수정하기 실패");
			request.getRequestDispatcher("views/common/errorPage.jap").forward(request, response);
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
