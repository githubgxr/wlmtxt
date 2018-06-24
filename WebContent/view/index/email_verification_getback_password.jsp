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


<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
</head>
<body style="margin: 0; padding: 0; background-color: #fff;">
	<div
		style="background: url(/wlmtxt/img/login.png) no-repeat; background-position-x: 0%; background-position-y: 0%; background-position: 0 -5px; border-top-right-radius: 4px; border-top-left-radius: 4px; width: 100%; height: 75px; background-size: 100%;"></div>
	<div
		style="width: 600px; margin: 100px auto; background-color: #FFF; padding: 0 20px; height: 350px; color: #999;">
		<div id="get_password_check_div" style="">
			<h3 style="text-align: center; margin: 20px 0;">邮箱验证已通过，请输入新密码！</h3>
			<div class="personal_info_details">
				<div class="img_wrap_list" style="float:left;width:100%;margin:5px 0;">
					<span style="float:left;width:160px;text-align: right;line-height: 30px;">新密码：</span>
					<input type="password" class="input_xzt" id="input_new_password"
						style="width: 350px;float:left;margin:0 0 0 10px;" placeholder="请输入新密码" oninput="checkPassword()" onblur="checkPassword()"/>
				</div>
				<div class="img_wrap_list" style="float:left;width:100%;margin:5px 0;">
					<span style="float:left;width:160px;text-align: right;line-height: 30px;">确认新密码：</span>
					<input type="password" class="input_xzt" id="input_new_repassword"
						style="width: 350px;float:left;margin:0 0 0 10px;" placeholder="请确认新密码" oninput="checkRepassword()" onblur="checkRepassword()" />
				</div>
				<div class="img_wrap_list" style="float:left;width:100%;margin:5px 0;">
					
					<div  class="input_xzt" id="get_password_alert_div"
						style="width: 350px;float:left;margin:0 0 0 170px;border:none;display:none;color:red;"></div>
				</div>

			</div>
			<button id="get_password_check_btn" class="button_a"
				style="width: 200px; height: 40px; margin: 10px 170px; font-size: 16px;">确认</button>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/index/email_verification_getback_password.js"></script>
</body>
</html>