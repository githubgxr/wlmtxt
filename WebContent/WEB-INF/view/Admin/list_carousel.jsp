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
<title>轮播图列表</title>
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
				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入轮播作品标题">
			</div>
		</div>
		
		<!-- 内容写在此处 -->

		<!--  -->
		<table id="tableC"
			style="width: 70%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover">
			<tr>
				<th>编号</th>
				<th>封面</th>
				<th>标题</th>
				<th>排序</th>
				<th><input type="checkbox" /></th>
			</tr>
			<tr><td>1</td><td><img src="<%=basePath%>img/Admin/lb2.jpg" /></td><td>让子弹飞</td><td><a href="">^</a></td><td><input type="checkbox"  /></td></tr>
			<tr><td>2</td><td><img src="<%=basePath%>img/Admin/lb3.jpg" /></td><td>让子弹飞</td><td><a href="">^</a></td><td><input type="checkbox"  /></td></tr>
			<tr><td>3</td><td><img src="<%=basePath%>img/Admin/lb4.jpg" /></td><td>让子弹飞</td><td><a href="">^</a></td><td><input type="checkbox"  /></td></tr>
		</table>
		<!--  -->
		<button class="btn btn-danger"
			style="float: right; margin: 20px 15% 0 0;" id="delete"
			onclick="deleteCarousel()">删除轮播</button>
		<!--  -->
		<div style="margin: 20px auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" style="" id="lastPage">上一页</button>
			<button class="btn btn-primary" style="" id="indexPage">首页</button>
			<button class="btn btn-primary" style="" id="nextPage">下一页</button>
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