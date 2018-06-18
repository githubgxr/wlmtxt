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
	<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_wdfs.css" />


</head>

<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container ">
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
			<!--我的关注-->
			<div id="wdfs_main" class="main_container">
				<!--头部-->
				<div class="wdfs_header list_header">
					<i class="header_line"></i>
					<h3>我的粉丝</h3>
					<a class="button_a" style="float: right;">全部关注</a>
				</div>
				<!--主体部分-->
				<div class="wdfs_content">
					<div class="user_list_container">
						<ul class="user_list_ul">
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊国防部多功能灰姑娘熊fh我比</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>

							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
							<li class="user_list">
								<div class="user_list_img_div">
									<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" />
								</div>
								<div class="user_info">
									<div class="user_name">熊啊熊</div>
									<div class="user_operateing">+ 关注</div>
									<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>
								</div>
							</li>
						</ul>
						
					</div>
				</div>
				<!--翻页-->
						<div class="page_container">
							<div class="page_component_container">
								<div class="page_component">
									<a class="page_prev" href="#">上一页</a> <a class="selected"
										href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
									<a href="#">5</a> <b>...</b> <a href="#">23</a> <a
										class="page_next" href="#">下一页</a> <span
										class="page_component_jumppage">跳转到：</span> <input
										class="page_component_jumptxt" type="text"> <a
										href="#" class="page_component_submit">GO</a>
								</div>
							</div>
						</div>
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>

</body>

</html>