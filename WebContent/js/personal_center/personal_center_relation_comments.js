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
			var relation_comments_response = JSON.parse(xhr.responseText);
			for (var i = 0; i < relation_comments_response.length; i++) {
				var relation_comments_str = '<li class="list_video_item">';
				/*---视频链接---*/
				relation_comments_str += '<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
						+ relation_comments_response[i].worksDTO.works.works_id
						+ '">';
				relation_comments_str += '<div class="video_cover">';
				relation_comments_str += '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ relation_comments_response[i].worksDTO.works.works_cover
						+ '"/>';
				relation_comments_str += ' <div class="category_name">'
						+ relation_comments_response[i].worksDTO.secondMenu.second_menu_name
						+ '</div>';
				relation_comments_str += '<div class="video_overplay"></div>';
				relation_comments_str += '<div class="video_play"></div>';
				relation_comments_str += '</div>';
				/* 视频信息 */
				relation_comments_str += '<div class="video_info">';
				/* 标题 */
				relation_comments_str += '<div class="video_title">'
						+ relation_comments_response[i].worksDTO.works.works_title
						+ '</div>';
				/* 浏览量 */
				relation_comments_str += '<div class="video_number">'
						+ relation_comments_response[i].worksDTO.playNum
						+ '</div>';
				/* 用户 */
				relation_comments_str += '<div class="video_username">'
						+ relation_comments_response[i].worksDTO.user.user_username
						+ '</div>';
				relation_comments_str += '</div>';
				relation_comments_str += '</a>';

				/*---视频分类---*/
				relation_comments_str += '<div class="video_label">';
				relation_comments_str += '<div id="video_label_content" class="video_label_content">';
				/*
				 * relation_comments_str+='<a class="video_label_item">绝地求生</a>';
				 * relation_comments_str+='<a class="video_label_item">绝地求生</a>
				 * <a class="video_label_item">绝地求生</a>';
				 */

				for (var num = 0; num < relation_comments_response[i].worksDTO.keyWordDTOList.length; num++) {
					relation_comments_str += '<a class="video_label_item">'
							+ relation_comments_response[i].worksDTO.keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}
				relation_comments_str += '</div>';
				relation_comments_str += '</div>';
				relation_comments_str += '</li>';
				$("#my_relation_comments_container").append(
						relation_comments_str);
			}
		}
	}
}