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


</head>

<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container ">
			<!--导航-->
			<jsp:include page="/personal_center_nav.jsp" flush="true"></jsp:include>
			<!--我的动态-->

			<div id="wddt_main" class="main_container">
				<!--浏览历史头部-->
				<div class="wddt_header list_header">
					<i class="header_line"></i>
					<h3>和我相似的用户</h3>
				</div>
				<!--主体部分-->
				<div class="wddt_content list_container"></div>
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
</body>

</html>