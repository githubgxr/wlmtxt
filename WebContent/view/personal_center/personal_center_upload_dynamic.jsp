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
<link rel="stylesheet" href="<%=basePath%>css/wlmtxt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt.css" />
<link rel="stylesheet" href="<%=basePath%>css/xzt/grzx_fbsp.css" />
<!--------------------------------------------------------------------------------->
<title>发布作品</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body onload="init()">
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
							<span>作品分类：</span> <select class="works_classificationOne"
								id="works_classificationOne"
								onchange="works_classificationTwo()">
								<option value="" id="selected">---请选择---</option>
								<option value=1>电影</option>
								<option value=2>电视剧</option>
								<option value=3>综艺</option>
								<option value=4>动画</option>
								<option value=5>短片</option>
							</select> <select id="works_classificationTwo">
							</select>
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
								<input class="form-control input_xzt input_keyword" type="text"
									placeholder="请输入关键字" style="width: 520px;" />
								<button type="submit" class="btn_keyword">确认</button>
								<div class="form-control input_xzt div_box"
									style="padding-top: 10px; border: 0px; display: none;"></div>
							</div>
						</div>

						<div class="img_wrap_list img_cover">
							<span>选择封面：</span>
							<div class="imgnum">
								<input type="file" class="filepath" id="imgfile" onchange="img_change(this)" />
								<img class="img" id="img" src="<%=basePath%>img/upload_video.png" onclick="img_click()" /> <img
									src="" class="img2" />
							</div>
						</div>


						<div class="img_wrap_list">
							<span>选择作品：</span>
							<div class="imgnum">
								<input type="file" class="filepath" id="worksfile" onchange="img_change(this)"	/>
								<img class="img" id="img" src="<%=basePath%>img/upload_video.png" onclick="img_click()" /> <img
									src="" class="img2" />
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
	<script type="text/javascript">
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
	</script>
	<script type="text/javascript">
		$(".btn_keyword").click(
				function() {
					var input_keyword_value = $(".input_keyword").val();
					if (input_keyword_value != ""
							&& input_keyword_value != null) {
						$(".div_box").css("display", "block");
						
						var str = '<div class="div_keyword">'+ input_keyword_value + '</div>';
						if ($(".div_box").html() == "") {
							$(".div_box").append(str);
						} else {
							var div_keyword = $(".div_keyword");
							var array = []
							$.each(div_keyword, function(i) {
								array.push($(div_keyword[i]).text())
							})
							if (($.inArray(input_keyword_value, array)) < 0) {
								$(".div_box").append(str)
							} else {
								alert("请不要输入相同的关键字");
								$(".input_keyword").val("");
								return;
							}
						}
						$(".input_keyword").val("");
					} else {
						alert("请输入关键字");
					}
				});
	</script>
	<script type="text/javascript">
		/*上传图片的JS*/
		function img_click() {
			document.getElementById("img").click();
		}
		function img_change(file) {
			var worksfile = document.getElementById("worksfile");
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		}
	</script>


	<!-- <script type="text/javascript">
		$(function() {
			$(".filepath").on("change", function() {
				var srcs = getObjectURL(this.files[0]); //获取路径
				$(this).nextAll(".img1").hide(); //this指的是input
				$(this).nextAll(".img2").show(); //fireBUg查看第二次换图片不起做用
				$(this).nextAll('.close').show(); //this指的是input
				$(this).nextAll(".img2").attr("src", srcs); //this指的是input
				$(this).val(''); //必须制空
			})
		})

		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file)
			} else if (window.URL != undefined) {
				url = window.URL.createObjectURL(file)
			} else if (window.webkitURL != undefined) {
				url = window.webkitURL.createObjectURL(file)
			}
			return url
		};

		$(function() {
			$("#img")
					.on(
							"change",
							".filepath1",
							function() {
								var srcs = getObjectURL(this.files[0]); //获取路径
								//this指的是input
								$(this).nextAll(".img22").attr("src", srcs); //this指的是input
								$(this).nextAll(".img22").show(); //fireBUg查看第二次换图片不起做用*/
								var htmlImg = '<div class="imgbox1">'
										+ '<div class="imgnum1">'
										+ '<input type="file" class="filepath1" />'
										+ '<span class="close1">X</span>'
										+ '<img src="btn.png" class="img11" />'
										+ '<img src="'+srcs+'" class="img22" />'
										+ '</div>' + '</div>';

								$(this).parent().parent().before(htmlImg);
								$(this).val(''); //必须制空
								$(this).parent().parent().prev().find(".img11")
										.hide(); //this指的是input
								$(this).parent().parent().prev()
										.find('.close1').show();

							})
		})
	</script> -->
</body>

<script type="text/javascript"
	src="<%=basePath%>/js/personal_center/personal_center_upload_dynamic.js">
	
</script>

</html>