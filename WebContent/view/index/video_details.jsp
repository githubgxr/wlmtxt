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

<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<link rel="stylesheet" href="../../css/navbar/style.css" />
<link rel="stylesheet" href="../../css/zb/fontawesome-all.css" />
<link rel="stylesheet" href="../../css/zb/zb.css" />
<link rel="stylesheet" href="../../css/wlmtxt.css" />
<link rel="stylesheet" href="../../css/xzt.css" />
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!--<div style="background-color: blanchedalmond;height: 230px;"></div>-->
	<div style="width: 960px; margin: 0 calc(( 100% - 960px)/2);">
		<!--顶部-->
		<div
			style="float: left; background-color: #ffffff; padding: 0 20px; border-radius: 5px; margin: 20px 0 0 0;">
			<!--左上角大DIV-->
			<div style="width: 660px; float: left;">
				<!--标题-->
				<div
					style="color: #1cd388; font-size: 30px; margin: 20px 0 10px; padding: 0 50px 0 0; overflow: hidden;">樱花庄的宠物女孩</div>
				<!--简介-->
				<div
					style="color: #99a2aa; height: 50px; line-height: 25px; overflow: hidden; padding: 0 50px 0 0;">其实樱花庄一再告诉我们梦想是遥不可及的东西，人要学会现实，更要学会接受。其实樱花庄一再告诉我们梦想是遥不可及的东西。</div>
				<!--日期-->
				<div style="color: #99a2aa; margin: 10px 0 0px;">
					<span>2013-02-26 09:12:49</span>
				</div>
				<!--关键字-->
				<div style="margin: 10px 0 10px;">
					<span class="video_label_item" style="margin: 0 10px 0 0;">TV动画</span>
					<span class="video_label_item" style="margin: 0 10px 0 0;">高虐</span>
				</div>
			</div>
			<!--用户-->
			<div style="width: 260px; float: right; margin: 15px 0 0 0;">
				<!--用户头像-->
				<img class="user_img" src="../../css/zb/img/tx.jpg"
					style="float: left;" />

				<div style="float: right; margin: 0 0 0 20px; width: 170px;">
					<!--用户名-->
					<div style="color: #1cd388;">树深时见鹿dear</div>
					<!--个人介绍-->
					<div
						style="color: #99a2aa; height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">月黑杀人夜，风高放火天,月黑杀人夜，风高放火天,月黑杀人夜，风高放火天</div>
					<!--关注和粉丝-->
					<div style="color: #99a2aa;">
						<div style="width: 85px; float: left;">
							关注：<span style="color: #1cd388;">20</span>
						</div>
						<div style="width: 85px; float: right;">
							粉丝：<span style="color: #1cd388;">5</span>
						</div>
					</div>
					<div>
						<button class="button_a" style="width: 100%; margin: 10px 0;">关注</button>
					</div>
				</div>
			</div>
		</div>
		<!--中部-->
		<div style="">
			<div
				style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: calc(100%); margin: 20px 0 0;">
				<!--视频-->
				<video controls="controls" poster="../../css/zb/img/t1.jpg"
					src="../../css/zb/img/trailer.mp4" style="width: 100%;"></video>
				<!--点赞
					收藏
					播放量
					下载-->
				<div style="margin: 10px 0 0 0;">
					<div>
						<button class="button_code">
							<i class="fas fa-download"></i>&nbsp;下载
						</button>

						<div class="dz_yes" style="float: right;">
							<i class="fas fa-thumbs-up"></i>&nbsp;顶255
						</div>
						<div class="dz_no" style="float: right; margin: 0 20px;">
							<i class="fas fa-heart"></i>&nbsp;收藏50
						</div>
						<div class="dz_no" style="float: right; margin: 0">
							<i class="fas fa-play-circle"></i>&nbsp;播放500
						</div>
					</div>
				</div>
			</div>
			<!--推荐-->
			<div
				style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: calc(100%); margin: 20px 0 0;">
				<div style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px;">相关推荐</div>
				<!--推荐列表-->
				<div>
					<!--一个视频-->
					<div class="tj" style="float: left;">
						<img src="../../css/zb/img/4.png" />
						<div
							style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
							05【千夏】</div>
					</div>
					<!--一个视频-->
					<div class="tj" style="float: left;">
						<img src="../../css/zb/img/4.png" />
						<div
							style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
							05【千夏】</div>
					</div>
					<!--一个视频-->
					<div class="tj" style="float: left;">
						<img src="../../css/zb/img/4.png" />
						<div
							style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
							05【千夏】</div>
					</div>
					<!--一个视频-->
					<div class="tj" style="float: left;">
						<img src="../../css/zb/img/4.png" />
						<div
							style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
							05【千夏】</div>
					</div>
					<!--一个视频-->
					<div class="tj" style="float: left;">
						<img src="../../css/zb/img/4.png" />
						<div
							style="height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;">【10月】樱花庄的宠物女孩
							05【千夏】</div>
					</div>
				</div>
			</div>
			<!--评论-->
			<div
				style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: calc(100%); margin: 20px 0 0;">
				<div style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px;">2452&nbsp;评论</div>
				<!--发表评论-->
				<div>
					<textarea class="form-control textarea_pl"
						style="width: 90%; float: left;"></textarea>
					<div class="button_pl" style="float: right;">
						发表<br />评论
					</div>
				</div>
				<!--遍历内容-->
				<div style="float: left; width: 100%;">
					<hr style="width: 100%;" />
					<!--整个评论-->
					<div style="float: left; width: 100%;">
						<!--左边-->
						<div style="float: left; margin: 0 30px 0 0; width: 70px;">
							<!--头像-->
							<img class="user_img" src="../../css/zb/img/tx.jpg"
								style="float: left;" />
							<div
								style="color: #1cd388; float: left; margin: 20px 0 0 0; overflow: hidden; height: 20px;">树深时见鹿dear</div>
						</div>
						<!--右边-->
						<div style="float: right; width: 820px;">
							<div style="margin: 0 0 10px 0; min-height: 80px;">个人认为Z剧场版是最好看的。</div>
							<div style="color: #bfbfbf;">2017-05-11 23:22</div>
						</div>
					</div>
				</div>
				<!--遍历内容-->
				<div style="float: left; width: 100%;">
					<hr style="width: 100%;" />
					<!--整个评论-->
					<div style="float: left; width: 100%;">
						<!--左边-->
						<div style="float: left; margin: 0 30px 0 0; width: 70px;">
							<!--头像-->
							<img class="user_img" src="../../css/zb/img/tx.jpg"
								style="float: left;" />
							<div
								style="color: #1cd388; float: left; margin: 20px 0 0 0; overflow: hidden; height: 20px;">树深时见鹿dear</div>
						</div>
						<!--右边-->
						<div style="float: right; width: 820px;">
							<div style="margin: 0 0 10px 0; min-height: 80px;">个人认为Z剧场版是个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的最好个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的个人认为Z剧场版是最好看的看的。</div>
							<div style="color: #bfbfbf;">2017-05-11 23:22</div>
						</div>
					</div>
				</div>
				<!--遍历内容-->
				<div style="float: left; width: 100%;">
					<hr style="width: 100%;" />
					<!--整个评论-->
					<div style="float: left; width: 100%;">
						<!--左边-->
						<div style="float: left; margin: 0 30px 0 0; width: 70px;">
							<!--头像-->
							<img class="user_img" src="../../css/zb/img/tx.jpg"
								style="float: left;" />
							<div
								style="color: #1cd388; float: left; margin: 20px 0 0 0; overflow: hidden; height: 20px;">树深时见鹿dear</div>
						</div>
						<!--右边-->
						<div style="float: right; width: 820px;">
							<div style="margin: 0 0 10px 0; min-height: 80px;">个人认为Z剧场版是最好看的。</div>
							<div style="color: #bfbfbf;">2017-05-11 23:22</div>
						</div>
					</div>
				</div>
				<!--
						
					-->

<!-- 				<div class="page_container" -->
<!-- 					style="float: left; margin: 10px 0;"> -->
<!-- 					<hr style="width: 100%;" /> -->
<!-- 					<div class="page_component_container"> -->
<!-- 						<div class="page_component"> -->
<!-- 							<a class="page_prev" href="#">上一页</a> <a class="pageSelected" -->
<!-- 								href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> -->
<!-- 							<a href="#">5</a> <b>...</b> <a href="#">23</a> <a -->
<!-- 								class="page_next" href="#">上一页</a> <span -->
<!-- 								class="page_component_jumppage">跳转到：</span> <input -->
<!-- 								class="page_component_jumptxt" type="text"> <a href="#" -->
<!-- 								class="page_component_submit">GO</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</div>
	<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>

</html>