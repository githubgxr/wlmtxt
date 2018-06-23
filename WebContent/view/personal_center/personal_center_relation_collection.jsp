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
		<link rel="stylesheet" href="<%=basePath%>css/lyq/ywxg_collection.css" />
	</head>
	<body>
		<div class="wlmtxt_main">
			<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
			<div class="wlmtxt_container">
				<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
				<div id="llls_main" class="main_container">
					<!--浏览历史头部-->
					
					<!--子导航-与我相关、消息中心-->
					<jsp:include page="/personal_center_relation_nav.jsp" flush="true"></jsp:include>
					
					<!--主体部分-->
					<div class="llls_content list_container">
						<ul id="relation_collection_list_container">
							<%-- <li class="list_video_item">
								<!--视频链接-->
								<a class="video_list_item_wrap">
									<div class="video_cover">
										<img class="video_img" src="<%=basePath%>css/zb/img/4.png" />
										<div class="video_overplay"></div>
										<div class="video_play"></div>
									</div>
									<!--视频信息-->
									<div class="video_info">
										<!--标题-->
										<div class="video_title">德科恶女合家福好地方好地方</div>
										<!--浏览量-->
										<div class="video_number">425</div>
										<!--用户名-->
										<div class="video_username">发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr</div>

									</div>
								</a>

								<!--视频分类-->
								<div class="video_label">
									<div class="video_label_content">
										<a class="video_label_item">绝地求生</a>
										<a class="video_label_item">绝地求生</a>
										<a class="video_label_item">绝地求生</a>
									</div>
								</div>
								<div class="video_options">
									<a class="video_delete_btn">取消收藏</a>
								</div>
							</li> --%>
						</ul>

					</div>
					<!-----翻页----------------------->
					<!-- <div class="page_container">
						<div class="page_component_container">
							<div class="page_component">
								<a class="page_prev" href="#">上一页</a>
								<a class="selected" href="#">1</a>
								<a href="#">2</a>
								<a href="#">3</a>
								<a href="#">4</a>
								<a href="#">5</a>
								<b>...</b>
								<a href="#">23</a>
								<a class="page_next" href="#">上一页</a>
								<span class="page_component_jumppage">跳转到：</span>
								<input class="page_component_jumptxt" type="text">
								<a href="#" class="page_component_submit">GO</a>
							</div>
						</div>
					</div> -->
				</div>

			</div>
			<jsp:include page="/foot.jsp" flush="true"></jsp:include>
			
		</div>
		<div class="my_collection" id="my_collection"  style="display:none;">我的收藏</div>
		<script type="text/javascript" src="<%=basePath%>js/personal_center/personal_center_relation.js"></script>
		<script type="text/javascript">
			var clearfix_a=$(".clearfix a");
			$.each(clearfix_a,function(i){
				var clearfix_a_html=$(clearfix_a[i]).html();
				if($(".my_collection").html()==clearfix_a_html){
					$(this).addClass("selected");
				}
			});
		</script>
		<script type="text/javascript">
		personal_center_relation("listMyCollectList");
		</script>
		<script type="text/javascript" src="<%=basePath%>js/personal_center/personal_center_relation_collection.js"></script>
	</body>
</html>