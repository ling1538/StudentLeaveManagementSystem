package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

@SuppressWarnings("serial")
public class BatchPassServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//	 for(int i=0;i<values.length;i++)
//	 	{
//		 System.out.print(values[i]+" + ");
//	 	}
	}
/**
 * 批准多条申请
 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取选中的复选框
		 String []values=req.getParameterValues("checkbox_id");
		 MaintainService maintainService = new MaintainService();
		 maintainService.BatchPass(values);
		 req.getRequestDispatcher("ApprovalManagementServlet").forward(req, resp);
	}

}
