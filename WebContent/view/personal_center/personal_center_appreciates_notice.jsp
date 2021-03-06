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
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_llls.css" />
<link rel="stylesheet" href="<%=basePath%>css/zb/zb.css" />
<link rel="stylesheet" href="<%=basePath%>css/lyq/xxzx_dztz.css" />
</head>
<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container">
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
			<div id="llls_main" class="main_container">
				<!--浏览历史头部-->
				<jsp:include page="/personal_center_notice_nav.jsp" flush="true"></jsp:include>
				<!--主体部分-->
				<div class="llls_content list_container" style="margin-bottom: 10px">
					<div id="llls_list_container">
						<div class="video_options">
							<div class="neck_name user_img_small">
								<img class="user_img_small "
									src="<%=basePath%>css/zb/img/tx.jpg " />
							</div>
							<div class="thumd_name">王小二</div>
							<div class="thumd_time">2018.6.3</div>
						</div>
						<div class="info_concise">王小二点赞了你的视频</div>
						<li class="list_video_item">
							<div class="list_li ">
								<!--视频链接-->
								<a class="video_list_item_wrap ">
									<div class="video_cover ">
										<img class="video_img " src="<%=basePath%>css/zb/img/4.png" />
										<div class="video_overplay "></div>
										<div class="video_play "></div>
									</div>
								</a>
							</div>
						</li>
						<div class="info_container">
							<span class="span_name">王小二：</span> <span class="span_info">我爱吃萝卜和青菜，身体健康人又可爱，萝卜青菜我最爱！</span>
						</div>
					</div>
					
				</div>
				<!-----翻页----------------------->
				<div class="page_container " style="margin: 10px auto">
					<div class="page_component_container ">
						<div class="page_component ">
							<a class="page_prev " href="# ">上一页</a> <a class="selected "
								href="# ">1</a> <a href="# ">2</a> <a href="# ">3</a> <a
								href="# ">4</a> <a href="# ">5</a> <b>...</b> <a href="# ">23</a>
							<a class="page_next " href="# ">上一页</a> <span
								class="page_component_jumppage ">跳转到：</span> <input
								class="page_component_jumptxt " type="text "> <a
								href="# " class="page_component_submit ">GO</a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
	<div class="appreciates_notice">点赞通知</div>
	<script type="text/javascript">
		var clearfix_a=$(".clearfix a");
		$.each(clearfix_a,function(i){
			var clearfix_a_html=$(clearfix_a[i]).html();
			if($(".appreciates_notice").html()==clearfix_a_html){
				$(this).addClass("selected");
			}
		});
	</script>
	<script type="text/javascript" src="<%=basePath%>js/personal_center/personal_center_appreciates_notice.js"></script>
</body>
</html>