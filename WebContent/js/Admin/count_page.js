
	$(".input_date").bind("change",function(){
		List_Total_By_Department();
	});


	function getXMLHttp() {
		if (window.XMLHttpRequest) {
			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xhr = new XMLHttpRequest();
		} else {
			// IE6, IE5 浏览器执行代码
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	

	function List_Total_By_Department(){
		
		var e_str=null;
		getXMLHttp();	
		var select_start_time=document.getElementById("select_start_time").value+" 00:00:00";
		var select_stop_time=document.getElementById("select_stop_time").value+" 23:59:59";
		
		
		xhr.onreadystatechange=function(){
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
				countVO=JSON.parse(xhr.responseText);
				var data_list = countVO.CountDTOList;
					var str = '';
					for (var len = 0; len < data_list.length; len++){
						str += '<tr>';
						str += '<td>' +  (len + 1) + '</td>';// 序号
						str += '<td>' +data_list[len].second_menu.second_menu_name		
								+ '</td>';// 
						str += '<td>'
								+data_list[len].works
								+ '</td>';
					
						str += '<td>'
							+ data_list[len].history	
							+ '</td>'; 
						
							str += '</tr>';
						
					}
					// 加载案件列表到表格中
					$('.COUNT tbody').html(str); // 操作点击事件
		}
       }
	}
		xhr.open("POST","/wlmtxt/Admin/Admin_count",true);
		var formData=new FormData();
	
		formData.append("countVO.start_time",select_start_time);
		formData.append("countVO.stop_time",select_stop_time);
		xhr.send(formData);
	}