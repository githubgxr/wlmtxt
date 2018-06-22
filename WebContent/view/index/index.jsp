<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!--页面上部主体-->
	<div
		style="width: 960px; height: 426px; background-color: #FFFFFF; padding: 20px; margin: 10px 0 0 calc(( 100% - 960px)/2); border-radius: 5px; float: left;">
		<div
			style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
			推荐</div>
		<!--大推荐-->
		<div id="dtj"
			style="background-size:660px 330px ; background-image:url('<%=basePath%>css/zb/img/4.png'); height: 330px; width: 660px; float: left;">
			<div style="margin: 280px 0 0 0; background-color: #fbfbfb; float: left; opacity: 0.5; width: 100%; height: 50px; line-height: 50px; color: #1cd388; padding: 0 20px;">小猪正在享受高空飞翔的快感</div>
			<!-- <div style="margin: 10px 0 0 0;">
					<div>
						<a id="download_a" class="button_code user_operate button_a" href="/wlmtxt/Works/Works_getVideo?worksName=bd9ae373-9682-4839-b04c-cb2f9965ce64.mp4" download="trailer">
							<i class="fas fa-download" style="width:50px;float:left;line-height:32px;text-align:left;margin:0 0 0 -10px;">&nbsp;下载</i>
							<div style="float:left;"></div>
						</a>
						<div class="button_code user_operate button_a">
							<i class="fas fa-download"
								style="width: 50px; float: left; line-height: 32px; text-align: left; margin: 0 0 0 -10px;">&nbsp;下载</i>
						</div>
						<div class="dz_no user_operate" id="thumbs_number_div" style="float: right;">
							<i class="fas fa-thumbs-up"></i>&nbsp;顶<span id="thumbs_number">0</span>
						</div>
						<div class="dz_no user_operate" id="collect_number_div" style="float: right; margin: 0 20px;">
							<i class="fas fa-heart"></i>&nbsp;收藏<span id="collect_number">0</span>
						</div>
						<div class="dz_no" id="play_number_div" style="float: right; margin: 0">
							<i class="fas fa-play-circle"></i>&nbsp;播放<span id="play_number">1</span>
						</div>
					</div>
				</div> -->
		</div>
		<!--小推荐-->
		<div style="height: 330px; width: 260px; float: right;">

			<div
				style="  margin: 0 0 20px 0;background-size:240px 155px ; background-image:url('<%=basePath%>css/zb/img/4.png'); height: 155px; width: 240px; float: right;">
				<div
					style="margin: 125px 0 0 0; background-color: #fbfbfb; float: right; opacity: 0.5; width: 100%; height: 30px; line-height: 30px; color: #1cd388; padding: 0 20px;">小猪正在享受高空飞翔的快感</div>
			</div>
			<div
				style="background-size:240px 155px ; background-image:url('<%=basePath%>css/zb/img/4.png'); height: 155px; width: 240px; float: right;">
				<div
					style="margin: 125px 0 0 0; background-color: #fbfbfb; float: right; opacity: 0.5; width: 100%; height: 30px; line-height: 30px; color: #1cd388; padding: 0 20px;">小猪正在享受高空飞翔的快感</div>
			</div>
		</div>
	</div>
	<!--关注人的动态-->
	<div
		style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: 960px; margin: 20px 0 20px calc(( 100% - 960px)/2); float: left;">
		<div
			style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
			<span>动态</span> <span class="dz_no" style="float: right;">更多&nbsp;<i
				class="fas fa-angle-double-right "></i></span>
		</div>
		<div>
			<!--一个视频-->
			<div class="tj" style="float: left;">
				<img src="<%=basePath%>css/zb/img/4.png" />
				<div
					style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
					05【千夏】</div>
			</div>
			<!--一个视频-->
			<div class="tj" style="float: left;">
				<img src="<%=basePath%>css/zb/img/4.png" />
				<div
					style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
					05【千夏】</div>
			</div>
			<!--一个视频-->
			<div class="tj" style="float: left;">
				<img src="<%=basePath%>css/zb/img/4.png" />
				<div
					style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
					05【千夏】</div>
			</div>
			<!--一个视频-->
			<div class="tj" style="float: left;">
				<img src="<%=basePath%>css/zb/img/4.png" />
				<div
					style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
					05【千夏】</div>
			</div>
			<!--一个视频-->
			<div class="tj" style="float: left;">
				<img src="<%=basePath%>css/zb/img/4.png" />
				<div
					style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
					05【千夏】</div>
			</div>
		</div>
	</div>


	<!--中间-->
	<div>
		<!--推荐-->
		<div
			style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: 600px; margin: 0 0 0 calc(( 100% - 960px)/2);">
			<div
				style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
				<span>大家都在看</span> <span class="dz_no" style="float: right;"><i
					class="fas fa-sync-alt"></i>&nbsp;换一批</span>
			</div>
			<!--推荐列表-->
			<div style="height: 320px;">
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
				<!--一个视频-->
				<div class="tj" style="float: left;">
					<img src="<%=basePath%>css/zb/img/4.png" />
					<div
						style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
						05【千夏】</div>
				</div>
			</div>

		</div>
		<!--推荐结束-->
		<!--排行-->
		<div
			style="background-color: #ffffff; padding: 20px; border-radius: 5px; width: 340px; margin: 0 0 0 20px; height: 416px; float: left;">
			<div
				style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
				<span>周榜</span> <span class="dz_no" style="float: right;">查看&nbsp;<i
					class="fas fa-angle-double-right "></i></span>
			</div>
			<div style="color: #999; padding: 0 20px;">
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star" style="color: #1cd388;"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star" style="color: #1cd388;"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star" style="color: #1cd388;"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
				<div
					style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">
					<i class="fas fa-star"></i>&nbsp;&nbsp;不管说什么都在摸鱼的秦先生什么也不知道吗
				</div>
			</div>
		</div>

		<jsp:include page="/foot.jsp" flush="true"></jsp:include>

		<script type="text/javascript">
			$(function() {
				$("#dtj").click(
								function() {
									window.location.href = "/wlmtxt/view/index/video_details.jsp";
								});
			});
		</script>
</body>

</html>