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
<link rel="stylesheet" href="<%=basePath%>css/lwk/index_list.css" />
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_llls.css" />

<link rel=stylesheet href="<%=basePath%>css/lwk/menu_list.css">
<link rel="stylesheet" href="<%=basePath%>css/xzt.css">
</head>

<body style="margin: 0; padding: 0; background-color: #f6f6f6;">

	<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
	<!--页面主体-->

	<div id="div_box"
		style="background-color: #FFFFFF; width: 1000px; margin: 20px calc(( 100% - 1000px)/2) 10px calc(( 100% - 1000px)/2); border-radius: 5px; padding: 20px 0">
	</div>

	<div
		style="background-color: #FFFFFF; margin: 20px calc(( 100% - 1000px)/2); border-radius: 5px; padding: 20px 20px 0 20px;">
		<div class="llls_header list_header" style="margin: 0 0 20px 0;">
			<i class="header_line"></i>
				<h3 style="margin:4px 0 0 0;">分类</h3>
		</div>
		<div class="llls_content list_container"
			style="margin: 20px 0 20px 0;">
			<ul id="llls_list_container">
				<%-- <li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li>

				<li class="list_video_item" style="margin: 0 5px 20px 5px;">
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
							<!--用户名-->
							<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

						</div>
				</a> <!--视频分类-->
					<div class="video_label">
						<div class="video_label_content">
							<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>
							<a class="video_label_item">绝地求生</a>
						</div>
					</div>
				</li> --%>


			</ul>
		</div>
	</div>
	<!--翻页-->
	<div class="page_container">
		<div class="page_component_container">
			<div class="page_component">
				<a class="page_prev" href="#">上一页</a> <a class="selected" href="#">1</a>
				<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a>
				<b>...</b> <a href="#">23</a> <a class="page_next" href="#">下一页</a>
				<span class="page_component_jumppage">跳转到：</span> <input
					class="page_component_jumptxt" type="text"> <a href="#"
					class="page_component_submit">GO</a>
			</div>
		</div>
	</div>
	<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript"
	src="<%=basePath%>/js/index/index_category.js">
	
</script>
</html>