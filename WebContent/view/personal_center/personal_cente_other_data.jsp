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
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_wddt.css" />
	<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_tdzl.css" />

</head>

<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container ">
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
			<!--发布视频-->
			<div class="main_container">
			<div style="display:none;" id="other_id"></div>
				<!--浏览历史头部-->
				<div class="tdzl_header list_header">
					<i class="header_line"></i>
					<h3>TA的资料</h3>
				</div>
				<!--主体部分-->
				<div class="tdzl_content">
					<div class="personal-setting-container">
						<div class="personal_info">
							<div class="personal_pic">
								<div class="user_img_div">
									<img src="<%=basePath%>img/user.jpg" />
									<div class="user_foot">
										<div class="user_fans">
											关注<span id="other_data_focus"></span>
										</div>
										<div class="user_fans">
											粉丝<span id="other_data_fans"></span>
										</div>
									</div>
								</div>

								<div class="personal_info_details">
									<div class="img_wrap_list">
										<span class="highlight">昵称：</span>
										<div id="other_data_username" class="personal_info_value highlight"
											style="color: #1cd388;"></div>
									</div>
									<div class="img_wrap_list">
										<span>账号：</span>
										<div class="personal_info_value" id="other_data_email"></div>
									</div>
									<div class="img_wrap_list">
										<span>性别：</span>
										<div class="personal_info_value" id="other_data_sex"></div>
									</div>
									<div class="img_wrap_list">
										<span>简介：</span>
										<div class="personal_info_value grjj" id="other_data_bio"></div>
									</div>

								</div>
							</div>

						</div>

					</div>
				</div>
			</div>
			<!--我的动态-->
			<div class="main_container">
				<div class="tdzl_header list_header">
					<i class="header_line"></i>
					<h3>TA的动态</h3>
				</div>
				<!--主体部分-->
				<div class="wddt_content list_container">
					<ul id="other_dynamic_list_container">
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--发布时间-->
									<div class="video_time">2018-5-30 14:18:02</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>

						</li>
					</ul>

				</div>
				<!--翻页-->
				<!-- <div class="page_container">
					<div class="page_component_container">
						<div class="page_component">
							<a class="page_prev" href="#">上一页</a> <a class="selected"
								href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
							<a href="#">5</a> <b>...</b> <a href="#">23</a> <a
								class="page_next" href="#">下一页</a> <span
								class="page_component_jumppage">跳转到：</span> <input
								class="page_component_jumptxt" type="text"> <a href="#"
								class="page_component_submit">GO</a>
						</div>
					</div>
				</div> -->
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/personal_center/personal_cente_other_data.js"></script>
</body>

</html>