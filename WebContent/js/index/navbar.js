var if_login = false;

//查询是否收藏
function checkCollect() {
	var collect_xhr = new XMLHttpRequest();
	collect_xhr.open("POST", "/wlmtxt/Works/Works_isCollectWorks");
	collect_xhr.send();
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
//查询是否点赞
function checkLike() {
	var like_xhr = new XMLHttpRequest();
	like_xhr.open("POST", "/wlmtxt/Works/Works_isLiked");
	like_xhr.send();
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
//查询是否关注
function checkFocus() {
	var focus_xhr = new XMLHttpRequest();
	focus_xhr.open("POST", "/wlmtxt/Works/Works_isLiked");
	focus_xhr.send();
	focus_xhr.onreadystatechange = function() {
		if (focus_xhr.readyState == 4 && focus_xhr.status == 200) {
			if (focus_xhr.responseText == "1") {
				console.log("已关注！");
				$("#focus_btn").addClass("has_focus");
				$("#focus_btn").removeClass("not_focus");
				/*
				 * $("#collect_number").html(parseInt($collect_number) +
				 * 1);
				 */
			} else {
				console.log("未关注！");
				$("#focus_btn").addClass("not_focus");
				$("#focus_btn").removeClass("has_focus");
			}
		}
	}
}

//判断是否登录
window.onload = checkLogin;
function checkLogin() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/User/User_isLogin");// 判断登录状态
	xhr.send(null);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == "2") {
				console.log("未登录！");
				// 点击头像栏显示登录注册
				$("#user_img").click(function() {
					show_login_div();
				});
				if_login = false;
				console.log("if_login：" + if_login);
				/* 登录前 */
				/* 未登录时点击用户操作的关注、点赞、收藏等出现登录框 */
				$(".user_operate").click(function() {
					// 显示navbar.js中的登录框
					show_login_div();
				});
			} else {
				var userInfo = JSON.parse(xhr.responseText);
				console.log("已登录！");
				console.log("user_mail:" + userInfo.user_mail);
				$(".login_show").css("display", "block");
				// 记得修改为用户的头像
				$("#user_img").attr("src",
						"http://localhost:8080/wlmtxt/css/zb/img/tx.jpg");
				if_login = true;
				console.log("if_login：" + if_login);
				/* 登录后 */
				/** *********************详情*********************************** */
				/*-----------收藏----------*/
				// 收藏
				checkCollect();
				// 点击收藏和取消收藏
				/* var $collect_number = $("#collect_number").html(); */
				$("#collect_number_div").click(function() {
					// 收藏
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/wlmtxt/Works/Works_collectWorks");
					xhr.send();
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
				checkLike();
				/* var $collect_number = $("#collect_number").html(); */
				$("#thumbs_number_div").click(function() {
					// 点赞
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/wlmtxt/Works/Works_likeWorks");
					xhr.send();
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
				checkFocus();
				$("#focus_btn").click(function() {
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/wlmtxt/Works/");
					xhr.send();
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							if (xhr.responseText == "1") {
								console.log("关注或取消成功！");
								checkFocus();
							}
					}
					
				}
			});
				/*---------下载-----------*/
				$(".video_download").click(function() {
					// 取消点赞
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/wlmtxt/Works/downloadWorks");
					xhr.send();
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							if (xhr.responseText == "1") {
								console.log("下载成功！");
							} else {
								console.log("下载失败！");
								return false;
							}
						}
					}

				});
				/*---------评论-----------*/
				$("#video_comment_btn")
						.click(
								function() {
									var comment_text = $("#textarea_comment")
											.val();
									if (comment_text == "") {
										alert("请输入评论内容！");
									} else {
										var xhr = new XMLHttpRequest();
										xhr.open("POST", "");
										xhr.send();
										xhr.onreadystatechange = function() {
											if (xhr.readyState == 4
													&& xhr.status == 200) {
												if (xhr.responseText == "1") {
													var comment_list_str = '<div class="comment_list">';
													comment_list_str += '<hr style="width: 100%;" />';
													/* <!--整个评论--> */
													comment_list_str += '<div class="comment_list_content">';
													/* <!--左边--> */
													comment_list_str += '<div class="comment_list_content_left">';
													/* <!--头像--> */
													comment_list_str += '<img class="user_img comment_user_img" src="../../css/zb/img/tx.jpg" />';
													comment_list_str += '<div class="comment_user_name">树深时见鹿dear</div>';
													comment_list_str += ' </div>';
													/* <!--右边--> */
													comment_list_str += '<div class="comment_list_content_right">';
													/* 评论内容 */
													comment_list_str += '<div class="comment_text">';
													comment_list_str += comment_text;
													comment_list_str += '</div>';
													comment_list_str += '<div class="comment_time">2017-05-11 23:22</div>';
													comment_list_str += '<div class="comment_delete">删除</div>';
													comment_list_str += '</div>';
													comment_list_str += '</div>';
													comment_list_str += '</div>';
													$("#comment_div").append(
															comment_list_str);
													document
															.getElementById("textarea_comment").value = "";

													console.log("评论成功！");
												} else {
													console.log("评论失败！");
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
								console.log("删除评论成功！");
							} else {
								console.log("删除评论失败！");
								return false;
							}
						}
					}

				});

			}
		}
	}
}

