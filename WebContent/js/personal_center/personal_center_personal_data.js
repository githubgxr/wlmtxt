/*点击修改个人资料*/
$(".update_btn").click(function() {
	$(".personal_info_value").css("display", "none");
	$(".xg").css("display", "block");
	$(".reset_btn").css("display", "block");
	$(".check_btn").css("display", "block");
	$(".update_btn").css("display", "none");
});
/* 点击取消 */
$(".reset_btn").click(function() {
	$(".personal_info_value").css("display", "block");
	$(".xg").css("display", "none");
	$(".update_btn").css("display", "block");
	$(".reset_btn").css("display", "none");
	$(".check_btn").css("display", "none");
});
/*-----------修改头像------------*/
var btn_file=document.getElementById("btn_file");
$("#update_user_img").click(function(){
	btn_file.click();
});
btn_file.oninput=function(){
	console.log("user_id:"+user_id);
	var btn_file_value=btn_file.files[0];
	var formData=new FormData();
	formData.append("touxiangfile",btn_file_value);
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/wlmtxt/User/User_uploadTouXiang");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			if(xhr.responseText=="1"){
				console.log("修改头像成功");
				$(".img_user").attr("src",
						"/wlmtxt/Works/Works_getImg?imgName="+user_id);
				
				$(".sidebar_img_user").attr("src","/wlmtxt/Works/Works_getImg?imgName="	+ user_id);
				location.reload();
				toastr.success("上传成功！");
			}else{
				console.log("修改头像失败");
				toastr.error("上传失败！");
				return false;
			}
		}
	}
}
/*-----------修改个人资料------------*/
$(".check_btn").click(function(){
	var formData=new FormData();
	//用户名
	formData.append("accept_user.user_username", $(".input_username").val());
	//邮箱
	formData.append("accept_user.user_mail", $(".input_email").val());
	//性别
	formData.append("accept_user.user_sex", $(".input_sex").val());
	//简介
	formData.append("accept_user.user_bio", $(".input_bio").val());
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/wlmtxt/User/User_modifyPersonalData");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText=="1"){

				toastr.success("修改资料成功！");
				$(".div_username").html($(".input_username").val());
				$(".div_email").html($(".input_email").val());
				$(".div_sex").html($(".input_sex").val());
				$(".div_bio").html($(".input_bio").val());
				//个人中心导航的资料
				
				$(".sidebar_user_name").html($(".input_username").val());
				$(".sidebar_user_signature").html($(".input_bio").val());
				$(".personal_info_value").css("display", "block");
				$(".xg").css("display", "none");
				$(".update_btn").css("display", "block");
				$(".reset_btn").css("display", "none");
				$(".check_btn").css("display", "none");

			}else{

				toastr.error("修改资料失败！");
				return false;
			}
		}
	}
});
/*----------------修改密码---------------*/

$(".check_pwd_btn").click(function(){
	if($(".new_password").val().length<6||$(".new_password").val().length>15){
		toastr.error("请输入6~15位新密码！");
		return false;
	}else if($(".new_repassword").val()!==$(".new_password").val()){
		toastr.error("两次密码不一致！");
		return false;
	}else if($(".old_password").val()==$(".new_password").val()){
		toastr.error("新旧密码不能相同！");
		return false;
	}else{
		var formData=new FormData();
		//旧密码
		formData.append("accept_user.user_password", $(".old_password").val());
		//新密码
		formData.append("new_password", $(".new_password").val());
		var xhr=new XMLHttpRequest();
		xhr.open("POST","/wlmtxt/User/User_modifyPassword");
		xhr.send(formData);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				if(xhr.responseText=="1"){
					toastr.success("修改密码成功，请重新登录！");
					window.location.href="/wlmtxt/User/User_logout";
					/*$(".old_password").val("");
					 $(".new_password").val("");
					 $(".new_repassword").val("");*/
				}else if(xhr.responseText=="3"){
					toastr.error("旧密码错误！");
					return false;
				}else{
					toastr.error("修改密码失败！");
					return false;
				}
			}
		}
	}
});

