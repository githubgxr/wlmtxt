//选择作品样式修饰 
	$(".inputfile").each( function(){ 
		var $input = $(this), 
		$label = $input.next('label'), 
		labelVal = $label.html(); 
		$input.on( 'change', function(e){ 
			var fileName = ''; 
			if( this.files && this.files.length > 1 ) 
				fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' )
				.replace( '{count}', this.files.length ); 
			else if(e.target.value)
				fileName = e.target.value.split( '\\' ).pop(); 
			if( fileName ) 
				$label.html( fileName ); 
			else 
				$label.html( labelVal ); 
			}); 
		});


//上传图片预览 
		/*上传图片的JS*/
		function img_click() {
			document.getElementById("img").click();
		}
		function img_change(file) {
			var imgfile = document.getElementById("imgfile");
			var reader = new FileReader();
			reader.onload = function(evt) {
				var img = document.getElementById("img");
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		}
// 关键字 
$(".btn_keyword").click(
				function() {
					if($(".div_keyword").length>4){
						toastr.error("关键字数量已达上限！");
						$(".input_keyword").val("");
						return false;
						
					}
					var input_keyword_value = $(".input_keyword").val();
					if (input_keyword_value != ""
							&& input_keyword_value != null) {
						$(".div_box").css("display", "block");

						var str = '<div class="div_keyword">'
								+ input_keyword_value + '<img class="keyword_delete" src="/wlmtxt/img/keyword_delete.png" style="width:8px;margin:0 0 0 10px;" onclick="keywordDelete(this)"/></div>';
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
								toastr.error("请不要输入相同的关键字");
								$(".input_keyword").val("");
								return;
							}
						}
						
						$(".input_keyword").val("");
					} else {
						toastr.error("请输入关键字");
					}
				});
function keywordDelete(img){
	img.parentNode.parentNode.removeChild(img.parentNode);
	$(".div_box").css("display","none");
}
/*$(".keyword_delete").click(function(){
	alert($(this));
	$(this).parent().remove();
})*/
//关键字获取enter监听
$("#input_keyword").bind("keydown",function(e){
        // 兼容FF和IE和Opera    
    var theEvent = e || window.event;    
    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;    
    if (code == 13) {    
        //回车执行查询
            $("#btn_keyword").click();
        }    
});

/*得到二级分类的name*/
$(function() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var caterory = JSON.parse(xhr.responseText);
				for ( var num in caterory) {
					var option = document.createElement("option");
					option.appendChild(document
							.createTextNode(caterory[num].second_menu_name));
					var select = document
							.getElementById("works_classificationOne");
					select.appendChild(option);
					option.value = caterory[num].second_menu_id;

				}
			}
		}
	}
	xhr.open("POST", "/wlmtxt/Works/Works_listSecondMenu");
	xhr.send(null);
})

/*$(function() {
	$(".input_xzt").blur(function() {
		var input_value = $(".input_xzt").val();
		if (input_value == "" || input_value == null) {
			toastr.error("请输入视频标题");
		}
	})
	$("textarea").blur(function() {
		var textarea_value = $("textarea").val();
		if (textarea_value == "" || textarea_value == null) {
			toastr.error("请输入作品描述");
		}
	})
	$(".input_keyword").blur(function() {
		var input_keyword_value = $(".input_keyword").val();
		if (input_keyword_value == "" || input_keyword_value == null) {
			toastr.error("请输入关键字");
		}
	})
})*/

function uploadWorks() {
	var input_title = $("#input_title").val();// 视频标题
	var works_describe = $("#works_describe").val();// 作品描述
	var div_keyword = $(".div_keyword");// 关键字数组
	var keyword = "";
	for (i = 0; i < div_keyword.length; i++) {
		keyword = keyword + div_keyword[i].innerHTML + ";";
	}
	var imgfile = document.getElementById("imgfile").files[0];// 图片封面
	var worksfile = document.getElementById("worksfile").files[0];// 视频选择
	if(input_title==""||input_title==null){
		toastr.error("请输入视频标题！");
		return false;
	}else if(works_describe==""||works_describe==null){
		toastr.error("请输入视频描述！");
		return false;
	}else if(div_keyword.length==0){
		toastr.error("请输入关键字！");
		return false;
	}else if (imgfile == undefined) {
		toastr.error("请选择封面！");
		return;
	}else if (worksfile == undefined) {
		toastr.error("请选择视频");
		return false;
	}else{
		var xmlhttp = false;
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var result = xmlhttp.responseText;
					if (result == "1") {
						toastr.success("作品发布成功");
						window.location = '/wlmtxt/view/personal_center/personal_center_my_dynamic.jsp';
					} else {
						toastr.error("作品发布失败");
					}
				}

			}
		}
		var formData = new FormData();
		xmlhttp.open("POST", "/wlmtxt/Works/Works_uploadWorks", true);
		formData.append("accept_works.works_title", input_title);
		formData.append("accept_works.works_reason", works_describe);
		formData.append("keyword", keyword);
		formData.append("imgfile", imgfile);
		formData.append("worksfile", worksfile);
		xmlhttp.send(formData);
	}
	
}
