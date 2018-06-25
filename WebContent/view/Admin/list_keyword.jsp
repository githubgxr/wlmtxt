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


<title>关键词管理</title>
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
								<div style="width: 150px; float: left; margin: 0 20px 0 0">
									<button class="btn btn-default " data-toggle="modal" data-target="#addKeyword" >
										<i class="fa fa-plus-square"></i> 添加关键词
									</button>
								</div>
								<!-- 检索 -->
								<div class="input-group" style="width: 300px; float: right;">
									<input id="input_PoliceSearchText" class="form-control" oninput="searchUsername()" type="text" placeholder="搜索关键词" />
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
										<th>关键词名</th>
										<th>操作</th>
										<th><label class="fancy-checkbox"> <input
												id="checkbox_all_select" type="checkbox"
												onclick="all_select()"> <span></span>
										</label></th>
									</tr>
								</thead>
								<tbody></tbody>
								<tfoot>
									<tr>
										<td colspan="8"></td>
<!-- 										<td colspan="8" style="font-size: 12px;" class="page_info"><a -->
<!-- 											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i> -->
<!-- 										</a>&nbsp&nbsp<a onclick="prePage()"><i -->
<!-- 												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a -->
<!-- 											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i> -->
<!-- 										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i -->
<!-- 												class="fa fa-angle-double-right"></i> -->
<!-- 										</a> <br /> -->
<!-- 											<p class='admin'></p></td> -->
									</tr>
								</tfoot>
								
							</table>
							
							<!-- 删除按钮 -->
							<div style="height: 34px;" id="btn_delete" >
								<button class="btn btn-danger role_one" onclick="deleteKeyword()"
									style="float: right; margin: 0 10px;">
									<i class="fa fa-trash-o"></i> 删除所选
								</button>
							</div>
		</div>
	</div>
<!-------------------------------------------添加的模态框--------------------------------------------------------->
	<div class="modal fade" id="addKeyword" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">添加关键词</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">关键词名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
											name="keyword.keyword_name" type="text"></span>
										<input type="hidden"  >
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input_sure">添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-------------------------------------------修改关键词的模态框--------------------------------------------------------->
	<div class="modal fade" id="updateKeyword" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">修改关键词</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 0 0 0;line-height:34px;">关键词名</span>
										<span style="float:left;margin:0 0 0 50px;"><input style="witdh: 80%;" class="form-control"
										id="updatekeyword_name"	name="keyword.keyword_name" type="text"></span>
										<input type="hidden"  name="keyword.keyword_id" id ="updatekeyword_id">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary update_input_sure">修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/Admin/page_list_keyword.js"></script>
</body>
</html>
