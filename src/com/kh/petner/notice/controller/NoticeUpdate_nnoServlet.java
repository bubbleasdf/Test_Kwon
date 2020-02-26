package com.kh.petner.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.notice.model.service.NoticeService;
import com.kh.petner.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdate_nnoServlet
 */
@WebServlet("/nUpnno.go")
public class NoticeUpdate_nnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdate_nnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		Notice n = new NoticeService().updatenno(nno);
		
		String page="";
		
		if(n!=null) {
			page="views/notice/noticeUpdate.jsp";
			request.setAttribute("notice", n);
			
		}else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 수정 불러오기 실패");
			
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
