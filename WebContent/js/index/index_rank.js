$(function(){
	listRankByPage();
});
function listRankByPage(){
	//日榜
	var xhr_day=new XMLHttpRequest();
	var formData_day=new FormData();
	xhr_day.open("POST","/wlmtxt/Works/Works_listWorks10OrderHotByDay");
	xhr_day.send(null);
	xhr_day.onreadystatechange=function(){
		if(xhr_day.readyState==4 && xhr_day.status==200){
			var day_rank_response=JSON.parse(xhr_day.responseText);
			for(var i=0;i<5;i++){
				var day_rank_str='<li class="list_video_item">';
				/*---视频链接---*/
				 day_rank_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+llls_response[i].worksDTO.works.works_id+'">';
				 day_rank_str+='<div class="video_cover">';
				 day_rank_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +llls_response[i].worksDTO.works.works_cover +'"/>';
				 day_rank_str+='<div class="video_overplay"></div>';
				 day_rank_str+='<div class="video_play"></div>';
				 day_rank_str+='</div>';
				 /*视频信息*/
				 day_rank_str+='<div class="video_info">';
				 /*标题*/
				 day_rank_str+='<div class="video_title">'+llls_response[i].worksDTO.works.works_title+'</div>';
				 /*浏览量*/
				 day_rank_str+='<div class="video_number">'+llls_response[i].worksDTO.playNum+'</div>';
				 /*用户*/
				 day_rank_str+='<div class="video_username">'+llls_response[i].worksDTO.user.user_username+'</div>';
				 day_rank_str+='</div>';
				 day_rank_str+='</a>';
				 
				 /*---视频分类---*/
				 day_rank_str+='<div class="video_label">';
				 day_rank_str+='<div id="video_label_content" class="video_label_content">';
			/*	 day_rank_str+='<a class="video_label_item">绝地求生</a>';
				 day_rank_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
				
				 for(var num=0;num<llls_response[i].worksDTO.keyWordDTOList.length;num++){
					 day_rank_str+='<a class="video_label_item">'+llls_response[i].worksDTO.keyWordDTOList[num].keyword.keyword_name+'</a>';
				 }
				 day_rank_str+='</div>';
				 day_rank_str+='</div>';
				 day_rank_str+='</li>';
				$("#day_rank").append(day_rank_str);
			}
		}
	}
}