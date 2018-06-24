$(function(){
	$
	.post(
			'/wlmtxt/WorksExamine/WorksExamine_listrecommend',
			
			function(xhr) {
				var data_list = xhr;
				
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len]
							+ '</td>';// 标题
					str += '<td>'
						+ '<i id="'
						+ data_list[len].keyword_id
						+ '" data-toggle="modal" data-target="#updateKeyword" onclick=getKeyword("'+data_list[len].keyword_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].keyword_id
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
})