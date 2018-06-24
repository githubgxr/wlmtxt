$(function(){
	$(".userName").blur(function(){
		if($(".userName").val()==""||$(".userName")==null){
			toastr.error('请输入用户名');
		}
	});
	$(".passWord").blur(function(){
		if($(".passWord").val()==""||$(".passWord")==null){
		toastr.error('请输入密码');
		}
	});
});

function admin_login(){
	var account = document.getElementById("account").value;
	var password = document.getElementById("password").value;
	if(account==''||password == ''){
		toastr.error('含有空信息');
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