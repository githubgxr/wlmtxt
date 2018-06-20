$(function(){
	listMyDynamicByPage(1);
});
function listMyDynamicByPage(pageIndex){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myWorksVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/Works/Works_getMyWorksListVO");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var wddt_response=JSON.parse(xhr.responseText);
			console.log("pageIndex:"+wddt_response.pageIndex);
			console.log("totalRecords:"+wddt_response.totalRecords);
			console.log("pageSize:"+wddt_response.pageSize);
			console.log("totalPages:"+wddt_response.totalPages);
			console.log("HavePrePage:"+wddt_response.HavePrePage);
			console.log("HaveNextPage:"+wddt_response.HaveNextPage);
			for(var i=0;i<wddt_response.worksDTOList.length;i++){
				var wddt_str='<li class="list_video_item">';
				/*---视频链接---*/
				 wddt_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+wddt_response.worksDTOList[i].works.works_id+'">';
				 wddt_str+='<div class="video_cover">';
				 wddt_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +wddt_response.worksDTOList[i].works.works_cover +'"/>';
				 wddt_str+='<div class="video_overplay"></div>';
				 wddt_str+='<div class="video_play"></div>';
				 wddt_str+='</div>';
				 /*视频信息*/
				 wddt_str+='<div class="video_info">';
				 /*标题*/
				 wddt_str+='<div class="video_title">'+wddt_response.worksDTOList[i].works.works_title+'</div>';
				 /*浏览量*/
				 wddt_str+='<div class="video_number">64845241</div>';
				 /*时间*/
				 wddt_str+='<div class="video_time">'+wddt_response.worksDTOList[i].works.works_gmt_create+'</div>';
				 wddt_str+='</div>';
				 wddt_str+='</a>';
				 /*---视频分类---*/
				 wddt_str+='<div class="video_label">';
				 wddt_str+='<div class="video_label_content">';
				 wddt_str+='<a class="video_label_item">绝地求生</a>';
				 wddt_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';
				 wddt_str+='</div>';
				 wddt_str+='</div>';
				 /*---删除---*/
				 wddt_str+='<div class="video_options">';
				 wddt_str+='<a class="video_delete_btn">删除</a>';
				 wddt_str+='</div>';
				 wddt_str+='</li>';
				$("#wddt_list_container").append(wddt_str);
			}
		}
	}
}