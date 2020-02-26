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
 * Servlet implementation class CommentInsertServlet
 */
@WebServlet("/insert.qc")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("name");
		String cemail = request.getParameter("email");
		int mno = Integer.parseInt(request.getParameter("mno"));
		String ccontent = request.getParameter("message");
		int refcno = Integer.parseInt(request.getParameter("refcno"));
		int clevel = Integer.parseInt(request.getParameter("clevel"));
		
		QComment qco = new QComment(mno,ccontent,cname,cemail,refcno,clevel);
		
		
		int result = new QCommentService().insertComment(qco);
		
		if(result > 0) {
			response.sendRedirect("MarketIN.mk?mno="+mno);
		}else {
			request.setAttribute("msg", "댓글 작성이 실패하였습니다.");
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
