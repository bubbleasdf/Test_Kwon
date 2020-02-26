package com.kh.petner.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.member.model.vo.Member;
import com.kh.petner.member.pet.model.service.PetService;
import com.kh.petner.member.pet.model.vo.Pet;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/mpServlet.mp")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		HttpSession session = request.getSession(false);
		
		System.out.println("mpServlet페이지입니다.");
		
		if(session !=null) {
			System.out.println("session이 null이 아니다");
			//session이 있으면 멤버를 받아온다
			Member m = (Member)session.getAttribute("member");
			session.setAttribute("member", m);
			
			System.out.println("유저 권한은 : "+ m.getUserRoles());
			//만약 펫 등록이 되어 있는 상태라면 PET의 정보도 request에 담아서 같이 전달해 준다.
			if(m.getUserRoles() >9) {
				System.out.println("plist를 불러오러 if문으로 들어왔습니다.");
				ArrayList<Pet> plist = new PetService().ListPet(m.getUserEmail());
				session.setAttribute("plist", plist);
			}
			
			// 요렇게 다시 세션을 세팅해주면 항상 최신 정보로 마이페이지를 띄울수 있따.
			
			
		}else {
			// 로그인 정보가 없으면 
			response.sendRedirect("/PETNER/index.jsp");
		}
		
//		request.getRequestDispatcher("/views/member/mypage.jsp").forward(request, response);
		response.sendRedirect("/PETNER/views/member/mypage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
