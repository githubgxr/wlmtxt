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
<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_llls.css" />
<link rel="stylesheet" href="<%=basePath%>css/zb/zb.css" />
<link rel="stylesheet" href="<%=basePath%>css/lyq/xxzx_dztz.css" />
<link rel="stylesheet" href="<%=basePath%>css/friends_dynamic.css" />
</head>
<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container" style="width: 600px;margin: 0 calc( ( 100% - 600px ) / 2  );">
			<!--浏览历史头部-->
			<div class="llls_header list_header">
				<i class="header_line" style="float: left;"></i>
				<h3 style="margin: 0px; padding: 0px;">好友动态</h3>
			</div>
			<!--主体部分-->
			<div class="llls_content list_container" style="margin: 20px 0px;">
				<div id="llls_list_container">
<!-- 					<div class="video_options"> -->
<!-- 						<div class="neck_name user_img_xzt_div"> -->
<%-- 							<img class="user_img_xzt " src="<%=basePath%>css/zb/img/tx.jpg " />  --%>
<!-- 						</div> -->
<!-- 						<div class="info_dynamic_name">王小二</div> -->
<!-- 						<div class="info_dynamic_time">2018.6.3</div> -->
<!-- 						<div class="info_dynamic_title">小猪正在享受高空飞翔的快感</div> -->
<!-- 						<div class="info_dynamic_concise">聪明的小猪觉得天气这么热，聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热聪明的小猪觉得天气这么热</div> -->
<!-- 						<div class="list_img"> -->
<%-- 							<img class="video_img" src="<%=basePath%>css/zb/img/4.png"  --%>
<!-- 								style="width: 660px; height: 330px;" />  -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<hr style="float: left; width: 100%;" /> -->
				</div>

			</div> 
			<!-----翻页----------------------->

		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript"
	src="<%=basePath%>js/index/friends_dynamic-zb.js"></script>
</html>