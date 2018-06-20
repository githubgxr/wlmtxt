/**
 * 
 */
/*获得所有一级分类*/
$(function(){
	var xmlhttp=null;
	var category_vo=null;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			category_vo = JSON.parse(xmlhttp.responseText);
			/*获得一级分类头部*/
			for ( var num in category_vo) {
				var new_a = null;
				var div_box = document.getElementById("div_box");
				new_a = document.createElement("a");
				new_a.className = "category_a";
				new_a.appendChild(document.createTextNode(category_vo[num].first_menu_name));
				div_box.appendChild(new_a);
				new_a.id=category_vo[num].first_menu_id;
				/*new_a.href = "/wlmtxt/Works/Works_listSecondMenu?first_menu.first_menu_id="+category_vo[num].first_menu_id;*/
				new_a.onclick=function(){
					getSecondMenu(this.id);
				}
				
				/*获得一级分类作品列表*/
				var ul_li=null;//ul下的li
				var li_a=null;//li下的a
				var li_div=null;//li下的div
				var llls_list_container=document.getElementById("llls_list_container");//得到ul的id
				
				ul_li=document.createElement("li");
				li_a=document.createElement("a");
				li_div=document.createElement("div");
				
				ul_li.className="list_video_item";
				ul_li.style.margin=" 0 5px 20px 5px";
				li_a.className="video_list_item_wrap";
				li_div.className = "video_label";
				
				ul_li.appendChild(li_a);
				ul_li.appendChild(li_div);
				llls_list_container.appendChild(ul_li);
				
				var a_div1=null;//a下的div1
				var a_div2=null;//a下的div2
				a_div1=document.createElement("div");
				a_div2=document.createElement("div");
				a_div1.className="video_cover";
				a_div2.className="video_info";
				
				li_a.appendChild(a_div1);
				li_a.appendChild(a_div2);
				
				var a_div1_img=null;//a下的div1下的Img
				var a_div1_div1=null;//a下的div1下的div1
				var a_div1_div2=null;//a下的div1下的div2
				
				a_div1_img=document.createElement("img");
				a_div1_div1=document.createElement("div");
				a_div1_div2=document.createElement("div");
				
				a_div1_img.className="video_img";
				/*a_div1_img.src="css/zb/img/4.png";*/
				a_div1_div1.className="video_overplay";
				a_div1_div2.className="video_play";
				
				a_div1.appendChild(a_div1_img);
				a_div1.appendChild(a_div1_div1);
				a_div1.appendChild(a_div1_div2);
				
				var a_div2_div1=null;//a下的div2的div1
				var a_div2_div2=null;//a下的div2的div2
				var a_div2_div3=null;//a下的div2的div3
				
				a_div2_div1=document.createElement("div");
				a_div2_div2=document.createElement("div");
				a_div2_div3=document.createElement("div");
				
				a_div2_div1.className="video_title";
				a_div2_div2.className="video_number";
				a_div2_div3.className="video_username";
				
				a_div2_div1.innerHTML="德科恶女合家福好地方好地方";
				a_div2_div2.innerHTML="425";
				a_div2_div3.innerHTML="发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr";
				
				a_div2.appendChild(a_div2_div1);
				a_div2.appendChild(a_div2_div2);
				a_div2.appendChild(a_div2_div3);
				
				var li_div_div=null;//li下的div下的div
				var li_div_div_a=null;//li下的div下的div下的a
				
				li_div_div=document.createElement("div");
				li_div_div_a=document.createElement("a");
				
				li_div_div.className="video_label_content";
				li_div_div_a.className="video_label_item";
				
				li_div_div_a.innerHTML="绝地求生";
				
				li_div_div.appendChild(li_div_div_a);
				li_div.appendChild(li_div_div);
				
			}
		}
	}
	xmlhttp.open("POST","/wlmtxt/Works/Works_listFirstMenu");
	xmlhttp.send(null);	
})

