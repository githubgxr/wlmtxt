<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<!--<div style="background-color: blanchedalmond;height: 230px;"></div>-->
	<div style="width: 960px; margin: 0 calc(( 100% - 960px)/2);">
		<!--隐藏的div，作品id  -->
		<div id="video_id" style="display: none;"><s:property value="accept_works.works_id" /></div>
		<!--顶部-->
		<div
			style="float: left; background-color: #ffffff; padding: 0 20px; border-radius: 5px; margin: 20px 0 0 0;">
			<!--左上角大DIV-->
			<div style="width: 660px; float: left;">
				<!--标题-->
				<div id="detail_video_title"
					style="color: #1cd388; font-size: 30px; margin: 20px 0 10px; padding: 0 50px 0 0; overflow: hidden;">樱花庄的宠物女孩</div>
				<!--简介-->
				<div id="detail_video_discribe"
					style="color: #99a2aa; height: 50px; line-height: 25px; overflow: hidden; padding: 0 50px 0 0;">其实樱花庄一再告诉我们梦想是遥不可及的东西，人要学会现实，更要学会接受。其实樱花庄一再告诉我们梦想是遥不可及的东西。</div>
				<!--日期-->
				<div id="detail_video_time" style="color: #99a2aa; margin: 10px 0 0px;">
					<span>2013-02-26 09:12:49</span>
				</div>
				<!--关键字-->
				<div id="detail_video_keywords" style="margin: 10px 0 10px;">
					<span class="video_label_item" style="margin: 0 10px 0 0;">TV动画</span>
					<span class="video_label_item" style="margin: 0 10px 0 0;">高虐</span>
				</div>
			</div>
			<!--用户-->
			<div style="width: 260px; float: right; margin: 15px 0 0 0;">
				<!--用户头像-->
				<img id="detail_user_img" class="user_img" src=""
					style="float: left;" />

				<div style="float: right; margin: 0 0 0 20px; width: 170px;">
					<!--用户名-->
					<div id="detail_user_name" style="color: #1cd388;"></div>
					<!--个人介绍-->
					<div id="detail_user_bio"
						style="color: #99a2aa; height: 40px; line-height: 20px; overflow: hidden; margin: 10px 0;"></div>
					<!--关注和粉丝-->
					<div style="color: #99a2aa;">
						<div style="width: 85px; float: left;">
							关注：<span id="his_attention" style="color: #1cd388;">20</span>
						</div>
						<div style="width: 85px; float: right;">
							粉丝：<span id="his_fans" style="color: #1cd388;">5</span>
						</div>
					</div>
					<div>
						<button class="button_a user_operate not_focus" id="focus_btn"
							style="width: 100%; margin: 10px 0;">+ 关注</button>
					</div>
				</div>
			</div>
		</div>
		<!--中部-->
		<div style="">
			<div
				style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: calc(100%); margin: 20px 0 0;">
				<!--视频-->
				<video id="detail_video_content" controls="controls" poster=""
					src="" style="width: 100%;"></video>
				<!--点赞
					收藏
					播放量
					下载-->
				<div style="margin: 10px 0 0 0;">
					<div>
						<a id="download_a" class="button_code user_operate button_a" href="" download="trailer">
							<i class="fas fa-download"  style="width:50px;float:left;line-height:32px;text-align:left;margin:0 0 0 -10px;">&nbsp;下载</i>
							<div style="float:left;"></div>
						</a>
						<!-- <div class="button_code user_operate button_a">
							<i class="fas fa-download"
								style="width: 50px; float: left; line-height: 32px; text-align: left; margin: 0 0 0 -10px;">&nbsp;下载</i>
						</div> -->
						<div class="dz_no user_operate" id="thumbs_number_div"
							style="float: right;">
							<i class="fas fa-thumbs-up"></i>&nbsp;顶<span id="thumbs_number">2555</span>
						</div>
						<div class="dz_no user_operate" id="collect_number_div"
							style="float: right; margin: 0 20px;">
							<i class="fas fa-heart"></i>&nbsp;收藏<span id="collect_number">500</span>
						</div>
						<div class="dz_no" id="play_number_div"
							style="float: right; margin: 0">
							<i class="fas fa-play-circle"></i>&nbsp;播放<span id="play_number">30</span>
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
			<!--评论-->
			<div
				style="float: left; background-color: #ffffff; padding: 20px; border-radius: 5px; width: calc(100%); margin: 20px 0 0;">
				<div style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px;"><span id="discussNum">0</span>&nbsp;评论</div>
				<!--发表评论-->
				<div>
					<textarea class="form-control textarea_pl" id="textarea_comment"
						style="width: 90%; float: left;"></textarea>
					<div class="button_pl user_operate" style="float: right;" id="video_comment_btn" onclick="video_comment_btn_click()">
						发表<br />评论
					</div>
				</div>
				<div id="comment_div" style="float:left;width:100%;">
					<%-- <!--遍历内容-->
					<div style="float: left; width: 100%;">
						<hr style="width: 100%;" />
						<!--整个评论-->
						<div style="float: left; width: 100%;">
							<!--左边-->
							<div style="float: left; margin: 0 30px 0 0; width: 70px;">
								<!--头像-->
								<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg"
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
								<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg"
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
								<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg"
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
					</div> --%>
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
	</div>
	<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	<script type="text/javascript"
		src="<%=basePath%>js/index/video_details.js"></script>
</body>

</html>