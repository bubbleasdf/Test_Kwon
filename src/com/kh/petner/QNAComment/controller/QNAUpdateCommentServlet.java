package com.kh.petner.QNAComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.kh.petner.QNAComment.model.service.QNACommentService;
import com.kh.petner.QNAComment.model.vo.QNAComment;

/**
 * Servlet implementation class QNAUpdateCommentServlet
 */
@WebServlet("/QNAUpdateCommen.go")
public class QNAUpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QNAUpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int qno = Integer.parseInt(request.getParameter("qno"));
		String content = request.getParameter("content");
		
		
		QNAComment qc = new QNAComment();
		qc.setCno(cno);
		qc.setCcontent(content);
		
		int result = new QNACommentService().QNAUpdateComment(qc);
		
		if(result > 0 ) {
			response.sendRedirect("QNASelectOne.go?qno="+qno);
		}else {
			request.setAttribute("msg", "댓글 수정 실패");
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
