<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/common/taglib.jsp"%>
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
				<form action="#" method="post">
					<div class="username">
						<span class="username">账号:</span>
						<input type="text" name="name" class="name" placeholder="" required="">
						<div class="clearfix"></div>
					</div>
					<div class="password-agileits">
						<span class="username">密码:</span>
						<input type="password" name="password" class="password" placeholder="" required="">
						<div class="clearfix"></div>
					</div>
					<div class="rem-for-agile">
						<input type="checkbox" name="remember" class="remember">记住我<br>
						<a href="#">忘记密码</a><br>
					</div>
					<div class="login-w3">
						<input type="submit" class="login" value="登陆">
					</div>
					<div class="clearfix"></div>
				</form>
				<div class="back">
					<a href="index.html">去主人博客</a>
				</div>
				<div class="footer">
					<p>&copy; 2018 Design by <a href="https://blog.csdn.net/caiqing116">https://blog.csdn.net/caiqing116</a></p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>