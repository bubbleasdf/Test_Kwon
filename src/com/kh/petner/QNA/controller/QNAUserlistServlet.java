package com.kh.petner.QNA.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;

/**
 * Servlet implementation class QNAUserlistServlet
 */
@WebServlet("/QNAUserlist.go")
public class QNAUserlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUserlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("userEmail");
		
		System.out.println("QNAUserListServlet userEmail :"+ userEmail);
		
		ArrayList<QNA> list = new QNAService().QNAuserlist(userEmail);
		System.out.println("list 값 : "+list);
		
		String page="";
		HttpSession session = request.getSession();
		
		if(list != null) {
			System.out.println("if list 값 : "+list);
			session.setAttribute("QNAUserlist", list);
			System.out.println("서블릿 끝났어염!!!!!!!!!!!!!");
			page="views/member/tab/tab3.jsp";

		}else {
			System.out.println("Asdfasdfa");
			page = "views/common/errorPage.jsp";
			 request.setAttribute("list", list);
		}
		
		//request.getRequestDispatcher(page).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
