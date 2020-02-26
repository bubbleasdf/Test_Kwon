package com.kh.petner.QNA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;

/**
 * Servlet implementation class QNAUpdateServlet
 */
@WebServlet("/qUp.go")
public class QNAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		int qno = Integer.parseInt(request.getParameter("qno"));	
				
		QNA q = new QNA();
		q.setQno(qno);
		q.setQtitle(qtitle);
		q.setQcontent(qcontent);
		
		int result = new QNAService().Qupdate(q);
		
		if(result > 0 ) {
			response.sendRedirect("QNASelectOne.go?qno="+qno);
			
		}else {
			request.setAttribute("msg","QNA 수정 실패" );
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
