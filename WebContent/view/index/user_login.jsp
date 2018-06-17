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
		<link href="<%=basePath%>css/login.css" type="text/css" rel="stylesheet" />
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="login">
			<form>
				<div class="form-title">
					用户登录
				</div>
				<div class="form-group" id="div_1">
					<input type="email" class="form-control" id="exampleInputEmail" placeholder="请输入你的账号（邮箱）"style="background: url(<%=basePath%>img/email.png) no-repeat;background-color: #fff; background-size: 30px 30px; font-size:inherit;padding: 0 0 0 35px;">
				</div>
				<div class="form-group" id="div_2">
					<label for="exampleInputPassword">&nbsp;</label>
					<input type="password" class="form-control" id="exampleInputPassword" placeholder="请输入密码"style="background: url(<%=basePath%>img/email.png) no-repeat;background-color: #fff; background-size: 30px 30px; font-size:inherit;padding: 0 0 0 35px;">
				</div>
				<div class="link">
					<a href="#">忘记密码|</a>
					<a href="<%=basePath%>view/index/user_register.jsp">注册</a>
				</div>
				<div class="button">
					<button type="button" class="btn btn-success btn-block">点击登录</button>
				</div>
			</form>
		</div>
	</body>
</html>