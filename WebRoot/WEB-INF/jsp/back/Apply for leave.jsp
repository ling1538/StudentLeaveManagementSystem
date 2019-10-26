<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这是学生申请请假操作页面 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>申请请假</title>
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
		<form action="<%= basePath %>servlet/ApplyForLeaveInformationServlet" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			<div class="right">
				<div class="current">当前位置：请假管理&nbsp;>&nbsp;请假申请</div> 
				<div class="rightCont">
					<p class="g_title fix" style="font-size:25px;">请假内容</p>
					<div class="apply" style='background-color:#D9FFFF;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请假状态：<label  style="font-size: 15px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新建</label></div>
					
					<div class="apply" style=';background-color:#ECF6EE;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						${id}
				    </div>
				    <div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						${m_name}
				    </div>
				    <div class="apply" style=';background-color:#ECF6EE;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生班级：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						${m_class}
				    </div>
					<div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="inp" type="text" name="phone"/>
					</div>
					<div class="apply" style=';background-color:#ECF6EE;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请假时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- WdatePicker({minDate:'%y-%M-{%d}'})//最小时间为当天
					     WdatePicker({minDate:'#F{$dp.$D(\'riqi1\')}',maxDate:'%y-%M-{%d+30}'})//最小时间不能超过前面id=“riqi1”选的时间，最大时间为当天后30天-->
					&nbsp;<input id="riqi1" name="startTime" class="Wdate" style="border-radius:5px;width:200px; height:20px;" type="text" value="开始时间" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'})"/>
					到&nbsp;<input class="Wdate" name="endTime" style="border-radius:5px;width:200px; height:20px;" type="text"value="结束时间"  onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'riqi1\')}',maxDate:'%y-%M-{%d+30}'})"/>
					</div>
					<div class="apply" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请假原因：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="text" placeholder="理由不超过30字" value="" class="inp" name="reason" style="width:700px;"/></input></div>
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="tabSub" value="提   交" />
						</div>
					</div>
				</div>
		
	    </form>
	</body>
</html>