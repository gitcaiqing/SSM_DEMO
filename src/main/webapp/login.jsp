<%@page import="com.ssm.entity.BasicUser"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<%
	//如果登陆成功，则直接跳转到主页
	Subject subject = SecurityUtils.getSubject();
	if(subject.isAuthenticated() || subject.isRemembered()){
		response.sendRedirect(request.getContextPath()+"/ssm/home");
	}

%>
<html>
<head>
<title>登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="${base }/static/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${base }/static/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${base }/static/css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="${base }/static/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="${base }/static/css/jquery-ui.css"> 
<!-- jQuery -->
<script src="${base }/static/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->
<link href='http://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="${base }/static/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
	<div class="main-wthree">
		<div class="container">
			<div class="sin-w3-agile">
				<h2>Sign In</h2>
				<form id="form" action="#" method="post">
					<div class="username">
						<span class="username">账号:</span>
						<input type="text" name="username" class="name" placeholder="" required="">
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">密码:</span>
						<input type="password" name="password" class="password" placeholder="" required="">
						<div class="clearfix"></div>
					</div>
					<div class="rem-for-agile">
						<input type="checkbox" name="rememberMe" class="remember" value="true">记住我<br>
						<!-- <a href="#">忘记密码</a><br> -->
					</div>
					<div class="login-w3">
						<input type="button" class="login" value="登陆" onclick="login()">
					</div>
					<div class="clearfix"></div>
				</form>
				<div class="back">
					<a href="https://blog.csdn.net/caiqing116" target="_blank">去主人博客</a>
				</div>
				<!--copy rights start -->
					<%@include file="/WEB-INF/common/copyright.jsp" %>
				<!--copy rights end -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function login(){
	$.post("${base}/ssm/shirologin",$("#form").serialize(),function(data){
		if(data.resultCode == 0){
			window.location.href = "${base}/ssm/home";
		}else{
			alert(data.msg);
		}
	})
}
</script>
</html>