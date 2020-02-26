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


@WebServlet("/pUpdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//회원 정보 수정용 데이터 꺼내오기
		String userName = request.getParameter("USER_NAME");
		String userPhone = request.getParameter("USER_PHONE");
		String userPwd = request.getParameter("userPwd");
		String userPwd1 = request.getParameter("usernPwd1");
		String userPwd2 = request.getParameter("usernPwd2");
	
		
		HttpSession session =request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		
		MemberService ms = new MemberService();
		
		
		//원래 비밀번호 검사
		m.setUserPwd(userPwd);
		//비밀번호만 넣은뒤 로그인 서블릿으로 비밀번호가 맞는지 확인
		try {
			m=ms.selectMember(m);
		} catch (MemberException e1) {
			request.setAttribute("msg", "기존 비밀번호 오류");
			request.setAttribute("exception", null);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			return;
		}
		
		
		//새로운 비밀번호있는지 있으면 같은지 검사
		if(	!(userPwd1==null || userPwd1 =="") 	//새로운 패스워드가 입력되었거나 
			||	!(userPwd2==null || userPwd2 =="")	) {	//새로운 패스워드 확인이 입력되었거나
			if(!userPwd1.equals(userPwd2)) {		// 새로운 패스워드가 일치하는지 검사
				System.out.println(userPwd1+","+userPwd2);
				System.out.println("새로운 비밀번호 불일치");
				request.setAttribute("msg",  "새로운 비밀번호가 일치 하지 않습니다");
				request.setAttribute("exception", null);
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				return;
			} //if
			m.setUserPwd(userPwd1); //새로운 패스워드가 일치한다면 새로운 패스워드를 세팅해준다.
		}//if
		
		m.setUserName(userName);
		m.setUserPhone(userPhone);
		
		
		try {
			ms.updateMember(m);
			System.out.println("회원 정보 수정 완료");
			session.setAttribute("member", m);
			response.sendRedirect("views/member/mypage.jsp");
			
		}catch(MemberException e) {
			request.setAttribute("msg", "회원 정보 수정 중 에러 발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
