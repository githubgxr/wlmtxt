
$(function(){
	listMyHistoryByPage();
});
function listMyHistoryByPage(){
	var list_video_item = document.getElementsByClassName("list_video_item");
	var long = list_video_item.length;
	for (var num = 0; num < long; num++) {
		list_video_item[0].parentNode.removeChild(list_video_item[0]);
	}
	var xhr=new XMLHttpRequest();

	/*var formData=new FormData();
	formData.append("myWorksVO.pageIndex",pageIndex);*/
	xhr.open("POST","/wlmtxt/Works/Works_listPlayHistoryListByUserID");
	xhr.send(null);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var llls_response=JSON.parse(xhr.responseText);
			if(llls_response.length>0){
				$("#history_delete_all").css("display", "block");
				for(var i=0;i<llls_response.length;i++){
					var llls_str='<li class="list_video_item">';
					/*---视频链接---*/
					 llls_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+llls_response[i].worksDTO.works.works_id+'">';
					 llls_str+='<div class="video_cover">';
					 llls_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +llls_response[i].worksDTO.works.works_cover +'"/>';
					 llls_str+=' <div class="category_name">'+llls_response[i].worksDTO.secondMenu.second_menu_name+'</div>';
					 llls_str+='<div class="video_overplay"></div>';
					 llls_str+='<div class="video_play"></div>';
					 llls_str+='</div>';
					 /*视频信息*/
					 llls_str+='<div class="video_info">';
					 /*标题*/
					 llls_str+='<div class="video_title">'+llls_response[i].worksDTO.works.works_title+'</div>';
					 /*浏览量*/
					 llls_str+='<div class="video_number">'+llls_response[i].worksDTO.playNum+'</div>';
					 /*用户*/
					 llls_str+='<div class="video_username">'+llls_response[i].worksDTO.user.user_username+'</div>';
					 llls_str+='</div>';
					 llls_str+='</a>';
					 
					 /*---视频分类---*/
					 llls_str+='<div class="video_label">';
					 llls_str+='<div id="video_label_content" class="video_label_content">';
				/*	 llls_str+='<a class="video_label_item">绝地求生</a>';
					 llls_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
					
					 for(var num=0;num<llls_response[i].worksDTO.keyWordDTOList.length;num++){
						 llls_str+='<a class="video_label_item">'+llls_response[i].worksDTO.keyWordDTOList[num].keyword.keyword_name+'</a>';
					 }
					 llls_str+='</div>';
					 llls_str+='</div>';
					 /*---删除---*/
					 llls_str+='<div class="video_options">';
					 llls_str+='<a class="video_delete_btn" onclick="deletePlayHistory(this.id)" id="'+llls_response[i].playHistory.play_history_id+'">删除</a>';
					 llls_str+='</div>';
					 llls_str+='</li>';
					$("#llls_list_container").append(llls_str);

					
				}
			}else{
				$("#history_delete_all").css("display", "none");
				$(".llls_content").append('<img src="/wlmtxt/img/no_message_bg.png" style="width:250px;height:250px;margin:30px 240px 0px 240px;float:left;"/><div style="color:#99a2aa;font-size：16px;text-align:center;margin:0 0 50px 0;">还没有观看历史哦，快去看视频吧！</div>');
			}
		
		}
	}
}
//删除单个作品

function deletePlayHistory(video_delete_btn_id){

	console.log("video_delete_btn_id:"+video_delete_btn_id);
	var video_delete_formData=new FormData();
	video_delete_formData.append("play_history.play_history_id",video_delete_btn_id);
	var xhr_delete=new XMLHttpRequest();
	xhr_delete.open("POST","/wlmtxt/Works/Works_deletePlayHistory");
	xhr_delete.send(video_delete_formData);
	xhr_delete.onreadystatechange=function(){
		if(xhr_delete.readyState==4&&xhr_delete.status==200){
			if(xhr_delete.responseText=="1"){
				toastr.success("删除成功！");
				listMyHistoryByPage(1);
			}else{
				toastr.error("删除失败！");
				return false;
			}
		}
	}
}
//删除全部作品
	function deleteAllMyHistory(){
		var xhr_delete_all=new XMLHttpRequest();
		xhr_delete_all.open("POST","/wlmtxt/Works/Works_deleteAllMyHistory");
		xhr_delete_all.send(null);
		xhr_delete_all.onreadystatechange=function(){
			if(xhr_delete_all.readyState==4&&xhr_delete_all.status==200){
				if(xhr_delete_all.responseText=="1"){
					toastr.success("清除全部成功！");
					listMyHistoryByPage(1);
				}else{
					toastr.error("清除全部失败！");
					return false;
				}
			}
		}
	}
	

