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
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_fbsp.css" />
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
							<span>作品分类：</span> <select class="works_classification">
								<option>电影</option>
								<option>电视剧</option>
								<option>综艺</option>
								<option>动画</option>
								<option>短片</option>
							</select>
						</div>
						<div class="img_wrap_list">
							<span>视频标题：</span> <input class="form-control input_xzt"
								type="text" placeholder="请输入标题" />
						</div>
						<div class="img_wrap_list">
							<span>作品描述：</span>
							<textarea class="form-control textarea_xzt" placeholder="请输入作品描述" /></textarea>
						</div>
						<div class="img_wrap_list">
							<span>关键字：</span>
							<div class="upload_selected">
								<input class="form-control input_xzt input_keyword" type="text"
									placeholder="请输入关键字" style="width: 520px;" />
								<button type="submit" class="btn_keyword">确认</button>
								<div class="form-control input_xzt div_box"
									style="padding-top:10px;border:0px;display:none;">
								</div>
							</div>
						</div>

						<div class="img_wrap_list">
							<span>选择封面：</span>
							<div class="imgnum">  
								<input type="file" class="filepath" id="imgfile"
								    	 />
								<img class="img1" src="<%=basePath%>img/upload_video.png" /> <img
									src="" class="img2" />
							</div>
						</div>
						<div class="img_wrap_list">
							<span>选择作品：</span>
							<div class="imgnum">
								<input type="file" class="filepath" id="worksfile"	/>
								
							</div>
						</div>
						<div class=" img_wrap_list">
							<a class="button_a">确认发布</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/foot.jsp" flush="true"></jsp:include>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".input_keyword").blur(function() {
				var input_keyword = $(".input_keyword").val();
				if (input_keyword != "" && input_keyword != null) {
					$(".btn_keyword").click(function() {
						$(".div_box").css("display","block");
						
						var div_keyword=document.createElement("div");
						$(".div_box").append(div_keyword);
						$(div_keyword).addClass("div_keyword");
						$(".div_keyword").css({float:"left",width:"120px",height:"30px","line-height":"30px","text-align":"center",
							"font-size":"13px",color:"#1dd388","border-radius":"100px","margin-right":"30px","background-color":"rgba(28, 211, 136, .3)"});
						
						
						$(".div_keyword").html(input_keyword);
					});
				} else {
					alert("请输入关键字");
				}
			})

		});
	</script>

</body>

</html>