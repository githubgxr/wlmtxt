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
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_fbsp.css" />
<!--------------------------------------------------------------------------------->
<title>发布作品</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<div class="wlmtxt_main">
		<jsp:include page="/navbar.jsp" flush="true"></jsp:include>
		<div class="wlmtxt_container ">
			<!--发布视频-->
			<div id="fbsp_main" class="main_container">
				<!--浏览历史头部-->
				<div class="fbsp_header list_header">
					<i class="header_line"></i>
					<h3 style="margin: 0px; padding: 0px;">发布作品</h3>
				</div>
				<!--主体部分-->
				<div class="fbsp_content list_container">
					<div class="img_wrap">
						<div class="img_wrap_list">
							<span>作品分类：</span>
							 <select class="works_classificationOne" id="works_classificationOne">
							</select> 
							<!-- <select id="works_classificationTwo"></select> -->
						</div>
						<div class="img_wrap_list">
							<span>视频标题：</span> <input class="form-control input_xzt"
								id="input_title" type="text" placeholder="请输入标题" />
						</div>
						<div class="img_wrap_list">
							<span>作品描述：</span>
							<textarea class="form-control textarea_xzt" id="works_describe"
								placeholder="请输入作品描述" /></textarea>
						</div>
						<div class="img_wrap_list">
							<span>关键字：</span>
							<div class="upload_selected">
								<input class="form-control input_xzt input_keyword" type="text" id="input_keyword"
									placeholder="请输入关键字（按回车结束）" style="width: 550px;" />
								<button type="submit" id="btn_keyword" class="btn_keyword" style="display:none;">确认</button>
								<div class="input_xzt div_box"
									style="margin-top: 10px; border: 0px; display: none;height:40px;"></div>
							</div>
						</div>

						<div class="img_wrap_list img_cover">
							<span>选择封面：</span>
							<div class="imgnum">
								<input type="file" class="filepath" id="imgfile"
									onchange="img_change(this)" /> <img class="img" id="img"
									src="<%=basePath%>img/upload_video.png" onclick="img_click()" />
							</div>
						</div>


						<div class="img_wrap_list">
							<span>选择作品：</span>
							<div class="imgnum">

								<input type="file" id="worksfile" class="inputfile"
								/> 
								<label for="file">Choose a file</label>

							</div>
						</div>
						
						
						<div class=" img_wrap_list">
							<a class="button_a" onclick="uploadWorks()">确认发布</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
	
	<!-- 二级联动 -->
	<!-- <script type="text/javascript">
		var arr = new Array();
		arr[0] = "---请选择---"
		arr[1] = "科幻电影,恐怖电影,剧情电影,喜剧电影,电影短片"
		arr[2] = "恐怖电视剧,剧情电视剧,喜剧电视剧,电影电视剧,科幻电视剧"
		arr[3] = "剧情综艺,喜剧综艺,电影综艺,科幻综艺,恐怖综艺"
		arr[4] = "喜剧动画,电影动画,科幻动画,恐怖动画,剧情动画"
		arr[5] = "电影短片,科幻短片,恐怖短片,剧情短片,喜剧短片"

		function init() {
			var works_classificationTwo = document
					.getElementById("works_classificationTwo");
			var works_classificationTwoArr = arr[0].split(",");
			for (var i = 0; i < works_classificationTwoArr.length; i++) {
				works_classificationTwo[i] = new Option(
						works_classificationTwoArr[i],
						works_classificationTwoArr[i]);
			}
		}
		function works_classificationTwo() {
			$(".works_classificationOne")
					.click(
							function() {
								$("#works_classificationTwo").css("display",
										"block");
								if ($(
										'#works_classificationOne option:selected')
										.val() == "") {
									document
											.getElementById("works_classificationTwo").style.display = "none";
								}
							});
			var works_classificationOne = document
					.getElementById("works_classificationOne");
			var works_classificationTwo = document
					.getElementById("works_classificationTwo");
			var index = works_classificationOne.selectedIndex;
			var works_classificationTwoArr = arr[index].split(",");

			works_classificationTwo.length = 0;
			//将城市数组中的值填充到城市下拉框中
			for (var i = 0; i < works_classificationTwoArr.length; i++) {
				works_classificationTwo[i] = new Option(
						works_classificationTwoArr[i],
						works_classificationTwoArr[i]);
			}
		}
	</script> -->
	<script type="text/javascript"
	src="<%=basePath%>/js/personal_center/personal_center_upload_dynamic.js">
	
</script>
</body>


</html>