function getfocusNum(its_class,get_user_id){
	/*------用户*/
	// 获取关注量
	console.log("getfocusits_class:"+its_class);
	console.log("getfocusNum:"+get_user_id);
	var formData_focus_num = new FormData();
	formData_focus_num.append("accept_user.user_id",
			get_user_id);
	var xhr_focus_num = new XMLHttpRequest();
	xhr_focus_num.open("POST", "/wlmtxt/Works/Works_totalFollowingNum");
	xhr_focus_num.send(formData_focus_num);
	xhr_focus_num.onreadystatechange = function() {
		if (xhr_focus_num.readyState == 4
				&& xhr_focus_num.status == 200) {
			$("."+its_class).html(xhr_focus_num.responseText);
			console.log(its_class+"-num:"+xhr_focus_num.responseText);
		}
	}
}
function getfansNum(its_class,get_user_id){
	// 获取粉丝量
	console.log("getfansits_class:"+its_class);
	console.log("getfansNum:"+get_user_id);
	var formData_fans_num = new FormData();
	formData_fans_num.append("accept_user.user_id",
			get_user_id);
	var xhr_fans_num = new XMLHttpRequest();
	xhr_fans_num.open("POST", "/wlmtxt/Works/Works_totalFansNum");
	xhr_fans_num.send(formData_fans_num);
	xhr_fans_num.onreadystatechange = function() {
		if (xhr_fans_num.readyState == 4 && xhr_fans_num.status == 200) {
			$("."+its_class).html(xhr_fans_num.responseText);
			console.log(its_class+"-num:"+xhr_fans_num.responseText);
		}
		
	}
}