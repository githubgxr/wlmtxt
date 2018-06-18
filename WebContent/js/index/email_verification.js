function GetRequest() {   
   var url = location.search; //获取url中"?"符后的字串   
   var theRequest = new Object();   
   if (url.indexOf("?") != -1) {   
      var str = url.substr(1);   
      strs = str.split("&");   
      for(var i = 0; i < strs.length; i ++) {   
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
      }   
   }   
   return theRequest;   
}  
document.getElementById("register_check_btn").onclick=function(){
	var Request = new Object();
	Request = GetRequest();
	var user_email,user_password,user_name;
	user_email = Request["accpet_user.user_mail"];
	user_password = Request["accpet_user.user_password"];
	user_name = Request["accpet_user.user_username"];
	var formData=new FormData();
	formData.append("accpet_user.user_username", user_name);
	formData.append("accpet_user.user_mail", user_email);
	formData.append("accpet_user.user_password", user_password);
	
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/wlmtxt/User/User_registerUser");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("user_name:"+user_name);
			console.log("user_email:"+user_email);
			console.log("user_password:"+user_password);
			if (xhr.responseText == "1") {
				toastr.success("注册成功！");
				window.location.href="/wlmtxt/User/User_skipToIndexPage";
			}else{
				toastr.error("注册失败！");
				return false;
			}
		}
	}

}
