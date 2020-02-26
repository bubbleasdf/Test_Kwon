package com.kh.petner.market.model.dao;

import static com.kh.petner.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

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

public class MarketDao {
	
	private Properties prop;
	
	public MarketDao() {
		prop = new Properties();
		
		String filePath = MarketDao.class.getResource("/config/market-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 매장 추가
	 * @param conn
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int insertMarket(Connection conn, Market m) throws MarketException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMarket");
		System.out.println("Dao Market:" + m);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMarketName());
			pstmt.setString(2, m.getMarketPwd());
			pstmt.setString(3, m.getMarketEmail());
			pstmt.setString(4, m.getMarketType());
			pstmt.setString(5, m.getMarketTel());
			pstmt.setString(6, m.getMarketCellPhone());
			pstmt.setString(7, m.getMarketAddress());
			pstmt.setString(8, m.getMarketPlace());
			pstmt.setString(9, m.getMarketMainPhoto());
			
			result = pstmt.executeUpdate();
			System.out.println("[Dao] insertMarket : " + result);
			
		} catch(Exception e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		
		String doit = "Insert";
		String methodName = "insertMarket";
		auditLog(conn, methodName, sql, doit);
		
		
		return result;
	}

	/**
	 * 권구현
	 * 상점 리스트 출력
	 * @param conn
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Market> selectMarketList(Connection conn) throws MarketException {
		System.out.println("[Dao] selectList() 시작");
		ArrayList<Market> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMarketList");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Market>();
			
			while(rset.next()) {
				
				Market m = new Market();
				
				m.setMarketId(rset.getInt("MARKET_ID"));
				m.setMarketName(rset.getString("MARKET_NAME"));
				m.setMarketPwd(rset.getString("MARKET_PASSWORD"));
				m.setMarketEmail(rset.getString("MARKET_EMAIL"));
				m.setMarketType(rset.getString("MARKET_TYPE"));
				m.setMarketTel(rset.getString("MARKET_TEL"));
				m.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
				m.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				m.setEnDate(rset.getDate("ENDATE"));
				m.setStatus(rset.getString("STATUS"));
				
				list.add(m);
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("[Dao] selectMarketList() 종료");

		return list;
	}

	/**
	 * 마켓 정보 하나 불러오기
	 * @param conn
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public Market selectOne(Connection conn, int marketId) throws MarketException {
		System.out.println("[Dao] selectOne() 시작 marketId : " + marketId);
		Market m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, marketId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Market();
				
				m.setMarketId(rset.getInt("MARKET_ID"));
				m.setMarketName(rset.getString("MARKET_NAME"));
				m.setMarketPwd(rset.getString("MARKET_PASSWORD"));
				m.setMarketEmail(rset.getString("MARKET_EMAIL"));
				m.setMarketType(rset.getString("MARKET_TYPE"));
				m.setMarketTel(rset.getString("MARKET_TEL"));
				m.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
				m.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				m.setEnDate(rset.getDate("ENDATE"));
				m.setStatus(rset.getString("STATUS"));
				m.setMarketPlace(rset.getString("MARKET_PLACE"));
			}
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("[Dao] selectOne() 종료 " + m);
		return m;
	}

	/**
	 * 마켓 정보 수정
	 * @param conn
	 * @param m
	 * @return
	 * @throws MarketException 
	 */
	public int updateMarket(Connection conn, Market m) throws MarketException {
		System.out.println("[Dao] updateMarket() :" + m);
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMarket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMarketName());
			pstmt.setString(2, m.getMarketPwd());
			pstmt.setString(3, m.getMarketEmail());
			pstmt.setString(4, m.getMarketType());
			pstmt.setString(5, m.getMarketTel());
			pstmt.setString(6, m.getMarketCellPhone());
			pstmt.setString(7, m.getMarketAddress());
			pstmt.setString(8, m.getMarketPlace());
			pstmt.setString(9, m.getMarketMainPhoto());
			pstmt.setInt(10, m.getMarketId());

