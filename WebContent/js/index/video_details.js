var discuss_id, video_id;
getWorksDetailVO();
collaborativeFilteringBySlopeOne();
function collaborativeFilteringBySlopeOne() {
	video_id = $.trim($("#video_id").html());
	console.log("video_id:" + video_id);
	var formData = new FormData();
	formData.append("accept_works.works_id", video_id);
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_collaborativeFilteringBySlopeOne");
	xhr.send(formData);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var worksDTOList = JSON.parse(xhr.responseText);
			/*
			 * 清空原表数据
			 */
			var XGTJ = document.getElementsByClassName("XGTJ");
			var long = XGTJ.length;

			for (var num = 0; num < long; num++) {
				XGTJ[0].parentNode.removeChild(XGTJ[0]);
			}
			/*
			 * 
			 */
			for (var i = 0; i < worksDTOList.length; i++) {
				var collaborativeFiltering = '<li class="XGTJ index_list_video_item" style="width: 160px; height: 200px; margin: 0 12px 10px 12px;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="width: 160px; height: 160px;"><div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ worksDTOList[i].works.works_cover
						+ '" style="width: 160px; height: 100px;">'
						+ ((worksDTOList[i].secondMenu == null) ? ''
								: ('<div class="category_name">'
										+ worksDTOList[i].secondMenu.second_menu_name + '</div>'))
						+ '<div class="video_overplay" style="width: 160px; height: 100px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;" onclick="window.location=\'/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
						+ worksDTOList[i].works.works_id
						+ '\'"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 160px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px; width: 160px;">'
						+ worksDTOList[i].works.works_title
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 90px; margin-top: -5px;">'
						+ worksDTOList[i].user.user_username
						+ '</div>'
						+ '<!--发布时间-->'
						+ '<div class="video_time" style="width: 70px; margin-top: -5px; float: right;">'
						+ worksDTOList[i].works.works_gmt_create.substr(0, 10)
						+ '</div>'
						+ '</div></a> <!--视频分类-->'
						+ '<div class="video_label" style="width: 160px; padding: 0;">'
						+ '<div class="video_label_content" style="width: 160px; padding: 0;">'
				for (var num = 0; num < worksDTOList[i].keyWordDTOList.length; num++) {
					collaborativeFiltering = collaborativeFiltering
							+ '<a class="video_label_item">'
							+ worksDTOList[i].keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}

				collaborativeFiltering = collaborativeFiltering + '</div>'
						+ '</div>' + '</li>';

				$("#XGTJ_Con").append(collaborativeFiltering);
			}
		}
	}
}
function getWorksDetailVO() {
	/* checkLogin(); */
	// 视频id
	video_id = $.trim($("#video_id").html());
	console.log("video_id:" + video_id);
	// 获取视频的详细信息
	var formData_detail = new FormData();
	formData_detail.append("accept_works.works_id", video_id);
	var xhr_detail = new XMLHttpRequest();
	xhr_detail.open("POST", "/wlmtxt/Works/Works_getWorksDetailVO");
	xhr_detail.send(formData_detail);
	xhr_detail.onreadystatechange = function() {
		if (xhr_detail.readyState == 4 && xhr_detail.status == 200) {
			var detail_response = JSON.parse(xhr_detail.responseText);
			// 用户id
			$("#user_id").html(detail_response.worksDTO.user.user_id);
			console.log("user_id:" + $("#user_id").html());
			// 当前登录用户不显示关注按钮
			if (detail_response.worksDTO.user.user_id == user_id) {
				$("#focus_btn").css("display", "none");
			} else {
				$("#focus_btn").css("display", "block");
			}
			/*------视频*/
			// 标题
			$("#detail_video_title").html(
					detail_response.worksDTO.works.works_title);
			// 简介
			$("#detail_video_discribe").html(
					detail_response.worksDTO.works.works_reason);
			// 时间
			$("#detail_video_time").html(
					detail_response.worksDTO.works.works_gmt_create);
			// 关键字
			var detail_str = "";
			for (var num = 0; num < detail_response.worksDTO.keyWordDTOList.length; num++) {
				detail_str += '<span class="video_label_item" style="margin: 0 10px 0 0;">'
						+ detail_response.worksDTO.keyWordDTOList[num].keyword.keyword_name
						+ '</span>';

			}
			$("#detail_video_keywords").html(detail_str);
			// 视频
			$("#detail_video_content").attr(
					"src",
					"/wlmtxt/Works/Works_getVideo?worksName="
							+ detail_response.worksDTO.works.works_name);

			$("#detail_video_content").attr(
					"poster",
					"/wlmtxt/Works/Works_getImg?imgName="
							+ detail_response.worksDTO.works.works_cover);
			$("#download_a").attr(
					"href",
					"/wlmtxt/Works/Works_getVideo?worksName="
							+ detail_response.worksDTO.works.works_name);
			$("#download_a").attr("download",
					"" + detail_response.worksDTO.works.works_name);

			// 头像
			$("#detail_user_img").attr(
					"src",
					"/wlmtxt/Works/Works_getImg?imgName="
							+ detail_response.worksDTO.user.user_avatar);

			// 用户名
			$("#detail_user_name").html(
					detail_response.worksDTO.user.user_username);
			// 个人介绍
			$("#detail_user_bio").html(detail_response.worksDTO.user.user_bio);

			// 推荐信息列表
			/*
			 * var xhr_tj = new XMLHttpRequest(); xhr_tj.open("POST", "");
			 * xhr_tj.send(null); xhr_tj.onreadystatechange = function() { if
			 * (xhr_tj.readyState == 4 && xhr_tj.status == 200) { var
			 * ti_response = JSON.parse(xhr_tj.responseText); for (var numDiss =
			 * 0; numDiss < detail_response.discussDTOList.length; numDiss++) {
			 * var tj_str = '<div class="tj" style="float: left;">'; tj_str += '<img
			 * src="<%=basePath%>css/zb/img/4.png" />'; tj_str += '<div
			 * style="height: 40px; line-height: 20px; overflow: hidden; margin:
			 * 10px 0;">'; tj_str += '</div>'; tj_str += '</div>';
			 * $("#tj_list").append(tj_str); } } }
			 */

			// 评论
			var comment_list = document.getElementsByClassName("comment_list");
			var long = comment_list.length;
			for (var num = 0; num < long; num++) {
				comment_list[0].parentNode.removeChild(comment_list[0]);
			}
			document.getElementById("discussNum").innerHTML = ""
					+ detail_response.discussDTOList.length;
			for (var numDiss = 0; numDiss < detail_response.discussDTOList.length; numDiss++) {
				var comment_list_str = '<div class="comment_list" >';
				comment_list_str += '<hr style="width: 100%;" />';
				/* <!--整个评论--> */
				comment_list_str += '<div class="comment_list_content">';
				/* <!--左边--> */
				comment_list_str += '<div class="comment_list_content_left">';
				/* <!--头像--> */
				comment_list_str += '<img id="'
						+ detail_response.discussDTOList[numDiss].discuss.discuss_user_id
						+ '" class="user_img comment_user_img to_other_data" src="/wlmtxt/Works/Works_getImg?imgName='
						+ detail_response.discussDTOList[numDiss].user.user_avatar
						+ '" onclick="to_other_data(this.id)"/>';
				comment_list_str += '<div class="comment_user_name to_other_data" id="'
						+ detail_response.discussDTOList[numDiss].discuss.discuss_user_id
						+ '">'
						+ detail_response.discussDTOList[numDiss].user.user_username
						+ '</div>';
				comment_list_str += ' </div>';
				/* <!--右边--> */
				comment_list_str += '<div class="comment_list_content_right">';
				/* 评论内容 */
				comment_list_str += '<div class="comment_text">';
				comment_list_str += detail_response.discussDTOList[numDiss].discuss.discuss_content;
				comment_list_str += '</div>';
				comment_list_str += '<div class="comment_time">'
						+ detail_response.discussDTOList[numDiss].discuss.discuss_gmt_create
						+ '</div>';
				if (user_id != null) {
					if (detail_response.discussDTOList[numDiss].discuss.discuss_user_id == user_id) {
						comment_list_str += '<div id="'
							+ detail_response.discussDTOList[numDiss].discuss.discuss_id
							+ '" class="comment_delete comment_response_operate" onclick="response_operate(this)">回复</div>';
						comment_list_str += '<div class="comment_delete comment_delete_operate" id="'
								+ detail_response.discussDTOList[numDiss].discuss.discuss_id
								+ '" onclick="delete_operate(this)">删除</div>';

					} else {
						comment_list_str += '<div id="'
								+ detail_response.discussDTOList[numDiss].discuss.discuss_id
								+ '" class="comment_delete comment_response_operate" onclick="response_operate(this)">回复</div>';
					}
				}

				comment_list_str += '</div>';
				// 回复
				if (detail_response.discussDTOList[numDiss].replyDTO.length !== 0) {
					for (var res = 0; res < detail_response.discussDTOList[numDiss].replyDTO.length; res++) {
						comment_list_str += '<div class="comment_list_content_right" style="margin:10px 0;">';
						comment_list_str += '<span style="color:#1cd388;">';
						comment_list_str += detail_response.discussDTOList[numDiss].replyDTO[res].user.user_username;
						comment_list_str += ':</span>';
						comment_list_str += '<span>';
						comment_list_str += detail_response.discussDTOList[numDiss].replyDTO[res].reply.discuss_content;
						comment_list_str += '</span>';

						comment_list_str += '<div style="float:right"><span style="color:#bfbfbf;float:right;margin:0 10px;">';
						comment_list_str += detail_response.discussDTOList[numDiss].replyDTO[res].reply.discuss_gmt_create;
						comment_list_str += '</span>';
						if (detail_response.discussDTOList[numDiss].replyDTO[res].user.user_id == user_id) {
							comment_list_str += '<span style="style="color:#bfbfbf;float:right;" class="comment_delete comment_delete_operate" id="'
									+ detail_response.discussDTOList[numDiss].replyDTO[res].reply.discuss_id
									+ '" onclick="delete_operate(this)">删除</span></div>';
						}
						comment_list_str += '</div>';

					}

				}
				comment_list_str += '</div>';
				comment_list_str += '</div>';
				$("#comment_div").append(comment_list_str);

			}
			// 获取关注量
			getfocusNum("detail_user_focus_num", $("#user_id").html());
			// 获取粉丝量
			getfansNum("detail_user_fans_num", $("#user_id").html());

		}
		/** *********************详情*********************************** */
		// 查询是否关注
		checkFocus();
		// 获取播放数
		getPlayNum();
		/*-----------收藏----------*/
		// 收藏
		// 获取收藏数
		getCollectNum();
		// 查询是否收藏
		checkCollect();
		/*-----------点赞----------*/
		// 点赞
		// 获取点赞数
		getLikeNum();
		// 查询是否点赞
		checkLike();
	}

}

