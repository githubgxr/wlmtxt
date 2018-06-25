var query_data = {
	"worksVO.currPage" : "1",
};
//当前页面分页信息
var page_infomantion = {
	currPage : 1,
	countRecords : 1,
	pageSize : 10,
	totalPages : 1,
	havePrePage : false,
	haveNexPage : false,
}
$(function(){
	get_ListBreakecaseInformationByPageAndSearch();
})

// 列表查询
function get_ListBreakecaseInformationByPageAndSearch() {
	$
			.post(
					'/wlmtxt/WorksExamine/WorksExamine_worksListThree',
					{'worksVO.works_passed':$('#passed').val() ,'worksVO.currPage' : 1 ,'worksVO.works_deleted':$('#delete').val()},
					function(xhr) {
						var data_list = xhr.wlmtxt_worksList;
						var str = '';
						for (var len = 0; len < data_list.length; len++) {
							str += '<tr>';
							str += '<td>' + (len + 1) + '</td>';// 序号
							str += '<td>' + data_list[len].works_title
									+ '</td>';// 标题
							str += '<td>'
									+ data_list[len].works_passed
									+ '</td>';// 审核
							str += '<td>' + data_list[len].works_deleted
									+ '</td>';// 删除
						
							if (data_list[len].works_deleted==2) {
								str += '<td>'
										+ '<input type="hidden" value="'
										+ data_list[len].works_id
										+ '" />'
										+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>'
										+ '</td>';
							if(data_list[len].works_passed==3){
								str += '<td>'
									+ '<input type="hidden" value="'
									+ data_list[len].works_id
									+ '" />'
								+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>通过</button>'
								+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>不通过</button>'
								+ '</td>';
							}	
								str += '</tr>';
							}
						}
						// 加载案件列表到表格中
						$('.breakcase_table_info tbody').html(str); // 操作点击事件

						// -----------------------------------------------------
						// 设置确认、删除点击事件
						$('.btn-xs').click(modifi_delete);
						// -----------------------------------------------------

						// 分页信息存入page_infomantion中
//						page_infomantion.currPage = xhr.currPage; // 当前页数
//						page_infomantion.countRecords = xhr.totalPage; // 总页数
//						page_infomantion.pageSize = xhr.pageSize; // 每页记录数
//						page_infomantion.totalPages = xhr.totalCount; // 总记录数
//						page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
//						page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页
//
//						// 分页下的记录信息
//						var opt = '<option value=""></option>';
//						for (var index = 1; index <= xhr.totalPage; index++) {
//							opt += '<option>' + index + '</option>';
//						}
//						$('.info').html(
//								'共 ' + xhr.totalCount + '条信息 当前'
//										+ xhr.currPage + '/' + xhr.totalPage
//										+ '页 ' + xhr.pageSize
//										+ '条信息/页&nbsp&nbsp转到第'
//										+ '<select onchange="toPage(this)">'
//										+ opt + '</select> 页');
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
	query_data['worksVO.currPage'] = 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 上一页
function prePage() {
	if (page_infomantion.currPage <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['worksVO.currPage'] = page_infomantion.currPage - 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 下一页
function nextPage() {
	if (page_infomantion.currPage >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['worksVO.currPage'] = page_infomantion.currPage + 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 尾页
function lastPage() {
	if (page_infomantion.currPage == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['worksVO.currPage'] = page_infomantion.totalPages;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
// 跳转到n页
function toPage(object) {
	query_data['worksVO.currPage'] = $(object).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
$("select#passed").change(
		function() {
		

			$.post('/wlmtxt/WorksExamine/WorksExamine_worksListThree', {'worksVO.works_passed':$('#passed').val() ,'worksVO.currPage' : 1 ,'worksVO.works_deleted':$('#delete').val()},
				function(xhr) {
					var data_list = xhr.wlmtxt_worksList;
					var str = '';
					for (var len = 0; len < data_list.length; len++) {
						str += '<tr>';
						str += '<td>' + (len + 1) + '</td>';// 序号
						str += '<td>' + data_list[len].works_title
								+ '</td>';// 标题
						str += '<td>'
								+ data_list[len].works_passed
								+ '</td>';// 审核
						str += '<td>' + data_list[len].works_deleted
								+ '</td>';// 删除
					
						if (data_list[len].works_deleted==2) {
							str += '<td>'
									+ '<input type="hidden" value="'
									+ data_list[len].works_id
									+ '" />'
									+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>'
									+ '</td>';
						if(data_list[len].works_passed==3){
							str += '<td>'
								+ '<input type="hidden" value="'
								+ data_list[len].works_id
								+ '" />'
							+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>通过</button>'
							+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>不通过</button>'
							+ '</td>';
						}	
							str += '</tr>';
						}
					}
					// 加载案件列表到表格中
					$('.breakcase_table_info tbody').html(str); // 操作点击事件

					// -----------------------------------------------------
					// 设置确认、删除点击事件
					$('.btn-xs').click(modifi_delete);
					// -----------------------------------------------------

					// 分页信息存入page_infomantion中
//					page_infomantion.currPage = xhr.currPage; // 当前页数
//					page_infomantion.countRecords = xhr.totalPage; // 总页数
//					page_infomantion.pageSize = xhr.pageSize; // 每页记录数
//					page_infomantion.totalPages = xhr.totalCount; // 总记录数
//					page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
//					page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页
//
//					// 分页下的记录信息
//					var opt = '<option value=""></option>';
//					for (var index = 1; index <= xhr.totalPage; index++) {
//						opt += '<option>' + index + '</option>';
//					}
//					$('.info').html(
//							'共 ' + xhr.totalCount + '条信息 当前'
//									+ xhr.currPage + '/' + xhr.totalPage
//									+ '页 ' + xhr.pageSize
//									+ '条信息/页&nbsp&nbsp转到第'
//									+ '<select onchange="toPage(this)">'
//									+ opt + '</select> 页');
					// 影藏模态框
					// $('#newQuery').modal('hide')
			}, 'json')
		})
$("select#delete").change(
		function() {
		

			$.post('/wlmtxt/WorksExamine/WorksExamine_worksListThree', {'worksVO.works_deleted':$('#delete').val() ,'worksVO.currPage' : 1 ,'worksVO.works_passed':$('#passed').val()},
				function(xhr) {
					var data_list = xhr.wlmtxt_worksList;
					var str = '';
					for (var len = 0; len < data_list.length; len++) {
						str += '<tr>';
						str += '<td>' + (len + 1) + '</td>';// 序号
						str += '<td>' + data_list[len].works_title
								+ '</td>';// 标题
						str += '<td>'
								+ data_list[len].works_passed
								+ '</td>';// 审核
						str += '<td>' + data_list[len].works_deleted
								+ '</td>';// 删除
					
						if (data_list[len].works_deleted==2) {
							str += '<td>'
									+ '<input type="hidden" value="'
									+ data_list[len].works_id
									+ '" />'
									+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>'
									+ '</td>';
						if(data_list[len].works_passed==3){
							str += '<td>'
								+ '<input type="hidden" value="'
								+ data_list[len].works_id
								+ '" />'
							+ '<button   type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>通过</button>'
							+ '<button type="button"  style="margin-left:6px;" class="btn btn-primary btn-xs" ><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>不通过</button>'
							+ '</td>';
						}	
							str += '</tr>';
						}
					}
					// 加载案件列表到表格中
					$('.breakcase_table_info tbody').html(str); // 操作点击事件

					// -----------------------------------------------------
					// 设置确认、删除点击事件
					$('.btn-xs').click(modifi_delete);
					// -----------------------------------------------------

					// 分页信息存入page_infomantion中
//					page_infomantion.currPage = xhr.currPage; // 当前页数
//					page_infomantion.countRecords = xhr.totalPage; // 总页数
//					page_infomantion.pageSize = xhr.pageSize; // 每页记录数
//					page_infomantion.totalPages = xhr.totalCount; // 总记录数
//					page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
//					page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页
//
//					// 分页下的记录信息
//					var opt = '<option value=""></option>';
//					for (var index = 1; index <= xhr.totalPage; index++) {
//						opt += '<option>' + index + '</option>';
//					}
//					$('.info').html(
//							'共 ' + xhr.totalCount + '条信息 当前'
//									+ xhr.currPage + '/' + xhr.totalPage
//									+ '页 ' + xhr.pageSize
//									+ '条信息/页&nbsp&nbsp转到第'
//									+ '<select onchange="toPage(this)">'
//									+ opt + '</select> 页');
					// 影藏模态框
					// $('#newQuery').modal('hide')
			}, 'json')
		})
function get_ListCaseSearch(){
	$.post('/wlmtxt/WorksExamine/WorksExamine_worksListThree', {'worksVO.works_title':$('#input_PoliceSearchText').val(),'worksVO.works_passed':$('#passed').val() ,'worksVO.currPage' : 1 ,'worksVO.works_deleted':$('#delete').val()},
			function(xhr) {
				var data_list = xhr.wlmtxt_worksList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].works_title
							+ '</td>';// 标题
					str += '<td>'
							+ data_list[len].works_passed
							+ '</td>';// 审核
					str += '<td>' + data_list[len].works_deleted
							+ '</td>';// 删除
				
					if (data_list[len].works_deleted==2) {
						str += '<td>'
								+ '<input type="hidden" value="'
								+ data_list[len].works_id
								+ '" />'
								+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>删除</button>'
								+ '</td>';
					if(data_list[len].works_passed==3){
						str += '<td>'
							+ '<input type="hidden" value="'
							+ data_list[len].works_id
							+ '" />'
						+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>通过</button>'
						+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i>不通过</button>'
						+ '</td>';
					}	
						str += '</tr>';
					}
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件

				// -----------------------------------------------------
				// 设置确认、删除点击事件
				$('.btn-xs').click(modifi_delete);
				// -----------------------------------------------------

				// 分页信息存入page_infomantion中
//				page_infomantion.currPage = xhr.currPage; // 当前页数
//				page_infomantion.countRecords = xhr.totalPage; // 总页数
//				page_infomantion.pageSize = xhr.pageSize; // 每页记录数
//				page_infomantion.totalPages = xhr.totalCount; // 总记录数
//				page_infomantion.havePrePage = xhr.havePrePage; // 是否有上一页
//				page_infomantion.haveNexPage = xhr.haveNexPage; // 是否有下一页
//
//				// 分页下的记录信息
//				var opt = '<option value=""></option>';
//				for (var index = 1; index <= xhr.totalPage; index++) {
//					opt += '<option>' + index + '</option>';
//				}
//				$('.info').html(
//						'共 ' + xhr.totalCount + '条信息 当前'
//								+ xhr.currPage + '/' + xhr.totalPage
//								+ '页 ' + xhr.pageSize
//								+ '条信息/页&nbsp&nbsp转到第'
//								+ '<select onchange="toPage(this)">'
//								+ opt + '</select> 页');
				// 影藏模态框
				// $('#newQuery').modal('hide')
		}, 'json')
	}

var modifi_delete = function(){
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	if(type=="删除"){
		var formData = new FormData();
		formData.append('wlmtxt_work.works_id', id);
		$.confirm({
			title : '确定删除?',
			smoothContent : false,
			content : false,
			autoClose : 'cancelAction|10000',
			buttons : {
				deleteUser : {
					btnClass : 'btn-danger',
					text : '确认',
					action : function() {
						$.ajax({
							url : '/wlmtxt/WorksExamine/WorksExamine_delete',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(data) {

								if (data == "1") {
									toastr.success("删除成功！");
									// 获取对应option中的value值
									window.location.reload();
									// get_ListBreakecaseInformationByPageAndSearch(query_data);
								} else {
									toastr.error("删除失败！");
								}
							}
						});
					}
				},
				cancelAction : {
					btnClass : 'btn-blue',
					text : '取消',
				}
			}
		});
	}else if(type=="通过"){
		var formData = new FormData();
		formData.append('wlmtxt_work.works_id', id);
		formData.append('passed', "1");
		$.confirm({
			title : '确定通过吗?',
			smoothContent : false,
			content : false,
			autoClose : 'cancelAction|10000',
			buttons : {
				deleteUser : {
					btnClass : 'btn-danger',
					text : '确认',
					action : function() {
						$.ajax({
							url : '/wlmtxt/WorksExamine/WorksExamine_passed',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(data) {

								if (data == "1") {
									toastr.success("提交成功！");
									// 获取对应option中的value值
									window.location.reload();
									// get_ListBreakecaseInformationByPageAndSearch(query_data);
								} else {
									toastr.error("操作失败！");
								}
							}
						});
					}
				},
				cancelAction : {
					btnClass : 'btn-blue',
					text : '取消',
				}
			}
		});
	}else if(type=="不通过"){
		var formData = new FormData();
		formData.append('wlmtxt_work.works_id', id);
		formData.append('passed', "2");
		$.confirm({
			title : '确定不通过吗?',
			smoothContent : false,
			content : false,
			autoClose : 'cancelAction|10000',
			buttons : {
				deleteUser : {
					btnClass : 'btn-danger',
					text : '确认',
					action : function() {
						$.ajax({
							url : '/wlmtxt/WorksExamine/WorksExamine_passed',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(data) {

								if (data == "1") {
									toastr.success("提交成功！");
									// 获取对应option中的value值
									window.location.reload();
									// get_ListBreakecaseInformationByPageAndSearch(query_data);
								} else {
									toastr.error("操作失败！");
								}
							}
						});
					}
				},
				cancelAction : {
					btnClass : 'btn-blue',
					text : '取消',
				}
			}
		});
	}
	
}