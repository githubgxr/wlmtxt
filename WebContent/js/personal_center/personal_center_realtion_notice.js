function listNoticeByPage(e){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	/*formData.append("myAttentionVO.pageIndex",pageIndex);*/
	xhr.open("POST","/wlmtxt/Works/Works_listUserNotification");
	xhr.send(null);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list_appreciateNotice=JSON.parse(xhr.responseText);
			for(var i=0;i<list_appreciateNotice.length;i++){
				if(e==list_appreciateNotice[i].notification.notification_type){
					
				var appreciateNotice='<div class="llls_list_container">';
				appreciateNotice+='<div class="video_options">';
				if(e==1){
					/*用户头像*/
					appreciateNotice+='<div class="user_img_small_div">';
					appreciateNotice+='<img class="" src="/wlmtxt/img/user.jpg"/>';
					appreciateNotice+='</div>';
					
					/*用户名*/
					appreciateNotice+='<div class="thumd_name" style="color:#1dd388;">系统通知</div>';
					
				}else{
					/*用户头像*/
					appreciateNotice+='<div class="user_img_small_div  to_other_data">';
					appreciateNotice+='<img id="'
						+ list_appreciateNotice[i].worksDTO.user.user_id
						+ '" onclick="to_other_data(this.id)" class="" src="/wlmtxt/Works/Works_getImg?imgName=' +list_appreciateNotice[i].worksDTO.user.user_avatar +'"/>';
					appreciateNotice+='</div>';
					
					/*用户名*/
					appreciateNotice+='<div class="thumd_name to_other_data" id="'
						+ list_appreciateNotice[i].worksDTO.user.user_id
						+ '" onclick="to_other_data(this.id)" style="color:#1dd388;">'+list_appreciateNotice[i].worksDTO.user.user_username+'</div>';
					
				}
				
				/*作品发布时间*/
				appreciateNotice+='<div class="thumd_time">'+list_appreciateNotice[i].worksDTO.works.works_gmt_create+'</div>';
				appreciateNotice+='</div>';
				
				/*通知信息*/
				appreciateNotice+='<div class="info_concise">'+list_appreciateNotice[i].notification.notification_content+'</div>';
				appreciateNotice+='<li class="list_video_item" style="margin:0px;">';
				
				/*作品链接*/
				appreciateNotice+='<a class="video_list_item_wrap " href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+list_appreciateNotice[i].worksDTO.works.works_id+'">';
				appreciateNotice+='<div class="video_cover ">';
				appreciateNotice+='<img class="video_img " src="/wlmtxt/Works/Works_getImg?imgName=' +list_appreciateNotice[i].worksDTO.works.works_cover +'"/>';
				appreciateNotice+='<div class="video_overplay "></div>';
				appreciateNotice+='<div class="video_play "></div>';
				appreciateNotice+='</div>';
				appreciateNotice+='</a>';
				appreciateNotice+='</li>';
				
				/*作品简介*/
				appreciateNotice+='<div class="info_container">';
				appreciateNotice+='<span id="'
					+ list_appreciateNotice[i].worksDTO.user.user_id
					+ '" onclick="to_other_data(this.id)"  class="span_name to_other_data" style="margin-right:10px;">'+list_appreciateNotice[i].worksDTO.user.user_username+":"+'</span>';
				appreciateNotice+='<span class="span_info">'+list_appreciateNotice[i].worksDTO.works.works_title+'</span>';
				appreciateNotice+='</div>';
				$(".list_container").append(appreciateNotice);
				}
			}
			$(".list_container").append('<div style="width:100%;height:50px;float:left;"></div>');
		}
	}
}
