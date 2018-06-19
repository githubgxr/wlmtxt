<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
		<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
		<link rel="stylesheet" href="<%=basePath%>/css/grzx_nav.css" />
	</head>

	<body>
		<div id="sidebar_grzx">
			<div class="sidebar_user">
					<div class="sidebar_user_head">
						<!--用户头像-->
						<div class="user_img">
							<img class="img_user" src="<%=basePath%>img/user.jpg" />
						</div>
						<!--用户名-->
						<div class="user_name">熊熊熊</div>
						<div class="user_signature">
							你都在愤怒光和热uwnbtghwiognvbhorityunbgyhoitgmb
						</div>
					</div>
					<!--个性签名-->

					<!--关注量和粉丝量-->
					<div class="sidebar_user_foot">
						<div class="user_fans">关注<span>0</span></div>
						<div class="user_fans">粉丝<span>0</span></div>
					</div>
				</div>
			<div class="sidebar_head">
				
				<!--搜索-->
				<div class="sidebar_search">
					<input type="text" placeholder="搜索我的动态" />
					<img src="<%=basePath%>/img/search.png" />
				</div>
			</div>
			<div class="sidebar_nav">
				<ul>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp"><img src="<%=basePath%>/img/dt3.png" />我的动态</a>
					</li>
					<%-- <li>
						<a href="/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp"><img src="<%=basePath%>/img/scsp.png" />发布动态</a>
					</li> --%>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_personal_data.jsp"><img src="<%=basePath%>/img/grzl3.png" />个人资料</a>
					</li>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_my_attention.jsp"><img src="<%=basePath%>/img/wdgz1.png" />我的关注</a>
					</li>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_my_fans.jsp"><img src="<%=basePath%>/img/wdfs1.png" />我的粉丝</a>
					</li>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_watch_history.jsp"><img src="<%=basePath%>/img/llls1.png" />观看历史</a>
					</li>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_relation_collection.jsp"><img src="<%=basePath%>/img/ywxg1.png" />与我相关</a>
					</li>
					<li>
						<a href="/wlmtxt/view/personal_center/personal_center_appreciates_notice.jsp"><img src="<%=basePath%>/img/xxtz1.png" />消息中心</a>
					</li>
					<li>
						<a class="login_out" href="/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp"><img src="<%=basePath%>/img/tcdl3.png" />退出登录</a>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
		/*退出登录*/
		$(".login_out").click(function(){
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "/wlmtxt/User/User_logout");// 退出
			xhr.send(null);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if (xhr.responseText == "1") {
						console.log("退出成功！");
						window.location.href="/wlmtxt/User/User_logout";
					} else {
						console.log("退出失败！");
					}
				}
			}
		});

		</script>
	</body>

</html>