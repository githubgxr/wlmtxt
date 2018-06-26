/**
 * 
 */
$(function() {
	listMyFansByPage(1);
});
function listMyFansByPage(pageIndex) {
	// 获取关注量
	getfocusNum("sidebar_user_focus", user_id);
	// 获取粉丝量
	getfansNum("sidebar_user_fans", user_id);

	/* 移除之前的数据 */
	var user_list = document.getElementsByClassName("user_list");
	var long = user_list.length;
	for (var num = 0; num < long; num++) {
		user_list[0].parentNode.removeChild(user_list[0]);
	}

	var xhr = new XMLHttpRequest();
	var formData = new FormData();
	formData.append("myFansVO.pageIndex", pageIndex);
	xhr.open("POST", "/wlmtxt/User/User_listMyFansDTO");
	xhr.send(formData);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var list_myFans = JSON.parse(xhr.responseText);
			if (list_myFans.length > 0) {
				$("#fans_btn").css("display","block");
				for (var i = 0; i < list_myFans.length; i++) {

					var myFans = '<li class="user_list">';
					myFans += '<div class="user_list_img_div">';
					myFans += '<img  id="'
							+ list_myFans[i].user.user_id
							+ '" onclick="to_other_data(this.id)" class="user_img" src="/wlmtxt/Works/Works_getImg?imgName='
							+ list_myFans[i].user.user_avatar + '"/>';
					myFans += '</div>';
					myFans += '<div class="user_info">';
					myFans += '<div  id="'
							+ list_myFans[i].user.user_id
							+ '" onclick="to_other_data(this.id)" class="user_name">'
							+ list_myFans[i].user.user_username + '</div>';
					console.log(i + ":list_myFans[i].mutualFollow:"
							+ list_myFans[i].mutualFollow);
					if (list_myFans[i].mutualFollow == "2") {
						myFans += '<div class="user_operateing focus_other" onclick="withFocus(this.id)" id="'
								+ list_myFans[i].user.user_id + '">+ 关注</div>';
					} else {
						myFans += '<div class="not_focus focus_other" id="'
								+ list_myFans[i].user.user_id + '">已关注</div>';
					}
					/*
					 * myFans+='<div class="user_operateing focus_other"
					 * id="'+list_myFans[i].user.user_id+'">+ 关注</div>';
					 */
					myFans += '<div class="user_grjj">'
							+ list_myFans[i].user.user_bio + '</div>';
					myFans += '</div>';
					myFans += '</li>';
					$(".user_list_ul").append(myFans);
				}

			} else {
				$("#fans_btn").css("display", "none");
				$("#wdfs_main").append('<img src="/wlmtxt/img/no_message_bg.png" style="width:250px;height:250px;margin:30px 240px 0px 240px;float:left;"/><div style="color:#99a2aa;font-size：16px;text-align:center;margin:0 0 50px 0;">还没有粉丝哦，快去找好友关注吧！</div>');
			}
		}
	}
}

/* +关注 */
function withFocus(focus_user_id) {
	var xhrhp = new XMLHttpRequest();
	xhrhp.open("POST", "/wlmtxt/User/User_followUser");
	var formData = new FormData();
	formData.append("accept_user.user_id", focus_user_id);
	xhrhp.send(formData);
	xhrhp.onreadystatechange = function() {
		if (xhrhp.readyState == 4 && xhrhp.status == 200) {
			if (xhrhp.responseText == "1") {
				toastr.success("关注成功！");
				listMyFansByPage(1);
			} else {
				toastr.error("关注失败！");
				return false;
			}
		}
	}
}

// 全部关注
function withFocusAll() {
	var xhrhttp = new XMLHttpRequest();
	xhrhttp.open("POST", "/wlmtxt/User/User_noticeAllMyFans");
	xhrhttp.send(null);
	xhrhttp.onreadystatechange = function() {

		if (xhrhttp.readyState == 4 && xhrhttp.status == 200) {
			var result = xhrhttp.responseText;
			console.log("result:" + result);
			if (result == "1") {
				toastr.success("全部关注成功！");
				listMyFansByPage(1);
			} else {
				toastr.error("全部关注失败！");
				return false;
			}
		}
	}
}
