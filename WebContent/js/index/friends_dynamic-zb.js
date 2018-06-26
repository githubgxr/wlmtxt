var dynamicVO;
var pageIndex = 1;
getDynamicVO();
function getDynamicVO() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				dynamicVO = JSON.parse(xhr.responseText);

				var llls_list_container = document
						.getElementById("llls_list_container");
				for (var num = 0; num < dynamicVO.worksDTOList.length; num++) {
					var new_work = '<div class="video_options" style="padding:20px 0 0 0;">'
							+ '<div class="neck_name user_img_xzt_div">'
							+ '<img id="'
							+ dynamicVO.worksDTOList[num].user.user_id
							+ '" onclick="to_other_data(this.id)" class="user_img_xzt to_other_data" src="/wlmtxt/Works/Works_getImg?imgName='
							+ dynamicVO.worksDTOList[num].user.user_avatar
							+ '" />'
							+ '</div>'
							+ '<div onclick="to_other_data(this.id)" id="'
							+ dynamicVO.worksDTOList[num].user.user_id
							+ '" class="info_dynamic_name to_other_data">'
							+ dynamicVO.worksDTOList[num].user.user_username
							+ '</div>'
							+ '<div class="info_dynamic_time">'
							+ dynamicVO.worksDTOList[num].works.works_gmt_create
							+ '</div>'
							+ '<div class="info_dynamic_title" onclick="window.location=\'/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
							+ dynamicVO.worksDTOList[num].works.works_id
							+ '\'">'
							+ dynamicVO.worksDTOList[num].works.works_title
							+ '</div>'
							+ '<div class="info_dynamic_concise" onclick="window.location=\'/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='
							+ dynamicVO.worksDTOList[num].works.works_id
							+ '\'">'
							+ dynamicVO.worksDTOList[num].works.works_reason
							+ '</div>'
							+ '<div class="list_img">'
							+ '<video controls="controls" poster="/wlmtxt/Works/Works_getImg?imgName='
							+ dynamicVO.worksDTOList[num].works.works_cover
							+ '" class="video_img" src="/wlmtxt/Works/Works_getVideo?worksName='
							+ dynamicVO.worksDTOList[num].works.works_name
							+ '" style="width: 560px; height: 315px;" />'
							+ '<div class="user_operate dz_yes" id="thumbs_number_div" style="float: right;">'
							+ '<i class="fas fa-thumbs-up"></i>&nbsp;<span id="thumbs_number">'
							+ dynamicVO.worksDTOList[num].likeNum
							+ '</span>'
							+ '</div>'
							+ '<div class="dz_yes user_operate" id="collect_number_div" style="float: right; margin: 0 20px;">'
							+ '<i class="fas fa-heart"></i>&nbsp;<span id="collect_number">'
							+ dynamicVO.worksDTOList[num].collectNum
							+ '</span>'
							+ '</div>'
							+ '<div class="dz_yes" id="play_number_div" style="float: right; margin: 0">'
							+ '<i class="fas fa-play-circle"></i>&nbsp;<span id="play_number">'
							+ dynamicVO.worksDTOList[num].playNum
							+ '</span>'
							+ '</div>'
							+ '</div>'
							+ '</div>'
							+ '<hr style="float: left; width: 100%;margin:5px 0px;" />'
					$("#button_div_more").before(new_work);
				}
				pageIndex++;
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/wlmtxt/Works/Works_getFriendsDynamicVO");
	var formData = new FormData();
	formData.append("dynamicVO.pageIndex", pageIndex);
	xhr.send(formData);
}
