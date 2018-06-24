function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}


$(function(){
	var Request = new Object();
	Request = GetRequest();
	var other_id =Request["accpet_user.user_id"];
	console.log("other_id:"+other_id);
	otherData(other_id);
	listOtherDynamicByPage(1,other_id);
	
});
//他的资料
function otherData(other_id){
	var other_data_formData=new FormData();
	other_data_formData.append("accpet_user.user_id",other_id);
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/wlmtxt/User/User_getUserInfo");
	xhr.send(other_data_formData);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var other_data_response=JSON.parse(xhr.responseText);
			//昵称
			$("#other_data_username").html(other_data_response.user_username);
			//账号
			$("#other_data_email").html(other_data_response.user_mail);
			//性别
			$("#other_data_sex").html(other_data_response.user_sex);
			//简介
			$("#other_data_bio").html(other_data_response.user_bio);
			//获取关注量
			getfocusNum(other_id);
			//获取粉丝量
			getfansNum(other_id);
			/*//获取关注量
			var formData_focus_num=new FormData();
			formData_focus_num.append("accpet_user.user_id",other_id);
			var xhr_focus_num=new XMLHttpRequest();
			xhr_focus_num.open("POST","/wlmtxt/Works/Works_totalFollowingNum");
			xhr_focus_num.send(formData_focus_num);
			xhr_focus_num.onreadystatechange=function(){
				if (xhr_focus_num.readyState == 4 && xhr_focus_num.status == 200) {
					//他的关注
					$("#other_data_focus").html(xhr_focus_num.responseText);
						}
					}
			//获取粉丝量
			var formData_fans_num=new FormData();
			formData_fans_num.append("accpet_user.user_id",other_id);
			var xhr_fans_num=new XMLHttpRequest();
			xhr_fans_num.open("POST","/wlmtxt/Works/Works_totalFansNum");
			xhr_fans_num.send(formData_focus_num);
			xhr_fans_num.onreadystatechange=function(){
				if (xhr_fans_num.readyState == 4 && xhr_fans_num.status == 200) {
					$("#other_data_fans").html(xhr_fans_num.responseText);
						}
					}
			}*/
		}
	}
}
//他的动态
function listOtherDynamicByPage(pageIndex,other_id){
	var list_video_item = document.getElementsByClassName("list_video_item");
	var long = list_video_item.length;
	for (var num = 0; num < long; num++) {
		list_video_item[0].parentNode.removeChild(list_video_item[0]);
	}
	var other_dynamic_xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myWorksVO.pageIndex",pageIndex);
	formData.append("accpet_user.user_id",other_id);
	other_dynamic_xhr.open("POST","/wlmtxt/User/User_getOtherDynamic");
	other_dynamic_xhr.send(formData);
	other_dynamic_xhr.onreadystatechange=function(){
		if(other_dynamic_xhr.readyState==4 && other_dynamic_xhr.status==200){
			var other_dynamic_response=JSON.parse(other_dynamic_xhr.responseText);
			console.log("pageIndex:"+other_dynamic_response.pageIndex);
			console.log("totalRecords:"+other_dynamic_response.totalRecords);
			console.log("pageSize:"+other_dynamic_response.pageSize);
			console.log("totalPages:"+other_dynamic_response.totalPages);
			console.log("HavePrePage:"+other_dynamic_response.HavePrePage);
			console.log("HaveNextPage:"+other_dynamic_response.HaveNextPage);
			for(var i=0;i<other_dynamic_response.worksDTOList.length;i++){
				
				var other_dynamic_str='<li class="list_video_item">';
				/*---视频链接---*/
				 other_dynamic_str+='<a class="video_list_item_wrap" href="/wlmtxt/Works/Works_videoDetailsPage?accept_works.works_id='+other_dynamic_response.worksDTOList[i].works.works_id+'">';
				 other_dynamic_str+='<div class="video_cover">';
				 other_dynamic_str+='<img class="video_img" src="/wlmtxt/Works/Works_getImg?imgName=' +other_dynamic_response.worksDTOList[i].works.works_cover +'"/>';
				 other_dynamic_str+=' <div class="category_name">'+other_dynamic_response.worksDTOList[i].secondMenu.second_menu_name+'</div>';
				 other_dynamic_str+='<div class="video_overplay"></div>';
				 other_dynamic_str+='<div class="video_play"></div>';
				 other_dynamic_str+='</div>';
				 /*视频信息*/
				 other_dynamic_str+='<div class="video_info">';
				 /*标题*/
				 other_dynamic_str+='<div class="video_title">'+other_dynamic_response.worksDTOList[i].works.works_title+'</div>';
				 /*浏览量*/
				 other_dynamic_str+='<div class="video_number">'+other_dynamic_response.worksDTOList[i].playNum+'</div>';
				 /*时间*/
				 other_dynamic_str+='<div class="video_time">'+other_dynamic_response.worksDTOList[i].works.works_gmt_create+'</div>';
				 other_dynamic_str+='</div>';
				 other_dynamic_str+='</a>';
				 
				 /*---视频分类---*/
				 other_dynamic_str+='<div class="video_label">';
				 other_dynamic_str+='<div id="video_label_content" class="video_label_content">';
			/*	 other_dynamic_str+='<a class="video_label_item">绝地求生</a>';
				 other_dynamic_str+='<a class="video_label_item">绝地求生</a> <a class="video_label_item">绝地求生</a>';*/
				
				 for(var num=0;num<other_dynamic_response.worksDTOList[i].keyWordDTOList.length;num++){
					 other_dynamic_str+='<a class="video_label_item">'+other_dynamic_response.worksDTOList[i].keyWordDTOList[num].keyword.keyword_name+'</a>';
				 }
				 other_dynamic_str+='</div>';
				 other_dynamic_str+='</div>';
				 other_dynamic_str+='</li>';
				$("#other_dynamic_list_container").append(other_dynamic_str);
				
			}
		}
	}
}

