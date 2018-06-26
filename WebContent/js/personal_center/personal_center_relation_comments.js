listMyDiscussWorkList();
function listMyDiscussWorkList() {
	var list_video_item = document.getElementsByClassName("list_video_item");
	var long = list_video_item.length;
	for (var num = 0; num < long; num++) {
		list_video_item[0].parentNode.removeChild(list_video_item[0]);
	}
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_listMyDiscussWorkList");
	xhr.send(null);
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			var list_appreciateNotice = JSON.parse(xhr.responseText);
			if(list_appreciateNotice.length>0){
				for (var i = 0; i < list_appreciateNotice.length; i++) {
					var appreciateNotice = '<div class="llls_list_container">';
					appreciateNotice += '<div class="video_options">';
					/* 用户头像 */
					appreciateNotice += '<div class="user_img_small_div  to_other_data">';
					appreciateNotice += '<img id="'
							+ user_id
							+ '" onclick="to_other_data(this.id)" class="" src="/wlmtxt/Works/Works_getImg?imgName='
							+ user_avatar
							+ '"/>';
					appreciateNotice += '</div>';

					/* 用户名 */
					appreciateNotice += '<div class="thumd_name to_other_data" id="'
							+ user_id
							+ '" onclick="to_other_data(this.id)" style="color:#1dd388;">'
							+ user_username
							+ '</div>';

					/* 作品发布时间 */
					appreciateNotice += '<div class="thumd_time">'
							+ list_appreciateNotice[i].worksDTO.works.works_gmt_create
							+ '</div>';
					appreciateNotice += '</div>';

					/* 通知信息 */
					appreciateNotice += '<div class="info_concise">'
							+ list_appreciateNotice[i].discuss.discuss_content
							+ '</div>';
					appreciateNotice += '<li class="list_video_item" style="margin:0px;">';

					/* 作品链接 */
					appreciateNotice += '<a class="video_list_item_wrap " href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
							+ list_appreciateNotice[i].worksDTO.works.works_id
							+ '">';
					appreciateNotice += '<div class="video_cover ">';
					appreciateNotice += '<img class="video_img " src="/wlmtxt/Works/Works_getImg?imgName='
							+ list_appreciateNotice[i].worksDTO.works.works_cover
							+ '"/>';
					appreciateNotice += '<div class="video_overplay "></div>';
					appreciateNotice += '<div class="video_play "></div>';
					appreciateNotice += '</div>';
					appreciateNotice += '</a>';
					appreciateNotice += '</li>';

					/* 作品简介 */
					appreciateNotice += '<div class="info_container">';
					appreciateNotice += '<span id="'
							+ list_appreciateNotice[i].worksDTO.user.user_id
							+ '" onclick="to_other_data(this.id)"  class="span_name to_other_data" style="margin-right:10px;">'
							+ list_appreciateNotice[i].worksDTO.user.user_username
							+ ":" + '</span>';
					appreciateNotice += '<span class="span_info">'
							+ list_appreciateNotice[i].worksDTO.works.works_title
							+ '</span>';
					appreciateNotice += '</div>';
					$(".list_container").append(appreciateNotice);
				}
				$(".list_container").append(
						'<div style="width:100%;height:50px;float:left;"></div>');
			}else{
				$("#llls_main").append('<img src="/wlmtxt/img/no_message_bg.png" style="width:250px;height:250px;margin:30px 240px 0px 240px;float:left;"/><div style="color:#99a2aa;font-size：16px;text-align:center;margin:0 0 50px 0;">还没有评论过的视频哦！</div>');
			}
			
		}
	}
}