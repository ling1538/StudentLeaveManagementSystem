package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class ApprovalSingleLeaveMessageServlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		
	}

/**
 * 批准单条申请
 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QueryService approvalSingleLeaveMessage = new QueryService();
		String number = (String) req.getParameter("number");
		approvalSingleLeaveMessage.approvalSingleLeaveMessage(number);
		
		req.getRequestDispatcher("ApprovalManagementServlet").forward(req, resp);
	}
}
