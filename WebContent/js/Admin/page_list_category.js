/*
 * 添加一级菜单
 */
$('.input_sure').click(
		function() {
			var this_modal = $(this);
			$.post('/wlmtxt/Admin/Admin_addFirst_menu',
					$('#frst_mune_add form').serialize(), function(xhr) {
						if (xhr == 1) {
							toastr.success('添加成功!');
							$('#frst_mune_add').modal('hide');
							$('#frst_mune_add input').val("");
							window.location.reload();
						} else {
							toastr.error('添加失败!');
							return false;
						}
					}, 'text')
		});
/*
 * 添加二级菜单
 */
$('.second_input_sure')
		.click(
				function() {
					var this_modal = $(this);
					var second_menu_name = document
							.getElementById("second_menu_name").value;
					var second_menu_first_menu_id = document
							.getElementById("second_menu_first_menu_id").value;
					$
							.post(
									'/wlmtxt/Admin/Admin_addSecond_menu',
									{
										'second_menu.second_menu_name' : second_menu_name,
										'second_menu.second_menu_first_menu_id' : second_menu_first_menu_id
									},
									function(xhr) {
										if (xhr == 1) {
											toastr.success('添加成功!');
											$('#second_mune_add').modal('hide');
											$('#second_mune_add input').val("");
											window.location.reload();
										} else {
											toastr.error('添加失败!');
											return false;
										}
									}, 'text')
				});
/*
 * 获得一级菜单的id
 */

function second_menu_add_first_id(id) {
	alert("a");
	$("#second_menu_first_menu_id").val(id);
}


var delete_category_id;
/*
 * 删除一级菜单
 */
function delete_category() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/wlmtxt/Admin/Admin_page_list_category";
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	var formData = new FormData();

	formData.append("first_menu.first_menu_id", delete_category_id);

	xhr.open("POST", "/wlmtxt/Admin/Admin_deleteFirst_munu");

	xhr.send(formData);

}
/*
 * 删除二级菜单
 */
function delete_sonCategory(){
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				message = xhr.responseText;

				toastr.success("删除成功");

				window.location = "/wlmtxt/Admin/Admin_page_list_category";
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	var formData = new FormData();

	formData.append("second_menu.second_menu_id", delete_category_id);

	xhr.open("POST", "/wlmtxt/Admin/Admin_deleteSecond_menu");

	xhr.send(formData);
}
/*
 * 获得单个一级菜单
 */
function getFirst_menuById(first_menu_id){
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
	fromDate.append("first_menu.first_menu_id",first_menu_id);
	xmlhttp.open("post","/wlmtxt/Admin/Admin_getFirst_menuById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var first_mune=xmlhttp.responseText;
	    first_mune = JSON.parse(first_mune);
	    $('#first_menu_name').val(first_mune.first_menu_name);
	    $('#first_menu_id').val(first_mune.first_menu_id);
	    }
	  }

}
/*
 * 获得单个二级菜单
 */
function getSecond_menuById(second_menu_id){
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
	fromDate.append("second_menu.second_menu_id",second_menu_id);
	xmlhttp.open("post","/wlmtxt/Admin/Admin_getSecondById",true);
	xmlhttp.send(fromDate);
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var second_mune=xmlhttp.responseText;
	    second_mune = JSON.parse(second_mune);
	    $('#update_second_menu_name').val(second_mune.second_menu_name);
	    $('#update_second_menu_first_menu_id').val(second_mune.second_menu_first_menu_id);
	    $('#update_second_menu_id').val(second_mune.second_menu_id);
	    }
	  }
}
/*
 * 修改一级菜单
 */
function updateFirst_menu(){
	var this_modal = $(this);
	$.post('/wlmtxt/Admin/Admin_updateFirst_menu',
			$('#update_frist_menu form').serialize(), function(xhr) {
				if (xhr == 1) {
					toastr.success('修改成功!');
					$('#update_frist_menu').modal('hide');
					$('#update_frist_menu input').val("");
					window.location.reload();
				} else {
					toastr.error('修改失败!');
					return false;
				}
			}, 'text')
}

/*
 * 修改二级菜单
 */
function updateSecond_menu(){
	var this_modal = $(this);
	$.post('/wlmtxt/Admin/Admin_updateSecond_menu',
			$('#updateSecond_menu form').serialize(), function(xhr) {
				if (xhr == 1) {
					toastr.success('修改成功!');
					$('#updateSecond_menu').modal('hide');
					$('#updateSecond_menu input').val("");
					window.location.reload();
				} else {
					toastr.error('修改失败!');
					return false;
				}
			}, 'text')
}













