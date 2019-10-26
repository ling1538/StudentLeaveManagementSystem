<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>用户登录</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
<!-- 界面的js效果 -->
<script type="text/javascript" src="resources/js/login/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/login/vector.js"></script>

<script type="text/javascript">
$(function(){
    Victor("container", "output");   //登录背景函数
    $("#entry_name").focus();
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#entry_btn").click();
        }
    });
});
</script>
</head>
<body>

<div id="container">
	<div id="output">
		<div class="containerT" >
			<h1 class="vintage3" style="font-size:30px">用户登录</h1>
			<form action="<%= basePath %>servlet/LoginServlet" class="form" id="entry_form" method="post">
				<input name="login_id" type="text" placeholder="用户名" >
				<input name="login_password" type="password" placeholder="密码" >
				<button style="background-color: #0080FF;" type="submit" >登录</button>
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>
</body>
</html>