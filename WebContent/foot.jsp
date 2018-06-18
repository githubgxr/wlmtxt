<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body style="margin: 0;padding: 0;background-color: #f6f6f6;">
		<!--底部-->
		<div style="float:left; color: #BFBFBF; background-color: #ffffff;height: 70px;line-height: 70px;text-align: center;width: 100%;margin: 20px 0 0;">
			网络媒体系统 <a href="<%=basePath%>adminLogin.jsp">©</a>2018 Created by 网络媒体开发组
		</div>
	</body>