// 评论
function video_comment_btn_click() {
	var video_id = $("#video_id").html();
	video_id = $.trim(video_id);
	var comment_text = $("#textarea_comment").val();
	if (comment_text == "") {
		toastr.error("请输入评论内容！");
	} else {
		var formData_comment = new FormData();
		// 评论的作品或者评论
		formData_comment.append("accept_discuss.discuss_father_discuss_id",
				video_id);
		// 评论内容
		formData_comment.append("accept_discuss.discuss_content", comment_text);

		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/wlmtxt/Works/Works_discussWorks");

		xhr.send(formData_comment);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				if (xhr.responseText == "1") {

					document.getElementById("textarea_comment").value = "";

					toastr.success("评论成功！");

					getWorksDetailVO();

				} else {
					toastr.error("评论失败！");
					return false;
				}
			}
		}

	}
}

/*---------关注-----------*/
// 查询是否关注
function checkFocus() {
	var formData_check_focus = new FormData();
	console.log("checkfocus:" + $("#user_id").html());
	formData_check_focus.append("accept_user.user_id", $("#user_id").html());
	var focus_xhr = new XMLHttpRequest();
	focus_xhr.open("POST", "/wlmtxt/User/User_isFollowedUser");
	focus_xhr.send(formData_check_focus);
	focus_xhr.onreadystatechange = function() {
		if (focus_xhr.readyState == 4 && focus_xhr.status == 200) {
			if (focus_xhr.responseText == "1") {
				console.log("已关注！");
				$("#focus_btn").html("已关注")
				$("#focus_btn").addClass("has_focus");
				$("#focus_btn").removeClass("not_focus");
			} else {
				console.log("未关注！");
				$("#focus_btn").html("+ 关注")
				$("#focus_btn").addClass("not_focus");
				$("#focus_btn").removeClass("has_focus");
			}
		}
	}
}
// 点击关注
$("#focus_btn").click(function() {
	console.log("focus:" + $("#user_id").html());
	var formData_focus = new FormData();
	formData_focus.append("accept_user.user_id", $("#user_id").html());
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/User/User_followUser");
	xhr.send(formData_focus);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == "1") {
				console.log("关注或取消成功！");
				checkFocus();
				// 获取关注量
				getfocusNum("detail_user_focus_num", $("#user_id").html());
				// 获取粉丝量
				getfansNum("detail_user_fans_num", $("#user_id").html());
			}
		}
	}
});

