package com.kh.petner.QNA.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;

/**
 * Servlet implementation class QNAInsertServlet
 */
@WebServlet("/QNAInsert.go")
public class QNAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qtitle = request.getParameter("qtitle");
		String qemail = request.getParameter("qemail");
		String qcontent = request.getParameter("qcontent");
		
		
		

		QNA q = new QNA();
		q.setQtitle(qtitle);
		q.setQemail(qemail);
		q.setQcontent(qcontent);
		
		
		
		int result = new QNAService().insertQNA(q);
		
		if(result > 0) {
			response.sendRedirect("QNAlist.go");
		}else {
			request.setAttribute("msg", "공지사항 등록 실패");
			request.getRequestDispatcher("views/common/erroerPage.jap").forward(request, response);
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
