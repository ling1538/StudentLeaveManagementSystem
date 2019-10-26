package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
/**
 * 拒绝单挑申请
 * @author asus
 *
 */
@SuppressWarnings("serial")
public class RefuseSingleLeaveMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QueryService RefuseSingleLeaveMessage = new QueryService();
		String number = (String) req.getParameter("number");
		RefuseSingleLeaveMessage.refuseSingleLeaveMessage(number);
		
		req.getRequestDispatcher("ApprovalManagementServlet").forward(req, resp);
	}

}
