package com.kh.petner.market.model.service;

import static com.kh.petner.common.JDBCTemplate.close;
import static com.kh.petner.common.JDBCTemplate.commit;
import static com.kh.petner.common.JDBCTemplate.getConnection;
import static com.kh.petner.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.petner.market.model.dao.MarketDao;
import com.kh.petner.market.model.exception.MarketException;
import com.kh.petner.market.model.vo.AdminMain;
import com.kh.petner.market.model.vo.AuditLog;
import com.kh.petner.market.model.vo.HotelReserve;
import com.kh.petner.market.model.vo.Market;
import com.kh.petner.market.model.vo.MarketDetail;
import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.vo.Member;
import com.kh.petner.member.model.vo.MemberDetail;
import com.kh.petner.member.pet.model.vo.Pet;
import com.kh.petner.notice.model.vo.Faq;
import com.kh.petner.notice.model.vo.Notice;
import com.kh.petner.notice.model.vo.Qna;

public class MarketService {
	
	private MarketDao mDao = new MarketDao();

	/**
	 * 권구현
	 * 상점 추가
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int insertMarket(Market m) throws MarketException {
		System.out.println("[Service] insertMarket() 시작");
		Connection conn = getConnection();
		
		int result = mDao.insertMarket(conn, m);
		
		if(result > 0) {
			System.out.println("commit");
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		System.out.println("[Service] insertMarket() 종료 result = " + result);
		return result;
	}

	/**
	 * 권구현
	 * 상점 리스트 불러오기
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Market> selectMarketList() throws MarketException {
		System.out.println("[Service] selectMarketList() 시작");

		ArrayList<Market> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = mDao.selectMarketList(conn);
		
		close(conn);
		System.out.println("[Service] selectMarketList() 종료");

		return list;
	}

	/**
	 * 마켓 하나 정보 불러오기 ㅡ> 수정하기
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public Market selectOne(int marketId) throws MarketException {
		System.out.println("[Service] selectOne() 시작 marketId : " + marketId);
		Connection conn = getConnection();
		
		Market m = mDao.selectOne(conn, marketId);
		
		close(conn);

		System.out.println("[Service] selectOne() 종료 m : " + m);
		return m;
	}

	/**
	 * 마켓 정보 수정
	 * @param m
	 * @return
	 * @throws MarketException 
	 */
	public int updateMarket(Market m) throws MarketException {
		System.out.println("[Service] updateMarket() 시작 " + m);
		Connection conn = getConnection();
		
		int result = mDao.updateMarket(conn, m);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * 마켓 삭제
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public int deleteMarket(int marketId, String status) throws MarketException {
		System.out.println("[Service] deleteMarket() 시작");
		
		Connection conn = getConnection();
		
		int result = mDao.deleteMarket(conn, marketId, status);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * 유저 리스트 생성
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Member> selectUserList() throws MarketException {
		System.out.println("[Service] 유저 리스트 시작");
		ArrayList<Member> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.selectUserList(conn);
		
		close(conn);
		
		System.out.println("[service] 유저 리스트 종료");
		return list;
	}

	/**
	 * 권구현
	 * 2020. 2. 7.
	 * countMarket : 메인페이지에서 각 상점 카운트 세기
	 * @return
	 * @throws MarketException 
	 */
	public AdminMain countMarket() throws MarketException {
		AdminMain am = new AdminMain();
		
		Connection conn = getConnection();
		
		am = mDao.countMarket(conn);
		
		close(conn);
		
		return am;
	}

	/**
	 * 권구현
	 * 2020.02.07
	 * 호텔 예약 목록을 테이블로 보여줍니다.
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<HotelReserve> reserveList() throws MarketException {
		ArrayList<HotelReserve> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = mDao.reserveList(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 매장 종류별로 불러오기
	 * 권구현 2020.02.08
	 * @param market_type
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Market> selectType(String marketType) throws MarketException {
		ArrayList<Market> list= new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.selectType(conn, marketType);
		
		close(conn);
		
		return list;
	}

	/**
	 * 펫 리스트 불러오기
	 * 권구현 2020.02.11
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Pet> petList() throws MarketException {
		ArrayList<Pet> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.petList(conn);
		
		close(conn);
		
		return list;
	}

	/**
	 * NOTICE 리스트 불러오기
	 * 권구현 2020.02.11
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Notice> noticeList() throws MarketException {
		ArrayList<Notice> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.noticeList(conn);
		
		close(conn);
		
		return list;
	}

	/**
	 * QNA 리스트 불러오기
	 * 권구현 2020.02.11
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Qna> qnaList() throws MarketException {
		ArrayList<Qna> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.qnaList(conn);
		
		close(conn);
		
		return list;
	}

	/**
	 * marketDetail 화면 불러오기
	 * 권구현 2020.02.12
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public MarketDetail selectMarketDetail(int marketId) throws MarketException {
		MarketDetail md = null;
		Connection conn = getConnection();
		
		md = mDao.selectMarketDetail(conn, marketId);
		
		if(md == null) {
			md = mDao.selectmarketDetailOne(conn, marketId);
		}
		
		close(conn);
		
//		if(md.getMarketSub().equals("null")) {
//			md.setMarketSub("");
//		}
		
//		if(md.getMarketSub()==null) {
//			md.setMarketSub("");
//		}
//		if(md.getMarketBus()==null) {
//			md.setMarketBus("");
//		}
//		if(md.getMarketCar()==null) {
//			md.setMarketCar("");
//		}
		
		
		return md;
	}

	/**
	 * marketDetail 업데이트 합니다
	 * 권구현 2020.02.12
	 * @param md
	 * @return
	 * @throws MarketException 
	 */
	public int updateMarketDetail(MarketDetail md) throws MarketException {
		int result = 0; 
		Connection conn = getConnection();
		
		result = mDao.updateMarketDetail(conn, md);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * 디테일에 Id가 있으면 지워버립니다~
	 * @param md
	 * @return
	 * @throws MarketException 
	 */
	public int deleteDetailMarket(MarketDetail md) throws MarketException {
		int result = 0;
		Connection conn = getConnection();
		
		result = mDao.deleteDetailMarket(conn, md);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * ADMIN 에서 NOTICE 하나 보여주기
	 * 권구현 2020.02.13
	 * @return
	 * @throws MarketException 
	 */
	public Notice noticeSelectOne(int nno) throws MarketException {
		Connection conn = getConnection();
		
		Notice n = mDao.noticeSelectOne(conn, nno);

		return n;
	}

	/**
	 * 마켓을 등록하면 바로 멤버에도 추가해주는거
	 * 권구현
	 * @param m
	 * @return
	 * @throws MarketException 
	 */
	public int insertMarketToMember(Market m) throws MarketException {
		int result = 0;
		Connection conn = getConnection();
		
		result = mDao.insertMarketToMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/**
	 * 유저 1명의 정보 가져오기
	 * 권구현 2020.02.14
	 * @param userEmail
	 * @return
	 * @throws MarketException 
	 */
	public MemberDetail selectUserOne(String userEmail) throws MarketException {
		MemberDetail md = new MemberDetail();
		Connection conn = getConnection();
		
		md = mDao.selectUserOne(conn, userEmail);
		
		close(conn);
		
		if(md.getUserRoles() == 0) {
			md.setUserRoleName("일반회원");
		} else if(md.getUserRoles() == 200) {
			md.setUserRoleName("매장회원");
		} else if(md.getUserRoles() == 777) {
			md.setUserRoleName("관리자");
		} else {
			md.setUserRoleName("미확인");
		}
		
		return md;
	}

	/**
	 * 예약 상세페이지 호출
	 * 권구현 2020.02.15
	 * @param rsvId
	 * @return
	 * @throws MarketException 
	 */
	public HotelReserve selectReserveOne(int rsvId) throws MarketException {
		HotelReserve hr = new HotelReserve();
		Connection conn = getConnection();
		
		hr = mDao.selectReserveOne(conn, rsvId);
		
		close(conn);
		
		
		return hr;
	}

	/**
	 * 펫 하나 조회하여 디테일로 접속
	 * 권구현 2020.02.16
	 * @param petId
	 * @return
	 * @throws MarketException 
	 */
	public Pet petSelectOne(int petId) throws MarketException {
		Pet pet = new Pet();
		Connection conn = getConnection();
		
		pet = mDao.petSelectOne(conn, petId);
		
		close(conn);
		
		return pet;
	}

	/**
	 * QNA 하나 조회해서 보여주기
	 * @param qno
	 * @return
	 * @throws MarketException 
	 */
	public Qna qnaSelectOne(int qno) throws MarketException {
		Qna q = new Qna();
		Connection conn = getConnection();
		
		q = mDao.qnaSelectOne(conn, qno);
		
		close(conn);
		
		return q;
	}

	/**
	 * 지도 좌표를 구하기 위한 주소 불러오기
	 * @param marketId
	 * @return
	 * @throws MarketException
	 */
	public String selectMarketAddress(int marketId) throws MarketException {
		Connection conn = getConnection();
		
		String address = mDao.selectMarketAddress(conn, marketId);
		
		close(conn);
		
		return address;
	}

	/**
	 * FAQ 리스트 불러오기
	 * @return
	 * @throws MarketException
	 */
	public ArrayList<Faq> faqList() throws MarketException {
		ArrayList<Faq> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.faqList(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 김혜림
	 * 가게 상세 보기
	 * @param mid
	 * @return
	 */
	public Market MarketIn(int marketId) {
		Connection con = getConnection();
		
		Market mk = mDao.MarketIn(con, marketId);
		
		close(con);
		return mk;
	}

	/**
	 * 김혜림
	 * 가게 상세 정보 보기
	 * @param mid
	 * @return
	 */
	public MarketDetail marketmd(int mid) {
		Connection con = getConnection();
		
		MarketDetail md = mDao.marketmd(con, mid);
		
		close(con);
		return md;
	}
	
	
	
	
	

	/**
	 * FAQ 불러오기
	 * 권구현 2020.02.18
	 * @param fno
	 * @return
	 * @throws MarketException
	 */
	public Faq faqSelectOne(int fno) throws MarketException {
		Faq f = new Faq();
		Connection conn = getConnection();
		
		f = mDao.faqSelectOne(conn, fno);
		
		close(conn);
		
		return f;
	}

	/**
	 * 로그 불러오기
	 * 권구현 2020.02.18
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<AuditLog> selectLogList() throws MarketException {
		ArrayList<AuditLog> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = mDao.selectLogList(conn);
		
		return list;
	}

	public ArrayList<HotelReserve> mReserveList(String userEmail) throws MarketException {
		ArrayList<HotelReserve> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = mDao.mReserveList(conn,userEmail);
		
		close(conn);
		System.out.println("mReserveList list : "+list);
		return list;
	}

	
}
