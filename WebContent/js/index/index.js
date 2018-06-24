indexListRank();
collaborativeFilteringByUser();
hotRecommend();
listrecommend();
function listrecommend() {
	var xhr_week = new XMLHttpRequest();
	xhr_week.open("POST", "/wlmtxt/WorksExamine/WorksExamine_listrecommend");
	xhr_week.send(null);
	xhr_week.onreadystatechange = function() {
		if (xhr_week.readyState == 4 && xhr_week.status == 200) {
			var listrecommend = JSON.parse(xhr_week.responseText);

			if (listrecommend[0] != null) {
				var lbt_1 = '<div id="dtj" style="background-size:660px 385px ; background-image:url(\'\'); height: 330px; width: 660px; float: left;">'
						+ '<ul id="llls_list_container">'
						+ '<li class="index_list_video_item" style="width: 660px; margin: 0 20px 10px 0;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="height: 450px; width: 660px;">'
						+ '<div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ listrecommend[0].worksDTO.works.works_cover
						+ '" style="height: 385px; width: 660px;" />'
						+ '<div class="category_name">'
						+ listrecommend[0].worksDTO.secondMenu.second_menu_name
						+ '</div>'
						+ '<div class="video_overplay" style="width: 660px; height: 385px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 660px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px; width: 600px;">'
						+ listrecommend[0].worksDTO.works.works_title
						+ '</div>'
						+ '<!--浏览量-->'
						+ '<div class="video_hot">'
						+ listrecommend[0].worksDTO.hot
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 660px;">'
						+ listrecommend[0].worksDTO.user.user_username
						+ '</div>'
						+ '</div>'
						+ '</a> <!--视频分类-->'
						+ '<div class="video_label" style="width: 660px; height: 40px;">'
						+ '<div class="video_label_content">';

				for (var num = 0; num < listrecommend[0].worksDTO.keyWordDTOList.length; num++) {
					lbt_1 = lbt_1
							+ '<a class="video_label_item">'
							+ listrecommend[0].worksDTO.keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}

				lbt_1 = lbt_1 + '</div>' + '</div>' + '</li>' + '</ul>'
						+ '</div>';

				$("#lbt_con").append(lbt_1);
			}
			if (listrecommend[1] != null) {
				var lbt_2 = '<li class="index_list_video_item" style="width: 240px; margin: 0 20px 10px 0;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="height: 200px; width: 240px;">'
						+ '<div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ listrecommend[1].worksDTO.works.works_cover
						+ '" style="width: 240px; height: 135px;" />'
						+ '<div class="category_name">'
						+ listrecommend[1].worksDTO.secondMenu.second_menu_name
						+ '</div>'
						+ '<div class="video_overplay" style="width: 240px; height: 135px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 240px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px;">'
						+ listrecommend[1].worksDTO.works.works_title
						+ '</div>'
						+ '<!--浏览量-->'
						+ '<div class="video_hot">'
						+ listrecommend[1].worksDTO.hot
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 220px;">'
						+ listrecommend[1].worksDTO.user.user_username
						+ '</div>'
						+ '</div>'
						+ '</a> <!--视频分类-->'
						+ '<div class="video_label" style="width: 220px; height: 40px;">'
						+ '<div class="video_label_content">'
				for (var num = 0; num < listrecommend[1].worksDTO.keyWordDTOList.length; num++) {
					lbt_2 = lbt_2
							+ '<a class="video_label_item">'
							+ listrecommend[1].worksDTO.keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}
				lbt_2 = lbt_2 + '</div>' + '</div>' + '</li>';
				$("#lbt_little_con").append(lbt_2);
			}
			if (listrecommend[2] != null) {
				var lbt_3 = '<li class="index_list_video_item" style="width: 240px; margin: 0 20px 10px 0;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="height: 200px; width: 240px;">'
						+ '<div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ listrecommend[2].worksDTO.works.works_cover
						+ '" style="width: 240px; height: 135px;" />'
						+ '<div class="category_name">'
						+ listrecommend[2].worksDTO.secondMenu.second_menu_name
						+ '</div>'
						+ '<div class="video_overplay" style="width: 240px; height: 135px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 240px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px;">'
						+ listrecommend[2].worksDTO.works.works_title
						+ '</div>'
						+ '<!--浏览量-->'
						+ '<div class="video_hot">'
						+ listrecommend[2].worksDTO.hot
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 220px;">'
						+ listrecommend[2].worksDTO.user.user_username
						+ '</div>'
						+ '</div>'
						+ '</a> <!--视频分类-->'
						+ '<div class="video_label" style="width: 220px; height: 40px;">'
						+ '<div class="video_label_content">'
				for (var num = 0; num < listrecommend[2].worksDTO.keyWordDTOList.length; num++) {
					lbt_3 = lbt_3
							+ '<a class="video_label_item">'
							+ listrecommend[1].worksDTO.keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}
				lbt_3 = lbt_3 + '</div>' + '</div>' + '</li>';
				$("#lbt_little_con").append(lbt_3);
			}
		}
	}
}
function hotRecommend() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_hotRecommend");
	xhr.send(null);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var hotRecommend_response = JSON.parse(xhr.responseText);
			/*
			 * 清空原表数据
			 */
			var djdzkCon = document.getElementsByClassName("djdzkCon");
			var long = djdzkCon.length;

			for (var num = 0; num < long; num++) {
				djdzkCon[0].parentNode.removeChild(djdzkCon[0]);
			}
			/*
			 * 
			 */
			for (var i = 0; i < hotRecommend_response.length; i++) {
				var collaborativeFiltering = '<li  class="djdzkCon index_list_video_item" style="width: 160px; height: 200px; margin: 0 20px 10px 0;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="width: 160px; height: 160px;">'
						+ '<div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ hotRecommend_response[i].works.works_cover
						+ '" style="width: 160px; height: 100px;" />'
						+ ((hotRecommend_response[i].secondMenu == null) ? ''
								: ('<div class="category_name">'
										+ hotRecommend_response[i].secondMenu.second_menu_name + '</div>'))
						+ '<div class="video_overplay" style="width: 160px; height: 100px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 160px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px;">'
						+ hotRecommend_response[i].works.works_title
						+ '</div>'
						+ '<!--浏览量-->'
						+ '<div class="video_hot">'
						+ hotRecommend_response[i].playNum
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 160px;">'
						+ hotRecommend_response[i].user.user_username
						+ '</div>'
						+ '</div>'
						+ '</a> <!--视频分类-->'
						+ '<div class="video_label">'
						+ '<div class="video_label_content">';

				for (var num = 0; num < hotRecommend_response[i].keyWordDTOList.length; num++) {
					collaborativeFiltering = collaborativeFiltering
							+ '<a class="video_label_item">'
							+ hotRecommend_response[i].keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}

				$("#djdzk_llls_list_container").append(collaborativeFiltering);
			}
		}
	}
}
function collaborativeFilteringByUser() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/Works/Works_collaborativeFilteringByUser");
	xhr.send(null);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var collaborativeFiltering_response = JSON.parse(xhr.responseText);

			/*
			 * 清空原表数据
			 */
			var cnxhCon = document.getElementsByClassName("cnxhCon");
			var long = cnxhCon.length;

			for (var num = 0; num < long; num++) {
				cnxhCon[0].parentNode.removeChild(cnxhCon[0]);
			}
			/*
			 * 
			 */
			for (var i = 0; i < collaborativeFiltering_response.length; i++) {
				var collaborativeFiltering = '<li class="cnxhCon index_list_video_item" style="width: 160px; height: 200px; margin: 0 12px 10px 12px;">'
						+ '<!--视频链接--> <a class="video_list_item_wrap" style="width: 160px; height: 160px;">'
						+ '<div class="video_cover">'
						+ '<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName='
						+ collaborativeFiltering_response[i].works.works_cover
						+ '" style="width: 160px; height: 100px;" />'
						+ ((collaborativeFiltering_response[i].secondMenu == null) ? ''
								: ('<div class="category_name">'
										+ collaborativeFiltering_response[i].secondMenu.second_menu_name + '</div>'))
						+ '<div class="video_overplay" style="width: 160px; height: 100px;"></div>'
						+ '<div class="video_play" style="width: 30px; height: 30px; margin: -20px 0 0 -20px;"></div>'
						+ '</div> <!--视频信息-->'
						+ '<div class="video_info" style="width: 160px; height: 40px; margin: 5px 0;">'
						+ '<!--标题-->'
						+ '<div class="video_title" style="font-size: 12px; margin-left: 5px; width: 160px;">'
						+ collaborativeFiltering_response[i].works.works_title
						+ '</div>'
						+ '<!--用户名-->'
						+ '<div class="video_username" style="width: 90px; margin-top: -5px;">'
						+ collaborativeFiltering_response[i].user.user_username
						+ '</div>'
						+ '<!--发布时间-->'
						+ '<div class="video_time" style="width: 70px; margin-top: -5px; float: right;">'
						+ collaborativeFiltering_response[i].works.works_gmt_create
								.substr(0, 10)
						+ '</div>'
						+ '</div>'
						+ '</a> <!--视频分类-->'
						+ '<div class="video_label" style="width: 160px; padding: 0;">'
						+ '<div  class="video_label_content" style="width: 160px; padding: 0;">';

				for (var num = 0; num < collaborativeFiltering_response[i].keyWordDTOList.length; num++) {
					collaborativeFiltering = collaborativeFiltering
							+ '<a class="video_label_item">'
							+ collaborativeFiltering_response[i].keyWordDTOList[num].keyword.keyword_name
							+ '</a>';
				}

				collaborativeFiltering = collaborativeFiltering + '</div>'
						+ '</div>' + '</li>';

				$("#cnxh_list_container").append(collaborativeFiltering);
			}
		}
	}
}
function indexListRank() {
	var xhr_week = new XMLHttpRequest();
	xhr_week.open("POST", "/wlmtxt/Works/Works_listWorks10OrderHotByWeek");
	xhr_week.send(null);
	xhr_week.onreadystatechange = function() {
		if (xhr_week.readyState == 4 && xhr_week.status == 200) {
			var week_rank_response = JSON.parse(xhr_week.responseText);
			var n = 0;
			if (week_rank_response.length >= 8) {
				n = 8;
			} else {
				n = week_rank_response.length;
			}
			for (var i = 0; i < n; i++) {
				var week_rank = '<div style="line-height: 20px; height: 20px; overflow: hidden; margin: 0 0 20px 0;">'
						+ '<div class="video_hot" style="float: left;">'
						+ week_rank_response[i].hot
						+ '</div>&nbsp;&nbsp;<span style="cursor: pointer;" class="green_text" onclick="window.location=\'/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
						+ week_rank_response[i].works.works_id
						+ '\'">'
						+ week_rank_response[i].works.works_title
						+ '</span>'
						+ '</div>';
				$("#index_week_rank").append(week_rank);
			}

		}
	}
}