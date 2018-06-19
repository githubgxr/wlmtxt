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
			<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_grzl.css" />

	</head>

	<body>
		<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
			<div class="wlmtxt_container ">
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
				<!--发布视频-->
				<div id="grzl_main" class="main_container">
					<!--浏览历史头部-->
					<div class="grzl_header list_header">
						<i class="header_line"></i>
						<h3>个人资料</h3>
					</div>
					<!--主体部分-->
					<div class="grzl_content">
						<div class="personal-setting-container">
							<div class="personal_info">
								<div class="personal_pic">
									<img src="<%=basePath%>img/user.jpg" />
									<div class="update_msg">
										<a href="#" class="category_a">更换头像</a>
										<div class="personal_pic_alert">JPG或PNG格式，最大3MB，不支持GIF</div>
									</div>
								</div>
								<div class="personal_info_details">
									<div class="img_wrap_list">
										<span class="highlight">昵称：</span>
										<div class="personal_info_value highlight div_username"></div>
										<input type="text"   class="input_xzt xg input_username" style="width:400px;" placeholder="" value="" />
									</div>
									<div class="img_wrap_list">
										<span>账号：</span>
										<div class="personal_info_value div_email"></div>
										<input type="text" class="input_xzt xg input_email" style="width:400px;" placeholder="" value="" />
									</div>
									<div class="img_wrap_list">
										<span>性别：</span>
										<div class="personal_info_value div_sex"></div>
										<!-- <input type="text" class="input_xzt xg input_sex" style="width:400px;" placeholder="" value="" /> -->
										<select class="input_xzt xg input_sex " style="width:400px;">
										<option value="">请选择</option>
										<option value="男">男</option>
										<option value="女">女</option>
										</select>
									</div>
									<div class="img_wrap_list">
										<span>简介：</span>
										<div class="personal_info_value grjj div_bio"></div>
										<textarea class="textarea_xzt xg input_bio" style="width:400px;" maxlength="100">
										</textarea>
									</div>
									
								</div>
								<div class="operate_btns">
									<a class="button_a update_btn">修改个人资料</a>
									<a class="button_a check_btn">确认修改</a>
									<a class="button_a reset_btn">取消</a>
								</div>
							</div>
							<!--修改密码-->
							<div class="update_pwd">
								<div class="update_pwd_header">修改密码</div>
								<div class="update_pwd_container">
									<div class="img_wrap_list">
										<span>旧密码：</span>
										<input type="text" class="input_xzt pwd old_password" style="width:400px;"  placeholder="请输入旧密码" value="" />
									</div>
									<div class="img_wrap_list">
										<span>新密码：</span>
										<input type="text" class="input_xzt pwd new_password" style="width:400px;"  placeholder="请输入新密码" value="" />
									</div>
									<div class="img_wrap_list">
										<span>确认新密码：</span>
										<input type="text" class="input_xzt pwd new_repassword" style="width:400px;" placeholder="请确认新密码" value="" />
									</div>
									<a class="button_a check_pwd_btn">确认修改密码</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				<jsp:include page="/foot.jsp" flush="true"></jsp:include>
		</div>
	<script type="text/javascript" src="<%=basePath%>js/personal_center/personal_center_personal_data.js"></script>
	</body>

</html>