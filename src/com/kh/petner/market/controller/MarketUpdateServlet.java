package com.kh.petner.market.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.service.MarketService;
import com.kh.petner.market.model.vo.Market;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MarketUpdateServlet
 */
@WebServlet("/updateMarket.ad")
public class MarketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 위한 사전 준비작업 //
				int maxSize = 1024*1024*10;
				
				System.out.println("[Servlet] marketUpdate() 시작");
				
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
				
				// 전송값 처리
				int marketId = Integer.parseInt(mrequest.getParameter("marketId"));
				String marketName = mrequest.getParameter("marketName");
				String marketPwd = mrequest.getParameter("marketPwd");
				String marketEmail = mrequest.getParameter("marketEmail");
				String marketType = mrequest.getParameter("marketType");
				String marketTel = mrequest.getParameter("marketTel");
				String marketCellPhone = mrequest.getParameter("marketCellPhone");
				String marketAddress = mrequest.getParameter("marketAddress");
				String marketPlace = mrequest.getParameter("marketPlace");
				String marketMainPhoto = mrequest.getFilesystemName("marketMainPhoto");
				
				
				Market m = new Market();
				m.setMarketId(marketId);
				m.setMarketName(marketName);
				m.setMarketPwd(marketPwd);
				m.setMarketEmail(marketEmail);
				m.setMarketType(marketType);
				m.setMarketTel(marketTel);
				m.setMarketCellPhone(marketCellPhone);
				m.setMarketAddress(marketAddress);
				m.setMarketPlace(marketPlace);
				m.setMarketMainPhoto(marketMainPhoto);
				
				System.out.println("Servlet MarketInsert : " + m);
				
				
				try {
					String enPassword = "";
					String mixPassword = marketPwd;
					MessageDigest messageDigest = null;
					try {
						MessageDigest md = MessageDigest.getInstance("SHA-512");
						byte[] bytes = marketPwd.getBytes(Charset.forName("UTF-8"));
						md.update(bytes);
						
						enPassword =  Base64.getEncoder().encodeToString(md.digest());
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					m.setMarketPwd(enPassword);
					
					int result = new MarketService().updateMarket(m);
					response.sendRedirect("/PETNER/marketList.ad");

				} catch (MarketException e) {
					request.setAttribute("msg", "상점 정보수정 실패");
					request.setAttribute("exception", e);
					request.getRequestDispatcher("views/common/errorPage.jsp");
					
				}
				
				System.out.println("[Servlet] marketUpdate() 종료");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