// 跳转页面
// 视频发布者
$("#detail_user_img").click(

function() {
	to_other_data($("#user_id").html());
});
$("#detail_user_name").click(

function() {
	to_other_data($("#user_id").html());
})

// 回复评论
function response_operate(button) {
	discuss_id = button.id;
	$("#mymodal").modal("toggle");

}
// 确认回复
function check_response() {
	if ($("#responseComment").val == "") {
		toastr.error("请输入回复内容！");
		return false;
	}
	var formData_response = new FormData();
	formData_response.append("accept_discuss.discuss_content", $(
			"#responseComment").val());
	formData_response.append("accept_discuss.discuss_father_discuss_id",
			discuss_id);
	var xhr_response = new XMLHttpRequest();
	xhr_response.open("POST", "/wlmtxt/Works/Works_discussWorks");
	xhr_response.send(formData_response);
	xhr_response.onreadystatechange = function() {
		if (xhr_response.readyState == 4 && xhr_response.status == 200) {
			if (xhr_response.responseText == "1") {
				document.getElementById("responseComment").innerHTML = "";
				$("#mymodal").modal("toggle");
				toastr.success("回复评论成功！");

				getWorksDetailVO();

			} else {
				toastr.error("回复评论失败！");
				return false;
			}
		}
	}
}

