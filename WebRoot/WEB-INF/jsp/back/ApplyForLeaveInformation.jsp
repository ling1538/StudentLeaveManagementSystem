<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 这是学生申请请假的状态页面 -->
<html>
  <head>
    <base href="<%=basePath%>">
    <title>请假信息状态</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
	<title>申请请假</title>
	<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
	<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
	<script src="<%= basePath %>resources/js/back/list.js"></script>
  </head>
  
  <body style="background: #e1e9eb;">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			<div class="right">
				<div class="current">当前位置：请假管理&nbsp;>&nbsp;查询请假</div> 
				<div class="rightCont">
					<p class="g_title fix" style="font-size:25px;">请假状态</p>
					
						<div class="zixun fix">
						<table class="tab2" width="100%"  style="font-size:13px;">
							<tbody >
								<tr>
									<th>序号</th>
								    <th>ID</th>
								    <th>姓别</th>
								    <th>班级</th>
								    <th>状态</th>
								    <th>手机</th>
								    <th>开始时间</th>
								    <th>结束时间</th>
								    <th>原因</th>
								</tr>
								<!-- 下面的queryleaveMessageList为数据库返回的一个queryleaveMessageList的list; 下面queryleaveMessageList为queryleaveMessageList的实例；status.index为迭代的索引下标，从0开始-->
								<c:forEach items="${queryleaveMessageList}" var="leaveMessageList"  varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
										<td>${status.index+1}</td>
										<td>${leaveMessageList.ID}</td>
										<td>${leaveMessageList.l_name}</td>
										<td>${leaveMessageList.l_class}</td>
										<td>${leaveMessageList.l_state}</td>
										<td>${leaveMessageList.l_phone}</td>
										<td>${leaveMessageList.l_startTime}</td>
										<td>${leaveMessageList.l_endTime}</td>
										<td>${leaveMessageList.l_reason}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
  </body>
</html>
