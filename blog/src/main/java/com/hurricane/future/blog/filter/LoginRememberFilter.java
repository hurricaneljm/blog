package com.hurricane.future.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginRememberFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		//如果是要进行登录，则从cookie中取出上一次用户登录的数据
//		if (requestURL.equals("/shop/user/loginPage")) {
//			Cookie[] cookies = ((HttpServletRequest)servletrequest).getCookies();
//			for (int i = 0; i < cookies.length; i++) {
//				if (cookies[i].getName().equals("username")||cookies[i].getName().equals("password")) {
//					servletrequest.setAttribute(cookies[i].getName(), new String(Base64Utils.decodeFromString(cookies[i].getValue()),"UTF-8"));
//				}
//			}
//		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