// 删除评论
function delete_operate(button) {
	var formData_comment_delete = new FormData();
	formData_comment_delete.append("accept_discuss.discuss_id", button.id);
	var comment_delete_xhr = new XMLHttpRequest();
	comment_delete_xhr.open("POST", "/wlmtxt/Works/Works_deleteDisscuss");
	comment_delete_xhr.send(formData_comment_delete);
	comment_delete_xhr.onreadystatechange = function() {
		if (comment_delete_xhr.readyState == 4
				&& comment_delete_xhr.status == 200) {
			if (comment_delete_xhr.responseText == "1") {
				toastr.success("删除评论成功！");
				getWorksDetailVO();
			}
		}
	}
}
// 获取播放数
function getPlayNum() {
	var formData_get_play_num = new FormData();
	formData_get_play_num.append("accept_works.works_id", video_id);
	var play_num_xhr = new XMLHttpRequest();
	play_num_xhr.open("POST", "/wlmtxt/Works/Works_getPlayNum");
	play_num_xhr.send(formData_get_play_num);
	play_num_xhr.onreadystatechange = function() {
		if (play_num_xhr.readyState == 4 && play_num_xhr.status == 200) {
			console.log("播放：" + play_num_xhr.responseText);
			$("#play_number").html(play_num_xhr.responseText);
		}
	}
}
// 获取收藏数
function getCollectNum() {
	var formData_get_collect_num = new FormData();
	formData_get_collect_num.append("accept_works.works_id", video_id);
	var collect_num_xhr = new XMLHttpRequest();
	collect_num_xhr.open("POST", "/wlmtxt/Works/Works_getCollectNum");
	collect_num_xhr.send(formData_get_collect_num);
	collect_num_xhr.onreadystatechange = function() {
		if (collect_num_xhr.readyState == 4 && collect_num_xhr.status == 200) {
			console.log("收藏：" + collect_num_xhr.responseText);
			$("#collect_number").html(collect_num_xhr.responseText);
		}
	}
}
// 查询是否收藏
function checkCollect() {
	var formData_check_collect = new FormData();
	formData_check_collect.append("accept_works.works_id", video_id);
	var collect_xhr = new XMLHttpRequest();
	collect_xhr.open("POST", "/wlmtxt/Works/Works_isCollectWorks");
	collect_xhr.send(formData_check_collect);
	collect_xhr.onreadystatechange = function() {
		if (collect_xhr.readyState == 4 && collect_xhr.status == 200) {
			if (collect_xhr.responseText == "1") {
				console.log("已收藏！");
				$("#collect_number_div").addClass("dz_yes");
				$("#collect_number_div").removeClass("dz_no");
				/* $("#collect_number").html(parseInt($collect_number) + 1); */
			} else {
				console.log("未收藏！");
				$("#collect_number_div").addClass("dz_no");
				$("#collect_number_div").removeClass("dz_yes");
			}
		}
	}
}
// 点击收藏和取消收藏
/* var $collect_number = $("#collect_number").html(); */
$("#collect_number_div").click(function() {
	// 收藏
	var formData_collect = new FormData();
	formData_collect.append("accept_works.works_id", video_id);
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_collectWorks");
	xhr.send(formData_collect);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == "1") {
				console.log("收藏或取消收藏成功！");
				checkCollect();
				getCollectNum();
			}
		}
	}
});
// 获取点赞数
function getLikeNum() {
	var formData_get_like_num = new FormData();
	formData_get_like_num.append("accept_works.works_id", video_id);
	var like_num_xhr = new XMLHttpRequest();
	like_num_xhr.open("POST", "/wlmtxt/Works/Works_getLikeNum");
	like_num_xhr.send(formData_get_like_num);
	like_num_xhr.onreadystatechange = function() {
		if (like_num_xhr.readyState == 4 && like_num_xhr.status == 200) {
			console.log("点赞：" + like_num_xhr.responseText);
			$("#thumbs_number").html(like_num_xhr.responseText);
		}
	}
}
// 查询是否点赞
function checkLike() {
	var formData_check_like = new FormData();
	formData_check_like.append("accept_works.works_id", video_id);
	var like_xhr = new XMLHttpRequest();
	like_xhr.open("POST", "/wlmtxt/Works/Works_isLiked");
	like_xhr.send(formData_check_like);
	like_xhr.onreadystatechange = function() {
		if (like_xhr.readyState == 4 && like_xhr.status == 200) {
			if (like_xhr.responseText == "1") {
				console.log("已点赞！");
				$("#thumbs_number_div").addClass("dz_yes");
				$("#thumbs_number_div").removeClass("dz_no");
				/* $("#collect_number").html(parseInt($collect_number) + 1); */
			} else {
				console.log("未点赞！");
				$("#thumbs_number_div").addClass("dz_no");
				$("#thumbs_number_div").removeClass("dz_yes");
			}
		}
	}
}
// 点赞
$("#thumbs_number_div").click(function() {
	var formData_like = new FormData();
	formData_like.append("accept_works.works_id", video_id);
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_likeWorks");
	xhr.send(formData_like);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == "1") {
				console.log("点赞或取消点赞成功！");
				checkLike();
				getLikeNum();
			}
		}
	}
});
// 评论获取enter监听
$("#comment_operate_div").bind("keydown", function(e) {
	// 兼容FF和IE和Opera
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		// 回车执行查询
		$("#video_comment_btn").click();
	}
});
// 回复评论获取enter监听
$("#mymodal").bind("keydown", function(e) {
	// 兼容FF和IE和Opera
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		// 回车执行查询
		$("#check_response_btn").click();
	}
});
