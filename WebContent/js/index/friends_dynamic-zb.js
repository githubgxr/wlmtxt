getDynamicVO();
var dynamicVO;
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
					var new_work = '<div class="video_options">'
							+ '<div class="neck_name user_img_xzt_div">'
							+ '<img class="user_img_xzt " src="/wlmtxt/Works/Works_getImg?imgName='
							+ dynamicVO.worksDTOList[num].user.user_avatar
							+ '" />'
							+ '</div>'
							+ '<div class="info_dynamic_name">'
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
							+ '</div>'
							+ '</div>'
							+ '<hr style="float: left; width: 100%;" />'
					$("#llls_list_container").append(new_work);
				}

			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/wlmtxt/Works/Works_getDynamicVO");

	xhr.send(null);
}
