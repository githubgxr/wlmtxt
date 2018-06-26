
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
				$("#llls_list_container").html('<div id="llls_list_container_div" style="width:100%;float:left;margin:30px 0;" ></div>');
				$("#history_delete_all").css("display", "block");
				for(var i=0;i<llls_response.length;i++){
					var llls_str='<li class="history_list">';
					/*<!--左边日期  -->*/
					llls_str+='<div class="history_list_time_div">';
					llls_str+='<div class="history_list_time">';
					llls_str+='<i class="history_round_icon"></i>';
					llls_str+='</div>';
					llls_str+='<div class="history_list_time_text">'+llls_response[i].playHistory.play_history_gmt_create+'</div>';

					llls_str+='</div>';
					llls_str+='<div class="list_video_item" style="float: left; margin: 20px 0;">';
					llls_str+='<div class="list_li" style="float: left;">';
						/*	<!--视频链接-->*/
					llls_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+llls_response[i].worksDTO.works.works_id+'">';
					llls_str+='<div class="video_cover ">';
					llls_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +llls_response[i].worksDTO.works.works_cover +'"/>';
					llls_str+='<div class="video_overplay "></div>';
					llls_str+='<div class="video_play "></div>';
					llls_str+='</div>';
					llls_str+='</a>';
					llls_str+='</div>';
					llls_str+='</div>';
					/**/
					llls_str+='<div class="history_video_info">';
					llls_str+='<div class="history_video_title">'+llls_response[i].worksDTO.works.works_title+'</div>';
					llls_str+='<div class="history_user_info">';
					llls_str+='<img id="'+llls_response[i].worksDTO.user.user_id+'" onclick="to_other_data(this.id)" style="width: 35px; height: 35px"  src="/wlmtxt/Works/Works_getImg?imgName=' +llls_response[i].worksDTO.user.user_avatar +'"/>';
					llls_str+='<div id="'+llls_response[i].worksDTO.user.user_id+'" onclick="to_other_data(this.id)" class="history_user_username to_other_data">'+llls_response[i].worksDTO.user.user_username+'</div>';
					llls_str+='	<div class="history_delete" onclick="deletePlayHistory(this.id)" id="'+llls_response[i].playHistory.play_history_id+'">删除</div>';
					llls_str+='</div>';
					llls_str+='</div>';
					llls_str+='</li>';
					$("#llls_list_container_div").append(llls_str);

					
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
					listMyHistoryByPage();
				}else{
					toastr.error("清除全部失败！");
					return false;
				}
			}
		}
	}
	

