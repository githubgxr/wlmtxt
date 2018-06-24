//忘记密码获取enter监听
$("#get_password_check_div").bind("keydown",function(e){
        // 兼容FF和IE和Opera    
    var theEvent = e || window.event;    
    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
    if (code == 13) {    
        //回车执行查询
            $("#get_password_check_btn").click();
        }    
});
function checkPassword(){
	var input_new_password = $("#input_new_password").val();
	if (input_new_password.length < 6 || input_new_password.length > 15) {
		/* 密码错误 */
		$("#get_password_alert_div").html("请输入6~15位的密码！");
		$("#get_password_alert_div").css("display","block");
		return false;
	}else{
		$("#get_password_alert_div").html("");
		$("#get_password_alert_div").css("display","none");
	}
}
function checkRepassword(){
	var input_new_password = $("#input_new_password").val();
	var input_new_repassword = $("#input_new_repassword").val();
	if (input_new_password !== input_new_repassword) {
		$("#get_password_alert_div").html("两次密码不一致！");
		$("#get_password_alert_div").css("display","block");
		return false;
	}else{
		$("#get_password_alert_div").html("");
		$("#get_password_alert_div").css("display","none");
	}
}
function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}
var Request = new Object();
Request = GetRequest();
var user_email;
user_email = Request["accept_user.user_mail"];
document.getElementById("get_password_check_btn").onclick = function() {
	var input_new_password = $("#input_new_password").val();
	var input_new_repassword = $("#input_new_repassword").val();
	console.log("input_new_password:"+input_new_password);
	console.log("input_new_repassword:"+input_new_repassword);
	if (input_new_password.length < 6 || input_new_password.length > 15) {
		/* 密码错误 */
		
		$("#get_password_alert_div").html("请输入6~15位的密码！");
		$("#get_password_alert_div").css("display","block");
		return false;
	} else {
		/* 密码正确 */
		if (input_new_password !== input_new_repassword) {
			$("#get_password_alert_div").html("两次密码不一致！");
			$("#get_password_alert_div").css("display","block");
			return false;
		} else {
			var formData = new FormData();
			formData.append("accept_user.user_mail", user_email);
			formData.append("accept_user.user_password", input_new_password);
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "/wlmtxt/User/User_modifiedPasswordBehindForgetted");
			xhr.send(formData);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					console.log("user_email:" + user_email);
					console.log("user_password:" + input_new_password);
					if (xhr.responseText == "1") {
						console.log("修改成功！");
						var str = '<img src="/wlmtxt/img/check_success.png" width="50px" style="float:left;margin:0 0 0 120px;"/>'
						str += '<h4 style="width:300px;line-height:50px;float:left;margin:0 30px;">恭喜您，修改密码成功！</h4>';
						str += '<button class="button_a" style="width:200px;height:50px;float:left;margin:50px 170px;font-size:16px;" onclick="checkSuccess()">返回首页</button>';
						$("#get_password_check_div").html(str);

					} else {
						console.log("修改失败！");
						var str = '<img src="/wlmtxt/img/check_failed.png" width="50px" style="float:left;margin:0 0 0 120px;"/>'
						str += '<h4 style="width:300px;line-height:50px;float:left;margin:0 30px;">很遗憾，修改密码失败！</h4>';
						str += '<button class="button_a" style="width:200px;height:50px;float:left;margin:50px 170px;font-size:16px;" onclick="checkSuccess()">返回首页</button>';
						$("#get_password_check_div").html(str);
						return false;
					}
				}
			}
		}
	}
}
function checkSuccess() {
	window.location.href = "/wlmtxt/User/User_skipToIndexPage";
}
