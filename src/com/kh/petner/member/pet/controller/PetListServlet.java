package com.kh.petner.member.pet.controller;

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
 * Servlet implementation class PetListServlet
 */
@WebServlet("/pList.pe")
public class PetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//펫을 불러올 멤버 정보를 가져온다
		HttpSession session=request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		//userEmail에 등록된 모든 펫을 가져온다.
		ArrayList<Pet> plist = new PetService().ListPet(m.getUserEmail());
		
		if(plist != null) {
			//성공
			System.out.println("리스트 불러옴");
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("/PETNER/views/").forward(request, response);
		}else {
			//실패
			System.out.println("리스트 못 불러옴");
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
