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
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_llls.css" />
</head>

<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container ">
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
			<!--浏览历史-->

			<div id="llls_main" class="main_container">
				<!--浏览历史头部-->
				<div class="llls_header list_header">
					<i class="header_line"></i>
					<h3>观看历史</h3>

					<a id="history_delete_all" style="display: none;" class="button_a"
						onclick="deleteAllMyHistory()">全部清空</a>
				</div>
				<!--主体部分-->
				<div class="llls_content list_container">
				
					<ul id="llls_list_container" style="background-color: #FFFFFF;">
						
					</ul>


				</div>
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/personal_center/personal_center_watch_history.js"></script>

</body>

</html>