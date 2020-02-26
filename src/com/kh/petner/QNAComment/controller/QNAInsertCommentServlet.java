package com.kh.petner.QNAComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.QNAComment.model.service.QNACommentService;
import com.kh.petner.QNAComment.model.vo.QNAComment;

/**
 * Servlet implementation class QNAInsertCommentServlet
 */
@WebServlet("/QNAInsertComment.go")
public class QNAInsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAInsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qemail = request.getParameter("qemail");
		String qcomment = request.getParameter("qcomment");
		System.out.println(qcomment);
		int qno = Integer.parseInt(request.getParameter("qno"));
		int refcno = Integer.parseInt(request.getParameter("refcno"));
		int clevel = Integer.parseInt(request.getParameter("clevel"));
		
		QNAComment qc = new QNAComment();
		qc.setQno(qno);
		qc.setCcontent(qcomment);
		qc.setCemail(qemail);
		qc.setRefcno(refcno);
		qc.setClevel(clevel);
		
		int result = new QNACommentService().insertComment(qc);
		
		if(result>0) {
			response.sendRedirect("QNASelectOne.go?qno="+qno);
		}else {
			request.setAttribute("msg", "댓글 작성 실패");
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
