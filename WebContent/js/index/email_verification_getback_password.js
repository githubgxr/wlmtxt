var input_new_password = $("#input_new_password").val();
var input_new_repassword = $("#input_new_repassword").val();
/* 验证密码 */
function checkPassword() {
	// 登录密码
	// 登录
	if (input_new_password.length < 6 || input_new_password.length > 15) {
		toastr.error("请输入6~15位的密码！");
		return false;
	}

}
/* 确认密码 */
function checkRepassword() {
	if (input_new_password !== input_new_repassword) {
		toastr.error("两次密码不一致！");
		return false;
	}
}
/* 找回密码 */
function getBackPassword() {
	var formData = new FormData();
	formData.append("accpet_user.user_username", register_username);
	formData.append("accpet_user.user_password", input_new_password);
	if (input_new_password.length < 6 || input_new_password.length > 15) {
		/* 密码错误 */
		toastr.error("请输入6~15位的密码！");
		return false;
	} else {
		/* 密码正确 */
		if (input_new_password !== input_new_repassword) {
			toastr.error("两次密码不一致！");
			return false;
		} else {
			// 确认密码正确
			/* 和后台交互 */
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "/wlmtxt/User/User_sendRegisterMail");// 发送验证邮件
			xhr.send(formData);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == "1") {
					} else {
						/* 发送失败 */
						return false;
					}
				}

			}
		}
	}
}

/*
 * function GetRequest() { var url = location.search; //获取url中"?"符后的字串 var
 * theRequest = new Object(); if (url.indexOf("?") != -1) { var str =
 * url.substr(1); strs = str.split("&"); for(var i = 0; i < strs.length; i ++) {
 * theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); } } return
 * theRequest; } var Request = new Object(); Request = GetRequest(); var
 * user_email,user_password,user_name; user_email =
 * Request["accpet_user.user_mail"]; user_password =
 * Request["accpet_user.user_password"]; user_name =
 * Request["accpet_user.user_username"];
 * document.getElementById("register_check_btn").onclick=function(){ var
 * formData=new FormData(); formData.append("accpet_user.user_username",
 * user_name); formData.append("accpet_user.user_mail", user_email);
 * formData.append("accpet_user.user_password", user_password); var xhr=new
 * XMLHttpRequest(); xhr.open("POST","/wlmtxt/User/User_registerUser");
 * xhr.send(formData); xhr.onreadystatechange=function(){ if(xhr.readyState==4 &&
 * xhr.status==200){ console.log("user_name:"+user_name);
 * console.log("user_email:"+user_email);
 * console.log("user_password:"+user_password);
 * 
 * if (xhr.responseText == "1") { console.log("激活成功！"); var str='<img
 * src="/wlmtxt/img/check_success.png" width="50px" style="float:left;margin:0 0
 * 0 120px;"/>' str += '<h4 style="width:300px;line-height:50px;float:left;margin:0 30px;">恭喜您，激活账号成功！</h4>';
 * str +='<button class="button_a"
 * style="width:200px;height:50px;float:left;margin:50px 170px;font-size:16px;"
 * onclick="checkSuccess()">返回首页</button>'; $("#register_check_div").html(str);
 * 
 * }else{ console.log("激活失败！"); var str='<img
 * src="/wlmtxt/img/check_failed.png" width="50px" style="float:left;margin:0 0
 * 0 120px;"/>' str += '<h4 style="width:300px;line-height:50px;float:left;margin:0 30px;">很遗憾，激活账号失败！</h4>';
 * str +='<button class="button_a"
 * style="width:200px;height:50px;float:left;margin:50px 170px;font-size:16px;"
 * onclick="checkSuccess()">返回首页</button>'; $("#register_check_div").html(str);
 * return false; } } } } function checkSuccess(){
 * window.location.href="/wlmtxt/User/User_skipToIndexPage"; }
 */