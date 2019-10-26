package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

@SuppressWarnings("serial")
public class AddMessage2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	
	}
	/**
	 * 新增信息页面-添加信息
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("新增2servlet");
		String name = req.getParameter("name");
		String myclass = req.getParameter("myclass");
		String sex= req.getParameter("sex");
		String remarks = req.getParameter("remarks");
		String password = req.getParameter("password");
		MaintainService maintainService = new MaintainService();
		maintainService.AddOne(name,myclass,sex,remarks,password);
		System.out.println(name+","+myclass+","+sex+","+remarks+","+password);
		
	}

}
