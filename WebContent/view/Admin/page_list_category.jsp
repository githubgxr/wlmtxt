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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>菜单</title>
</head>
<body>
	<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 0 0 0 260px; width: calc(100% - 260px);">
		<!-- 内容写在此处 -->
	<div style="width: 100%; height: 50px; margin: 100px 0 0 0;">
			<button class="btn btn-primary" data-toggle="modal" data-target="#frst_mune_add"
				style="margin: 0 10% 0 0; float: right;" 
				><i class="fa fa-plus-square" style="margin:0 10px 0 0;"></i>创建一级类别</button>
	</div>


		<!---------------------------------------------------------------------------->
		<div style="width: 80%; margin: 0 0 100px 10%;">
			<hr
				style="width: 100%; height: 0px; border: 2px solid #eeeeee; margin: 0;">
			<!---------------------------------------------------------------------------->

			<s:iterator value="categoryListDTO" var="CL">
				<div style="height: 50px;">
					<i class="lnr lnr-bookmark"
						style="color: #1abc9c; font-weight: bold; margin: 0 5px 0 0; font-size: 20px;"></i>
					<%--  --%>
					<span style="line-height: 50px;"><s:property
							value="#CL.category.first_menu_name" /></span>
					<!--  -->

					<!--  -->
					<button class="btn btn-danger"
						id="<s:property
							value="#CL.category.first_menu_id" />"
						style="margin: 8px 5px; float: right;" data-toggle="modal"
						data-target="#model_delete_category"
						onclick="javascript:delete_category_id=this.id;">删除</button>
					<!--  -->
					<button class="btn btn-warning" data-toggle="modal" data-target="#model_update_category"
						style="margin: 8px 5px; float: right;"
						onclick="getFirst_menuById('<s:property
							value="#CL.category.first_menu_id" />')">修改</button>
					<!--  -->

					<!--  -->
					<button class="btn btn-success"  data-toggle="modal" data-target="#second_mune_add" 
					onclick="second_menu_add_first_id('<s:property 
					value="#CL.category.first_menu_id"/>')"
						style="margin: 8px 5px; float: right;"
						>创建子类别</button>
					
				</div>
				<!---------------------------->
				<s:iterator value="#CL.sonCategoryList" var="SCL">
					<div style="height: 50px; margin: 0 0 0 80px;">
						<span style="line-height: 50px;"><s:property
								value="#SCL.second_menu_name" /></span>
						
						<button class="btn btn-danger" data-toggle="modal"
							data-target="#model_delete_soncategory"
							id="<s:property
							value="#SCL.second_menu_id" />"
							style="margin: 8px 5px ; float: right;"
							onclick="javascript:delete_category_id=this.id;">删除</button>
						<!--  -->
						<button class="btn btn-warning" data-toggle="modal" data-target="#model_update_soncategory"
							style="margin: 8px 5px; float: right;"
							onclick="window.location='<%=basePath%>snews/category_page_create_category?page=page_create_category&option=update&category.jsj_snews_category_id=<s:property
							value="#SCL.second_menu_id" />'">修改</button>
						<!--  -->
					</div>
				</s:iterator>
				<hr
					style="width: 100%; height: 0px; border: 2px solid #eeeeee; margin: 0;">
				<!---------------------------->
			</s:iterator>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!--------------------------------------删除一级菜单模态框-------------------------------------------------------------->


	<div class="modal fade" id="model_delete_category">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认信息</h4>
				</div>
				<div class="modal-body">
					<h4 id="h4_delete">删除此类别，将删除此类别的所有子类别</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" onclick="delete_category()">删除</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
<!--------------------------------------删除二级菜单模态框-------------------------------------------------------------->


	<div class="modal fade" id="model_delete_soncategory">
		<div class="modal-dialog" style="width:300px;height:150px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">确认信息</h4>
				</div>
				<div class="modal-body">
					<h4 id="h4_delete">删除此类别</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" onclick="delete_sonCategory()">删除</button>
					<button class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
   
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-------------------------------------------添加一级菜单的模态框--------------------------------------------------------->
	<div class="modal fade" id="frst_mune_add" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title"></h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 30px 0 0;line-height:34px;">一级菜单名</span>
										<span style="float:left;"><input style="witdh: 70%;" class="form-control"
											name="first_menu.first_menu_name" type="text"></span>
										<input type="hidden" name="first_menu.first_menu_id" value>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input_sure" onclick="input_sure()">添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-------------------------------------------修改一级菜单的模态框--------------------------------------------------------->
	<div class="modal fade" id="update_frist_menu" tabindex="-1"
		role="dialog" aria-labelledby="model_update_category" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">菜单修改</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 30px 0 0;line-height:34px;">一级菜单名</span>
										<span style="float:left;"><input style="witdh: 70%;" class="form-control"
										id="first_menu_name"	name="first_menu.first_menu_name" type="text"></span>
										<input type="hidden" name="first_menu.first_menu_id" id="first_menu_id">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input_sure" onclick="updateFirst_menu()">修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-------------------------------------------添加二级菜单的模态框--------------------------------------------------------->
	<div class="modal fade" id="second_mune_add" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" style="width:500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title"></h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%; margin: auto;" class="panel-body">
										<span style="float:left;margin:0 30px 0 0;line-height:34px;">二级菜单名</span>
										<span style="float:left;"><input style="witdh: 70%;" class="form-control"
											id="second_menu_name" name="second_menu.second_menu_name" type="text"></span>
										<input type="hidden" id="second_menu_first_menu_id" name="second_menu.second_menu_first_menu_id">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary second_input_sure" >添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- -------------------------------------------------------------------------------------------------------------------- -->
</body>
<script type="text/javascript">
	
$('input').on('ifChanged', function(event){
	update_category_show(event.target);
	});

function update_category_show(checkbox){
	
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				
				if(xhr.responseText=='success'){
					toastr.success("修改成功");
				}else{
 					toastr.error("修改失败");
				}
				
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	
	xhr.open("POST", "/xxyjsjgcxy/snews/category_update_category_show");
	
	if(checkbox.checked){
		var category_show=1;
	}else{
		var category_show=0;
	}
	var formData = new FormData();
	
	formData.append("category.jsj_snews_category_id",checkbox.id.substring(9));
	formData.append("category.category_show",category_show);
	
	xhr.send(formData);
}

</script> 
<script type="text/javascript" src="<%=basePath%>js/Admin/page_list_category.js"></script>
	
</html>