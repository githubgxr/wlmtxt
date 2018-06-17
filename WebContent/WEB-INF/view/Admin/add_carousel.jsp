<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加轮播图</title>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script type="text/javascript"
	src="<%=basePath%>js/Admin/add_carousel.js"></script>
</head>
<body>
	<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>
	<div
		style="margin: 50px 0 0 260px; width: calc(100% - 260px); padding: 0 20px;">

		<div style="width: 100%; float: right; margin: 0 15% 20px 0;">
			<%-- <div style="float: right; width: 220px;">
				<select class="selectpicker" id="number">
					<option value="大图">大图组</option>
					<option value="小图">小图组</option>
				</select>
			</div> --%>
			<div style="float: right; margin-right: 130px;"> 
				<input id="query" type="button" value="搜索" class="btn btn-primary">
			</div>
			<div style="float: right; margin-right: 30px;">
				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入作品标题">
			</div>
		</div>

		<table id="tableC" style="width: 70%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover">
			<tr><th>编号</th><th>封面</th><th>标题</th><th><input type="checkbox"  /></th></tr>
			<tr><td>1</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>2</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>3</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>4</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>5</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>6</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>7</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>8</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>9</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
			<tr><td>10</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td><input type="checkbox"  /></td></tr>
		</table>
		
		<button class="btn btn-danger"
			style="float: right; margin: 20px 15% 0 0;" id="add"
			onclick="addCarousel()">添加轮播</button>
		
		<div style="margin: 20px auto; width: 400px; text-align: center;">
			<button class="btn btn-primary" style="" id="lastPage">上一页</button>
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
<style type="text/css">
#tableC tr th {
	padding: 10px !important;
}
</style>
</html>