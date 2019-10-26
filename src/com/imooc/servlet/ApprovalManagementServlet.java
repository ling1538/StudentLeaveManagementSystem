package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class ApprovalManagementServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

/**
 * 跳转到审批管理
 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 设置编码
				req.setCharacterEncoding("UTF-8");
				// 接受页面的值
				String id = req.getParameter("id1");
				String name = req.getParameter("name1");
						
				System.out.println(id+"+"+name);
				
		req.setCharacterEncoding("UTF-8");
		String l_class = (String) req.getSession().getAttribute("m_class");
		QueryService queryleaveMessageForClassList = new QueryService();
		req.setAttribute("queryleaveMessageForClassList", queryleaveMessageForClassList.queryleaveMessageForClassList(l_class));
		req.getRequestDispatcher("/WEB-INF/jsp/back/ApprovalManagement.jsp").forward(req, resp);
	}

}
