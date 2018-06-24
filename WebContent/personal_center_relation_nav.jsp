<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="llls_header list_header">
		<i class="header_line"></i>
		<h3 style="margin: 0; padding: 0;">我的动作</h3>
		<!--子导航-与我相关、消息中心-->
		<div class="tab_container clearfix" style="float: right;">
			<a
				href="/wlmtxt/view/personal_center/personal_center_relation_collection.jsp"
				class="tabButton" id="collection">我收藏的</a> <a
				href="/wlmtxt/view/personal_center/personal_center_relation_appreciates.jsp"
				class="tabButton" id="appreciates">我点赞的</a> <a
				href="/wlmtxt/view/personal_center/personal_center_relation_comments.jsp"
				class="tabButton" id="comments">我评论的</a>
		</div>
	</div>
</body>
</html>