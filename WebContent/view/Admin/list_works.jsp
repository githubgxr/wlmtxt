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


<title>作品列表</title>
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
							<div class="input-group" style="width: 300px; float: right;margin: 0 7% 20px 0px;"">
									<input id="input_PoliceSearchText" class="form-control" oninput="get_ListCaseSearch()" type="text" placeholder="搜索标题" />
									<span class="input-group-addon" style="border-radius: unset;">
										<i class="fa fa-search"></i>   
									</span>
					</div>

							</div>

							<table id="table_police" class="table table-hover breakcase_table_info"
								style="text-align: center; margin: 20px 0;">
								
								<thead>
					<tr>
						<th>编号</th>
						<th>标题</th>
						<th><select id="passed">
								<option value="3">待审核</option>
								<option value="1">通过</option>
								<option value="2">不通过</option>
						</select></th>
						<th><select id="delete">
								<option value="2">未删除</option>
								<option value="1">已删除</option>
						</select></th>
						<th><label class="fancy-checkbox"> <input
												id="checkbox_all_select" type="checkbox"
												onclick="all_select()"> <span></span>
										</label></th>
					 
						<th>审核</th>
                       
					</tr>
				</thead>
								<tbody></tbody>
								<tfoot>
									<tr>
<!-- 										<td colspan="8"></td> -->
<!-- 										<td colspan="8" style="font-size: 12px;" class="page_info"><a -->
<!-- 											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i> -->
<!-- 										</a>&nbsp&nbsp<a onclick="prePage()"><i -->
<!-- 												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a -->
<!-- 											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i> -->
<!-- 										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i -->
<!-- 												class="fa fa-angle-double-right"></i> -->
<!-- 										</a> <br /> -->
<!-- 											<p class='discuss'></p></td> -->
									</tr>
								</tfoot>
								
							</table>
							
				<!-- 删除按钮 -->
							<div style="height: 34px;" id="btn_delete" >
								<button class="btn btn-danger role_one" onclick="deleteWorks()"
									style="float: right; margin: 0 10px;">
									<i class="fa fa-trash-o"></i> 删除所选
								</button>
							</div>		
		</div>
	</div>

	<script type="text/javascript"
	src="<%=basePath%>js/Admin/worksExamine.js"></script>
	<script src="<%=basePath%>js/jquery-confirm.js"></script>
</body>
</html>
