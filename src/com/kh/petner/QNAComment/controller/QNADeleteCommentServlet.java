package com.kh.petner.QNAComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNAComment.model.service.QNACommentService;
import com.kh.petner.QNAComment.model.vo.QNAComment;

/**
 * Servlet implementation class QNADeleteCommentServlet
 */
@WebServlet("/QNADeleteComment.go")
public class QNADeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNADeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int qno = Integer.parseInt(request.getParameter("qno"));
			
		
		int result = new QNACommentService().QNADeleteComment(cno);
		
		if(result >0) {
			response.sendRedirect("QNASelectOne.go?qno="+qno);
		}else {
			request.setAttribute("msg", "댓글 삭제 실패");
			request.getRequestDispatcher("views/commom/erroPage.jsp").forward(request, response);
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
