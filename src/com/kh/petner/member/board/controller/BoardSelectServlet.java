package com.kh.petner.member.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.petner.member.board.model.service.mpBoardService;
import com.kh.petner.member.board.model.vo.mpBoard;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/bSelect.bo")
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		String bno_ = request.getParameter("bno");
		System.out.println("ㄴ머어온 bno 값 : "+bno_);
		int bno = Integer.parseInt(bno_);
		
		mpBoard b = null;
		b=new mpBoardService().selectBoard(bno);
		
		System.out.println("Servlet = return 받은 b : "+b);
		
		JSONObject result = new JSONObject();

		//필요한것만 넘기자 그럴려고 했는데그냥 생각하기 귀차나서 다 넘김
		
//		result.put("bno", b.getBno());
//		result.put("btype", b.getBtype());
//		result.put("btitle", b.getBtitle());
//		result.put("bcontent", b.getBcontent());
//		result.put("bwriter", b.getBwriter());
//		result.put("bcount", b.getBcount());
//		result.put("boardfile", b.getBoardfile());
//		result.put("bdate", b.getBdate());
//		result.put("status", b.getStatus());
//		result.put("starCount", b.getStarCount());
		

//		response.getWriter().print(result.toJSONString());
		new Gson().toJson(b ,response.getWriter());
		
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
