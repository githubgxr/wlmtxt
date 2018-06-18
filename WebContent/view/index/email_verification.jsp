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
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />

<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
</head>
<body style="margin: 0; padding: 0; background-color: #fff;">
<div style="background: url(/wlmtxt/img/login.png) no-repeat; background-position-x: 0%; background-position-y: 0%;
	background-position: 0 -5px;
	border-top-right-radius: 4px;
	border-top-left-radius: 4px;width:100%;height:75px;background-size:100%;"></div>
	<div style="width: 600px; margin: 100px auto; background-color: #FFF; padding:0 20px; height: 350px; color: #999;">
		<div id="register_check_div" style="">
			<h3 style="text-align:center;margin:20px 0;">邮箱验证已通过，请立即激活账号！</h3>
			<div class="img_wrap_list" style="width:100%;float:left;margin:5px 150px">
				<span style="width:100px;float:left;text-align:center;">昵称：</span>
				<div style="width:100px;float:left;" class="personal_info_value highlight div_username"></div>
			</div>
			<div class="img_wrap_list" style="width:100%;float:left;margin:10px 150px">
				<span style="width:100px;float:left;text-align:center;">邮箱：</span>
				<div style="width:100px;float:left;" class="personal_info_value div_email"></div>
			</div>
			<button id="register_check_btn" class="button_a" style="width:200px;height:50px;margin:20px 170px;font-size:18px;">立即激活账号</button>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/index/email_verification.js"></script>
</body>
</html>