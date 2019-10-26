<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<base href="<%=basePath%>">
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>新增信息</title>
		<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%= basePath %>resources/js/back/list.js"></script>
		
		<script type="text/javascript" src="<%= basePath %>My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%= basePath %>My97DatePicker/calendar.js"></script>
		
<style type="text/css">
		.apply{
			width: 100%;   
			height: 25px;
			padding-top:6px;
			font-size:13px;
			border-bottom:1px solid #BEBEBE;
		}
		.inp{
		border-radius:5px;
		border:1px #9D9D9D solid;
		width:200px; height:20px;
		}
</style> 
  </head>
  <body style="background: #e1e9eb;">
		<form action="<%= basePath %>servlet/AddMessage2Servlet" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			<div class="right">
				<div class="current">当前位置：用户管理&nbsp;>&nbsp;新增信息</div> 
				<div class="rightCont">
					<p class="g_title fix" style="font-size:25px;">新增信息</p>
					<div class="apply" style='background-color:#D9FFFF;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：<label  style="font-size: 15px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</label></div>
					
				    <div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="inp" type="text" name="name">
				    </div>
				    <div class="apply" style='background-color:#ECF6EE;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班级：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name="myclass">
 					<option value="11">高一1班</option>
  					<option value="12">高一2班</option>
  					<option value="13">高一3班</option>
  					<option value="14">高一4班</option>
  					<option value="15">高一5班</option>
  					<option value="高二1班">高二1班</option>
  					<option value="高二2班">高二2班</option>
  					<option value="高三1班">高三1班</option>
					</select>
					
				    </div>
					<div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="男">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女">女
					</div>
					
					<div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;特点：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="inp"  type="text" name="remarks">
					</div>
					
					<div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="inp"  type="text" name="password">
					</div>
					
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="tabSub" value="注 册" />
						</div>
					</div>
				</div>
		
	    </form>
	</body>
</html>
