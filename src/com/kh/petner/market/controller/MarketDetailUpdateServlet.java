package com.kh.petner.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.MarketDetail;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MarketDetailUpdateServlet
 */
@WebServlet("/updateMarketDetail.ad")
public class MarketDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketDetailUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 위한 사전 준비작업 //
		int maxSize = 1024*1024*10;
		
		System.out.println("[Servlet] marketDetailUpdate() 시작");
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "Multipart를 통한 파일 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		String root = request.getServletContext().getRealPath("/"); // 최상위 폴더 위치 지정
		String savePath = root + "resources/adminUploadFiles";
		
		// 멀티 리퀘스트 생성
		MultipartRequest mrequest = new MultipartRequest(
										request,
										savePath,
										maxSize,
										"UTF-8",
										new DefaultFileRenamePolicy()
										);
				
		// ----------- 준비 끝 컨트롤러 시작 --------------------//
		MarketService ms = new MarketService();
		MarketDetail md = new MarketDetail();
		
		System.out.println("여기까진 돌아갑니다 11111111111");
		
		String test1 = "";
		int marketId = Integer.parseInt(mrequest.getParameter("marketId"));
		String marketName = mrequest.getParameter("marketName");
		String marketCheck = "";
		if(mrequest.getParameterValues("marketCheckData") != null) {
			marketCheck = String.join(", ", mrequest.getParameterValues("marketCheckData"));
		} else {
			marketCheck = "";
		}
		
		String marketSubPhoto01 = mrequest.getFilesystemName("marketSubPhoto01");
		String marketSubPhoto02 = mrequest.getFilesystemName("marketSubPhoto02");
		String marketSubPhoto03 = mrequest.getFilesystemName("marketSubPhoto03");
		String marketSub = mrequest.getParameter("marketSub");
		String marketBus = mrequest.getParameter("marketBus");
		String marketCar = mrequest.getParameter("marketCar");
		
		// 강제 형변환을 하려면 값이 있어야 하는데 null이 들어오면 null point exception이 뜬다.. For input string = "" 이런 에러코드와 함께
		int marketPrice = 0;
		if(test1.equals(mrequest.getParameter("marketPrice"))) {
			marketPrice = 0;
		} else {
			marketPrice = Integer.parseInt(mrequest.getParameter("marketPrice"));

		}
		String marketIntro = mrequest.getParameter("marketIntro");

		double mapx = 0;
		if(mrequest.getParameter("mapx") != null) {
			mapx = Double.parseDouble(mrequest.getParameter("mapx"));
		}
		double mapy = 0;
		if(mrequest.getParameter("mapy") != null) {
			mapy = Double.parseDouble(mrequest.getParameter("mapy"));
		}
		System.out.println("mapx : " + mapx);
		
		md.setMarketId(marketId);
		md.setMarketName(marketName);
		md.setMarketCheck(marketCheck);
		md.setMarketSubPhoto01(marketSubPhoto01);
		md.setMarketSubPhoto02(marketSubPhoto02);
		md.setMarketSubPhoto03(marketSubPhoto03);
		md.setMarketSub(marketSub);
		md.setMarketBus(marketBus);
		md.setMarketCar(marketCar);
		md.setMarketPrice(marketPrice);
		md.setMarketIntro(marketIntro);
		md.setMapx(mapx);
		md.setMapy(mapy);
		System.out.println("X좌표 : " + md.getMapx());
		System.out.println("Y좌표 : " + md.getMapy());
		
//		System.out.println("[Servlet] MarketDetail : " + md);
		
		// 만약 검색해서 Market_ID값이 있으면 그 컬럼을 삭제하고 시작해야겠다
		
		try {
			int delResult = ms.deleteDetailMarket(md);
		} catch (MarketException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("이제 여기가 들어가야 합니다!!!!!!!!!!!!!!");
		try {
			int result = ms.updateMarketDetail(md);
			response.sendRedirect("/PETNER/marketList.ad");
		} catch (MarketException e) {
			request.setAttribute("msg", "상점 세부정보 수정 실패");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
