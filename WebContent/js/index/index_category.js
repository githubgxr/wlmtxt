/**
 * 
 */
/*获得所有一级分类*/
$(function(){
	var xmlhttp=null;
	var category_vo=null;
	xmlhttp=new XMLHttpRequest();
	console.log(111);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			console.log(xmlhttp.responseText);
			category_vo = JSON.parse(xmlhttp.responseText);
			
			for ( var num in category_vo) {
				var new_a = null;
				var div_box = document.getElementById("div_box");
				new_a = document.createElement("a");
				new_a.className = "category_a";
				new_a.appendChild(document.createTextNode(category_vo[num].first_menu_name));
				div_box.appendChild(new_a);
				new_a.id=category_vo[num].first_menu_id;
				new_a.href = "/wlmtxt/Works/Works_listSecondMenu?aaaaa="+category_vo[num].first_menu_id;
			}
			/*$('#' + new_a.id).selectpicker('refresh');	*/
		}
		toastr.error(xmlhttp.status);
	}
	xmlhttp.open("POST","/wlmtxt/Works/Works_listFirstMenu");
	var formData=new FormData();
	xmlhttp.send(null);	
})

/*移除一级分类，显示二级*/
function getSecondMenu(){
	var xhr=false;
	var categorySecond_vo=null;
	
	
	 /*移出所有一级菜单*/
	var old_a = document.getElementsByClassName("category_a");
	var long = old_a.length;
	for (var i = 0; i < long; i++) {
		old_a[0].parentNode.removeChild(old_a[0]);
	}
	
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			categorySecond_vo=JSON.parse(xhr.responseText);
			for(var num in categorySecond_vo){
				var new_a=null;
				var div_box=document.getElementById("div_box");
				new_a=document.createElement("a");
				new_a.className="category_a";
				new_a.append(document.createTextNode(categorySecond_vo[num].second_menu_name));
				div_box.appendChild(new_a);
			}
		}
	}
	xhr.open("POST","/wlmtxt/Works/Works_listSecondMenu");
	xhr.send(null);
}
