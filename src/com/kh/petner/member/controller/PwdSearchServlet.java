package com.kh.petner.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
//import javax.net.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.petner.member.model.exception.MemberException;
import com.kh.petner.member.model.service.MemberService;
import com.kh.petner.member.model.vo.Member;

/**
 * Servlet implementation class PwdSearchServlet
 */
@WebServlet("/pwdsearch")
public class PwdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
	
		String userEmail = request.getParameter("userEmail");
		String userPwdHintSelect = request.getParameter("userPwdHintSelect");
		String userPwdHint = request.getParameter("userPwdHint");
		
		System.out.println("sikim SearchPwdServlet userEmail : " + userEmail);
		System.out.println("sikim SearchPwdServlet userPwdHintSelect : " + userPwdHintSelect);
		System.out.println("sikim SearchPwdServlet userPwd : " + userPwdHint);
		
		Member m_pwd = new Member();
		m_pwd.setUserEmail(userEmail);
		m_pwd.setUserPwdHintSelect(userPwdHintSelect);
		m_pwd.setUserPwdHint(userPwdHint);
		
		MemberService ms = new MemberService();
		
		try {
			m_pwd = ms.searchPwd(m_pwd);
				if(m_pwd != null) {
					System.out.println("m_pwd.getUserPwdHint() : " + m_pwd.getUserPwdHint() +", userPwdHint : " + userPwdHint);
					System.out.println("m_pwd.getUserPwdHintSelect() : " + m_pwd.getUserPwdHintSelect() +", userPwdHintSelect : " + userPwdHintSelect);
					if(m_pwd.getUserPwdHint().equals(userPwdHint) && m_pwd.getUserPwdHintSelect().equals(userPwdHintSelect)) {
						

		                //mail server 설정
		                String host = "smtp.naver.com";
		                String user = "tjsdls0724@naver.com"; //자신의 네이버 계정
		                String password = "1dktmskf!@";//자신의 네이버 패스워드
		                
		                //메일 받을 주소
//		                String to_email = userEmail;
		                String to_email = m_pwd.getUserEmail();
		                
		                //SMTP 서버 정보를 설정한다.
		                Properties props = new Properties();
		                props.put("mail.smtp.host", host);
		                props.put("mail.smtp.port", 465);
		                props.put("mail.smtp.auth", "true");
		                props.put("mail.smtp.ssl.enable", "true");
//		                props.put("mail.smtp.starttls.enable", "true");
//		                props.put("mail.debug", "true");
		                
		                //인증 번호 생성기
		                StringBuffer temp =new StringBuffer();
		                Random rnd = new Random();
		                for(int i=0;i<10;i++)
		                {
		                    int rIndex = rnd.nextInt(3);
		                    switch (rIndex) {
		                    case 0:
		                        // a-z
		                        temp.append((char) ((int) (rnd.nextInt(26)) + 97));
		                        break;
		                    case 1:
		                        // A-Z
		                        temp.append((char) ((int) (rnd.nextInt(26)) + 65));
		                        break;
		                    case 2:
		                        // 0-9
		                        temp.append((rnd.nextInt(10)));
		                        break;
		                    }
		                }
		                String AuthenticationKey = temp.toString();
		                System.out.println(AuthenticationKey);
		                
		                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(user,password);
		                    }
		                });
		        /*        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		                        return new javax.mail.PasswordAuthentication(user,password);
		                    }
		                });*/
		                
		                //email 전송
		                try {
		                    MimeMessage msg = new MimeMessage(session);
		                    msg.setFrom(new InternetAddress(user, "KH Books"));
		                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
		                    
		                    //메일 제목
		                    msg.setSubject("안녕하세요 KH BOOKS 인증 메일입니다.");
		                    //메일 내용
		                    msg.setText("인증 번호는 :"+temp);
		                    
		                    Transport.send(msg);
		                    System.out.println("이메일 전송");
		                    
		                }catch (Exception e) {
		                    e.printStackTrace();// TODO: handle exception
		                }
		                HttpSession saveKey = request.getSession();
		                saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
		                //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
		                request.setAttribute("m_pwd", m_pwd);
		                request.getRequestDispatcher("/views/member/NewPwd.jsp").forward(request, response);
						
						
		                // 아래부터는 원래 있던 코드
						System.out.println("비밀번호 변경 시작");
//						request.setAttribute("m_pwd", m_pwd);
						
//						request.getRequestDispatcher("views/member/searchPwConfirm.jsp").forward(request, response);
//						request.getRequestDispatcher("views/member/NewPwd.jsp").forward(request, response);
					}else {
						System.out.println("비밀번호 찾기 실패(힌트가 틀렸어)");
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('힌트가 틀렸어'); history.go(-1);;</script>");
						out.flush();
					}
				}
				else {
					System.out.println("비밀번호 찾기 실패2(이메일이 틀렸어)");
					
					
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('이메일이 틀렸어'); history.go(-1);</script>");
					out.flush();
				}
		} catch (MemberException e) {
			e.printStackTrace();
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
