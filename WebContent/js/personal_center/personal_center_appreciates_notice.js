/**
 * 
 */
$(function(){
	appreciateNoticeByPage(1);
});
function appreciateNoticeByPage(pageIndex){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myAttentionVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/Works/Works_listUserNotification");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list_appreciateNotice=JSON.parse(xhr.responseText);
			for(var i=0;i<list_appreciateNotice.followDTO.length;i++){
				
				var list_appreciateNotice='<div id="llls_list_container">';
				
				list_appreciateNotice+='<div class="video_options">';
				/*用户头像*/
				list_appreciateNotice+='<div class="neck_name user_img_small">';
				/*list_appreciateNotice+='<img class="user_img_small" src="/wlmtxt/Works/Works_getImg?imgName=' +list_appreciateNotice.followDTO[i].works.works_cover +'"/>';*/
				list_appreciateNotice+='</div>';
				/*用户名*/
				list_appreciateNotice+='<div class="thumd_name">王小二</div>';
				/*时间*/
				list_appreciateNotice+='<div class="thumd_time">2018.6.3</div>';
				list_appreciateNotice+='</div>';
				list_appreciateNotice+='<div class="info_concise">王小二点赞了你的视频</div>';
				list_appreciateNotice+='<li class="list_video_item">';
				list_appreciateNotice+='<div class="list_li ">';
				list_appreciateNotice='<a class="video_list_item_wrap ">';
				list_appreciateNotice+='<div class="video_cover ">';
				/*list_appreciateNotice+='<img class="user_img" src="/wlmtxt/Works/Works_getImg?imgName=' +list_appreciateNotice.followDTO[i].works.works_cover +'"/>';*/
				list_appreciateNotice+='<div class="video_overplay "></div>';
				list_appreciateNotice+='<div class="video_play "></div>';
				list_appreciateNotice+='</div>';
				list_appreciateNotice+='</a>';
				list_appreciateNotice+='</div>';
				list_appreciateNotice+='</li>';
				list_appreciateNotice+='<div class="info_container">';
				list_appreciateNotice+='<span class="span_name">王小二：</span> <span class="span_info">我爱吃萝卜和青菜，身体健康人又可爱，萝卜青菜我最爱！</span>';
				list_appreciateNotice+='</div>';
				list_appreciateNotice+='</div>';
				$(".list_container").append(list_appreciateNotice);
				
			}
		}
	}
}
/*
取消单个用户关注
function cancelFocus(focus_user_id){
	console.log("focus_user_id:"+focus_user_id);
	var xhrhp=new XMLHttpRequest();
	xhrhp.open("POST","/wlmtxt/Works/Works_deleteMyWorks");
	var formData=new FormData();
	formData.append("accept_works.works_id",focus_user_id);
	xhrhp.send(formData);
	xhrhp.onreadystatechange=function(){
		if(xhrhp.readyState==4&&xhrhp.status==200){
			if(xhrhp.responseText=="1"){
				toastr.success("取消关注成功！");
				appreciateNoticeByPage(1);
			}else{
				toastr.error("取消关注失败！");
				return false;
			}
		}
	}
}

//取消关注全部用户
function cancelAllFocus(){
	var xhrhttp=new XMLHttpRequest();
	xhrhttp.open("POST","/wlmtxt/Works/Works_deleteAllMyWorks");
	xhrhttp.send(null);
	xhrhttp.onreadystatechange=function(){
		if(xhrhttp.readyState==4&&xhrhttp.status==200){
			if(xhrhttp.responseText=="1"){
				toastr.success("取消关注全部用户成功！");
				appreciateNoticeByPage(1);
			}else{
				toastr.error("取消关注全部用户失败！");
				return false;
			}
		}
	}
}
*/