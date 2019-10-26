package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Login;
import com.imooc.bean.Message;
import com.imooc.bean.Teacher;
import com.imooc.service.QueryService;
/**
 * 登录界面
 * @author asus
 *
 */
@SuppressWarnings("serial")//首先是@SuppressWarnings 也就是如果你不加这个 你的程序会报黄色的警告信息，加了这个可以忽略这个警告 ("serial") 是序列化警告，当实现了序列化接口的类上缺少serialVersionUID属性的定义时，会出现黄色警告。可以使用@SuppressWarnings将警告关闭
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		// 接受页面的值
		String login_id = req.getParameter("login_id");
		String login_password = req.getParameter("login_password");
		req.setAttribute("login_id", login_id);
		System.out.println("("+login_id+")+++++++++++++++("+login_password+")");
		//判断是否有输入帐号密码;trim()的作用是去掉字符串两端的多余的空格，注意，是两端的空格，且无论两端的空格有多少个都会去掉
		if(login_id != null && !"".equals(login_id.trim())&&login_password != null && !"".equals(login_password.trim())){
			QueryService listService = new QueryService();
			List<Login> a = listService.queryLogin(login_id, login_password);
			
			if(a.size()>0){
				System.out.println("登陆成功！！");
				// 初始化页面，显示全部信息
				req.setAttribute("loginList", listService.queryLogin(login_id, login_password));
				// 查询条件设为空，初始化页面
				req.setAttribute("messageList", listService.queryMessageList("", ""));
				
				if("学生".equals(a.get(0).getL_identity())){
					List<Message> b = listService.querySingleMessage(login_id);
					req.getSession().setAttribute("id", b.get(0).getId());
					req.getSession().setAttribute("m_name", b.get(0).getM_name());
					req.getSession().setAttribute("m_class", b.get(0).getM_class());
				}else{
					List<Teacher> teacher = listService.queryTeacherMessage(login_id);
					req.getSession().setAttribute("id", teacher.get(0).getID());
					req.getSession().setAttribute("m_name", teacher.get(0).getT_name());
					req.getSession().setAttribute("m_class", teacher.get(0).getT_class());
				}
				
				req.getSession().setAttribute("l_identity", a.get(0).getL_identity());
				
				// 向页面跳转
				req.getRequestDispatcher("/WEB-INF/jsp/back/index.jsp").forward(req, resp);
			}else{
				// 向页面跳转
				resp.setContentType("text/html;charset=utf-8");//解决弹出框乱码问题
				PrintWriter pw=resp.getWriter();
				pw.write("<script language='javascript'>alert('帐号或者密码错误！！！');window.location.href='/StudentLeaveManagementSystem/login_index.jsp';</script>");//弹出警告框
			}
		}
		else{
			// 向页面跳转
			resp.setContentType("text/html;charset=utf-8");//解决弹出框乱码问题
			PrintWriter pw=resp.getWriter();
			pw.write("<script language='javascript'>alert('帐号或密码不能为空！！！');window.location.href='/StudentLeaveManagementSystem/login_index.jsp';</script>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
