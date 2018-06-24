<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>

<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%><%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/Admin/login.css" />
<!--------------------------------------------------------------------------------->
<title>管理员入口</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">1

	-->

</head>

<body>
	<div class="logo">
		<div class="header">
			<%-- 			<img src="<%=basePath%>img/sadmin/logo.png"> --%>
			<h1>管理入口</h1>
		</div>
		<div class="content">
			<form action="" method="post">
				<div id="div_userName">
					<label class="label_userName">用户名：</label>
					<input type="text" class="userName" id="account"  / >
				</div>
				<div id="div_password">
					<label class="label_password">密&nbsp;&nbsp;&nbsp;码：</label>
					<input type="password" id="password" class="passWord"  />
				</div>
				<div class="clear"></div>
				<div id="login" class="logo-button" onclick="admin_login()">LOGIN</div>
			</form>
		</div>
	</div>
	


</body>
<script type="text/javascript"
	src="<%=basePath%>/js/Admin/admin_login.js"></script>
</html>
