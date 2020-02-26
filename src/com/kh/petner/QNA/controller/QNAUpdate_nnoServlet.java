package com.kh.petner.QNA.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.notice.model.service.NoticeService;
import com.kh.petner.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdate_nnoServlet
 */
@WebServlet("/qUpno.go")
public class QNAUpdate_nnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUpdate_nnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		QNA q = new QNAService().updateqno(qno);
		
		String page="";
		
		if(q!=null) {
			page="views/QNA/QNAUpdate.jsp";
			request.setAttribute("QNA", q);
			
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "QNA 수정 실패");
			
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
