package com.kh.petner.QNA.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.QNA.model.service.QNAService;
import com.kh.petner.QNA.model.vo.QNA;
import com.kh.petner.QNAComment.model.service.QNACommentService;
import com.kh.petner.QNAComment.model.vo.QNAComment;

/**
 * Servlet implementation class QNASelectOneServlet
 */
@WebServlet("/QNASelectOne.go")
public class QNASelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNASelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qno = Integer.parseInt(request.getParameter("qno"));

		QNA q = new QNAService().selectOne(qno);
		
		ArrayList<QNAComment> Clist = new QNACommentService().selectList(qno);
		
		System.out.println(Clist);
		
		String page = "";
		
		if( q !=null) {
			page="views/QNA/QNADetail.jsp";
			request.setAttribute("QNA", q);
			request.setAttribute("QNAComment", Clist);
			
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패");
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
