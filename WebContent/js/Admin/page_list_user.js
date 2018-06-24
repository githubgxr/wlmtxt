var query_data = {
	"userVO.currPage" : "1",
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
			'/wlmtxt/AdminUser/AdminUser_getUserListBysearchPage',
			{'userVO.currPage' : 1 },
			function(xhr) {
				var data_list = xhr.wlmtxt_userList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].user_username
							+ '</td>';// 昵称
					str += '<td>'
							+ data_list[len].user_mail
					str += '<td>'
						+ data_list[len].user_upload
						+ '</td>';// 
					str += '<td>'
						+ data_list[len].user_discuss
						+ '</td>';// 
					str += '<td>'
						+ '<i  data-toggle="modal" data-target="#updateUser" onclick=getUser("'+data_list[len].user_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].user_id
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
			'/wlmtxt/AdminUser/AdminUser_getUserListBysearchPage',
			{'userVO.user_username':$('#input_PoliceSearchText').val() ,'userVO.user_mail':$('#input_PoliceSearchText').val(),'userVO.currPage' : 1 },
			function(xhr) {
				var data_list = xhr.wlmtxt_userList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].user_username
							+ '</td>';// 
					str += '<td>'
							+ data_list[len].user_mail
							+ '</td>';//
					str += '<td>'
						+ data_list[len].user_upload
						+ '</td>';// 
					str += '<td>'
						+ data_list[len].user_discuss
						+ '</td>';// 
					str += '<td>'
						+ '<i  data-toggle="modal" data-target="#updateUser" onclick=getUser("'+data_list[len].user_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].user_id
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
 * 得到用户信息
 */

function getUser(user_id){
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
	fromDate.append("user.user_id",user_id);
	xmlhttp.open("post","/wlmtxt/AdminUser/AdminUser_getUserById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var user=xmlhttp.responseText;
	    user = JSON.parse(user);
	    $('#updateuser_upload').val(user.user_upload);
	    $('#updateuser_discuss').val(user.user_discuss);
	    $('#updateuser_id').val(user.user_id);
	    }
	  }
}
/*
 * 修改用户信息
 */
$('.update_input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/wlmtxt/AdminUser/AdminUser_updateUser_authority',
					$('#updateUser form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('修改成功!');
							$('#updateUser').modal('hide');
							$('#updateUser input').val("");
							window.location.reload();
						} else {
							toastr.error('修改失败!');
							return false;
						}
					}, 'text')
		});


/*
 * 删除用户
 */  
function deleteUser(){
	$.confirm({
		smoothContent : false,
		title : '删除用户',
		content : '此操作将删除所有所选的用户信息',
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
					formData.append("userIDAll",str);

					xhr.open("POST", "/wlmtxt/AdminUser/AdminUser_deleteUser");
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








