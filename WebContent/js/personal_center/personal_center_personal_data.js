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
/*-----------修改个人资料------------*/
$(".check_btn").click(function(){
	var formData=new FormData();
	//用户名
	formData.append("accpet_user.user_username", $(".input_username").val());
	//邮箱
	formData.append("accpet_user.user_mail", $(".input_email").val());
	//性别
	formData.append("accpet_user.user_sex", $(".input_sex").val());
	//简介
	formData.append("accpet_user.user_bio", $(".input_bio").val());
	var xhr=new XMLHttpRequest();
	xhr.open("POST","");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText=="1"){
				toastr.success("修改资料成功！");
				$(".div_username").html($(".input_username").val());
				$(".div_email").html($(".input_email").val());
				$(".div_sex").html($(".input_sex").val());
				$(".div_bio").html($(".input_bio").val());
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
	var formData=new FormData();
	//旧密码
	formData.append("accpet_user.user_username", $(".old_password").val());
	//新密码
	formData.append("accpet_user.user_mail", $(".new_password").val());
	//确认新密码
	formData.append("accpet_user.user_sex", $(".new_repassword").val());
	var xhr=new XMLHttpRequest();
	xhr.open("POST","");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText=="1"){
				toastr.success("修改密码成功！");
				$(".old_password").val("");
				 $(".new_password").val("");
				 $(".new_repassword").val("");
			}else{
				toastr.error("修改密码失败！");
				return false;
			}
		}
	}
});