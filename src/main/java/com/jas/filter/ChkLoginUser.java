package com.jas.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChkLoginUser
 */
public class ChkLoginUser implements Filter {

    /**
     * Default constructor. 
     */
    public ChkLoginUser() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req =(HttpServletRequest)request;
		String path = req.getServletPath();
		System.out.println(path);
		Cookie[] cookies = req.getCookies();
		boolean fl = false;
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				 Cookie cookie=cookies[i];
				 if(cookie.getName().equalsIgnoreCase("loginId")){
					 fl =true;
				 }
			}
		}
		if(path.equalsIgnoreCase("/login.html")||path.equalsIgnoreCase("/jas/login.do")){
			fl =true;
		}
		if(fl){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else{
			HttpServletResponse res =(HttpServletResponse)response;
			res.getWriter().write("login.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
