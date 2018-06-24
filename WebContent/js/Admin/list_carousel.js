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
					str += '<td>' + data_list[len].works.works_title
							+ '</td>';// 标题
					str += '<td>' + data_list[len].recommend.recommend_sort
					+ '</td>';// 
					
					str += '<td>'
						+ '<i style="margin-left:6px;" id="'
						+  data_list[len].recommend.recommend_id
						+ '" data-toggle="modal" data-target="#updateKeyword" onclick=move("'+data_list[len].recommend.recommend_id+'",1) class="fa fa-arrow-circle-up" aria-hidden="true"></i>'
						+ '<i style="margin-left:6px;" id="'
						+  data_list[len].recommend.recommend_id
						+ '" data-toggle="modal" data-target="#updateKeyword" onclick=move("'+data_list[len].recommend.recommend_id+'",2) class="fa fa-arrow-circle-down" aria-hidden="true"></i>'
						+ '</td>';
					
				   
						
						str += '<td>'
							+ '<input  type="checkbox" class="checkbox_select" value="'
							+ data_list[len].recommend.recommend_id
							+ '" >'
							+ '</td>';
						
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.breakcase_table_info tbody').html(str); // 操作点击事件

			}, 'json')
})
function move(id,moveaction){
	alert("a")
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
	fromDate.append("recommend.recommend_id",id);
	fromDate.append("moveAction",moveaction);
	xmlhttp.open("post","/wlmtxt/WorksExamine/WorksExamine_moveRecommend",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var move=xmlhttp.responseText;
	   // keyword = JSON.parse(keyword);
	   if(move="1"){
		   toastr.success("移动成功");
		   $
			.post(
					'/wlmtxt/WorksExamine/WorksExamine_listrecommend',
					
					function(xhr) {
						var data_list = xhr;
						
						var str = '';
						for (var len = 0; len < data_list.length; len++) {
							
							str += '<tr>';
							str += '<td>' + (len + 1) + '</td>';// 序号
							str += '<td>' + data_list[len].works.works_title
									+ '</td>';// 标题
							str += '<td>' + data_list[len].recommend.recommend_sort
							+ '</td>';// 
							str += '<td>'
								+ '<i style="margin-left:6px;" id="'
								+  data_list[len].recommend.recommend_id
								+ '" data-toggle="modal" data-target="#updateKeyword" onclick=move("'+data_list[len].recommend.recommend_id+'",1) class="fa fa-arrow-circle-up" aria-hidden="true"></i>'
								+ '<i style="margin-left:6px;" id="'
								+  data_list[len].recommend.recommend_id
								+ '" data-toggle="modal" data-target="#updateKeyword" onclick=move("'+data_list[len].recommend.recommend_id+'",2) class="fa fa-arrow-circle-down" aria-hidden="true"></i>'
								+ '</td>';
								
								str += '<td>'
									+ '<input  type="checkbox" class="checkbox_select" value="'
									+ data_list[len].recommend.recommend_id
									+ '" >'
									+ '</td>';
								
								str += '</tr>';
							
						}
						// 加载案件列表到表格中
						$('.breakcase_table_info tbody').html(str); // 操作点击事件

						
					}, 'json')
	   }else{
		   toastr.error("移动失败");
		   return false;
	   }
	    }
	  }
}

/*
 * 删除轮播图
 */  
function deleteRecomment(){
	$.confirm({
		smoothContent : false,
		title : '删除轮播图',
		content : '此操作将删除所有所选的轮播图',
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
									//window.location.reload();
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
					formData.append("recommendIdAll",str);

					xhr.open("POST", "/wlmtxt/WorksExamine/WorksExamine_deleteRecommend");
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







