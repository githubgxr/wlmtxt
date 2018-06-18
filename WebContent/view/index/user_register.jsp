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
		<link href="<%=basePath%>css/register.css" type="text/css" rel="stylesheet" />
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
		<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="bootstrap.min.js"></script>
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="register">
			<form>
				<div class="form-title">
					用户注册
				</div>
				<div class="form-group" id="div_1">
					<input type="email" class="form-control" id="exampleInputEmail" placeholder="请输入你的常用邮箱" style="background: url(<%=basePath%>img/email.png) no-repeat;background-color: #fff; background-size: 30px 30px; font-size:inherit;padding: 0 0 0 35px;">
				</div>
				<div class="from-group" id="div_2">
					<input type="text" class="form-control" id="exampleInputname" placeholder="请填写你的昵称" style="background: url(<%=basePath%>img/user.png) no-repeat;background-color: #fff; background-size: 30px 30px; font-size:inherit; padding: 0 0 0 35px;">
				</div>	
				<div class="form-group" id="div_3">
					<input type="password" class="form-control" id="exampleInputPassword" placeholder="密码长度为6~16位，可以由字母或数字组成" style="background: url(<%=basePath%>img/password.png) no-repeat;background-color: #fff; background-size: 30px 30px; font-size:inherit;padding: 0 0 0 35px;">
				</div>
				<div class="checkbox">
    				<label>
      				<input type="checkbox">已阅读并同意<a href="#">《皮皮猴用户协议》</a>和<a href="#">《隐私政策》</a>
    			</label>
				</div>
				<div class="button">
					<button type="button" class="btn btn-success btn-block">点击注册核对邮箱</button>
				</div>
			</form>
		</div>
	</body>
</html>