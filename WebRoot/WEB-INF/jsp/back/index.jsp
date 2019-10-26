<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 这是导航栏和菜单栏页面 -->
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我要请假</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Custom Theme">
    
    <link rel="stylesheet" type="text/css" href="resources/css/indexcss.css">
	<!-- 图标库 -->
    <link href="Olive_File/assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME CSS  -->
    <script type="text/javascript" src="resources/js/back/nice.js"></script>
 </head>
  <body>
  
  <div id="div1" >
  	&nbsp;&nbsp;&nbsp;&nbsp;<span style="line-height:1.7em;"><i class="fa fa-home fa-fw"></i>&nbsp;我要请假！</span>
  	<div style=" background:#97CBFF;border-width:2px;font-size:16px;Margin:10px;height:30px;line-height:2.0em;float:right;display:inline;border:2px  solid  #ccc;">
  	&nbsp;&nbsp;欢迎您&nbsp;${m_class}的${m_name}&nbsp;${l_identity}&nbsp;
  	<a href="javascript:loginOut()" >安全退出</a>
  	</div>
  </div>
  <div class="a2"  style="color:#ECECFF">
  	   <div class="sidebar-menu" id="nav-accordion">
  				   <div class="user" >
                    	<form action="${basePath}servlet/HomePageServlet" method="post"  >
                    	        <i class="fa fa-picture-o fa-fw"></i> <input type="submit"  value="首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>
                  	  </form>
                     </div>
                    <div class="user" >
                     <form action="${basePath}servlet/MenuMessageServlet" method="post" target="iframe1" >
                            <i class="fa fa-user"></i>
                            <input <c:if test="${l_identity=='学生'}">style="color:#8E8E8E;"disabled="";</c:if>  type="submit"  value="用户管理"/>
                        </form>
                    </div>
                        <div class="user"><i class="fa fa-plus-square-o"></i>
                        <input <c:if test="${l_identity=='教师'}">style="color:#8E8E8E;" disabled="";</c:if>  type="submit" onclick="hidetext()" value="请假管理"/>
                        </div>
                        <div id="exq" style="display:none;">
                             <form action="${basePath}servlet/ApplyForLeaveServlet" method="post" target="iframe1" >
                       		 <div class="user" ><input type="submit"  value="请假申请"/></div>
                       		 </form>
                       		  <form action="${basePath}servlet/QueryLeaveInformationServlet" method="post" target="iframe1" >
                             <div class="user" ><input type="submit"  value="查询请假"/></div>
                             </form>
                        </div >
                     <div class="user" >
                    	 <form action="${basePath}servlet/ApprovalManagementServlet" method="post" target="iframe1" >
                            <i class="fa fa-tasks"></i>
                            <input <c:if test="${l_identity=='学生'}">style="color:#8E8E8E;"disabled=""</c:if>  type="submit"  value="审批管理"/>
                        </form>
                        </div>
                    <div class="user"  >
                    	 <form action="${basePath}servlet/ReportManagementServlet" method="post" target="iframe1" >
                            <i class=" fa fa-bar-chart-o"></i>
                            <input <c:if test="${l_identity=='学生'}">style="color:#8E8E8E;"disabled=""</c:if> type="submit"  value="报表管理"/>
                         </form>
                    </div>
                </div>
  </div>
  <!-- 中间主页 -->
  	<div class="a1" style="background:url('resources/images/bg2.jpg');background-size:100% 100%;">
	<iframe  name="iframe1" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" style="width:100%; height:100%;" 
	  ></iframe>
  </div>
  
  </body>
</html>
