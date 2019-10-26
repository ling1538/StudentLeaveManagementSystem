package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/**
 * 单条删除控制层
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		// 接受页面的值
		String id = req.getParameter("id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		
		resp.setContentType("text/html;charset=utf-8");//解决弹出框乱码问题
		PrintWriter pw=resp.getWriter();
		pw.write("<script language='javascript'>alert('删除成功，返回首页！');history.go(-1);</script>");//弹出警告框
		
		// 向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/home.jsp").forward(req, resp);

	}
}
