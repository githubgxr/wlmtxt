function getWorksDetailVO() {
	// 视频id
	var video_id = $("#video_id").html();
	console.log("video_id:" + video_id);
	// 获取视频的详细信息
	var formData_detail = new FormData();
	formData_detail.append("accept_works.works_id", video_id);
	var xhr_detail = new XMLHttpRequest();
	xhr_detail.open("POST", "/wlmtxt/Works/Works_getWorksDetailVO");
	xhr_detail.send(formData_detail);
	xhr_detail.onreadystatechange = function() {
		if (xhr_detail.readyState == 4 && xhr_detail.status == 200) {
			console.log(1);
			var detail_response = JSON.parse(xhr_detail.responseText);
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
			$("#detail_video_keywords").html();
			// 视频
			$("#detail_video_content").attr(
					"src",
					"/wlmtxt/Works/Works_getVideo?worksName="
							+ detail_response.worksDTO.works.works_name);
			$("#detail_video_content").attr(
					"poster",
					"/wlmtxt/Works/Works_getImg?imgName="
							+ detail_response.worksDTO.works.works_cover);
			// 下载
			$("#detail_user_img").attr(
					"href",
					"/wlmtxt/Works/Works_getVideo?worksName="
							+ detail_response.worksDTO.works.works_id);

			/*------用户*/
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

			// 评论

			var comment_list = document.getElementsByClassName("comment_list");
			var long = comment_list.length;
			for (var num = 0; num < long; num++) {
				comment_list[0].parentNode.removeChild(comment_list[0]);
			}
			document.getElementById("discussNum").innerHTML = ""
					+ detail_response.discussDTOList.length;
			for (var numDiss = 0; numDiss < detail_response.discussDTOList.length; numDiss++) {
				var comment_list_str = '<div class="comment_list">';
				comment_list_str += '<hr style="width: 100%;" />';
				/* <!--整个评论--> */
				comment_list_str += '<div class="comment_list_content">';
				/* <!--左边--> */
				comment_list_str += '<div class="comment_list_content_left">';
				/* <!--头像--> */
				comment_list_str += '<img class="user_img comment_user_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ detail_response.discussDTOList[numDiss].user.user_avatar
						+ '" />';
				comment_list_str += '<div class="comment_user_name">'
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
				comment_list_str += '<div class="comment_delete"></div>';
				comment_list_str += '</div>';
				comment_list_str += '</div>';
				comment_list_str += '</div>';
				$("#comment_div").append(comment_list_str);
			}

		}
	}
	/** *********************详情*********************************** */

	/*-----------收藏----------*/
	// 收藏
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

	checkCollect();
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
				}
			}
		}
	});
	/*-----------点赞----------*/
	// 点赞
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

	checkLike();
	/* var $collect_number = $("#collect_number").html(); */
	$("#thumbs_number_div").click(function() {
		// 点赞
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
				}
			}
		}
	});
	/*---------关注-----------*/
	/*
	 * // 查询是否关注 function checkFocus() { var formData_check_focus=new
	 * FormData();
	 * formData_check_focus.append("accept_works.works_id",video_id); var
	 * focus_xhr = new XMLHttpRequest(); focus_xhr.open("POST",
	 * "/wlmtxt/Works/Works_isLiked"); focus_xhr.send(formData_check_focus);
	 * focus_xhr.onreadystatechange = function() { if (focus_xhr.readyState == 4 &&
	 * focus_xhr.status == 200) { if (focus_xhr.responseText == "1") {
	 * console.log("已关注！"); $("#focus_btn").addClass("has_focus");
	 * $("#focus_btn").removeClass("not_focus");
	 * 
	 * $("#collect_number").html(parseInt($collect_number) + 1); } else {
	 * console.log("未关注！"); $("#focus_btn").addClass("not_focus");
	 * $("#focus_btn").removeClass("has_focus"); } } } }
	 */
	/*
	 * checkFocus(); $("#focus_btn").click(function() { var formData_focus=new
	 * FormData(); formData_focus.append("accept_works.works_id",video_id); var
	 * xhr = new XMLHttpRequest(); xhr.open("POST", "/wlmtxt/Works/Works");
	 * xhr.send(formData_focus); xhr.onreadystatechange = function() { if
	 * (xhr.readyState == 4 && xhr.status == 200) { if (xhr.responseText == "1") {
	 * console.log("关注或取消成功！"); checkFocus(); } } } });
	 */
	/*---------评论-----------*/
	/*function setDiscuss() {

	}

	setDiscuss();*/
	$("#video_comment_btn")
			.click(
					function() {
						var comment_text = $("#textarea_comment").val();
						if (comment_text == "") {
							toastr.error("请输入评论内容！");
						} else {
							var formData_comment = new FormData();
							// 评论的作品或者评论
							formData_comment.append(
									"accpet_discuss.discuee_father_discuss_id",
									video_id);
							// 评论内容
							formData_comment.append(
									"accpet_discuss.discuss_content",
									comment_text);

							var xhr = new XMLHttpRequest();
							xhr
									.open("POST",
											"/wlmtxt/Works/Works_discussWorks");
							xhr.send(formData_comment);
							xhr.onreadystatechange = function() {
								if (xhr.readyState == 4 && xhr.status == 200) {
									if (xhr.responseText == "1") {

										document
												.getElementById("textarea_comment").value = "";

										toastr.success("评论成功！");

										getWorksDetailVO()

									} else {
										toastr.error("评论失败！");
										return false;
									}
								}
							}

						}
					});
	/*--------删除评论-----------*/
	$(".comment_delete").click(function() {
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "");
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				if (xhr.responseText == "1") {
					$(this).remove();
					toastr.success("删除评论成功！");
				} else {
					toastr.error("删除评论失败！");
					return false;
				}
			}
		}

	});
}
getWorksDetailVO();