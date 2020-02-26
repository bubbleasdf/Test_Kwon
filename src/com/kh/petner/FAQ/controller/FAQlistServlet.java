package com.kh.petner.FAQ.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.FAQ.model.service.FAQService;
import com.kh.petner.FAQ.model.vo.FAQ;

/**
 * Servlet implementation class FAQlistServlet
 */
@WebServlet("/FAQlist.go")
public class FAQlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		list = new FAQService().FAQlist();
		
		String page="";
		
		if(list!=null) {
			page="views/FAQ/FAQlist.jsp";
			request.setAttribute("list", list);
		}else {
			page="views/common/erroPage.jsp";
			request.setAttribute("msg", "FAQ List Read Faile");
			
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
