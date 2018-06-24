var query_data = {
	"adminVO.currPage" : "1",
};
$(function(){
	get_ListBreakecaseInformationByPageAndSearch();
})

//当前页面分页信息
var page_infomantion = {
	currPage : 1,
	countRecords : 1,
	pageSize : 10,
	totalPages : 1,
	havePrePage : false,
	haveNexPage : false,
}
/*
 *查询列表
 */
function get_ListBreakecaseInformationByPageAndSearch(){
	$
	.post(
			'/wlmtxt/Admin/Admin_getAdminListBysearchPage',
			{'adminVO.admin_username':$('#input_PoliceSearchText').val() ,'worksVO.currPage' : 1 },
			function(xhr) {
				var data_list = xhr.wlmtxt_adminList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					if(data_list[len].admin_admin=="1"){
						var admin_admin = '是'
					}else{
						var admin_admin = '否'
					}
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].admin_username
							+ '</td>';// 账号
					str += '<td>'
							+ admin_admin
							+ '</td>';// 是否超级管理员
				
						str += '<td>'
						+ '<i id="'
						+ data_list[len].admin_id
						+ '" data-toggle="modal" data-target="#updateAdmin" onclick=getAdmin("'+data_list[len].admin_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].admin_id
							+ '" >'
							+ '</td>';
						
						
						
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件

				// -----------------------------------------------------
				// -----------------------------------------------------

				// 分页信息存入page_infomantion中
				page_infomantion.currPage = xhr.currPage; // 当前页数
				page_infomantion.countRecords = xhr.totalPage; // 总页数
				page_infomantion.pageSize = xhr.pageSize; // 每页记录数
				page_infomantion.totalPages = xhr.totalCount; // 总记录数
				page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
				page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页

				// 分页下的记录信息
				var opt = '<option value=""></option>';
				for (var index = 1; index <= xhr.totalPage; index++) {
					opt += '<option>' + index + '</option>';
				}
				$('.admin').html(
						'共 ' + xhr.totalCount + '条信息 当前'
								+ xhr.currPage + '/' + xhr.totalPage
								+ '页 ' + xhr.pageSize
								+ '条信息/页&nbsp&nbsp转到第'
								+ '<select onchange="toPage(this)">'
								+ opt + '</select> 页');
				// 影藏模态框
				// $('#newQuery').modal('hide')
			}, 'json')
}
/*
 * 初始密码
 */

function password_show(){
	$('#password').val('000000');
}
/*
 * 添加管理员
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/wlmtxt/Admin/Admin_addAdmin',
					$('#addAdmin form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#addAdmin').modal('hide');
							$('#addAdmin input').val("");
							$('#addAdmin select').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});

//首页
function firstPage() {
	if (page_infomantion.currPage == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['adminVO.currPage'] = 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 上一页
function prePage() {
	if (page_infomantion.currPage <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['adminVO.currPage'] = page_infomantion.currPage - 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 下一页
function nextPage() {
	if (page_infomantion.currPage >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['adminVO.currPage'] = page_infomantion.currPage + 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 尾页
function lastPage() {
	if (page_infomantion.currPage == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['adminVO.currPage'] = page_infomantion.totalPages;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 跳转到n页
function toPage(object) {
	query_data['adminVO.currPage'] = $(object).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}


/*
 * 搜索
 */
function searchUsername(query_data){
	$.post(
			'/wlmtxt/Admin/Admin_getAdminListBysearchPage',
			{'adminVO.admin_username':$('#input_PoliceSearchText').val() ,'worksVO.currPage' : 1 },
			function(xhr) {
				var data_list = xhr.wlmtxt_adminList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					if(data_list[len].admin_admin=="1"){
						var admin_admin = '是'
					}else{
						var admin_admin = '否'
					}
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].admin_username
							+ '</td>';// 账号
					str += '<td>'
							+ admin_admin
							+ '</td>';// 是否超级管理员
				
						str += '<td>'
							+ '<input type="hidden" value="'
							+ data_list[len].admin_id
							+ '" />'
						+ '<i  data-toggle="modal" data-target="#updateAdmin" onclick=getAdmin("'+data_list[len].admin_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].admin_id
							+ '" >'
							+ '</td>';
						
						
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件

				// -----------------------------------------------------

				// 分页信息存入page_infomantion中
				page_infomantion.currPage = xhr.currPage; // 当前页数
				page_infomantion.countRecords = xhr.totalPage; // 总页数
				page_infomantion.pageSize = xhr.pageSize; // 每页记录数
				page_infomantion.totalPages = xhr.totalCount; // 总记录数
				page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
				page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页

				// 分页下的记录信息
				var opt = '<option value=""></option>';
				for (var index = 1; index <= xhr.totalPage; index++) {
					opt += '<option>' + index + '</option>';
				}
				$('.admin').html(
						'共 ' + xhr.totalCount + '条信息 当前'
								+ xhr.currPage + '/' + xhr.totalPage
								+ '页 ' + xhr.pageSize
								+ '条信息/页&nbsp&nbsp转到第'
								+ '<select onchange="toPage(this)">'
								+ opt + '</select> 页');
				// 影藏模态框
				// $('#newQuery').modal('hide')
			}, 'json')
}

/*
 * 得到管理员信息
 */

function getAdmin(id){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	var fromDate = new FormData();	
	fromDate.append("admin.admin_id",id);
	xmlhttp.open("post","/wlmtxt/Admin/Admin_getAdminById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var admin=xmlhttp.responseText;
	    admin = JSON.parse(admin);
	    $('#updateAdmin_username').val(admin.admin_username);
	    $('#updateAdmin_id').val(admin.admin_id);
	    $('#updateAdmin_password').val(admin.admin_password);
	    $('#updateAdmin_admin').val(admin.admin_admin);
	    }
	  }
}
/*
 * 修改管理员信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/wlmtxt/Admin/Admin_updateAdmin',
					$('#updateAdmin form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#updateAdmin').modal('hide');
							$('#updateAdmin input').val("");
							$('#updateAdmin select').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});


/*
 * 删除管理员
 */  
function deleteAdmin(){
	$.confirm({
		smoothContent : false,
		title : '删除管理员',
		content : '此操作将删除所有所选的管理员信息',
		type : 'red',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			删除 : {
				btnClass : 'btn-red',
				action : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								if (xhr.responseText == "1") {
									toastr.success("删除成功");
									window.location.reload();
								} else {
									toastr.error("删除失败");
								}
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var checkbox_select = document
							.getElementsByClassName("checkbox_select");
					

					var formData = new FormData();
					var arr=new Array();
					var str=null;
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							arr.push(checkbox_select[num].value);
							str=arr.join(",")
						}
					}
					formData.append("adminIDAll",str);

					xhr.open("POST", "/wlmtxt/Admin/Admin_deleteAdmin");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}
/*
 * 选中所有复选框
 */
function all_select(){
	var checkbox_all_select = document.getElementById("checkbox_all_select")
	   var checkbox_select = document.getElementsByClassName("checkbox_select");
	 if (checkbox_all_select.checked){
	     //循环设置所有复选框为选中状态
	     for(var i = 0; i < checkbox_select.length; i++)
	    	 checkbox_select[i].checked = true;
	  }else{//取消obj选中状态，则全不选
	     //循环设置所有复选框为未选中状态
	     for(var i = 0; i < checkbox_select.length; i++)
	    	 checkbox_select[i].checked = false;
	  }
}








