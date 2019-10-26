package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ExitServlet extends HttpServlet {
/**
 * 点击退出，清除session
 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			req.getSession().invalidate();
			resp.sendRedirect("/StudentLeaveManagementSystem/login_index.jsp");
			
			resp.setHeader("Pragma","No-cache");
			resp.setHeader("Cache-Control","no-cache");
			resp.setDateHeader("Expires", 0);
			resp.flushBuffer();
			
			resp.setHeader("Pragma","no-cache");
			resp.setHeader("Cache-Control","no-cache");
			resp.setHeader("Cache-Control","no-store"); //和上面的参数不一样
			resp.setDateHeader("Expires", 0);
			resp.flushBuffer();
			
			Cookie   killMyCookie   =   new   Cookie("mycookie",   null);  
	        killMyCookie.setMaxAge(0);  
	        killMyCookie.setPath("/");  
	        resp.addCookie(killMyCookie);  
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
