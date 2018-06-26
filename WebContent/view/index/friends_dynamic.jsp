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
<link rel="stylesheet" href="<%=basePath%>css/lyq/xxzx.css" />
<link rel="stylesheet" href="<%=basePath%>css/friends_dynamic.css" />
</head>
<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container"
			style="width: 600px; margin: 0 calc(( 100% - 600px)/2);">
			<!--浏览历史头部-->
			<div class="llls_header list_header">
				<i class="header_line" style="float: left;"></i>
				<h3 style="margin: 0px; padding: 0px;">好友动态</h3>
			</div>
			<!--主体部分-->
			<div class="llls_content list_container" style="margin: 20px 0px;">
				<div id="llls_list_container">
					<div id="button_div_more" class="div_more"
						style="text-align: center;" onclick="getDynamicVO()">
						<span class="span_more">加载更多&nbsp;<i
							class="fas fa-angle-double-down "></i></span>
					</div>
					<div style="width:560px;">
						<!-- <div class="button_code user_operate button_a">
							<i class="fas fa-download"
								style="width: 50px; float: left; line-height: 32px; text-align: left; margin: 0 0 0 -10px;">&nbsp;下载</i>
						</div> -->
						
					</div>
				</div>

			</div>
			<!-----翻页----------------------->

		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>
<script type="text/javascript"
	src="<%=basePath%>js/index/friends_dynamic-zb.js"></script>
</html>