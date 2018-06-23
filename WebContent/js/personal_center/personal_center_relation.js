function personal_center_relation(personal_center_relation_type){
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/wlmtxt/Works/Works_"+personal_center_relation_type);
	xhr.send(null);
	xhr.onreadystatechange=function(){
		var relation_response=JSON.parse(xhr_day.responseText);
		for(var i=0;i<relation_response.length;i++){
			var relation_str='<li class="list_video_item">';
			/*---视频链接---*/
			 relation_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+relation_response[i].works.works_id+'">';
			 relation_str+='<div class="video_cover">';
			 relation_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +relation_response[i].works.works_cover +'"/>';
			 relation_str+='<div class="video_overplay"></div>';
			 relation_str+='<div class="video_play"></div>';
			 relation_str+='</div>';
			 /*视频信息*/
			 relation_str+='<div class="video_info">';
			 /*标题*/
			 relation_str+='<div class="video_title">'+relation_response[i].works.works_title+'</div>';
			 /*浏览量*/
			 relation_str+='<div class="video_hot">'+relation_response[i].playNum+'</div>';
			 /*用户*/
			 relation_str+='<div class="video_username">'+relation_response[i].user.user_username+'</div>';
			 relation_str+='</div>';
			 relation_str+='</a>';
			 
			 /*---视频分类---*/
			 relation_str+='<div class="video_label">';
			 relation_str+='<div id="video_label_content" class="video_label_content">';
		/*	 relation_str+='<a class="video_label_item">绝地求生</a>';
			 relation_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
			
			 for(var num=0;num<relation_response[i].keyWordDTOList.length;num++){
				 relation_str+='<a class="video_label_item">'+relation_response[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
			 }
			 relation_str+='</div>';
			 relation_str+='</div>';
			 relation_str+='</li>';
			$("#day_rank").append(relation_str);
		}
	}
}