			result = pstmt.executeUpdate();
			System.out.println("[Dao] 결과 : " + result);
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 마켓 삭제
	 * @param conn
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public int deleteMarket(Connection conn, int marketId, String status) throws MarketException {
		System.out.println("[Dao] deleteMarket()");
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMarket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, status);
			pstmt.setInt(2, marketId);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 유저 리스트 출력
	 * @param conn
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Member> selectUserList(Connection conn) throws MarketException {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUserList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserName(rset.getString("USER_NAME"));
				m.setUserEmail(rset.getString("USER_EMAIL"));
				m.setUserPhone(rset.getString("USER_PHONE"));
				m.setEnDate(rset.getDate("USER_ENDATE"));
				m.setUserRoles(rset.getInt("USER_ROLES"));
				if(m.getUserRoles() == 0) {
					m.setUserRolesName("일반회원");
				} else if(m.getUserRoles() == 200) {
					m.setUserRolesName("매장회원");
				} else if(m.getUserRoles() == 777) {
					m.setUserRolesName("관리자");
				} else {
					m.setUserRolesName("미확인");
				}

				
				list.add(m);
			}

			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	/**
	 * Admin 메인 페이지 시작하기위한 페이지(마켓 숫자 각각 받아오기) + 접속자 수 받아오기
	 * @param conn
	 * @return
	 * @throws MarketException 
	 */
	public AdminMain countMarket(Connection conn) throws MarketException {
		AdminMain am = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("countMarket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				am = new AdminMain();
				
				am.setSumMarket(rset.getInt(1));
				am.setHotel(rset.getInt(2));
				am.setBeauty(rset.getInt(3));
				am.setHospital(rset.getInt(4));
				am.setSumMember(rset.getInt(5));
				am.setTotalCnt(rset.getInt(6));
				am.setTodayCnt(rset.getInt(7));
				am.setOneAgo(rset.getInt(8));
				am.setTwoAgo(rset.getInt(9));
				am.setThreeAgo(rset.getInt(10));
				am.setFourAgo(rset.getInt(11));
				am.setFiveAgo(rset.getInt(12));
				am.setSixAgo(rset.getInt(13));
				am.setRsvCnt(rset.getInt(14));
				am.setPetCnt(rset.getInt(15));
				
				System.out.println(am);
			}
				
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return am;
	}

