/**
 * 
 */
var xmlhttp;
var category_vo=null;
window.onload=function(){
	XMLHttp();
	console.log(111);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			console.log(111);
			category_vo = JSON.parse(xmlhttp.responseText);
			var new_a = null;
			var div_box = document.getElementById("div_box");

			/*
			 * 移出除标题以外的所有行
			 */
			var old_a = document.getElementsByClassName("category_a");
			var long = old_a.length;
			for (var i = 0; i < long; i++) {
				old_a[0].parentNode.removeChild(old_a[0]);
			}			
			/*
			 * 将数据库的数据取出来放到表格里
			 */
			for (var num = 0; num < category_vo.statisticPoliceCaseDto.length; num++) {
				new_a = document.createElement("a");
				new_a.className = "category_a";
				new_a.appendChild(document.createTextNode(''));
				div_box.append(new_a);
				
				new_a.innerHTML = category_vo.statisticPoliceCaseDto[num].department.department_name;
				new_a.href = "/ajdbxt/total/Total_page_caseInfoList?totalcase=2&policeId="+policeId+"&select_start_time="
				+select_start_time+"&select_stop_time="+select_stop_time;
			}

		}
	}
	xmlhttp.open("POST","url",true);
	var formData=new FormData();
	xmlhttp.send(formData);
	
}


function XMLHttp(){
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
}