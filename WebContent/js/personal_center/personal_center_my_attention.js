/**
 * 
 */
$(function(){
	listMyAttentionByPage(1);
});
function listMyAttentionByPage(pageIndex){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myAttentionVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/Works/Works_listMyAttentionVO");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list_myAttention=JSON.parse(xhr.responseText);
			for(var i=0;i<list_myAttention.followDTO.length;i++){
				var list_myAttention='<li class="user_list">';
				list_myAttention+='<div class="user_list_img_div">';
				list_myAttention+='<img class="user_img" src="/wlmtxt/Works/Works_getImg?imgName=' +list_myAttention.followDTO[i].works.works_cover +'"/>';
				list_myAttention+='</div>';
				list_myAttention+='<div class="user_info">';
				list_myAttention+='<div class="user_name">'+list_myAttention.followDTO[i].user.user_username+'</div>';
				list_myAttention+='<div class="user_operateing" onclick="cancelFocus(this.id)" id="'+list_myAttention.followDTO[i].user.user_id+'">取消关注</div>';
				list_myAttention+='<div class="user_grjj">'+list_myAttention.followDTO[i].user.user_bio+'</div>';
				list_myAttention+='</div>';
				list_myAttention+='</li>';
				$("#list_myAttention").append(list_myAttention);
				
			}
		}
	}
}

/*取消单个用户关注*/
function cancelFocus(focus_user_id){
	console.log("focus_user_id:"+focus_user_id);
	var xhrhp=new XMLHttpRequest();
	xhrhp.open("POST","/wlmtxt/Works/Works_deleteMyWorks");
	var formData=new FormData();
	formData.append("accept_works.works_id",focus_user_id);
	xhrhp.send(formData);
	xhrhp.onreadystatechange=function(){
		if(xhrhp.readyState==4&&xhrhp.status==200){
			if(xhrhp.responseText=="1"){
				toastr.success("取消关注成功！");
				listMyAttentionByPage(1);
			}else{
				toastr.error("取消关注失败！");
				return false;
			}
		}
	}
}

//取消关注全部用户
function cancelAllFocus(){
	var xhrhttp=new XMLHttpRequest();
	xhrhttp.open("POST","/wlmtxt/Works/Works_deleteAllMyWorks");
	xhrhttp.send(null);
	xhrhttp.onreadystatechange=function(){
		if(xhrhttp.readyState==4&&xhrhttp.status==200){
			if(xhrhttp.responseText=="1"){
				toastr.success("取消关注全部用户成功！");
				listMyAttentionByPage(1);
			}else{
				toastr.error("取消关注全部用户失败！");
				return false;
			}
		}
	}
}
