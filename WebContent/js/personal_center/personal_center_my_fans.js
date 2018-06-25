/**
 * 
 */
$(function(){
	listMyFansByPage(1);
});
function listMyFansByPage(pageIndex){
	
	/*移除之前的数据*/
	var user_list = document.getElementsByClassName("user_list");
	var long = user_list.length;
	for (var num = 0; num < long; num++) {
		user_list[0].parentNode.removeChild(user_list[0]);
	}
	
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myFansVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/User/User_listMyFansDTO");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			
			var list_myFans=JSON.parse(xhr.responseText);
			for(var i=0;i<list_myFans.length;i++){
				
				var myFans='<li class="user_list">';
				myFans+='<div class="user_list_img_div">';
				myFans+='<img  id="'+list_myFans[i].user.user_id+'" onclick="to_other_data(this.id)" class="user_img" src="/wlmtxt/Works/Works_getImg?imgName=' +list_myFans[i].user.user_avatar  +'"/>';
				myFans+='</div>';
				myFans+='<div class="user_info">';
				myFans+='<div  id="'+list_myFans[i].user.user_id+'" onclick="to_other_data(this.id)" class="user_name">'+list_myFans[i].user.user_username+'</div>';
				myFans+='<div class="user_operateing focus_other" id="'+list_myFans[i].user.user_id+'">+ 关注</div>';
				myFans+='<div class="user_grjj">'+list_myFans[i].user.user_bio+'</div>';
				myFans+='</div>';
				myFans+='</li>';
				$(".user_list_ul").append(myFans);
				checkFocus(list_myFans[i].user.user_id);
			}
		}
	}
}

/*+关注*/
function withFocus(focus_user_id){
	var xhrhp=new XMLHttpRequest();
	xhrhp.open("POST","/wlmtxt/User/User_followUser");
	var formData=new FormData();
	formData.append("accept_user.user_id",focus_user_id);
	xhrhp.send(formData);
	xhrhp.onreadystatechange=function(){
		if(xhrhp.readyState==4&&xhrhp.status==200){
			if(xhrhp.responseText=="1"){
				toastr.success("关注成功！");
				listMyFansByPage(1);
			}else{
				toastr.error("关注失败！");
				return false;
			}
		}
	}
}

//全部关注
function withFocusAll(){
	var xhrhttp=new XMLHttpRequest();
	xhrhttp.open("POST","/wlmtxt/User/User_noticeAllMyFans");
	xhrhttp.send(null);
	xhrhttp.onreadystatechange=function(){
		
		if(xhrhttp.readyState==4&&xhrhttp.status==200){
			var result=xhrhttp.responseText;
			console.log("result:"+result);
			if(result=="1"){
				toastr.success("全部关注成功！");
				listMyFansByPage(1);
			}else{
				toastr.error("全部关注失败！");
				return false;
			}
		}
	}
}
//查看是否关注
function checkFocus(focus_user_id) {
	var formData_check_focus = new FormData();
	formData_check_focus.append("accept_user.user_id", focus_user_id);
	var focus_xhr = new XMLHttpRequest();
	focus_xhr.open("POST", "/wlmtxt/User/User_isFollowedUser");
	focus_xhr.send(formData_check_focus);
	focus_xhr.onreadystatechange = function() {
		if (focus_xhr.readyState == 4 && focus_xhr.status == 200) {
			if (focus_xhr.responseText == "1") {
				console.log("已关注！");
				$(".focus_other").html("已关注");
				$(".focus_other").removeClass("user_operateing");
				$(".focus_other").addClass("not_focus");
			} else {
				console.log("未关注！");
				$(".focus_other").html("+ 关注");
				$(".focus_other").click(function(){
					withFocus(focus_user_id);
				})
			}
		}
	}
}
