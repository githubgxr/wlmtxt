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
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/swiper.min.css">
<script src="<%=basePath%>js/swiper.min.js"></script>
<!--------------------------------------------------------------------------------->
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!--页面上部主体-->

	<div id="lbt_con"
		style="width: 960px; height: 576px; background-color: #FFFFFF; padding: 20px; margin: 10px 0 0 calc(( 100% - 960px)/2); border-radius: 5px; float: left;">
		<div
			style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
			推荐</div>
		<!--大推荐-->

		<!--小推荐-->
		<div style="height: 330px; width: 260px; float: right;">

			<div
				style="margin: 0 0 70px 0; background-size: 240px 155px; height: 155px; width: 240px; float: right;">
				<ul id="lbt_little_con">



				</ul>
			</div>
		</div>
	</div>
	<!--关注人的动态-->
	<div
		style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: 960px; margin: 20px 0 20px calc(( 100% - 960px)/2); float: left;">
		<div
			style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
			<span>猜你喜欢</span> <span class="dz_no" style="float: right;"
				onclick="collaborativeFilteringByUser()"> <i
				class="fas fa-sync-alt"></i>&nbsp;换一批
			</span>
		</div>
		<div>
			<ul id="cnxh_list_container">



			</ul>
		</div>
	</div>


	<!--中间-->
	<div>
		<!--推荐-->
		<div
			style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: 600px; margin: 0 0 0 calc(( 100% - 960px)/2);">
			<div
				style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
				<span>大家都在看</span> <span class="dz_no" style="float: right;"
					onclick="hotRecommend()"><i class="fas fa-sync-alt"></i>&nbsp;换一批</span>
			</div>
			<!--推荐列表-->
			<div style="height: 420px;">
				<ul id="djdzk_llls_list_container">



				</ul>

			</div>

		</div>
		<!--推荐结束-->
		<!--排行-->
		<div
			style="background-color: #ffffff; padding: 20px; border-radius: 5px; width: 340px; margin: 0 0 0 20px; height: auto; float: left;">
			<div
				style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
				<span>周榜</span> <span class="dz_no" style="float: right;"
					onclick="window.location='/wlmtxt/view/index/index_rank.jsp'">查看&nbsp;<i
					class="fas fa-angle-double-right "></i></span>
			</div>
			<div style="color: #999; padding: 0 0px;" id="index_week_rank">

			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>

		<script type="text/javascript">
			$(function() {
				$("#dtj")
						.click(
								function() {
									window.location.href = "/wlmtxt/view/index/video_details.jsp";
								});
			});
		</script>
</body>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
</html>