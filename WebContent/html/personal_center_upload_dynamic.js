/**
 * 
 */
var xmlhttp;
function releaseWorks(){
	XMLHttp();
	var works_classification=document.getElementById("works_classification").innerText;
	var input_title=document.getElementById("input_title").value;
	var works_describe=document.getElementById("works_describe").innerText;
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			
			
		}
	}
	xmlhttp.open("POST","",true);
	Formdata formdata=new Formdata();
	xmlhttp.send();
}

function selectImg(){
	 $(function() {
	        $(".filepath").on("change",function() {
	            var srcs = getObjectURL(this.files[0]);   //获取路径
	            $(this).nextAll(".img1").hide();   //this指的是input
	            $(this).nextAll(".img2").show();  //fireBUg查看第二次换图片不起做用
	            $(this).nextAll('.close').show();   //this指的是input
	            $(this).nextAll(".img2").attr("src",srcs);    //this指的是input
	            $(this).val('');    //必须制空
	        })
	    })

	    function getObjectURL(file) {
	        var url = null;
	        if (window.createObjectURL != undefined) {
	            url = window.createObjectURL(file)
	        } else if (window.URL != undefined) {
	            url = window.URL.createObjectURL(file)
	        } else if (window.webkitURL != undefined) {
	            url = window.webkitURL.createObjectURL(file)
	        }
	        return url
	    };

	    $(function() {
	        $("#img").on("change",".filepath1",function() {
	            var srcs = getObjectURL(this.files[0]);   //获取路径
	            //this指的是input
	            $(this).nextAll(".img22").attr("src",srcs);    //this指的是input
	            $(this).nextAll(".img22").show();  //fireBUg查看第二次换图片不起做用*/
	            var htmlImg='<div class="imgbox1">'+
	                    '<div class="imgnum1">'+
	                    '<input type="file" class="filepath1" />'+
	                    '<span class="close1">X</span>'+
	                    '<img src="btn.png" class="img11" />'+
	                    '<img src="'+srcs+'" class="img22" />'+
	                    '</div>'+
	                    '</div>';

	            $(this).parent().parent().before(htmlImg);
	            $(this).val('');    //必须制空
	            $(this).parent().parent().prev().find(".img11").hide();   //this指的是input
	            $(this).parent().parent().prev().find('.close1').show();

	        })
	    })

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