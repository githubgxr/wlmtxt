<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:300px;margin:0 auto;">
<h3>邮箱验证</h3>
<button id="register_check_btn" style="width:300px;margin:0 auto;height:50px;border-redius:20px;">确认激活</button>
</div>
<script type="text/javascript" src="<%=basePath%>js/index/email_verification.js"></script>
</body>
</html>