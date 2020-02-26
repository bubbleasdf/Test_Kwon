package com.kh.petner.FAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.kh.petner.FAQ.model.service.FAQService;

/**
 * Servlet implementation class FAQChooseListServlet
 */
@WebServlet("/fDel.go")
public class FAQDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		
		System.out.println(fno);
	
		
		int result = new FAQService().FAQdelete(fno);
		
		if(result > 0) {
			response.sendRedirect("FAQlist.go");
			
		
		}else {
			request.setAttribute("msg", "FAQ 삭제 하기 실패");
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