/*移除一级分类，显示二级*/
function getSecondMenu(first_menu_id){
	console.log(first_menu_id)
	var xhr=false;
	var secondMenuList=null;
	
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			secondMenuList=JSON.parse(xhr.responseText);
			
			/*移出所有一级菜单*/
			var old_a = document.getElementsByClassName("category_a");
			var long = old_a.length;
			for (var i = 0; i < long; i++) {
				old_a[0].parentNode.removeChild(old_a[0]);
			}
			
			/*移出所有一级列表*/
			var old_li = document.getElementsByClassName("list_video_item");
			var long = old_li.length;
			for (var i = 0; i < long; i++) {
				old_li[0].parentNode.removeChild(old_li[0]);
			}
			
			for(var num in secondMenuList){
				var new_a=null;
				var div_box=document.getElementById("div_box");
				new_a=document.createElement("a");
				new_a.className="category_a";
				new_a.append(document.createTextNode(secondMenuList[num].second_menu_name));
				div_box.appendChild(new_a);
				new_a.id=secondMenuList[num].second_menu_id;
				
				/*获得一级分类作品列表*/
				var ul_li=null;//ul下的li
				var li_a=null;//li下的a
				var li_div=null;//li下的div
				var llls_list_container=document.getElementById("llls_list_container");//得到ul的id
				
				ul_li=document.createElement("li");
				li_a=document.createElement("a");
				li_div=document.createElement("div");
				
				ul_li.className="list_video_item";
				ul_li.style.margin=" 0 5px 20px 5px";
				li_a.className="video_list_item_wrap";
				li_div.className = "video_label";
				
				ul_li.appendChild(li_a);
				ul_li.appendChild(li_div);
				llls_list_container.appendChild(ul_li);
				
				var a_div1=null;//a下的div1
				var a_div2=null;//a下的div2
				a_div1=document.createElement("div");
				a_div2=document.createElement("div");
				a_div1.className="video_cover";
				a_div2.className="video_info";
				
				li_a.appendChild(a_div1);
				li_a.appendChild(a_div2);
				
				var a_div1_img=null;//a下的div1下的Img
				var a_div1_div1=null;//a下的div1下的div1
				var a_div1_div2=null;//a下的div1下的div2
				
				a_div1_img=document.createElement("img");
				a_div1_div1=document.createElement("div");
				a_div1_div2=document.createElement("div");
				
				a_div1_img.className="video_img";
				/*a_div1_img.src="css/zb/img/4.png";*/
				a_div1_div1.className="video_overplay";
				a_div1_div2.className="video_play";
				
				a_div1.appendChild(a_div1_img);
				a_div1.appendChild(a_div1_div1);
				a_div1.appendChild(a_div1_div2);
				
				var a_div2_div1=null;//a下的div2的div1
				var a_div2_div2=null;//a下的div2的div2
				var a_div2_div3=null;//a下的div2的div3
				
				a_div2_div1=document.createElement("div");
				a_div2_div2=document.createElement("div");
				a_div2_div3=document.createElement("div");
				
				a_div2_div1.className="video_title";
				a_div2_div2.className="video_number";
				a_div2_div3.className="video_username";
				
				a_div2_div1.innerHTML="德科恶女合家福好地方好地方";
				a_div2_div2.innerHTML="425";
				a_div2_div3.innerHTML="发杜师傅女是不是的看法和gewgrgegerbhrtehtrnjr";
				
				a_div2.appendChild(a_div2_div1);
				a_div2.appendChild(a_div2_div2);
				a_div2.appendChild(a_div2_div3);
				
				var li_div_div=null;//li下的div下的div
				var li_div_div_a=null;//li下的div下的div下的a
				
				li_div_div=document.createElement("div");
				li_div_div_a=document.createElement("a");
				
				li_div_div.className="video_label_content";
				li_div_div_a.className="video_label_item";
				
				li_div_div_a.innerHTML="王者荣耀";
				
				li_div_div.appendChild(li_div_div_a);
				li_div.appendChild(li_div_div);
				
			}
		}
	}
	xhr.open("POST","/wlmtxt/Works/Works_listSecondMenu_byFirstMenuID");
	var formData=new FormData();
	formData.append("first_menu.first_menu_id",first_menu_id);
	xhr.send(formData);
}