// 移出登录注册
function removeTest() {
	$("#mask").css("display", "none");
	$("#login_and_register").css("display", "none");
	$("#register_div").css("display", "none");
	$("#login_div").css("display", "none");
	$("#check_email_text").css("display", "none");
	$(".log_alert_div").css("display", "none");
	$(".log_alert_div").html("");
}
// 显示登录注册
function show_login_div() {
	/* 创建遮罩层 */
	// 获取页面的高度和宽度
	var sHeight = document.documentElement.scrollHeight;
	var sWidth = document.documentElement.scrollWidth;
	var mask = document.getElementById("mask");
	mask.style.display = "block";
	mask.style.height = sHeight + "px";
	mask.style.width = sWidth + "px";
	/* document.body.appendChild(mask);//将遮罩层的div添加到页面中 */
	/* 创建登录框 */
	// 获取可视区域的高度和宽度
	var wHeight = document.documentElement.clientWidth;
	var login_and_register = document.getElementById("login_and_register");
	login_and_register.style.display = "block";
	$("#login_div").css("display", "block");
	/* var wWidth=document.documentElement.clientWidth; *//* 针对当前页面（如果说页面是一个竖向的页面），它的页面宽度与可视区域的宽度相同 */
	/*
	 */
	/* 获取login的高度和宽度 */
	/* 获取已有元素的高度和宽度，要写在插入div的后面，不然只存在js中，不在DOM中就获取不到 */
	var dHeight = login_and_register.offsetHeight;
	var dWidth = login_and_register.offsetWidth;
	login_and_register.style.left = (sWidth - dWidth) / 2 + "px";
	login_and_register.style.top = "200px";

	/* 获得id为close的关闭元素 */
	var oClose = document.getElementById("close");
	/* 点击遮罩层和关闭图标关闭 */
	oClose.onclick = mask.onclick = removeTest;
	/* 点击注册和登录 */
	$(".log_text").click(function() {
		$(this).addClass("selected_log");
		$(this).removeClass("not_selected_log");
		$("input").val("");
		$(".log_alert_div").html("");
		$(".log_text").not($(this)).removeClass("selected_log");
		$(".log_text").not($(this)).addClass("not_selected_log");
		if ($(this).text() == "登录") {
			// 显示登录，隐藏提示，隐藏注册
			$("#login_div").css("display", "block");
			$("#register_div").css("display", "none");
			$("#check_email_text").css("display", "none");
		} else {
			// 显示注册，隐藏提示，隐藏登录
			$("#login_div").css("display", "none");
			$("#register_div").css("display", "block");
			$("#check_email_text").css("display", "none");

		}
	});
}

/*-------------验证-------------------*/
/* 验证邮箱 */
var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
function checkEmailLogin() {
	var login_email = $("#login_email").val();// 登录 邮箱
	// 登录
	if (filter.test(login_email)) {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	} else {
		$(".log_alert_div").html("您的邮箱格式不正确！");
		$(".log_alert_div").css("display", "block");
		return false;
	}
}
function checkEmailRegister() {
	var register_email = $("#register_email").val();// 注册邮箱
	// 注册
	if (filter.test(register_email)) {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	} else {
		$(".log_alert_div").html("您的邮箱格式不正确！");
		$(".log_alert_div").css("display", "block");
		return false;
	}
}
/* 验证密码 */
function checkPasswordLogin() {
	var login_password = $("#login_password").val();// 登录密码
	// 登录
	if (login_password.length < 6 || login_password.length > 15) {
		$(".log_alert_div").html("请输入6~15位的密码！");
		$(".log_alert_div").css("display", "block");
		return false;
	} else {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	}

}
function checkPasswordRegister() {
	var register_password = $("#register_password").val();// 注册密码
	// 注册
	if (register_password.length < 6 || register_password.length > 15) {
		$(".log_alert_div").html("请输入6~15位的密码！");
		$(".log_alert_div").css("display", "block");
		return false;
	} else {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	}
}