	/**
	 * 예약 리스트 출력용
	 * @param conn
	 * @return
	 */
	public ArrayList<HotelReserve> reserveList(Connection conn) throws MarketException  {
		ArrayList<HotelReserve> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reserveList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				HotelReserve hr = new HotelReserve();
				hr.setReserveId(rset.getInt("RESERVE_ID"));
				hr.setMarketId(rset.getInt("MARKET_ID"));
				hr.setUserEmail(rset.getString("USER_EMAIL"));
				hr.setUserName(rset.getString("USER_NAME"));
				hr.setUserPhone(rset.getString("USER_PHONE"));
				hr.setS_date(rset.getDate("S_DATE"));
				hr.setE_date(rset.getDate("E_DATE"));
				hr.setMarketPrice(rset.getInt("MARKET_PRICE"));
				hr.setMarketName(rset.getString("MARKET_NAME"));
				hr.setMarketPhone(rset.getString("MARKET_TEL"));
				hr.setPetId(rset.getInt("PET_ID"));
				hr.setPetName(rset.getString("PET_NAME"));
				hr.setPetType(rset.getString("PET_TYPE"));
				hr.setStatus(rset.getString("STATUS"));
				hr.setTerm(rset.getInt("TERM"));
				
				list.add(hr);
				
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * 매장 종류별로 불러오기
	 * 권구현 2020.02.08
	 * @param conn
	 * @param market_type
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Market> selectType(Connection conn, String marketType) throws MarketException {
		ArrayList<Market> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectType");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, marketType);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				Market m = new Market();
				
				m.setMarketId(rset.getInt("MARKET_ID"));
				m.setMarketName(rset.getString("MARKET_NAME"));
				m.setMarketPwd(rset.getString("MARKET_PASSWORD"));
				m.setMarketEmail(rset.getString("MARKET_EMAIL"));
				m.setMarketType(rset.getString("MARKET_TYPE"));
				m.setMarketTel(rset.getString("MARKET_TEL"));
				m.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
				m.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				m.setEnDate(rset.getDate("ENDATE"));
				m.setStatus(rset.getString("STATUS"));
				
				list.add(m);
			
			}
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}

		
		return list;
	}

	/**
	 * 펫 리스트 불러오기 
	 * 권구현 2020.02.11
	 * @param conn
	 * @return
	 */
	public ArrayList<Pet> petList(Connection conn) throws MarketException {
		ArrayList<Pet> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("petList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Pet p = new Pet();
				p.setPetId(rset.getInt("PET_ID"));
				p.setPetName(rset.getString("PET_NAME"));
				p.setUserEmail(rset.getString("USER_EMAIL"));
				p.setPetType(rset.getString("PET_TYPE"));
				p.setPetProfile(rset.getString("PET_PROFILE"));
				p.setPetWeight(rset.getInt("PET_WEIGHT"));
				p.setPetBirth(rset.getDate("PET_BIRTH"));
				p.setPetDate(rset.getDate("PET_ENDATE"));
				p.setPetPic(rset.getString("PET_PIC"));
				p.setPetTop(rset.getString("PET_TOP"));
				
				list.add(p);
			}
				
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	/**
	 * NOTICE 리스트 불러오기
	 * 권구현 2020.02.11
	 * @param conn
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Notice> noticeList(Connection conn) throws MarketException {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNno(rset.getInt("NNO"));
				n.setNemail(rset.getString("NEMAIL"));
				n.setNtitle(rset.getString("NTITLE"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnCount(rset.getInt("NCOUNT"));
				n.setNdate(rset.getDate("NDATE"));
				
				list.add(n);
			}
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * QNA 불러오기
	 * @param conn
	 * @return
	 * @throws MarketException
	 */
	public ArrayList<Qna> qnaList(Connection conn) throws MarketException {
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("qnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Qna q = new Qna();
				q.setQno(rset.getInt("QNO"));
				q.setQtitle(rset.getString("QTITLE"));
				q.setQcontent(rset.getString("QCONTENT"));
				q.setQemail(rset.getString("QEMAIL"));
				q.setNdate(rset.getDate("QDATE"));
				
				list.add(q);
			}
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	/**
	 * 마켓 디테일 불러오기
	 * 권구현 2020.02.12
	 * @param conn
	 * @param marketId
	 * @return
	 * @throws MarketException
	 */
	public MarketDetail selectMarketDetail(Connection conn, int marketId) throws MarketException {
		MarketDetail md = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectDetailMarket");
		ResultSet rset = null;
		
		System.out.println("Dao selectMarketDetail marketId : " + marketId);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, marketId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				md = new MarketDetail();

				md.setMarketId(rset.getInt("MARKET_ID"));
				md.setMarketName(rset.getString("MARKET_NAME"));
				md.setMarketCheck(rset.getString("MARKET_CHECK"));
				md.setMarketSubPhoto01(rset.getString("MARKET_SUBPHOTO_01"));
				md.setMarketSubPhoto02(rset.getString("MARKET_SUBPHOTO_02"));
				md.setMarketSubPhoto03(rset.getString("MARKET_SUBPHOTO_03"));
				md.setMarketSub(rset.getString("MARKET_SUB"));
				md.setMarketBus(rset.getString("MARKET_BUS"));
				md.setMarketCar(rset.getString("MARKET_CAR"));
				md.setMarketPrice(rset.getInt("MARKET_PRICE"));
				md.setMarketIntro(rset.getString("MARKET_INTRO"));
				md.setMapx(rset.getDouble("MAP_X"));
				md.setMapy(rset.getDouble("MAP_Y"));
				
				System.out.println("Dao selectMarketDetail : " + md);
				
			}
						
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return md;
	}

	/**
	 * 마켓 디테일에 값이 없으면 Market 테이블에서 ID와 이름 갖고오기
	 * @param conn
	 * @param marketId
	 * @return
	 * @throws MarketException
	 */
	public MarketDetail selectmarketDetailOne(Connection conn, int marketId) throws MarketException {
		MarketDetail md = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOne");
		ResultSet rset = null;
		System.out.println("[Dao] SelectmarketDetailOne 의 MarketId : " + marketId);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, marketId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				md = new MarketDetail();

				md.setMarketId(rset.getInt("MARKET_ID"));
				md.setMarketName(rset.getString("MARKET_NAME"));
				System.out.println(md);
				
			}
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return md;
	}

	/**
	 * Market Detail Update
	 * Kwon 2020.02.12
	 * @param conn
	 * @param md
	 * @return
	 * @throws MarketException 
	 */
	public int updateMarketDetail(Connection conn, MarketDetail md) throws MarketException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMarketDetail");
		
		System.out.println("디테일 추가 다오!!!!!!! 여기가 들어가라!!!!!!!!!!!");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, md.getMarketId());
			pstmt.setString(2, md.getMarketName());
			pstmt.setString(3, md.getMarketCheck());
			pstmt.setString(4, md.getMarketSubPhoto01());
			pstmt.setString(5, md.getMarketSubPhoto02());
			pstmt.setString(6, md.getMarketSubPhoto03());
			pstmt.setString(7, md.getMarketSub());
			pstmt.setString(8, md.getMarketBus());
			pstmt.setString(9, md.getMarketCar());
			pstmt.setInt(10, md.getMarketPrice());
			pstmt.setString(11, md.getMarketIntro());
			pstmt.setDouble(12, md.getMapx());
			pstmt.setDouble(13, md.getMapy());
			
			result = pstmt.executeUpdate();
			
			System.out.println("다오 디테일 추가 결과  : " + result);
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/**
	 * marketDetail 지우기
	 * @param conn
	 * @param md
	 * @return
	 * @throws MarketException 
	 */
	public int deleteDetailMarket(Connection conn, MarketDetail md) throws MarketException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteDetail"); // 이건 재사용 가능하겠네
		System.out.println("[Dao]deleteDetailMarket 시작");
		System.out.println("[Dao]MarketId : " + md.getMarketId());
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, md.getMarketId());
			
			result = pstmt.executeUpdate();
			System.out.println("Dao 결과 : " + result);
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * Notice 1개 리턴 -> ADMIN
	 * @param conn
	 * @param nno
	 * @return
	 * @throws MarketException 
	 */
	public Notice noticeSelectOne(Connection conn, int nno) throws MarketException {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeSelectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				n.setNno(nno);
				n.setNemail(rset.getString("NEMAIL"));
				n.setNtitle(rset.getString("NTITLE"));
				n.setnContent(rset.getString("NCONTENT"));
				n.setnCount(rset.getInt("NCOUNT"));
				n.setNdate(rset.getDate("NDATE"));
				
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	
	/**
	 * 마켓을 추가하면 User테이블에도 추가해줍니다
	 * @param m
	 * @return
	 * @throws MarketException 
	 */
	public int insertMarketToMember(Connection conn, Market m) throws MarketException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("marketToMember");
		System.out.println("DAO market to member의 MARKET : " + m);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMarketName());
			pstmt.setString(2, m.getMarketEmail());
			pstmt.setString(3, m.getMarketPwd());
			pstmt.setString(4, m.getMarketTel());
			
			result = pstmt.executeUpdate();
			System.out.println("DAO market to member 결과 : " + result);
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/**
	 * 유저 상세보기
	 * @param conn
	 * @param userEmail
	 * @return
	 * @throws MarketException
	 */
	public MemberDetail selectUserOne(Connection conn, String userEmail) throws MarketException {
		MemberDetail md = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUserOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				md = new MemberDetail();
				
				md.setUserName(rset.getString("USER_NAME"));
				md.setUserEmail(rset.getString("USER_EMAIL"));
				md.setUserPhone(rset.getString("USER_PHONE"));
				md.setUserRoles(rset.getInt("USER_ROLES"));
				md.setEnDate(rset.getDate("USER_ENDATE"));
				md.setPetName(rset.getString("PET_NAME"));
				md.setPetProfile(rset.getString("PET_PROFILE"));
				md.setPetType(rset.getString("PET_TYPE"));
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return md;
		
	}

	/**
	 * 예약 상세페이지 불러오기
	 * @param conn
	 * @param rsvId
	 * @return
	 * @throws MarketException 
	 */
	public HotelReserve selectReserveOne(Connection conn, int rsvId) throws MarketException {
		HotelReserve hr = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserveOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rsvId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				hr = new HotelReserve();
				
				hr.setReserveId(rset.getInt("RESERVE_ID"));
				hr.setMarketId(rset.getInt("MARKET_ID"));
				hr.setUserEmail(rset.getString("USER_EMAIL"));
				hr.setUserName(rset.getString("USER_NAME"));
				hr.setUserPhone(rset.getString("USER_PHONE"));
				hr.setS_date(rset.getDate("S_DATE"));
				hr.setE_date(rset.getDate("E_DATE"));
				hr.setMarketName(rset.getString("MARKET_NAME"));
				hr.setMarketPhone(rset.getString("MARKET_TEL"));
				hr.setMarketPrice(rset.getInt("MARKET_PRICE"));
				hr.setPetId(rset.getInt("PET_ID"));
				hr.setPetName(rset.getString("PET_NAME"));
				hr.setPetType(rset.getString("PET_TYPE"));
				hr.setStatus(rset.getString("STATUS")); // 상태(예약완료, 결제완료 등)
				hr.setTerm(rset.getInt("TERM")); // 총 기간
				
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hr;
	}

	/**
	 * 펫 상세페이지 출력
	 * 권구현 2020.02.16
	 * @param conn
	 * @param petId
	 * @return
	 * @throws MarketException
	 */
	public Pet petSelectOne(Connection conn, int petId) throws MarketException {
		Pet pet = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("petSelectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, petId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pet = new Pet();
				
				pet.setUserEmail(rset.getString("USER_EMAIL"));
				pet.setPetName(rset.getString("PET_NAME"));
				pet.setPetType(rset.getString("PET_TYPE"));
				pet.setPetBirth(rset.getDate("PET_BIRTH"));
				pet.setPetProfile(rset.getString("PET_PROFILE"));
				pet.setPetWeight(rset.getInt("PET_WEIGHT"));
				pet.setPetPic(rset.getString("PET_PIC"));
				pet.setPetTop(rset.getString("PET_TOP"));
				pet.setPetId(rset.getInt("PET_ID"));
				pet.setPetDate(rset.getDate("PET_ENDATE"));
				
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pet;
	}

	/**
	 * QNA 상세페이지 출력
	 * 권구현 2020.02.17
	 * @param conn
	 * @param qno
	 * @return
	 * @throws MarketException
	 */
	public Qna qnaSelectOne(Connection conn, int qno) throws MarketException {
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("qnaSelectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna();
				
				q.setQno(qno);
				q.setQemail(rset.getString("QEMAIL"));
				q.setQtitle(rset.getString("QTITLE"));
				q.setQcontent(rset.getString("QCONTENT"));
				q.setNdate(rset.getDate("QDATE"));
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
	}

	/**
	 * x,y 좌표를 위한 주소 받아오기 
	 * @param conn
	 * @param marketId
	 * @return
	 * @throws MarketException 
	 */
	public String selectMarketAddress(Connection conn, int marketId) throws MarketException {
		String address = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMarketAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, marketId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				address = rset.getString(1);
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return address;
	}
	

	/**
	 * faq 리스트 불러오기
	 * @param conn
	 * @return
	 * @throws MarketException 
	 */
	public ArrayList<Faq> faqList(Connection conn) throws MarketException {
		ArrayList<Faq> list = new ArrayList<>();
		Faq f = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("faqList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				f = new Faq();
				f.setFno(rset.getInt("FNO"));
				f.setfType(rset.getInt("FTYPE"));
				switch(f.getfType()) {
					case 1 : f.setfType2("호텔"); break;
					case 2 : f.setfType2("병원"); break;
					case 3 : f.setfType2("미용"); break;
					case 4 : f.setfType2("회원관리"); break;
				}
				f.setTitle(rset.getString("TITLE"));
				f.setContent(rset.getString("CONTENT"));
				
				list.add(f);
			}
			
		} catch(Exception e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
			
		}
		return list;
	}

	public Faq faqSelectOne(Connection conn, int fno) throws MarketException {
		Faq f = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("faqSelectOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Faq();
				
				f.setFno(rset.getInt("FNO"));
				f.setfType(rset.getInt("FTYPE"));
				switch(f.getfType()) {
					case 1 : f.setfType2("호텔"); break;
					case 2 : f.setfType2("병원"); break;
					case 3 : f.setfType2("미용"); break;
					case 4 : f.setfType2("회원관리"); break;
				}
				f.setTitle(rset.getString("TITLE"));
				f.setContent(rset.getString("CONTENT"));
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return f;
		
	}

	
	


	/**
	 * 김혜림
	 * 가게 상세 보기
	 * @param con
	 * @param mid
	 * @return
	 */
	public Market MarketIn(Connection con, int mid) {
		Market mk = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("marketin");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mk = new Market();
				
				mk.setMarketId(rset.getInt("MARKET_ID"));
				mk.setMarketName(rset.getString("MARKET_NAME"));
				mk.setMarketPwd(rset.getString("MARKET_PASSWORD"));
				mk.setMarketEmail(rset.getString("MARKET_EMAIL"));
				mk.setMarketType(rset.getString("MARKET_TYPE"));
				mk.setMarketTel(rset.getString("MARKET_TEL"));
				mk.setMarketCellPhone(rset.getString("MARKET_CELLPHONE"));
				mk.setMarketAddress(rset.getString("MARKET_ADDRESS"));
				mk.setEnDate(rset.getDate("ENDATE"));
				mk.setStatus(rset.getString("STATUS"));
				System.out.println("Dao : " + mk);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mk;
	}

	/**
	 * 김혜림
	 * 마켓 상세 정보 보기
	 * @param con
	 * @param mid
	 * @return
	 */
	public MarketDetail marketmd(Connection con, int mid) {
		MarketDetail md = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("marketmd");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				md = new MarketDetail();
				
				md.setMarketId(rset.getInt("MARKET_ID"));
	            md.setMarketName(rset.getString("MARKET_NAME"));
	            md.setMarketCheck(rset.getString("MARKET_CHECK"));
	            md.setMarketSubPhoto01(rset.getString("MARKET_SUBPHOTO_01"));
	            md.setMarketSubPhoto02(rset.getString("MARKET_SUBPHOTO_02"));
	            md.setMarketSubPhoto03(rset.getString("MARKET_SUBPHOTO_03"));
	            md.setMarketSub(rset.getString("MARKET_SUB"));
	            md.setMarketBus(rset.getString("MARKET_BUS"));
	            md.setMarketCar(rset.getString("MARKET_CAR"));
	            md.setMarketPrice(rset.getInt("MARKET_PRICE"));
	            md.setMarketIntro(rset.getString("MARKET_INTRO"));
	            md.setMapx(rset.getDouble("MAP_X"));
	            md.setMapy(rset.getDouble("MAP_Y"));
	            System.out.println("Dao의 MarketDetail : " + md); 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return md;
	}
	
	


	
	/**
	 * 로그 리스트 불러오는 메소드
	 * 권구현 2020.02.18
	 * @param conn
	 * @return
	 * @throws MarketException
	 */
	public ArrayList<AuditLog> selectLogList(Connection conn) throws MarketException {
		ArrayList<AuditLog> list = new ArrayList<>();
		AuditLog alog = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLogList");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				alog = new AuditLog();
				alog.setLogNo(rset.getInt("LOG_NO"));
				alog.setLogDate(rset.getString("LOG_DATE"));
				alog.setMethodName(rset.getString("METHOD_NAME"));
				alog.setLogSql(rset.getString("LOG_SQL"));
				alog.setDoit(rset.getString("DO"));
				
				list.add(alog);
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	
	
	/**
	 * 로그 찍는 메소드
	 * @param conn
	 * @param sql
	 * @param doit
	 * @param doit2 
	 */
	public void auditLog(Connection conn, String methodName, String sql, String doit) {
		int result = 0;
		PreparedStatement pstmt = null;
		String auditSql = prop.getProperty("auditLog");
		
		try {
			pstmt = conn.prepareStatement(auditSql);
			pstmt.setString(1, methodName);
			pstmt.setString(2, sql);
			pstmt.setString(3, doit);
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
	}

	public ArrayList<HotelReserve> mReserveList(Connection conn, String userEmail) throws MarketException {
		
		ArrayList<HotelReserve> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("mReserveList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userEmail);
			
			System.out.println("dao sql : "+ sql);
			System.out.println("dao userEmail :"+ userEmail);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				System.out.println("DAO while");
				
				HotelReserve hr = new HotelReserve();
				
				hr.setReserveId(rset.getInt("RESERVE_ID"));
				hr.setMarketId(rset.getInt("MARKET_ID"));
				hr.setUserEmail(rset.getString("USER_EMAIL"));
				hr.setUserName(rset.getString("USER_NAME"));
				hr.setUserPhone(rset.getString("USER_PHONE"));
				hr.setS_date(rset.getDate("S_DATE"));
				hr.setE_date(rset.getDate("E_DATE"));
				hr.setMarketPrice(rset.getInt("MARKET_PRICE"));
				hr.setMarketName(rset.getString("MARKET_NAME"));
				hr.setMarketPhone(rset.getString("MARKET_TEL"));
				hr.setPetId(rset.getInt("PET_ID"));
				hr.setPetName(rset.getString("PET_NAME"));
				hr.setPetType(rset.getString("PET_TYPE"));
				hr.setStatus(rset.getString("STATUS"));
				hr.setTerm(rset.getInt("TERM"));
				
				System.out.println("불러오기 완료");
				list.add(hr);
				
			}
			
		} catch(SQLException e) {
			throw new MarketException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("DAO return list : "+list);
		return list;
	}


}

