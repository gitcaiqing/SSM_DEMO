<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<%
	//如果登陆成功，则直接跳转到主页
	Subject subject = SecurityUtils.getSubject();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登陆成功</h1>
	<h2>
		<input type="button" value="退出" onclick='window.location.href="${base}/ssm/shirologout"'>
	</h2> 
	<h2>是否【登陆认证】访问：<%=subject.isAuthenticated() %></h2>
	<h2>是否【记住我】访问：<%=subject.isRemembered() %></h2>
</body>
</html>