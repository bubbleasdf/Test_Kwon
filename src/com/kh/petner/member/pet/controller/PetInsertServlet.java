package com.kh.petner.member.pet.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.service.MemberService;
import com.kh.petner.member.model.vo.Member;
import com.kh.petner.member.pet.model.service.PetService;
import com.kh.petner.member.pet.model.vo.Pet;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/PInsert.pe")
public class PetInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PetInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("checked : "+(!ServletFileUpload.isMultipartContent(request)));
		
		System.out.println("request getContentType : " + request.getContentType());


		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
		
		int maxSize=1024*1024*10;
		String root = request.getServletContext().getRealPath("/");
		
		System.out.println("root : "+root);
		String savePath=root+"resources/img/member/pet";
		System.out.println("savePath : "+savePath);

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		
		String userEmail = mrequest.getParameter("userEmail");
		
		String petName=mrequest.getParameter("petName");
		String petType =mrequest.getParameter("petType");
		String petBirth_ =mrequest.getParameter("petBirth");
		String petProfile=mrequest.getParameter("petProfile");
//		int petWeight =Integer.parseInt(request.getParameter("petWeight"));
		String petWeight_=mrequest.getParameter("petWeight");

		System.out.println("받아온 petuserEmail : "+userEmail);
		System.out.println("받아온 petName : "+petName);
		System.out.println("받아온 petType : "+petType);
		System.out.println("받아온 petBirth : "+petBirth_);
		System.out.println("받아온 petProfile : "+petProfile);
		System.out.println("받아온 petWeight_ : "+petWeight_);
		
		
		int petWeight = Integer.parseInt(petWeight_);
		
		
		Date petBirth = null;
		
		if(petBirth_ !="" && petBirth_ != null) {
			//날짜가 입력됨
			String[] dateArr = petBirth_.split("-");
			int[] intArr=new int[dateArr.length];

			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}//for

			petBirth = new Date(new GregorianCalendar(intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());

		}else {	
			//날짜 입력안됨
			petBirth = new Date(new GregorianCalendar().getTimeInMillis());
		}//if else

		
		
		String petPic = mrequest.getFilesystemName("petPic");
		if(petPic == null) petPic="default.jpg";
		
		Pet p = new Pet(userEmail, petName, petType, petBirth, petProfile, petWeight, petPic);

		int result = new PetService().insertPet(p);

		if(result>0) {
			System.out.println("펫 등록 성공");

			//펫 등록이 성공하면 권한을 상승시켜 펫이 등록되어 있음을 표시해야 한다.
			
			//권한 바꾸는 서비스 실행
			HttpSession session = request.getSession();
			Member m = (Member)session.getAttribute("member");
			System.out.println("펫 등록성공 후 권한을 바꿔주기 위해 세션에서 받아온 멤버 : "+m);
			
			//권한이 10이하라면 +10을 해줘서 펫에 관한 권한을 준다.
			//권한이 10을 넘긴다면 굳이 권한을 주지 않아도 이미 권한을 가지고 있는 경우이다.
			if(m.getUserRoles()<10) {
				System.out.println("유저권한이 10미만이라서 권한 다시 설정");
				new MemberService().chMemberRoles(userEmail, (m.getUserRoles() +10));
				
				//다시 권한 설정
				m.setUserRoles(m.getUserRoles() +10);
				System.out.println("권한이 다시 설정된 m : "+m);
				session.setAttribute("member", m);
			}

			//마이페이지로 리다이렉트로 보냈는데 에러나면 로그인 서블릿으로 보내야댐
			response.sendRedirect("/PETNER/mpServlet.mp");
		}else {
			System.out.println("펫 등록 실패");
			request.setAttribute("msg", "등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
