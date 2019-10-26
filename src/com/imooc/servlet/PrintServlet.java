package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.imooc.util.ExcelUtil;

/**
 * 打印报表
 * @author asus
 *
 */
@SuppressWarnings("serial")
public class PrintServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		String l_class = (String) req.getSession().getAttribute("m_class");
		System.out.println(l_class+"+++++++++++++++测试");
		ExcelUtil excelUtil = new ExcelUtil();
		try {
			excelUtil.print(l_class);
			System.out.println("打印成功！");
			
//			// 向页面跳转
//			req.getRequestDispatcher("ReportManagementServlet").forward(req, resp);
//			
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('打印成功！文件保存在D://WorkspacesMyEclipse10/StudentLeaveManagementSystem/WebRoot/ReportManagement');window.location='ReportManagementServlet'</script>");
			out.flush();
			out.close();
			
			// 向页面跳转
			req.getRequestDispatcher("ReportManagementServlet").forward(req, resp);
			
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("打印失败！");
			
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('打印失败！'); window.location='/StudentLeaveManagementSystem/WebRoot/WEB-INF/jsp/back/ReportManagement.jsp'</script>");
			out.flush();
			out.close();
			
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("打印失败！");
		}
		
		
	}
	
	

}
