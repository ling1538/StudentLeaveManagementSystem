<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这是学生信息管理页面 -->
<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>用户管理内容列表页面</title>
		<link href="<%= basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
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
		<form action="<%= basePath %>List.action" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			
			<div class="right">
				<div class="current">当前位置：用户管理</div> 
				<div class="rightCont">
					<p class="g_title fix" style="font-size:25px;">内容列表 <a class="btn03" href="${basePath}servlet/AddMessageServlet">新增 </a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">姓名：</td>
								<td>
									<input name="m_name" type="text" class="allInput" value="${m_name}"/>
								</td>
								<td width="90" align="right">班级：</td>
								<td>
									<input name="m_class" type="text" class="allInput" value="${m_class}"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>学号</th>
								    <th>姓别</th>
								    <th>性别</th>
								    <th>班级</th>
								    <th>特点</th>
								    <th>操作</th>
								</tr>
								<!-- 下面的messageList为数据库返回的一个message的list; 下面message为messagelist的实例；status.index为迭代的索引下标，从0开始-->
								<c:forEach items="${messageList}" var="message" varStatus="status">
									<tr  <c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
										<td>${status.index + 1}</td>
										<td>${message.id}</td>
										<td>${message.m_name}</td>
										<td>${message.m_sex}</td>
										<td>${message.m_class}</td>
										<td>${message.m_remarks}</td>
										<td>
											<div>
											<form id="deleteform" style="display:inline" action="<%= basePath %>DeleteOneServlet.action?id=${message.id}" method="post">
											<input  style="color: #FF5151" type="submit" value="删 除 "/>
											</form>
											</div>
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