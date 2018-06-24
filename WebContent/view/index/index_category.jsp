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
			<div style="float: left;" id="div_img">
				<img src="<%=basePath%>img/img_back.png" id="img_back"
					style="width: 30px; height: 30px; display: none;">
			</div>
			<i class="header_line"></i>
			<h3 style="margin: 4px 0 0 0;" id="category_name"></h3>
		</div>
		<div class="llls_content list_container"
			style="margin: 20px 0 20px 0;">
			<ul id="llls_list_container" style="height: 80%;">
			</ul>

		</div>
	</div>
	<!--翻页-->
	<jsp:include page="/foot.jsp" flush="true"></jsp:include>
</body>

<script type="text/javascript"
	src="<%=basePath%>/js/index/index_category.js"></script>

</html>