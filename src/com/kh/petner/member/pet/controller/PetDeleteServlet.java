package com.kh.petner.member.pet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.service.MemberService;
import com.kh.petner.member.model.vo.Member;
import com.kh.petner.member.pet.model.service.PetService;
import com.kh.petner.member.pet.model.vo.Pet;


@WebServlet("/pDelete.pe")
public class PetDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public PetDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String petName = request.getParameter("petName");
		
		
		int result=0;
		result = new PetService().deletePet(petName);
		
		
		if(result>0) {
			System.out.println("펫 삭제 미션 석세스");
			
			//펫이 없으면 권한도 낮춰야 하므로 검사하는 부분
			HttpSession session = request.getSession();
			Member m = (Member)session.getAttribute("member");
			
			ArrayList<Pet> plist = new PetService().ListPet(m.getUserEmail());
					
			System.out.println("펫 등록성공 후 권한을 바꿔주기 위해 세션에서 받아온 멤버 : "+m);
			int petNum = new PetService().countPet(m.getUserEmail());
			
			//권한이 10이하라면 +10을 해줘서 펫에 관한 권한을 준다.
			//권한이 10을 넘긴다면 굳이 권한을 주지 않아도 이미 권한을 가지고 있는 경우이다.
			if(petNum == 0) {
				new MemberService().chMemberRoles(m.getUserEmail(), (m.getUserRoles() -10));
				
				m.setUserRoles((m.getUserRoles() -10));
				System.out.println("삭제후 변경된 권한 확인 : "+m);
				
				//다시 불러온 멤버를 세션에 보관한다.
				session.setAttribute("member", m);
			}
			
			
			response.sendRedirect("/PETNER/mpServlet.mp");			
			

		}else {
			System.out.println("펫 삭제 실패");
			request.setAttribute("msg", "펫 삭제 수행 중 에러 발생!");
			request.setAttribute("exception", null);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
