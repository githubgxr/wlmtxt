/**
 * 在绑定新click方法前对元素所绑定的click方法解绑
 * $("#obj").unbind("click").click(function(e){ ***** });
 */

//$(function() {
//	$("#login").click(function() {
//		if (!$('#account').val() || !$('#password').val()) {
//			toastr.warning("含有空信息");
//			return;
//		}
//		window.location.href="/wlmtxt/admin_navbar.jsp";
//		/*$.ajax({
//			url : "/wlmtxt/Admin/Admin_login",
//			type : "post",
//			timeout : 3000,
//			data : {
//				admin_account : $('#account').val(),
//				admin_password : $('#password').val(),
//		        
//			},
//			dataType : "json",
//			success : function(data) {
//				if (data.result == 'passerror') {
//					toastr.warning('密码错误');
//					return;
//				} else if (data.result == 'error') {
//					toastr.warning('帐号不存在');
//					return;
//				} else {
//					window.location.href="/wlmtxt/navbar.jsp";
//				}
//
//			},
//			error : function() {}
//		});*/
//	});
//});

function admin_login(){
	var account = document.getElementById("account").value;
	var password = document.getElementById("password").value;
	if(account==''||password == ''){
		toastr.warning('含有空信息');
		return ;
	}
	var admin_login = new FormData();
	admin_login.append("admin.admin_username",account);
	admin_login.append("admin.admin_password",password);
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    var login=xmlhttp.responseText;
	    if(login==1){
	    	window.location="/wlmtxt/Admin/Admin_login";
	    	
	    }else{
	    	toastr.error('用户名或密码错误！');
	    }
	    }
	  }
	xmlhttp.open("post","/wlmtxt/Admin/Admin_admin_login",true);
	xmlhttp.send(admin_login);
}