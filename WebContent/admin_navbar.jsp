<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script type="text/javascript" src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!--------------------------------------------------------------------------------->
<%-- <link rel="stylesheet" href="<%=basePath%>css/flat/green.css" />
<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script> --%>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<%-- <link rel="stylesheet" href="<%=basePath%>css/snews/load.css" /> --%>
<%-- <script type="text/javascript" src="<%=basePath%>js/snews/load.js"></script> --%>
<!--------------------------------------------------------------------------------->
<%-- <link rel="stylesheet" href="<%=basePath%>css/slink/load.css" /> --%>
<%-- <script type="text/javascript" src="<%=basePath%>js/slink/load.js"></script> --%>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/Admin/load.css" />
<script type="text/javascript" src="<%=basePath%>js/Admin/load.js"></script>
<!--------------------------------------------------------------------------------->
<title>首页</title>
</head>
<body>
	<!--顶部-->
	<%-- <div
		style="background-color: white; height: 125px; width: 100%; z-index: 10; position: fixed; top: 0; left: 0;">
		<img src="<%=basePath%>img/logo.jpg" class="img-responsive logo">
	</div> --%>

	<div id="wrapper" style="position: fixed; top: 0; left: 0;">
		<!--左侧-->
		<div id="sidebar-nav" class="sidebar"
			style="margin: 0 0 0 0; position: fixed; top: 0; left: 0;">
			<div
				style="color: white; font-size: 25px; margin: 0 0 20px 0; text-align: center; padding: 0 50px 0 0;">
				管理员&nbsp;<s:property value="#session.adminLoginResult.admin_username"/>
			</div>
			<div class="sidebar-scroll">

				<ul class="nav">
					<li><s:if test="page=='skipToAdd'||page=='skipToDelete'">
							<a href="#scarousel" data-toggle="collapse" class="active">
						</s:if> <s:else>
							<a href="#scarousel" data-toggle="collapse" class="collapsed">
						</s:else> <i class="lnr lnr-picture"></i><span>轮播图管理</span><i
						class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
							test="page=='skipToAdd'||page=='skipToDelete'">
							<div id="scarousel" class="collapse in">
						</s:if> <s:else>
							<div id="scarousel" class="collapse ">
						</s:else>

						<ul class="nav">
							<li><s:if test="page=='skipToAdd'">
									<a href="<%=basePath%>Admin/Admin_add_carousel_page" class="active">添加轮播图</a>
								</s:if> <s:else>
									<a href="<%=basePath%>Admin/Admin_add_carousel_page">添加轮播图</a>
								</s:else></li>
							<li><s:if test="page=='skipToDelete'">
									<a href="<%=basePath%>Admin/Admin_list_carousel_page" class="active">轮播图列表</a>
								</s:if> <s:else>
									<a href="<%=basePath%>Admin/Admin_list_carousel_page">轮播图列表</a>
								</s:else></li>
						</ul>
			</div>
			</li>

			<!---------------------------------------------------------------------------------------------------------------------------------->
			
			<!---------------------------------------------------------------------------------------------------------------------------------->


			<li><s:if
					test="page=='page_create_news'||page=='page_list_category'||page=='page_create_category'||page=='page_list_news' ">
					<a href="#snews" data-toggle="collapse" class="active">
				</s:if> <s:else>
					<a href="#snews" data-toggle="collapse" class="collapsed">
				</s:else> <i class="lnr lnr-user"></i> <span>用户管理</span> <i
				class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
					test="page=='page_create_news'||page=='page_list_category'||page=='page_create_category'||page=='page_list_news'">
					<div id="snews" class="collapse in">
				</s:if> <s:else>
					<div id="snews" class="collapse">
				</s:else>


				<ul class="nav">
					<!--  -->
					<li><s:if test="page=='page_list_news'">
							<a
								href="<%=basePath%>Admin/Admin_list_works_page?page=page_list_news&page_list_news.pageIndex=1"
								class="active">作品管理</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>Admin/Admin_list_works_page?page=page_list_news&page_list_news.pageIndex=1"
								>作品管理</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_create_news'">
							<a
								href="<%=basePath%>Admin/Admin_list_user_page?page=page_create_news"
								class="active"> 信息管理</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>Admin/Admin_list_user_page?page=page_create_news">
								信息管理</a>
						</s:else></li>
					<!--  -->
					<li><s:if test="page=='page_create_news'">
							<a
								href="<%=basePath%>Admin/Admin_list_discuss_page?page=page_create_news"
								class="active"> 评价管理</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>Admin/Admin_list_discuss_page?page=page_create_news">
								评价管理</a>
						</s:else></li>
					<!--  -->
				</ul></li>


			<!---------------------------------------------------------------------------------------------------------------------------------->
			<li><s:if
					test="page=='page_create_admin'||page=='page_list_admin' ">
					<a href="#sadmin" data-toggle="collapse" class="active">
				</s:if> <s:else>
					<a href="#sadmin" data-toggle="collapse" class="collapsed">
				</s:else> <i class="lnr lnr lnr-users"></i><span>管理员管理</span> <i
				class="icon-submenu lnr lnr-chevron-left"></i></a> <s:if
					test="page=='page_create_admin'||page=='page_list_admin'">
					<div id="sadmin" class="collapse in">
				</s:if> <s:else>
					<div id="sadmin" class="collapse">
				</s:else>
				<ul class="nav">
					<!--  -->
					<%-- <li><s:if test="page=='page_create_admin'">
							<a
								href="<%=basePath%>Admin/Admin_add_admin_page?page=page_create_admin"
								class="active"> 添加管理员</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>Admin/Admin_add_admin_page?page=page_create_admin">
								添加管理员</a>
						</s:else></li> --%>
					<!--  -->
					<li><s:if test="page=='page_list_admin'">
							<a
								href="<%=basePath%>Admin/Admin_list_admin_page?page=page_list_admin&page_list_admin.pageIndex=1"
								class="active">管理员列表</a>
						</s:if> <s:else>
							<a
								href="<%=basePath%>Admin/Admin_list_admin_page?page=page_list_admin&page_list_admin.pageIndex=1">
								管理员列表</a>
						</s:else></li>
					<!--  -->
				</ul>
		</div>
		</li>
		
		<!---------------------------------------------------------------------------------------------------------------------------------->
		
		<li><a
				href="<%=basePath%>Admin/Admin_count_page"><i
					class="lnr lnr lnr-chart-bars"></i><span>统计</span></a></li>
					
		<!---------------------------------------------------------------------------------------------------------------------------------->
					
		<li><a
				href="<%=basePath%>Admin/Admin_page_list_category"><i
					class="lnr lnr lnr-chart-bars"></i><span>分类管理</span></a></li>
		
		<!---------------------------------------------------------------------------------------------------------------------------------->			
					
		<li><a
				href="<%=basePath%>Admin/Admin_count_page"><i
					class="lnr lnr lnr-chart-bars"></i><span>关键词管理</span></a></li>
		
		<!---------------------------------------------------------------------------------------------------------------------------------->
		
		<%-- <s:if test="#session.Admin.admin_account!=null"> --%>
			<li><a
				href="<%=basePath%>Admin/Admin_modified_adminPassword_page"><i
					class="lnr lnr lnr-highlight"></i><span>修改个人密码</span></a></li>
		<%-- </s:if> --%>

		<!---------------------------------------------------------------------------------------------------------------------------------->
		<li><a href="<%=basePath%>Admin/Admin_logout"><i
				class="lnr lnr-exit"></i><span>退出系统</span></a></li>
		</ul>
	</div>
	</div>
	</div>
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<div id="div_load"></div>
	<div id="cloth"></div>
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
	<!--------------------------------------------------------------------------------------------->
</body>

</html>