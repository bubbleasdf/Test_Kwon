package com.kh.petner.member.board.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.petner.member.board.model.service.mpBoardService;
import com.kh.petner.member.board.model.vo.mpBoard;




/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/selectList.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		String type=request.getParameter("type");
		
		ArrayList<mpBoard> mplist = null;
		mpBoardService bs = new mpBoardService();
		
		int startPage, endPage, maxPage, currentPage=1, limit=6;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = bs.getListCount();
		System.out.println("총 페이지 개수 : "+listCount);
		
		maxPage=(int)((double)listCount/limit+0.9);
		
		startPage = ((int)((double)currentPage/limit +0.9)-1)*limit+1;
		endPage = startPage+limit-1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}//if
		
		mplist= bs.selectList(currentPage, limit, type);
		
//		JSONObject boardInfo = null;
//		JSONArray result = new JSONArray();
//		
//		for(mpBoard b : mplist) {
//			boardInfo = new JSONObject();
//			
//			System.out.println("for mplist : "+mplist);
//			System.out.println("for mpBoard b : "+b);
		
//			boardInfo.put("bno", b.getBno());
//			boardInfo.put("btype", b.getBtype());
//			boardInfo.put("btitle", b.getBtitle());
//			boardInfo.put("bcontent", b.getBcontent());
//			boardInfo.put("bwriter", b.getBwriter());
//			boardInfo.put("bcount", b.getBcount());
//			boardInfo.put("boardfile", b.getBoardfile());
//			boardInfo.put("bdate", b.getBdate());
//			boardInfo.put("status", b.getStatus());
//			
//			result.add(boardInfo);
//		}
//		
		
		new Gson().toJson(mplist,response.getWriter());
		
//		System.out.println("BoardListServlet for문 다 돌았어염");
//		response.getWriter().print(result.toJSONString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
