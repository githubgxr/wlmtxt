$(function(){
	listMyDynamicByPage(1);
});
function listMyDynamicByPage(pageIndex){
	var list_video_item = document.getElementsByClassName("list_video_item");
	var long = list_video_item.length;
	for (var num = 0; num < long; num++) {
		list_video_item[0].parentNode.removeChild(list_video_item[0]);
	}
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myWorksVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/Works/Works_getMyWorksListVO");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			
			var wddt_response=JSON.parse(xhr.responseText);
			if(wddt_response.worksDTOList.length>0){
				for(var i=0;i<wddt_response.worksDTOList.length;i++){
					
					var wddt_str='<li class="list_video_item">';
					/*---视频链接---*/
					 wddt_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+wddt_response.worksDTOList[i].works.works_id+'">';
					 wddt_str+='<div class="video_cover">';
					 wddt_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +wddt_response.worksDTOList[i].works.works_cover +'"/>';
					 wddt_str+=' <div class="category_name">';
					 wddt_str+=wddt_response.worksDTOList[i].secondMenu.second_menu_name;
					 wddt_str+='</div>';
					 wddt_str+='<div class="video_overplay"></div>';
					 wddt_str+='<div class="video_play"></div>';
					 wddt_str+='</div>';
					 /*视频信息*/
					 wddt_str+='<div class="video_info">';
					 /*标题*/
					 wddt_str+='<div class="video_title">'+wddt_response.worksDTOList[i].works.works_title+'</div>';
					 /*浏览量*/
					 wddt_str+='<div class="video_number">'+wddt_response.worksDTOList[i].playNum+'</div>';
					 /*时间*/
					 wddt_str+='<div class="video_time">'+wddt_response.worksDTOList[i].works.works_gmt_create+'</div>';
					 wddt_str+='</div>';
					 wddt_str+='</a>';
					 
					 /*---视频分类---*/
					 wddt_str+='<div class="video_label">';
					 wddt_str+='<div id="video_label_content" class="video_label_content">';
				/*	 wddt_str+='<a class="video_label_item">绝地求生</a>';
					 wddt_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
					
					 for(var num=0;num<wddt_response.worksDTOList[i].keyWordDTOList.length;num++){
						 wddt_str+='<a class="video_label_item">'+wddt_response.worksDTOList[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
					 }
					 wddt_str+='</div>';
					 wddt_str+='</div>';
					 /*---删除---*/
					 wddt_str+='<div class="video_options">';
					 wddt_str+='<a class="video_delete_btn" onclick="deleteWork(this.id)" id="'+wddt_response.worksDTOList[i].works.works_id+'">删除</a>';
					 wddt_str+='</div>';
					 wddt_str+='</li>';
					$("#wddt_list_container").append(wddt_str);
					
				}
			}else{
				$("#wddt_list_container").html('<img src="/wlmtxt/img/no_message_bg.png" style="width:250px;height:250px;margin:30px 240px 0px 240px;float:left;"/><div style="color:#99a2aa;font-size：16px;text-align:center;margin:0 0 50px 0;">还没有我的动态哦，快去发布作品吧！</div>');
			}
		
		}
	}
}
//删除单个作品
function deleteWork(video_delete_btn_id){
	console.log("video_delete_btn_id:"+video_delete_btn_id);
	var video_delete_formData=new FormData();
	video_delete_formData.append("accept_works.works_id",video_delete_btn_id);
	var xhr_delete=new XMLHttpRequest();
	xhr_delete.open("POST","/wlmtxt/Works/Works_deleteMyWorks");
	xhr_delete.send(video_delete_formData);
	xhr_delete.onreadystatechange=function(){
		if(xhr_delete.readyState==4&&xhr_delete.status==200){
			if(xhr_delete.responseText=="1"){
				toastr.success("删除成功！");
				listMyDynamicByPage(1);
			}else{
				toastr.error("删除失败！");
				return false;
			}
		}
	}
}
//删除全部作品
	function deleteAllMyWork(){
		var xhr_delete_all=new XMLHttpRequest();
		xhr_delete_all.open("POST","/wlmtxt/Works/Works_deleteAllMyWorks");
		xhr_delete_all.send(null);
		xhr_delete_all.onreadystatechange=function(){
			if(xhr_delete_all.readyState==4&&xhr_delete_all.status==200){
				if(xhr_delete_all.responseText=="1"){
					toastr.success("清除全部成功！");
					listMyDynamicByPage(1);
				}else{
					toastr.error("清除全部失败！");
					return false;
				}
			}
		}
	}
	
