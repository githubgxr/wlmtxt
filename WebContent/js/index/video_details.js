$(function(){
	//视频id
	var video_id=$("#video_id").html();
	console.log("video_id:"+video_id);
	//获取视频的详细信息
		var formData_detail=new FormData();
		formData_detail.append("accept_works.works_id",video_id);
		var xhr_detail=new XMLHttpRequest();
		xhr_detail.open("POST", "/wlmtxt/Works/Works_getWorksDetailVO");
		xhr_detail.send(formData_detail);
		xhr_detail.onreadystatechange=function(){
			if(xhr_detail.readyState==4&&xhr_detail.status==200){
				console.log(1);
				var detail_response=JSON.parse(xhr_detail.responseText);
				/*------视频*/
				//标题
				$("#detail_video_title").html(detail_response.worksDTO.works.works_title);
				//简介
				$("#detail_video_discribe").html(detail_response.worksDTO.works.works_reason);
				//时间
				$("#detail_video_time").html(detail_response.worksDTO.works.works_gmt_create);
				//关键字
				$("#detail_video_keywords").html();
				//视频
				$("#detail_video_content").attr("src","/wlmtxt/Works/Works_getVideo?worksName=" + detail_response.worksDTO.works.works_name);
				$("#detail_video_content").attr("poster","/wlmtxt/Works/Works_getImg?imgName=" + detail_response.worksDTO.works.works_cover);
				//下载
				$("#detail_user_img").attr("href","/wlmtxt/Works/Works_getVideo?worksName=" + detail_response.worksDTO.works.works_id);
				
				/*------用户*/
				//头像
				$("#detail_user_img").attr("src","/wlmtxt/Works/Works_getImg?imgName=" + detail_response.worksDTO.user.user_avatar);
				//用户名
				$("#detail_user_name").html(detail_response.worksDTO.user.user_username);
				//个人介绍
				$("#detail_user_bio").html(detail_response.worksDTO.user.user_bio);
			}
		}
});