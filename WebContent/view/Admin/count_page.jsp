<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>统计</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#table_total tbody tr {
	text-align: center;
}

#page_flip span a:hover, #select_start_time, #select_stop_time {
	cursor: pointer;
}
</style>
</head>

<body>
<jsp:include page="/admin_navbar.jsp" flush="true"></jsp:include>

	<div style="margin: 50px 0 0 260px; width: calc(100% - 260px);">
	<div  style="width: 95%; margin: 20px auto;">
			<div style="height: 34px; width: 100%;">
				<div>
					<span style="float: left; margin: 0 0 0 20px; line-height: 34px;">按日期筛选：</span>
					<input id="select_start_time"
						class="form-control mydate input_date"
						style="width: 150px; float: left; text-align: center;" type="text"
						placeholder="起始时间" value="2018-01-01" />
					<%--  --%>
					<span style="float: left; margin: 0 0 0 20px; line-height: 34px;">至</span>
					<!--  -->
					<input id="select_stop_time" class="form-control mydate input_date"
						style="width: 150px; float: left; margin: 0 0 0 20px; text-align: center;"
						type="text" placeholder="结束时间" />
					<%--  --%>
				</div>
			</div>
			<table id="table_total" class="table table-hover COUNT"
								style="text-align: center; margin: 20px 0;">
								<thead>
									<tr>
										<th>序号</th>
										<th>菜单</th>
										<th>播放量</th>
										<th>上传量</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>

					<!-- END TABLE HOVER -->
			
			
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/Input_Select.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/laydate/laydate.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Admin/count_page.js"></script>
	<script type="text/javascript">
		var select_start_time = document.getElementById("select_start_time");
		var select_stop_time = document.getElementById("select_stop_time");
		var str = '';
		var now_date = new Date();
		var now_date_year = now_date.getFullYear();
		str += now_date_year;
		var now_date_month = now_date.getMonth() + 1;
		str += "-" + now_date_month;
		var now_date_date = now_date.getDate();
		str += "-" + now_date_date;
		/* select_start_time.value=str; */
		select_stop_time.value = str;
		console.log(str);
		//var sumCase=document.getElementById("sumCase").value;
		List_Total_By_Department();
		$(".input_date").bind("change", function() {
			List_Total_By_Department();
		});
	</script>

	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.mydate').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.mydate_minute').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d H:i', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
	</script>
</body>
</html>