<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>评论列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.table_police tbody tr {
	text-align: center;
}

#page_flip span a:hover {
	cursor: pointer;
}
</style>
</head>

<body>
	<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>

	<div style="margin: 50px 0 0 260px; width: calc(100% - 260px);">

		<div  style="width: 95%; margin: 20px auto;">
				<!--  -->
						
							<div style="height: 34px; width: 100%;">
								
								<!-- 检索 -->
								<div class="input-group" style="width: 300px; float: right;">
									<input id="input_PoliceSearchText" class="form-control" oninput="searchUsername()" type="text" placeholder="搜索用户名、邮箱、评论内容" />
									<span class="input-group-addon" style="border-radius: unset;">
										<i class="fa fa-search"></i>   
									</span>
								</div>

							</div>

							<table id="table_police" class="table table-hover breakcase_table_info"
								style="text-align: center; margin: 20px 0;">
								
								<thead>
									<tr>
										<th>序号</th>
										<th>用户名</th>
										<th>用户邮箱</th>
										<th>评论内容</th>
										<th>评论时间</th>
										<th><label class="fancy-checkbox"> <input
												id="checkbox_all_select" type="checkbox"
												onclick="all_select()"> <span></span>
										</label></th>
									</tr>
								</thead>
								<tbody></tbody>
								<tfoot>
									<tr>
										<td colspan="8" style="font-size: 12px;" class="page_info"><a
											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i>
										</a>&nbsp&nbsp<a onclick="prePage()"><i
												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a
											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i>
										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i
												class="fa fa-angle-double-right"></i>
										</a> <br />
											<p class='discuss'></p></td>
									</tr>
								</tfoot>
								
							</table>
							
							<!-- 删除按钮 -->
							<div style="height: 34px;" id="btn_delete" >
								<button class="btn btn-danger role_one" onclick="deletediscuss()"
									style="float: right; margin: 0 10px;">
									<i class="fa fa-trash-o"></i> 删除所选
								</button>
							</div>
		</div>
	</div>

	
	<script type="text/javascript"
		src="<%=basePath%>js/Admin/page_list_discuss.js"></script>
</body>
</html>
