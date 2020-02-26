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
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/coDelete.co")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		QComment qco = new QComment();
		
		int result = new QCommentService().DeleteComment(cno);
		
		if(result > 0) {
			response.sendRedirect("MarketIN.mk?mno="+mno);
		}else {
			request.setAttribute("msg", "댓글 삭제가 실패하였습니다.");
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
