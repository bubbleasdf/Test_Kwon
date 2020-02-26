package com.kh.petner.member.encrypt;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter({ "/Plogin.me", "/PmInsert.me", "/pUpdate.me", "/pwdnewenter.do" })
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿 동작하기 전
		HttpServletRequest req = (HttpServletRequest)request;
		
		
		
		System.out.println("암호화 과정");
		
		System.out.println("userPwd : "+ req.getParameter("userPwd"));
		System.out.println("userPwd2 : "+ req.getParameter("userPwd2"));
		System.out.println("usernPwd1 : "+ req.getParameter("usernPwd1"));
		System.out.println("usernPwd2 : "+ req.getParameter("usernPwd2"));
		System.out.println("userName : "+ req.getParameter("userName"));
		
		
		// 비밀번호 원본 값 ( 확인용 )
		request.setAttribute("originPwd", req.getParameter("userPwd"));
		
		// 비밀번호 확인용 원본 값

		if(req.getParameter("userPwd2")!=null && req.getParameter("userPwd2")!="") {
			request.setAttribute("originPwd2", req.getParameter("userPwd2"));
		} //if
		
		//비밀번호 변경시 새로운 비밀번호 값 2개
		
		if(req.getParameter("usernPwd1")!=null && req.getParameter("usernPwd1")!="") {
			request.setAttribute("originnPwd1", req.getParameter("usernPwd1"));
			request.setAttribute("originnPwd2", req.getParameter("usernPwd2"));
		}//if
		
		
		EncryptWrapper lw = new EncryptWrapper(req);
		
		chain.doFilter(lw, response);
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