/* 确认密码 */
function checkRepassword() {
	var register_password = $("#register_password").val();// 密码
	var register_repassword = $("#register_repassword").val();// 确认密码
	if (register_password !== register_repassword) {
		$(".log_alert_div").html("两次密码不一致！");
		$(".log_alert_div").css("display", "block");
		return false;
	} else {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	}
}
/* 用户名 */
function checkUsername() {
	var register_username = $("#register_username").val();// 用户名
	if (register_username == "" || register_username == null) {
		$(".log_alert_div").html("您的用户名不能为空！");
		$(".log_alert_div").css("display", "block");
		return false;
	} else {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		return true;
	}
}
// 登录
function login() {
	var login_email = $("#login_email").val();// 邮箱
	var login_password = $("#login_password").val();// 密码
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (filter.test(login_email)) {
		/* 邮箱正确 */
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		if (login_password.length < 6 || login_password.length > 15) {
			/* 密码错误 */
			$(".log_alert_div").html("请输入6~15位的密码！");
			$(".log_alert_div").css("display", "block");
			return false;
		} else {
			/* 密码正确 */
			$(".log_alert_div").html("");
			$(".log_alert_div").css("display", "none");
			/* 和后台交互 */
			var formData = new FormData();
			formData.append("accpet_user.user_mail", login_email);
			formData.append("accpet_user.user_password", login_password);
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "/wlmtxt/User/User_loign");
			xhr.send(formData);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == "1") {
						/* 登录成功 */
						// 移除登录框
						removeTest();
						// 跳转至首页
						/*
						 * window.location.href =
						 * "/wlmtxt/view/index/index.jsp";
						 */
						// 执行登录成功操作
						checkLogin();
					} else {
						/* 登录失败 */
						$(".log_alert_div").html("邮箱或密码错误！");
						$(".log_alert_div").css("display", "block");
						return false;
					}
				}

			}
		}
	} else {
		/* 邮箱 */
		$(".log_alert_div").html("您的邮箱格式不正确！");
		$(".log_alert_div").css("display", "block");
		return false;
	}
}
/* 注册 */
function register() {
	var register_username = $("#register_username").val();// 用户名
	var register_email = $("#register_email").val();// 邮箱
	var register_password = $("#register_password").val();// 密码
	var register_repassword = $("#register_repassword").val();// 确认密码
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var formData = new FormData();
	formData.append("accpet_user.user_username", register_username);
	formData.append("accpet_user.user_mail", register_email);
	formData.append("accpet_user.user_password", register_password);
	if (register_username == "" || register_username == null) {
		// 用户名正确
		$(".log_alert_div").html("请输入用户名！");
		$(".log_alert_div").css("display", "block");
		return false;
	} else {
		$(".log_alert_div").html("");
		$(".log_alert_div").css("display", "none");
		if (filter.test(register_email)) {
			/* 邮箱正确 */
			$(".log_alert_div").html("");
			$(".log_alert_div").css("display", "none");
			// 验证邮箱是否被注册
			var xhr0 = new XMLHttpRequest();
			xhr0.open("POST", "/wlmtxt/User/User_mailRegisted");
			xhr0.send(formData);
			xhr0.onreadystatechange = function() {
				if (xhr0.readyState == 4 && xhr0.status == 200) {
					if (xhr0.responseText == "1") {
						/* 发送成功 */
						$(".log_alert_div").html("");
						$(".log_alert_div").css("display", "none");
						if (register_password.length < 6
								|| register_password.length > 15) {
							/* 密码错误 */
							$(".log_alert_div").html("请输入6~15位的密码！");
							$(".log_alert_div").css("display", "block");
							return false;
						} else {
							/* 密码正确 */
							$(".log_alert_div").html("");
							$(".log_alert_div").css("display", "none");

							if (register_password !== register_repassword) {
								// 确认密码错误
								$(".log_alert_div").html("两次密码不一致！");
								$(".log_alert_div").css("display", "block");
								return false;
							} else {
								// 确认密码正确
								$(".log_alert_div").html("");
								$(".log_alert_div").css("display", "none");
								/* 和后台交互 */
								var xhr = new XMLHttpRequest();
								xhr.open("POST",
										"/wlmtxt/User/User_sendRegisterMail");// 发送验证邮件
								xhr.send(formData);
								xhr.onreadystatechange = function() {
									if (xhr.readyState == 4
											&& xhr.status == 200) {
										if (xhr.responseText == "1") {
											/* 发送成功 */
											alert("发送成功！");
											$("#register_div").css("display",
													"none");
											$("#check_email_text").css(
													"display", "block");
											$("#login_and_register").click(
													function() {
														removeTest();
													});
										} else {
											/* 发送失败 */
											alert("发送失败！");
											return false;
										}
									}

								}
							}
						}
					} else {
						/* 发送失败 */
						$(".log_alert_div").html("该邮箱已注册！");
						$(".log_alert_div").css("display", "block");
						return false;
					}
				}
			}
		} else {
			/* 邮箱错误 */
			$(".log_alert_div").html("您的邮箱格式不正确！");
			$(".log_alert_div").css("display", "block");
			return false;
		}
	}

}
