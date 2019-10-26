package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class ApplyForLeaveInformationServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
/**
 * 申请请假页面-保存申请请假信息
 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		QueryService saveInformationService = new QueryService();
		String ID=(String) req.getSession().getAttribute("id");
		String l_name=(String) req.getSession().getAttribute("m_name");
		String l_class=(String) req.getSession().getAttribute("m_class");
		String l_state="待审核";
		String l_phone=(String) req.getParameter("phone");
		String l_startTime=(String) req.getParameter("startTime");
		String l_endTime=(String) req.getParameter("endTime");
		String l_reason=(String) req.getParameter("reason");;
		saveInformationService.saveMessage(ID, l_name, l_class, l_state, l_phone, l_startTime,l_endTime, l_reason);
		
		req.setAttribute("saveInformationList", saveInformationService.queryleaveMessageList(ID));
		req.getRequestDispatcher("QueryLeaveInformationServlet").forward(req, resp);
	}
}
