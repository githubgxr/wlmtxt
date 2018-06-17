/**
 * 在绑定新click方法前对元素所绑定的click方法解绑
 * $("#obj").unbind("click").click(function(e){ ***** });
 */

$(function() {
	$("#login").click(function() {
		if (!$('#account').val() || !$('#password').val()) {
			toastr.warning("含有空信息");
			return;
		}
		window.location.href="/wlmtxt/admin_navbar.jsp";
		/*$.ajax({
			url : "/wlmtxt/Admin/Admin_login",
			type : "post",
			timeout : 3000,
			data : {
				admin_account : $('#account').val(),
				admin_password : $('#password').val(),
		        
			},
			dataType : "json",
			success : function(data) {
				if (data.result == 'passerror') {
					toastr.warning('密码错误');
					return;
				} else if (data.result == 'error') {
					toastr.warning('帐号不存在');
					return;
				} else {
					window.location.href="/wlmtxt/navbar.jsp";
				}

			},
			error : function() {}
		});*/
	});
});