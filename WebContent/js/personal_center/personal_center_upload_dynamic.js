/*得到二级分类的name*/
$(function(){
	var xhr=false;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var caterory = JSON.parse(xhr.responseText);
			for ( var num in caterory) {
				var option = document.createElement("option");
				option.appendChild(document.createTextNode(caterory[num].second_menu_name));
				var select=document.getElementById("works_classificationOne");
				select.appendChild(option);
				option.value = caterory[num].second_menu_id;
				
			}
			$('#' + select.id).selectpicker('refresh');

		}
		toastr.error(xhr.status);
	}
	xhr.open("POST","/wlmtxt/Works/listSecondMenu");
	xhr.send(null);
})

$(function(){
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
})

function uploadWorks(){
	var input_title=$("#input_title").val();//视频标题
	var works_describe=$("#works_describe").val();//作品描述
	
	var div_keyword=$(".div_keyword");//关键字数组
	var keyword="";
	for(i=0;i<div_keyword.length;i++){
		keyword=keyword+div_keyword[i].innerHTML+";";
	}
	var imgfile=document.getElementById("imgfile").files[0];//图片封面
	var worksfile = document.getElementById("worksfile").files[0];//视频选择
	var xmlhttp=false;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			var result=xmlhttp.responseText;
			if(result=="1"){
				toastr.error("作品发布成功");
			}else{
				toastr.error("作品发布失败");
			}
			
		}
	}
	var formData=new FormData();
	xmlhttp.open("POST","/wlmtxt/Works/Works_uploadWorks",true);
	formData.append("accept_works.works_title",input_title);
	formData.append("accept_works.works_reason",works_describe);
	formData.append("keyword",keyword);
	formData.append("imgfile",imgfile);
	formData.append("worksfile",worksfile); 
	xmlhttp.send(formData);
}
