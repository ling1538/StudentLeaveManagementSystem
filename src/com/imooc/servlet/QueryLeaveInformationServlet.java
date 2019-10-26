package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class QueryLeaveInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String l_identity = (String) req.getSession().getAttribute("l_identity");
		if("学生".equals(l_identity))//如果是学生登录的话，就显示该学生的请假信息
		{
			String id = (String) req.getSession().getAttribute("id");
			QueryService queryleaveMessageList1 = new QueryService();
			req.setAttribute("queryleaveMessageList", queryleaveMessageList1.queryleaveMessageList(id));
		}
			req.getRequestDispatcher("/WEB-INF/jsp/back/ApplyForLeaveInformation.jsp").forward(req, resp);
		
	}

}
