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

		<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=basePath%>css/lwk/navbar.css" />
		<link rel="stylesheet" href="<%=basePath%>css/zb/zb.css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<%=basePath%>css/zb/fontawesome-all.css" />
	</head>

	<body style="margin: 0;padding: 0;background-color: #f6f6f6;">
		<!--整个导航-->
		<div style="background-color: #FFFFFF;width: 100%;height: 56px;">
			<!--导航的主体部分-->
			<div style="width: 960px;height: 100%;margin: 0 auto;">
				<!--logo-->
				<img src="<%=basePath%>css/zb/img/wglogo.png" style="height: 45px;float: left;margin: 5.5px 20px 0 20px;" />
				<!--分类-->
				<div class="a_cateory" style="float: left;" onclick="window.location.href='/wlmtxt/view/index/index.jsp'">首页</div>
				<div class="a_cateory" style="float: left;" onclick="window.location.href='/wlmtxt/view/index/friends_dynamic.jsp'">动态</div>
				<div class="a_cateory" style="float: left;" onclick="window.location.href='/wlmtxt/view/index/index_category.jsp'">分类</div>
				<div class="a_cateory" style="float: left;" onclick="window.location.href='/wlmtxt/view/index/index_rank.jsp'">排行榜</div>
				<!--头像-->
				<img class="user_img" src="<%=basePath%>css/zb/img/tx.jpg" style="float: right;height: 45px;width: 45px;margin: 5.5px 0 0 0;" />
				<!--个人中心-->
				
				<div class="a_cateory" style="float: right;margin: 0 10px;" onclick="window.location.href='/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp'">个人中心</div>
				<div class="a_cateory" style="float: right;" onclick="window.location.href='/wlmtxt/view/personal_center/personal_center_upload_dynamic.jsp'">发布作品</div>
				<!--搜索-->

			</div>
		</div>
	</body>

</html>