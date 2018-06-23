$(function(){
	listRankByPage();
});
function listRankByPage(){
	/*------------------日榜------------------*/
	var xhr_day=new XMLHttpRequest();
	xhr_day.open("POST","/wlmtxt/Works/Works_listWorks10OrderHotByDay");
	xhr_day.send(null);
	xhr_day.onreadystatechange=function(){
		if(xhr_day.readyState==4 && xhr_day.status==200){
			var day_rank_response=JSON.parse(xhr_day.responseText);
			var long_day="";
			if(day_rank_response.length>5){
				long_day=5;
			}else{
				long_day=day_rank_response.length;
			}
			for(var i=0;i<day_rank_response.length;i++){
				var day_rank_str='<li class="list_video_item">';
				/*---视频链接---*/
				 day_rank_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+day_rank_response[i].works.works_id+'">';
				 day_rank_str+='<div class="video_cover">';
				 day_rank_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +day_rank_response[i].works.works_cover +'"/>';
				 day_rank_str+='<div class="video_overplay"></div>';
				 day_rank_str+='<div class="video_play"></div>';
				 day_rank_str+='</div>';
				 /*视频信息*/
				 day_rank_str+='<div class="video_info">';
				 /*标题*/
				 day_rank_str+='<div class="video_title">'+day_rank_response[i].works.works_title+'</div>';
				 /*浏览量*/
				 day_rank_str+='<div class="video_number">'+day_rank_response[i].hot+'</div>';
				 /*用户*/
				 day_rank_str+='<div class="video_username">'+day_rank_response[i].user.user_username+'</div>';
				 day_rank_str+='</div>';
				 day_rank_str+='</a>';
				 
				 /*---视频分类---*/
				 day_rank_str+='<div class="video_label">';
				 day_rank_str+='<div id="video_label_content" class="video_label_content">';
			/*	 day_rank_str+='<a class="video_label_item">绝地求生</a>';
				 day_rank_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
				
				 for(var num=0;num<day_rank_response[i].keyWordDTOList.length;num++){
					 day_rank_str+='<a class="video_label_item">'+day_rank_response[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
				 }
				 day_rank_str+='</div>';
				 day_rank_str+='</div>';
				 day_rank_str+='</li>';
				$("#day_rank").append(day_rank_str);
			}
		}
	}
	/*------------------周榜------------------*/
	var xhr_week=new XMLHttpRequest();
	xhr_week.open("POST","/wlmtxt/Works/Works_listWorks10OrderHotByWeek");
	xhr_week.send(null);
	xhr_week.onreadystatechange=function(){
		if(xhr_week.readyState==4 && xhr_week.status==200){
			var week_rank_response=JSON.parse(xhr_week.responseText);
			var long_week="";
			if(week_rank_response.length>5){
				long_week=5;
			}else{
				long_week=week_rank_response.length;
			}
			for(var i=0;i<long_week;i++){
				var week_rank_str='<li class="list_video_item">';
				/*---视频链接---*/
				week_rank_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+week_rank_response[i].works.works_id+'">';
				week_rank_str+='<div class="video_cover">';
				week_rank_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +week_rank_response[i].works.works_cover +'"/>';
				week_rank_str+='<div class="video_overplay"></div>';
				week_rank_str+='<div class="video_play"></div>';
				week_rank_str+='</div>';
				 /*视频信息*/
				week_rank_str+='<div class="video_info">';
				 /*标题*/
				week_rank_str+='<div class="video_title">'+week_rank_response[i].works.works_title+'</div>';
				 /*浏览量*/
				week_rank_str+='<div class="video_number">'+week_rank_response[i].hot+'</div>';
				 /*用户*/
				week_rank_str+='<div class="video_username">'+week_rank_response[i].user.user_username+'</div>';
				week_rank_str+='</div>';
				week_rank_str+='</a>';
				 
				 /*---视频分类---*/
				week_rank_str+='<div class="video_label">';
				week_rank_str+='<div id="video_label_content" class="video_label_content">';
			/*	 day_rank_str+='<a class="video_label_item">绝地求生</a>';
				 day_rank_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
				
				 for(var num=0;num<week_rank_response[i].keyWordDTOList.length;num++){
					 week_rank_str+='<a class="video_label_item">'+week_rank_response[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
				 }
				 week_rank_str+='</div>';
				 week_rank_str+='</div>';
				 week_rank_str+='</li>';
				$("#week_rank").append(week_rank_str);
			}
		}
	}
	/*------------------月榜------------------*/
	var xhr_month=new XMLHttpRequest();
	xhr_month.open("POST","/wlmtxt/Works/Works_listWorks10OrderHotByMonth");
	xhr_month.send(null);
	xhr_month.onreadystatechange=function(){
		if(xhr_month.readyState==4 && xhr_month.status==200){
			var month_rank_response=JSON.parse(xhr_month.responseText);
			var long_month="";
			if(month_rank_response.length>5){
				long_month=5;
			}else{
				long_month=month_rank_response.length;
			}
			for(var i=0;i<long_month;i++){
				var month_rank_str='<li class="list_video_item">';
				/*---视频链接---*/
				month_rank_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+month_rank_response[i].works.works_id+'">';
				month_rank_str+='<div class="video_cover">';
				month_rank_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +month_rank_response[i].works.works_cover +'"/>';
				month_rank_str+='<div class="video_overplay"></div>';
				month_rank_str+='<div class="video_play"></div>';
				month_rank_str+='</div>';
				 /*视频信息*/
				month_rank_str+='<div class="video_info">';
				 /*标题*/
				month_rank_str+='<div class="video_title">'+month_rank_response[i].works.works_title+'</div>';
				 /*浏览量*/
				month_rank_str+='<div class="video_number">'+month_rank_response[i].hot+'</div>';
				 /*用户*/
				month_rank_str+='<div class="video_username">'+month_rank_response[i].user.user_username+'</div>';
				month_rank_str+='</div>';
				month_rank_str+='</a>';
				 
				 /*---视频分类---*/
				month_rank_str+='<div class="video_label">';
				month_rank_str+='<div id="video_label_content" class="video_label_content">';
			/*	 day_rank_str+='<a class="video_label_item">绝地求生</a>';
				 day_rank_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
				
				 for(var num=0;num<month_rank_response[i].keyWordDTOList.length;num++){
					 month_rank_str+='<a class="video_label_item">'+month_rank_response[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
				 }
				 month_rank_str+='</div>';
				 month_rank_str+='</div>';
				 month_rank_str+='</li>';
				$("#month_rank").append(month_rank_str);
			}
		}
	}
}