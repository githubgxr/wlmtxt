
/*
 * 选中所有复选框
 */
function deleteUser(session_id,session_password){
	var old_password = document.getElementById("old_password").value;
	var confirm_password = document.getElementById("confirm_password").value;
	var new_password = document.getElementById("new_password").value;
	if(session_password!=old_password){
		toastr.error("原密码输入错误");
	}else{
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		var fromData = new FormData();
		fromData.append("admin.admin_password",new_password);
		fromData.append("admin.admin_id",session_id);
		xmlhttp.open("POST","/wlmtxt/Admin/Admin_updatePassword",true);
		xmlhttp.send(fromData);
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		   var  result = xmlhttp.responseText;
		   if(result==1){
				toastr.success("修改密码成功");
		   }else{
			   toastr.error("修改密码失败");
		   }
		    }
		  }
	
	}
	
}








