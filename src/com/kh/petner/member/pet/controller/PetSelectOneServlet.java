package com.kh.petner.member.pet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.member.pet.model.service.PetService;
import com.kh.petner.member.pet.model.vo.Pet;

/**
 * Servlet implementation class PetSelectOneServlet
 */
@WebServlet("/pSel.pe")
public class PetSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//권한 체크해서 펫이 등록된 경우만 가져오므로 펫이 있을것이다.
		String petName = request.getParameter("petName");
		
		System.out.println("PetSelectOneServlet에서 "+petName+"을 불러옵니다.");
		Pet p=null;
		p = new PetService().selectOne(petName);
		
		if(p!=null) {
			//성공 리퀘스트에 넣어서 돌려줌
			System.out.println("미션 석세스");
			request.setAttribute("p", p);
			
			//어디로 전송해주지?
			request.getRequestDispatcher("/views/member/PET/UpdatePet.jsp").forward(request, response);
		}else {
			//못 불러옴
			System.out.println("실패");
			request.setAttribute("msg", "펫을 불러오는데 실패했습니다.");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
