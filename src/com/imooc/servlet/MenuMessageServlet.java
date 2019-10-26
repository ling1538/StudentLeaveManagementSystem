package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class MenuMessageServlet extends HttpServlet {

	/**
	 * 用于从菜单栏点击用户管理时，进行跳转
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QueryService listService = new QueryService();
		// 查询条件设为空，初始化页面
		req.setAttribute("messageList", listService.queryMessageList("", ""));
		// 向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	
	}

}
