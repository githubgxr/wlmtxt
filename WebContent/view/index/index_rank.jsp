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
<title>排行榜</title>
<link rel="stylesheet" href="<%=basePath%>css/lwk/index_list.css" />
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_llls.css" />
<link rel="stylesheet" href="<%=basePath%>css/lwk/index_rank.css">
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">
	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>



	<!-- 排行榜+所有榜 -->
	<div
		style="width: 960px; background-color: #f6f6f6; padding: 0 0 20px 0; margin: 0 0 0 calc(( 100% - 960px)/2); border-radius: 5px; float: left;">
		<div class="data-title-container">
			<p>排行榜</p>
		</div>
		<!-- 所有榜 -->
		<div class="rank-column">

			<!--电影榜  -->
			<div class="rank-table-content rank-table-movie"
				style="margin: 20px 25px; float: left; padding: 20px; background-color: #ffffff; border-radius: 5px;">
				<!--榜头  -->
				<div class="rank-table-header">
					<!--一级分类名  -->
					<p class="title">日榜</p>
					<!--问号提示  -->
					<!-- <div class="question">
						<div class="question-hover-dialog">按照主播获得的送礼人数排名</div>
					</div> -->
					<!--数据时间段  -->
					<div class="exchange-tab">
						<a data-table="popular" data-time="now" class="active">本日</a> <a
							data-table="popular" data-time="past">上日</a>
					</div>
				</div>

				<!-- 榜单内容 -->
				<div class="rank-table-body">
					<ul class="ps ps--active-y"
						style="width: 230px; padding: 10px 0px; float: left; display: inline-block;">
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

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

				<!--电影榜  -->

			</div>
			<!--电影榜  -->
			<div class="rank-table-content rank-table-movie"
				style="margin: 20px 25px; float: left; padding: 20px; background-color: #ffffff; border-radius: 5px;">
				<!--榜头  -->
				<div class="rank-table-header">
					<!--一级分类名  -->
					<p class="title">周榜</p>
					<!--问号提示  -->
					<!-- <div class="question">
						<div class="question-hover-dialog">按照主播获得的送礼人数排名</div>
					</div> -->
					<!--数据时间段  -->
					<div class="exchange-tab">
						<a data-table="popular" data-time="now" class="active">本周</a> <a
							data-table="popular" data-time="past">上周</a>
					</div>
				</div>

				<!-- 榜单内容 -->
				<div class="rank-table-body">
					<ul class="ps ps--active-y"
						style="width: 230px; padding: 10px 0px; float: left; display: inline-block;">
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

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

				<!--电影榜  -->

			</div>
			<!--电影榜  -->
			<div class="rank-table-content rank-table-movie"
				style="margin: 20px 25px; float: left; padding: 20px; background-color: #ffffff; border-radius: 5px;">
				<!--榜头  -->
				<div class="rank-table-header">
					<!--一级分类名  -->
					<p class="title">月榜</p>
					<!--问号提示  -->
					<!-- <div class="question">
						<div class="question-hover-dialog">按照主播获得的送礼人数排名</div>
					</div> -->
					<!--数据时间段  -->
					<div class="exchange-tab">
						<a data-table="popular" data-time="now" class="active">本月</a> <a
							data-table="popular" data-time="past">上月</a>
					</div>
				</div>

				<!-- 榜单内容 -->
				<div class="rank-table-body">
					<ul class="ps ps--active-y"
						style="width: 230px; padding: 10px 0px; float: left; display: inline-block;">
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

								</div>
						</a> <!--视频分类-->
							<div class="video_label">
								<div class="video_label_content">
									<a class="video_label_item">绝地求生</a> <a
										class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
								</div>
							</div>
						</li>
						<li class="list_video_item">
							<!--视频链接--> <a class="video_list_item_wrap">
								<div class="video_cover">
									<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
									<div class="category_name">分类</div>
									<div class="video_overplay"></div>
									<div class="video_play"></div>
								</div> <!--视频信息-->
								<div class="video_info">
									<!--标题-->
									<div class="video_title">德科恶女合家福好地方好地方</div>
									<!--浏览量-->
									<div class="video_number">425</div>
									<!--用户名-->
									<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

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

				<!--电影榜  -->

			</div>


			<!-- 所有榜 -->
		</div>
		<!--  -->
	</div>





	<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>

</html>