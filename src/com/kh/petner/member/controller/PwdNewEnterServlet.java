package com.kh.petner.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.service.MemberService;
import com.kh.petner.member.model.vo.Member;

/**
 * Servlet implementation class PwdNewEnter
 */
@WebServlet("/pwdnewenter.do")
public class PwdNewEnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdNewEnterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userEmail = request.getParameter("userEmail");
		String NewuserPwd = request.getParameter("NewuserPwd");
		String NewuserPwdConfirm = request.getParameter("NewuserPwdConfirm");
		
		System.out.println("sikim PwdNewEnterServlet userEmail : " + userEmail);
		System.out.println("sikim PwdNewEnterServlet NewuserPwd : " + NewuserPwd);
		System.out.println("sikim PwdNewEnterServlet NewuserPwdConfirm : " + NewuserPwdConfirm);
		
		String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
		System.out.println("메일로 보낸 인증코드 가져와 지니? : " + AuthenticationKey);
		String AuthenticationUser = request.getParameter("AuthenticationUser");
		System.out.println("입력한 인증코드도 가져와 지니? : " + AuthenticationUser);
		if(AuthenticationKey.equals(AuthenticationUser)) {
			if(NewuserPwd.equals(NewuserPwdConfirm)) {
				System.out.println("두개가 같아");
				Member m_Npwd = new Member();
				m_Npwd.setUserEmail(userEmail);
				m_Npwd.setUserPwd(NewuserPwd);
				
				MemberService ms = new MemberService();
				try {
					ms.passwordchange(m_Npwd);
					response.sendRedirect("index.jsp");
				}catch(MemberException e){
					request.setAttribute("msg", "회원정보 수정 중 에러 발생");
					request.setAttribute("exception", e);
					
					request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
				
				}
			}else {
				System.out.println("두개가 달라");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('두개가 달라'); history.go(-1);;</script>");
				out.flush();
			}
		}else {
			System.out.println("인증코드가  달라");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('인증코드가  달라'); history.go(-1);;</script>");
			out.flush();
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
