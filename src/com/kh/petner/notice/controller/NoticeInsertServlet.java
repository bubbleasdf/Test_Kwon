package com.kh.petner.notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.notice.model.service.NoticeService;
import com.kh.petner.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/NoticeInsert.go")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String ntitle = request.getParameter("ntitle");
		String nemail = request.getParameter("nemail");
		String ncontent = request.getParameter("ncontent");
		
		String ndate = request.getParameter("ndate");
		
		
		Date Wndate = null;
		
		if(ndate != null && ndate!="") {
			String[] dateArr = ndate.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i=0 ; i<intArr.length ; i++) {
				intArr[i]=Integer.parseInt(dateArr[i]);
			}
			
			Wndate = new Date(new GregorianCalendar(intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());
			
			
		}else {
			Wndate = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		
		Notice n = new Notice();
		
		n.setNtitle(ntitle);
		n.setNemail(nemail);
		n.setnContent(ncontent);
		n.setNdate(Wndate);
		
		
		
		int result = new NoticeService().InsertNotice(n);
		
		if(result > 0) {
			
			response.sendRedirect("NoticeList.go");
			
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
