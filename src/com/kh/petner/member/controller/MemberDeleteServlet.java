package com.kh.petner.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.service.MemberService;
import com.kh.petner.member.model.vo.Member;




@WebServlet("/pDelete.me")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userEmail = ((Member)session.getAttribute("member")).getUserEmail();
		
		System.out.println("삭제할 회원 아이디 : "+ userEmail);
		
		MemberService ms = new MemberService();
		
		
		int result;
		try {
			result = ms.deleteMember(userEmail);
				System.out.println("미션 석세스");
				
				// =============!!!!!!!회원 탈퇴성공시 현재 로그인한 세션정보를 초기화 해줘야 한다.!!!!
				session.invalidate();
				response.sendRedirect("index.jsp");
		} catch (MemberException e) {
			System.out.println("미션 뽸일");
			request.setAttribute("msg", "회원탈퇴 수행 중 에러 발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			e.printStackTrace();
			
		}//try catch
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
