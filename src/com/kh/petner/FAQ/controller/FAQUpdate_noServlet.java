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
 * Servlet implementation class FAQUpdateServlet
 */
@WebServlet("/fUpno.go")
public class FAQUpdate_noServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQUpdate_noServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		FAQ f = new FAQService().FAQupdatfno(fno);
		
		
	
	
		String page="";
		
		if(f!=null) {
			page="views/FAQ/FAQUpdate.jsp";
			request.setAttribute("FAQ", f);
			
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "FAQ 수정은 관리자만 가능합니다.");
			
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
