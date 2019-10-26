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
    <title>审批管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
	<script src="<%= basePath %>resources/js/back/list.js"></script>
	
<script type="text/javascript">
function checkOrCancelAll(){
	var chElt=document.getElementById("selectAll");
	var checkedElt=chElt.checked;
	var allCheck=document.getElementsByName("checkbox_id");
	if(checkedElt){
		for(var i=0;i<allCheck.length;i++){
			allCheck[i].checked=true;
		}
	}else{
		for(var i=0;i<allCheck.length;i++){
			allCheck[i].checked=false;
		}
	}
}
</script>

  </head>
  
  <body style="background: #e1e9eb;">
  <form action="${basePath}servlet/BatchPassServlet" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			
			<div class="right">
				<div class="current">当前位置：审批管理</div> 
				<div class="rightCont">
				<p class="g_title fix" style="font-size:25px;">请假列表
				<input class="btn03" type="submit" value="批量通过"/>
			    </p>
					
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody style="font-size:13px;">
								<tr>
								    <th><input type="checkbox" id="selectAll" onclick="checkOrCancelAll()"/></th>
								    <th>序号</th>
								    <th>学号</th>
								    <th>姓别</th>
								    <th>班级</th>
								    <th>状态</th>
								    <th>联系方式</th>
								    <th>开始时间</th>
								    <th>结束时间</th>
								    <th>原因</th>
								    <th>操作</th>
								</tr>
								<!-- 下面的queryleaveMessageForClassList为数据库返回的一个queryleaveMessageForClassList的list; 下面leaveMessageForClassList为queryleaveMessageForClassList的实例；status.index为迭代的索引下标，从0开始-->
								<c:forEach items="${queryleaveMessageForClassList}" var="leaveMessageForClassList" varStatus="status">
									<tr  <c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
										<td><input type="checkbox"  name="checkbox_id" value="${leaveMessageForClassList.l_number}"/></td>
										<td>${status.index + 1}</td>
										<th>${leaveMessageForClassList.ID}</th>
										<td>${leaveMessageForClassList.l_name}</td>
										<td>${leaveMessageForClassList.l_class}</td>
										<td>${leaveMessageForClassList.l_state}</td>
										<td>${leaveMessageForClassList.l_phone}</td>
										<td>${leaveMessageForClassList.l_startTime}</td>
										<td>${leaveMessageForClassList.l_endTime}</td>
										<td>${leaveMessageForClassList.l_reason}</td>
										<td>
											<a href="${basePath}servlet/ApprovalSingleLeaveMessageServlet?number=${leaveMessageForClassList.l_number}">批准</a>&nbsp;&nbsp;&nbsp;
											<a href="${basePath}servlet/RefuseSingleLeaveMessageServlet?number=${leaveMessageForClassList.l_number}">拒绝</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	    </form>
  </body>
</html>
