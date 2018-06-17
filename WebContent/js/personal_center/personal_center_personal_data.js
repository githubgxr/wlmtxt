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
