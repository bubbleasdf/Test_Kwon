package com.kh.petner.QComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QComment.model.service.QCommentService;
import com.kh.petner.QComment.model.vo.QComment;

/**
 * Servlet implementation class CommentUpdateServlet
 */
@WebServlet("/coUpdate.co")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		String ccontent = request.getParameter("ccontent");
		
		QComment qco = new QComment();
		
		qco.setCno(cno);
		qco.setMno(mno);
		qco.setCcontent(ccontent);
		
		int result = new QCommentService().UpdateComment(qco);
		
		if(result > 0) {
			response.sendRedirect("MarketIN.mk?mno="+mno);
		}else {
			request.setAttribute("msg", "댓글 수정이 실패하였습니다.");
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
