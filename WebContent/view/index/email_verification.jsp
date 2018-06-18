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
<body style="margin: 0; padding: 0; background-color: #1dd388;">
	<div style="width: 600px; margin: 100px auto; background-color: #FFF; padding: 50px 30px; height: 350px; color: #999;">
		<div id="register_check_div" style="">
			<h3 style="text-align:center;margin:20px 0;">邮箱验证已通过，请立即激活账号！</h3>
			<div class="img_wrap_list" style="text-align:center;">
				<span>昵称：</span>
				<div class="personal_info_value highlight div_username"></div>
			</div>
			<div class="img_wrap_list" style="text-align:center;">
				<span>邮箱：</span>
				<div class="personal_info_value div_email"></div>
			</div>
			<button id="register_check_btn" class="button_a" style="width:200px;height:50px;margin:20px 170px;font-size:18px;">立即激活账号</button>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/index/email_verification.js"></script>
</body>
</html>