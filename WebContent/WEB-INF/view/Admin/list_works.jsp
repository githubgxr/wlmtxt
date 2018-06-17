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
<title>作品列表</title>
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
				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入作品标题">
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
				<th>
					<select>
						<option>审核情况</option>
						<option>待审核</option>
						<option>通过</option>
						<option>不通过</option>
					</select>
				</th>
				<th>
					<select>
						<option>是否删除</option>
						<option>已删除</option>
						<option>未删除</option>
					</select>
				</th>
				<th><input type="checkbox" /></th>
			</tr>
			<tr><td>1</td><td><img src="<%=basePath%>img/Admin/lb1.jpg" /></td><td>让子弹飞</td><td>待审核</td><td>是</td><td><input type="checkbox"  /></td></tr>
			<tr><td>2</td><td><img src="<%=basePath%>img/Admin/lb2.jpg" /></td><td>少年奇幻漂流</td><td>待审核</td><td>否</td><td><input type="checkbox"  /></td></tr>
			<tr><td>3</td><td><img src="<%=basePath%>img/Admin/lb3.jpg" /></td><td>雷神</td><td>待审核</td><td>是</td><td><input type="checkbox"  /></td></tr>
			<tr><td>4</td><td><img src="<%=basePath%>img/Admin/lb4.jpg" /></td><td>终结者3</td><td>待审核</td><td>否</td><td><input type="checkbox"  /></td></tr>
			<tr><td>5</td><td><img src="<%=basePath%>img/Admin/lb5.jpg" /></td><td>赛德克巴莱</td><td>审核通过</td><td>是</td><td><input type="checkbox"  /></td></tr>
			<tr><td>6</td><td><img src="<%=basePath%>img/Admin/lb6.jpg" /></td><td>亲爱的</td><td>审核通过</td><td>否</td><td><input type="checkbox"  /></td></tr>
			<tr><td>7</td><td><img src="<%=basePath%>img/Admin/lb7.jpg" /></td><td>基因解密</td><td>审核通过</td><td>否</td><td><input type="checkbox"  /></td></tr>
			<tr><td>8</td><td><img src="<%=basePath%>img/Admin/lb8.jpg" /></td><td>大秦帝国</td><td>审核通过</td><td>是</td><td><input type="checkbox"  /></td></tr>
			<tr><td>9</td><td><img src="<%=basePath%>img/Admin/lb9.jpg" /></td><td>无问西东</td><td>审核通过</td><td>是</td><td><input type="checkbox"  /></td></tr>
			<tr><td>10</td><td><img src="<%=basePath%>img/Admin/lb10.jpg" /></td><td>美人鱼</td><td>审核不通过</td><td>是</td><td><input type="checkbox"  /></td></tr>
		</table>
		<!--  -->
		<button class="btn btn-danger" style="float: right; margin: 20px 15% 20px 0;" id="passed"
			onclick="deleteCarousel()">审核通过</button>
		<button class="btn btn-danger" style="float: right; margin: 20px 15% 20px 0;" id="nopassed"
			onclick="deleteCarousel()">审核不通过</button>
		<button class="btn btn-danger" style="float: right; margin: 20px 15% 20px 0;" id="delete"
			onclick="deleteCarousel()">删除作品</button>
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