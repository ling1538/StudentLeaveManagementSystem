package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
/**
 * 跳转到报表界面
 * @author asus
 *
 */
@SuppressWarnings("serial")
public class ReportManagementServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String l_class = (String) req.getSession().getAttribute("m_class");
		QueryService queryleaveMessageForClassList = new QueryService();
		req.setAttribute("queryleaveMessageForClassList", queryleaveMessageForClassList.queryleaveMessageForClassList(l_class));
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/ReportManagement.jsp").forward(req, resp);
	}

}
