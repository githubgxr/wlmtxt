<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();//当前项目目录
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评论列表</title>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<%-- <link rel="stylesheet" href="<%=basePath%>css/Admin/normalize.css"> --%>
<%-- <link rel="stylesheet" href="<%=basePath%>css/Admin/style.css"> --%>
<script type="text/javascript"
	src="<%=basePath%>js/Admin/list_carousel.js"></script>
</head>
<body>
	<!-- /前代表网站的根地址即域名 -->
	<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>
	<div
		style="margin: 50px 0 0 260px; width: calc(100% - 260px); padding: 0 20px;">
		
		<div style="width: 100%; float: right; margin: 0 15% 20px 0;">
			<div style="float: right; margin-right: 130px;"> 
				<input id="query" type="button" value="搜索" class="btn btn-primary">
			</div>
			<div style="float: right; margin-right: 30px;">
				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入用户名、用户邮箱或评论内容">
			</div>
		</div>
		
		<!-- 内容写在此处 -->

		<!--  -->
		<table id="tableC"
			style="width: 70%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover">
			<tr>
				<th>编号</th>
				<th>评论内容</th>
				<th>评论用户</th>
				<th>评论用户邮箱</th>
				<th>评论时间</th>
				<th><input type="checkbox" /></th>
			</tr>
			<tr><td>1</td><td>这片ojbk</td><td>这个杀手不太冷</td><td>zgssbtl@sina.com</td><td>2018-5-6 12:23</td><td><input type="checkbox"  /></td></tr>
			<tr><td>2</td><td>太血腥</td><td>天圣孙</td><td>tss@sina.com</td><td>2018-6-6 13:23</td><td><input type="checkbox"  /></td></tr>
			<tr><td>3</td><td>恐怖片中的恐怖片</td><td>背锅侠</td><td>bgx@sina.com</td><td>2018-6-6 14:23</td><td><input type="checkbox"  /></td></tr>
		</table>
		<!--  -->
		<button class="btn btn-danger"
			style="float: right; margin: 20px 15% 0 0;" id="delete"
			onclick="deleteCarousel()">删除评论</button>
		<!--  -->
		<div style="margin: 20px auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" style="" id="lastPage">上一页</button>
			<button class="btn btn-primary" style="" id="indexPage">首页</button>
			<button class="btn btn-primary" style="" id="nextPage">下一页</button>
		</div>

		<div id="currentPage" style="text-align: center;">
			第 1 页	
		</div>
		<div id="pageCount" style="text-align: center;">
			共 1页
		</div>

	</div>
</body>
<script>
	// 	$('select').selectpicker('refresh');
</script>
<style type="text/css">
#tableC tr th {
	padding: 10px !important;
}
</style>
</html>