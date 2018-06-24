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
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<%-- <link rel="stylesheet" href="<%=basePath%>css/Admin/normalize.css"> --%>
<%-- <link rel="stylesheet" href="<%=basePath%>css/Admin/style.css"> --%>

</head>
<body>
	<!-- /前代表网站的根地址即域名 -->
	<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>
	<div
		style="margin: 50px 0 0 260px; width: calc(100% - 260px); padding: 0 20px;">
		
		
<!-- 		<div style="width: 100%; float: right; margin: 0 15% 20px 0;"> -->
<!-- 			<div style="float: right; margin-right: 130px;">  -->
<!-- 				<input id="query" type="button" value="搜索" class="btn btn-primary"> -->
<!-- 			</div> -->
<!-- 			<div style="float: right; margin-right: 30px;"> -->
<!-- 				<input type="text" id="queryTitle" class="form-control" style="width: 300px;"  placeholder="请输入作品标题"> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="input-group" style="width: 300px; float: right;margin: 0 7% 20px 0px;"">
									<input id="input_PoliceSearchText" class="form-control" oninput="get_ListCaseSearch()" type="text" placeholder="搜索标题" />
									<span class="input-group-addon" style="border-radius: unset;">
										<i class="fa fa-search"></i>   
									</span>
					</div>
		<!-- 内容写在此处 -->

		<!--  -->
		
		<div class="panel-body">
							<table id="tableC"
			style="width: 90%; margin: 0 auto; text-align: center;"
			class="table-condensed table-bordered table-hover breakcase_table_info">
								<thead>
								<tr>
				<th>编号</th>
				<th>标题</th>
				<th>
					<select id="passed">
						<option value="3">待审核</option>
						<option value="1">通过</option>
						<option value="2">不通过</option>
					</select>
				</th>
				<th>
					<select id="delete">
					    <option value="2">未删除</option>
						<option value="1">已删除</option>
					</select>
				</th>
				<th>操作</th>
				<th>审核</th>
					
			</tr>
								</thead>
								<tbody>

								</tbody>
								<tfoot>
									<td colspan="8"></td>
<!-- 									<tr> -->
<!-- 										<td colspan="8" style="font-size: 12px;" class="page_info"><a -->
<!-- 											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i> -->
<!-- 										</a>&nbsp&nbsp<a onclick="prePage()"><i -->
<!-- 												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a -->
<!-- 											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i> -->
<!-- 										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i -->
<!-- 												class="fa fa-angle-double-right"></i> -->
<!-- 										</a> <br /> -->
<!-- 											<p class='info'></p></td> -->
<!-- 									</tr> -->
								</tfoot>
							</table>
						</div>
		
		
	</div>
	<script type="text/javascript"
	src="<%=basePath%>js/Admin/worksExamine.js"></script>
	<script src="<%=basePath%>js/jquery-confirm.js"></script>
</body>


<style type="text/css">
#tableC tr th {
	padding: 10px !important;
}
</style>
</html>