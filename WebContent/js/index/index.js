indexListRank();

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