/**
 * 
 */
var xmlhttp;
window.onload=function(){
	$("input").blur(function(){
		var input_value=$("input").val();
		if(input_value=="" || input_value==null){
			toastr.error("请输入内容");
		}
	})
	$("textarea").blur(function(){
		var textarea_value=$("textarea").val();
		if(textarea_value=="" || textarea_value==null){
			toastr.error("请输入内容");
		}
	})
	$(".input_keyword").blur(function(){
		var input_keyword_value=$(".input_keyword").val();
		if(input_keyword_value=="" || input_keyword_value==null){
			toastr.error("请输入内容");
		}
	})
}
function uploadWorks(){
	console.log(111);
	var works_classificationTwo=$("#works_classificationTwo").val();
	var input_title=$("#input_title").val();
	var works_describe=$("#works_describe").val();
	var div_keyword=$(".div_keyword").text();
	/* var upload_img = $("#upload_img").get(0).files[0];
	 var upload_works = $("#upload_works").get(0).files[0];*/
	
	XMLHttp();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			/*var result=xmlhttp.responseText;
			if(result=="1"){
				toastr.error("作品发布成功");
			}else{
				toastr.error("作品发布失败");
			}*/
			
		}
	}
	var formData=new FormData();
	xmlhttp.open("POST","",true);
	formData.append("",works_classificationTwo);
	formData.append("",input_title);
	formData.append("",works_describe);
	formData.append("",div_keyword);
	xmlhttp.send(formData);
}

function XMLHttp(){
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
}