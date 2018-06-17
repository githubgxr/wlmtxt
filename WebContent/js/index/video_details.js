/*window.onload=function(){
	checkLogin();
	if(if_login==true){
		登录后
		-----------收藏----------
		//收藏
		var $collect_number = $("#collect_number").html();
		$("#collect_number_div").click(function() {
			if ($(this).hasClass("dz_no")) {
				//收藏
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "");
				xhr.send();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "1") {
							console.log("收藏成功！");
							$(this).addClass("dz_yes");
							$(this).removeClass("dz_no");
							$("#collect_number").html(parseInt($collect_number)+1);
						} else {
							alert("收藏失败！");
							console.log("收藏失败！");
							return false;
						}
					} 
				}
			}else if($(this).hasClass("dz_yes")){
				//取消点赞
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "");
				xhr.send();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "1") {
							console.log("取消收藏成功！");
							$(this).addClass("dz_no");
							$(this).removeClass("dz_yes");
							$("#collect_number").html($collect_number);
						} else {
							alert("取消收藏失败！");
							return false;
						}
					}
				}
				
			}
		});
		-----------点赞----------
		//点赞
		var $thumbs_number = $("#thumbs_number").html();
		$("#thumbs_number_div").click(function() {
			if ($(this).hasClass("dz_no")) {
				//点赞
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "");
				xhr.send();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "1") {
							console.log("点赞成功！");
							$(this).addClass("dz_yes");
							$(this).removeClass("dz_no");
							$("#thumbs_number").html(parseInt($thumbs_number)+1);
						} else {
							alert("点赞失败！");
							return false;
						}
					} 
				}
			}else if($(this).hasClass("dz_yes")){
				//取消点赞
				var xhr = new XMLHttpRequest();
				xhr.open("POST", "");
				xhr.send();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "1") {
							console.log("取消点赞成功！");
							$(this).addClass("dz_no");
							$(this).removeClass("dz_yes");
							$("#thumbs_number").html($thumbs_number);
						} else {
							alert("取消点赞失败！");
							return false;
						}
					} 
				}
				
			}
		});
		---------关注-----------
		$("#focus_btn").click(function(){
			if($(this).hasClass("not_focus")){
				//未关注
				$(this).addClass("has_focus");
				$(this).removeClass("not_focus");
				$(this).html("关注");
			}else if($(this).hasClass("has_focus")){
				//已关注
				$(this).addClass("not_focus");
				$(this).removeClass("has_focus");
				$(this).html("已关注");
			}
		});

	}else{
		登录前
		未登录时点击用户操作的关注、点赞、收藏等出现登录框
		$(".user_operate").click(function(){
			//显示navbar.js中的登录框
			 show_login_div();
			 });
	}
}
*/