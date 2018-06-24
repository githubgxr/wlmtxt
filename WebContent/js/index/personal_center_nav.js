//获取关注量
				getfocusNum("sidebar_user_focus",user_id);
				//获取粉丝量
				getfansNum("sidebar_user_fans",user_id);
				/*//获取关注量
				var formData_focus_num=new FormData();
				formData_focus_num.append("accept_user.user_id",userInfo.user_id);
				var xhr_focus_num=new XMLHttpRequest();
				xhr_focus_num.open("POST","/wlmtxt/Works/Works_totalFollowingNum");
				xhr_focus_num.send(formData_focus_num);
				xhr_focus_num.onreadystatechange=function(){
					if (xhr_focus_num.readyState == 4 && xhr_focus_num.status == 200) {
						$(".sidebar_user_focus").html(xhr_focus_num.responseText);
							}
						}
				//获取粉丝量
				var formData_fans_num=new FormData();
				formData_fans_num.append("accept_user.user_id",userInfo.user_id);
				var xhr_fans_num=new XMLHttpRequest();
				xhr_fans_num.open("POST","/wlmtxt/Works/Works_totalFansNum");
				xhr_fans_num.send(formData_focus_num);
				xhr_fans_num.onreadystatechange=function(){
					if (xhr_fans_num.readyState == 4 && xhr_fans_num.status == 200) {
						$(".sidebar_user_fans").html(xhr_fans_num.responseText);
							}
						}*/