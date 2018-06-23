$(function (){
	var list_video_item = document.getElementsByClassName("list_video_item");
	var long = list_video_item.length;
	for (var num = 0; num < long; num++) {
		list_video_item[0].parentNode.removeChild(list_video_item[0]);
	}
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/wlmtxt/Works/Works_listMyLikeList");
	xhr.send(null);
	xhr.onreadystatechange=function(){
		var relation_like_response=JSON.parse(xhr.responseText);
		for(var i=0;i<relation_like_response.length;i++){
			var relation_like_str='<li class="list_video_item">';
			/*---视频链接---*/
			 relation_like_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+relation_like_response[i].worksDTO.works.works_id+'">';
			 relation_like_str+='<div class="video_cover">';
			 relation_like_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +relation_like_response[i].worksDTO.works.works_cover +'"/>';
			 relation_like_str+=' <div class="category_name">'+relation_like_response[i].worksDTO.secondMenu.second_menu_name+'</div>';
			 relation_like_str+='<div class="video_overplay"></div>';
			 relation_like_str+='<div class="video_play"></div>';
			 relation_like_str+='</div>';
			 /*视频信息*/
			 relation_like_str+='<div class="video_info">';
			 /*标题*/
			 relation_like_str+='<div class="video_title">'+relation_like_response[i].worksDTO.works.works_title+'</div>';
			 /*浏览量*/
			 relation_like_str+='<div class="video_number">'+relation_like_response[i].worksDTO.playNum+'</div>';
			 /*用户*/
			 relation_like_str+='<div class="video_username">'+relation_like_response[i].worksDTO.user.user_username+'</div>';
			 relation_like_str+='</div>';
			 relation_like_str+='</a>';
			 
			 /*---视频分类---*/
			 relation_like_str+='<div class="video_label">';
			 relation_like_str+='<div id="video_label_content" class="video_label_content">';
		/*	 relation_like_str+='<a class="video_label_item">绝地求生</a>';
			 relation_like_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
			
			 for(var num=0;num<relation_like_response[i].worksDTO.keyWordDTOList.length;num++){
				 relation_like_str+='<a class="video_label_item">'+relation_like_response[i].worksDTO.keyWordDTOList[num].keyword.keyword_name+'</a>';
			 }
			 relation_like_str+='</div>';
			 relation_like_str+='</div>';
			 relation_like_str+=' <div class="video_options">';
			 relation_like_str+='<a class="video_delete_btn">取消点赞</a>';
			 relation_like_str+='</div>';
			 relation_like_str+='</li>';
			$("#relation_appreciates_list_container").append(relation_like_str);
		}
	}
})