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
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!--页面上部主体-->
	<div
		style="width: 960px; height: 576px; background-color: #FFFFFF; padding: 20px; margin: 10px 0 0 calc(( 100% - 960px)/2); border-radius: 5px; float: left;">
		<div
			style="color: #1cd388; margin: 0 0 20px 0; font-size: 18px; line-height: 36px;">
			推荐</div>
		<!--大推荐-->
		<div id="dtj"
			style="background-size:660px 385px ; background-image:url('<%=basePath%>css/zb/img/4.png'); height: 330px; width: 660px; float: left;">
			<ul id="llls_list_container">
				<li class="index_list_video_item"
						style="width: 660px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="height: 450px; width: 660px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="height: 385px; width: 660px;"/>
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 660px; height: 385px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 660px; height: 40px;margin:5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 660px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label"  style="width: 660px; height: 40px;">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
			</ul>
		</div>
		<!--小推荐-->
		<div style="height: 330px; width: 260px; float: right;">

			<div
				style="margin: 0 0 70px 0; background-size: 240px 155px; height: 155px; width: 240px; float: right;">
				<ul id="llls_list_container">
					<li class="index_list_video_item"
						style="width: 240px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="height: 200px; width: 240px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 240px; height: 135px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 240px; height: 135px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								 style="width: 240px; height: 40px;margin:5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 220px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label"  style="width: 220px; height: 40px;">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 240px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="height: 200px; width: 240px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 240px; height: 135px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 240px; height: 135px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								 style="width: 240px; height: 40px;margin:5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 220px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label"  style="width: 220px; height: 40px;">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					
				</ul>
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
			<ul id="llls_list_container">
				<li class="index_list_video_item"
					style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
					<!--视频链接--> <a class="video_list_item_wrap"
					style="width: 160px; height: 160px;">
						<div class="video_cover">
							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
								style="width: 160px; height: 100px;" />
							<div class="category_name">分类</div>
							<div class="video_overplay" style="width: 160px; height: 100px;"></div>
							<div class="video_play"
								style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
						</div> <!--视频信息-->
						<div class="video_info"
							style="width: 160px; height: 40px; margin: 5px 0;">
							<!--标题-->
							<div class="video_title"
								style="font-size: 12px; margin-left: 5px; width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							<!--用户名-->
							<div class="video_username"
								style="width: 90px; margin-top: -5px;">宠物女孩</div>
							<!--发布时间-->
							<div class="video_time"
								style="width: 70px; margin-top: -5px; float: right;">2018-6-13</div>
						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>
				<li class="index_list_video_item"
					style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
					<!--视频链接--> <a class="video_list_item_wrap"
					style="width: 160px; height: 160px;">
						<div class="video_cover">
							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
								style="width: 160px; height: 100px;" />
							<div class="category_name">分类</div>
							<div class="video_overplay" style="width: 160px; height: 100px;"></div>
							<div class="video_play"
								style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
						</div> <!--视频信息-->
						<div class="video_info"
							style="width: 160px; height: 40px; margin: 5px 0;">
							<!--标题-->
							<div class="video_title"
								style="font-size: 12px; margin-left: 5px; width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							<!--用户名-->
							<div class="video_username"
								style="width: 90px; margin-top: -5px;">宠物女孩</div>
							<!--发布时间-->
							<div class="video_time"
								style="width: 70px; margin-top: -5px; float: right;">2018-6-13</div>
						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>
				
				<li class="index_list_video_item"
					style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
					<!--视频链接--> <a class="video_list_item_wrap"
					style="width: 160px; height: 160px;">
						<div class="video_cover">
							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
								style="width: 160px; height: 100px;" />
							<div class="category_name">分类</div>
							<div class="video_overplay" style="width: 160px; height: 100px;"></div>
							<div class="video_play"
								style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
						</div> <!--视频信息-->
						<div class="video_info"
							style="width: 160px; height: 40px; margin: 5px 0;">
							<!--标题-->
							<div class="video_title"
								style="font-size: 12px; margin-left: 5px; width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							<!--用户名-->
							<div class="video_username"
								style="width: 90px; margin-top: -5px;">宠物女孩</div>
							<!--发布时间-->
							<div class="video_time"
								style="width: 70px; margin-top: -5px; float: right;">2018-6-13</div>
						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>
				
				<li class="index_list_video_item"
					style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
					<!--视频链接--> <a class="video_list_item_wrap"
					style="width: 160px; height: 160px;">
						<div class="video_cover">
							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
								style="width: 160px; height: 100px;" />
							<div class="category_name">分类</div>
							<div class="video_overplay" style="width: 160px; height: 100px;"></div>
							<div class="video_play"
								style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
						</div> <!--视频信息-->
						<div class="video_info"
							style="width: 160px; height: 40px; margin: 5px 0;">
							<!--标题-->
							<div class="video_title"
								style="font-size: 12px; margin-left: 5px; width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							<!--用户名-->
							<div class="video_username"
								style="width: 90px; margin-top: -5px;">宠物女孩</div>
							<!--发布时间-->
							<div class="video_time"
								style="width: 70px; margin-top: -5px; float: right;">2018-6-13</div>
						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>
				
				<li class="index_list_video_item"
					style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
					<!--视频链接--> <a class="video_list_item_wrap"
					style="width: 160px; height: 160px;">
						<div class="video_cover">
							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
								style="width: 160px; height: 100px;" />
							<div class="category_name">分类</div>
							<div class="video_overplay" style="width: 160px; height: 100px;"></div>
							<div class="video_play"
								style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
						</div> <!--视频信息-->
						<div class="video_info"
							style="width: 160px; height: 40px; margin: 5px 0;">
							<!--标题-->
							<div class="video_title"
								style="font-size: 12px; margin-left: 5px; width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							<!--用户名-->
							<div class="video_username"
								style="width: 90px; margin-top: -5px;">宠物女孩</div>
							<!--发布时间-->
							<div class="video_time"
								style="width: 70px; margin-top: -5px; float: right;">2018-6-13</div>
						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

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
				<span>大家都在看</span> <span class="dz_no" style="float: right;"><i
					class="fas fa-sync-alt"></i>&nbsp;换一批</span>
			</div>
			<!--推荐列表-->
			<div style="height: 420px;">
				<ul id="llls_list_container">
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>
					<li class="index_list_video_item"
						style="width: 160px; height: 200px; margin: 0 20px 10px 0;">
						<!--视频链接--> <a class="video_list_item_wrap"
						style="width: 160px; height: 160px;">
							<div class="video_cover">
								<img class="video_img" src="<%=basePath%>css/zb/img/4.png"
									style="width: 160px; height: 100px;" />
								<div class="category_name">分类</div>
								<div class="video_overplay" style="width: 160px; height: 100px;"></div>
								<div class="video_play"
									style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>
							</div> <!--视频信息-->
							<div class="video_info"
								style="width: 160px; height: 40px; margin: 5px 0;">
								<!--标题-->
								<div class="video_title"
									style="font-size: 12px; margin-left: 5px;">【10月】樱花庄的宠物女孩05【千夏】</div>
								<!--浏览量-->
								<div class="video_number">425</div>
								<!--用户名-->
								<div class="video_username" style="width: 160px;">【10月】樱花庄的宠物女孩05【千夏】</div>
							</div>
					</a> <!--视频分类-->
						<div class="video_label">
							<div class="video_label_content">
								<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								<a class="video_label_item">绝地求生</a>
							</div>
						</div>
					</li>

				</ul>

			</div>

		</div>
		<!--推荐结束-->
		<!--排行-->
		<div
			style="background-color: #ffffff; padding: 20px; border-radius: 5px; width: 340px; margin: 0 0 0 20px; height: 516px; float: left;">
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
				$("#dtj")
						.click(
								function() {
									window.location.href = "/wlmtxt/view/index/video_details.jsp";
								});
			});
		</script>
</body>

</html>