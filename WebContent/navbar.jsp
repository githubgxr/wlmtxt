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
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/zb/zb.css" />
<link rel="stylesheet" href="<%=basePath%>css/zb/fontawesome-all.css" />
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/lwk/navbar.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<!--整个导航-->
	<div style="background-color: #FFFFFF; width: 100%; height: 56px;">
		<!--导航的主体部分-->
		<div style="width: 960px; height: 100%; margin: 0 auto;">
			<!--logo-->
			<img src="<%=basePath%>css/zb/img/wglogo.png"
				style="height: 45px; float: left; margin: 5.5px 20px 0 20px;" />
			<!--分类-->
			<div class="a_cateory" style="float: left;"
				onclick="window.location.href='/wlmtxt/view/index/index.jsp'">首页</div>
			<div class="a_cateory login_show" style="float: left;display:none;"
				onclick="window.location.href='/wlmtxt/view/index/friends_dynamic.jsp'">动态</div>
			<div class="a_cateory" style="float: left;"
				onclick="window.location.href='/wlmtxt/view/index/index_category.jsp'">分类</div>
			<div class="a_cateory" style="float: left;"
				onclick="window.location.href='/wlmtxt/view/index/index_rank.jsp'">排行榜</div>
			<!--头像-->
			<img class="user_img img_user" id="user_img"
				src="<%=basePath%>img/user.jpg"
				style="float: right; height: 45px; width: 45px; margin: 5.5px 0 0 0;" />
			<!--个人中心-->

			<div class="a_cateory login_show" style="float: right; margin: 0 10px;display:none;"
				onclick="window.location.href='/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp'">个人中心</div>
			<div class="a_cateory login_show" style="float: right;display:none;"
				onclick="window.location.href='/wlmtxt/view/personal_center/personal_center_upload_dynamic.jsp'">发布作品</div>
			<!--搜索-->
		</div>
	</div>
	<!-- 遮罩层 -->
	<div id="mask" style="display: none;"></div>
	<!-- 登录注册 -->
	<div class="login_and_register" id="login_and_register"
		style="display: none;">
		<div class="log_and_reg">
			<div class="log_head">
				<img class="logo_img" alt="" src="<%=basePath%>css/zb/img/logo.png">
				<span class="log_text selected_log">登录</span> <span
					class="log_text  not_selected_log">注册</span> <img id="close"
					class="close_img" alt="" src="<%=basePath%>img/close.png">
			</div>
			<!-- 登录 -->
			<div class="login_div" id="login_div">
				<!--  邮箱-->
				<input type="text" class="form-control log_email" id="login_email"
					placeholder="请输入邮箱" oninput="checkEmailLogin()" onblur="checkEmailLogin()"  />
				<!--密码  -->
				<input type="password" id="login_password"
					class="form-control log_password" placeholder="请输入密码"
					maxlength="15" oninput="checkPasswordLogin()" onblur="checkPasswordLogin()"/>
				<!-- 忘记密码 -->
				<div class="forget_password">忘记密码?</div>
				<!-- 错误提示框 -->
				<div class="log_alert_div" id="login_alert_div"></div>
				<!-- 登录按钮 -->
				<button class="btn btn-success btn-block log_btn button_a"
					style="font-size: 16px;" id="login_button" onclick="login()">登录</button>
			</div>
			<!-- 注册 -->
			<div class="login_div" id="register_div" style="display: none;">
				<!-- 用户名 -->
				<input type="text" class="form-control log_email reg_username"
					id="register_username" placeholder="请输入用户名" oninput="checkUsername()" onblur="checkUsername() "/>
				<!-- 邮箱 -->
				<input type="text" class="form-control log_email"
					placeholder="请输入邮箱" id="register_email" oninput="checkEmailRegister()" onblur="checkEmailRegister()" />
				<!-- 密码 -->
				<input type="password" class="form-control log_password"
					placeholder="请输入密码" maxlength="15" id="register_password"
					oninput="checkPasswordRegister()" onblur="checkPasswordRegister()" />
				<!-- 确认密码 -->
				<input type="password" id="register_repassword"
					class="form-control log_password reg_repassword"
					placeholder="请确认密码" maxlength="15" oninput="checkRepassword()" onblur="checkRepassword()"/>
				<!-- 错误提示框 -->
				<div class="log_alert_div" id="register_alert_div"></div>
				<!-- 注册按钮 -->
				<button class="btn btn-success btn-block reg_btn button_a"
					style="font-size: 16px;" id="register_button" onclick="register()">注册</button>
			</div>
			<h4 style="display:none;padding:20px;float:left;" id="check_email_text">邮件发送成功，请进行验证...</h4>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/index/navbar.js"></script>

</body>

</html>