/**
 * 
 */
$(function(){
	listMyAttentionByPage(1);
});
function listMyAttentionByPage(pageIndex){
	var xhr=new XMLHttpRequest();
	var formData=new FormData();
	formData.append("myWorksVO.pageIndex",pageIndex);
	xhr.open("POST","/wlmtxt/Works/Works_listMyAttentionVO");
	xhr.send(formData);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var list_myAttention=JSON.parse(xhr.responseText);
			for(var i=0;i<list_myAttention.worksDTOList.length;i++){
				var list_myAttention='<li class="user_list">';
				list_myAttention+='<div class="user_list_img_div">';
				list_myAttention+='<img class="user_img" src="/wlmtxt/Works/Works_getImg?imgName=' +wddt_response.worksDTOList[i].works.works_cover +'"/>';
				list_myAttention+='</div>';
				list_myAttention+='<div class="user_info">';
				list_myAttention+='<div class="user_name">熊啊熊fh我比</div>';
				list_myAttention+='<div class="user_operateing">取消关注</div>';
				list_myAttention+='<div class="user_grjj">你不必想念，也无需忧怀，我与岁月山河同好，关于未来，自有承担。不必想念，也无需忧怀，我与</div>';
				list_myAttention+='</div>';
				list_myAttention+='</li>';
				$("#list_myAttention").append(list_myAttention);
				
			}
		}
	}
}