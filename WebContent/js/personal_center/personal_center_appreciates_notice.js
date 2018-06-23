/**
 * 
 */
$(function(){
	appreciateNoticeByPage();
});
function appreciateNoticeByPage(){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	/*formData.append("myAttentionVO.pageIndex",pageIndex);*/
	xhr.open("POST","/wlmtxt/Works/Works_listUserNotification");
	xhr.send(null);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list_appreciateNotice=JSON.parse(xhr.responseText);
			for(var i=0;i<list_appreciateNotice.notificationList.length;i++){
				
				var appreciateNotice='<div class="video_options">';
				
				appreciateNotice+='<div class="neck_name user_img_small">';
				appreciateNotice+='<img class="user_img_small src="/wlmtxt/Works/Works_getImg?imgName=' +list_appreciateNotice.notificationList[i].worksDTO.works.works_cover +'"/>';
				appreciateNotice+='</div>';
				appreciateNotice+='<div class="thumd_name">王小二</div>';
				appreciateNotice+='<div class="thumd_time">2018.6.3</div>';
				appreciateNotice+='</div>';
				appreciateNotice+='<div class="info_concise">王小二点赞了你的视频</div>';
				appreciateNotice+='<li class="list_video_item">';
				appreciateNotice+='<div class="list_li ">';
				
				/*视频链接*/
				appreciateNotice+='<a class="video_list_item_wrap ">';
				appreciateNotice+='<div class="video_cover ">';
				appreciateNotice+='<img class="video_img " src="<%=basePath%>css/zb/img/4.png" />';
				appreciateNotice+='<div class="video_overplay "></div>';
				appreciateNotice+='<div class="video_play "></div>';
				appreciateNotice+='</div>';
				appreciateNotice+='</a>';
				appreciateNotice+='</div>';
				appreciateNotice+='</li>';
				appreciateNotice+='<div class="info_container">';
				appreciateNotice+='<span class="span_name">王小二：</span> <span class="span_info">我爱吃萝卜和青菜，身体健康人又可爱，萝卜青菜我最爱！</span>';
				appreciateNotice+='</div>';
				appreciateNotice+='</div>';
				
				$("#llls_list_container").append(appreciateNotice);
				
			}
		}
	}
}
