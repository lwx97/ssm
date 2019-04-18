

var list = null;
var resList = null;

getAfficheList();

function getAfficheList(){
	
	$.ajax({
		url : localhostPath() + "/affiche/getAfficheList.do",
		dataType : "json",
		type : "post",
		success : function(data){
			list = data.afficheList;
			$(".tabula-box ul").find("li").remove();
			for(var i=0;i<list.length;i++){
				$(".tabula-box ul").append(
						"<li><a href='javascript:getValue("+list[i].id+");'>"+list[i].menu_name+"</a></li>"
						);
				if(i==0){
					$("#content-box1 h1").html(list[i].menu_name);
					$("#content-box1 .content").html(list[i].menu_value);
					$(".tit-80 span").html(list[i].menu_name);
				}
			}
			
		},
		error : function(){
			alert("出错了！");
		}
	});
}



function getValue(id){
//	tuition 学费     res物品
	for(var i=0;i<list.length;i++){
		if(id==list[i].id){
			$(".tit-80 span").html(list[i].menu_name);
			$("#content-box1 h1").html(list[i].menu_name);
			if(list[i].menu_value=="res"){
				getResList();
			}else if(list[i].menu_value=="tuition"){
				getTuitionList();
			}else{
				$("#content-box2").hide();
				$("#content-box1").show();
				$("#content-box1 h1").html(list[i].menu_name);
				$("#content-box1 .content").html(list[i].menu_value);
			}
		}
	}
	
}


function getResList(){
	$("#content-box1").hide();
	$("#content-box2").show();
	$.ajax({
		url : localhostPath() +"/res/getResList.do",
		dataType : "json",
		type : "post",
		success : function(data){
			resList = data.resList;
			$("#content-box2 ul").find("li").remove();
			for(var i=0;i<resList.length;i++){
				$("#content-box2 ul").append(
						'<li class="pic">'+
		            	'<div class="img-box">'+
	                	'<a href="javascript:getOneRes('+resList[i].res_id+');" >'+
	                	'<img src="'+resList[i].res_image+'"></a></div>'+
	                	'<h3><a href="javascript:0;">'+resList[i].res_title+'</a></h3></li>'
				);
			}
		},
		error : function(){
			alert("出错了！");
		}
	});
}

function getOneRes(id){
	for(var i=0;i<resList.length;i++){
		if(id==resList[i].res_id){
			$("#content-box2").hide();
			$("#content-box1 h1").html(resList[i].res_title);
			var s = '<div class="center450">'+
		       ' <p><img src="'+resList[i].res_image+'" align="left">'+
			'<p id="res_text">'+resList[i].res_text+'</p></div><div><h4>丢失时间：'+data_string(resList[i].res_time)+'</h4></div>';
			$("#content-box1 .content").html(s);
			$("#content-box1").show();
		}
	}
}

function getTuitionList(){
	//学费暂时没写。准备花个表格！。
	$("#content-box2").hide();
	$("#content-box1").show();
	$.ajax({
		url : localhostPath() +"/college/getTuitionList.do",
		dataType : "json",
		type : "post",
		success : function(data){
			var tr = "";
			var list = data.tuitionList;
			for(var i=0;i<list.length;i++){
				tr = tr +'<tr>'
		        +'<td>'+list[i].college_name+'</td>'
		        +'<td>'+list[i].tu_major+'</td>'
		        +'<td>'+list[i].tu_price1+'</td>'
		        +'<td>'+list[i].tu_price2+'</td>'
		        +'<td>'+list[i].tu_price3+'</td>'
		        +'<td>'+list[i].tu_price4+'</td>'
		    +'</tr>';
			}
			$("#content-box1 .content").html(
				'<table cellspacing="0" id="tech-companies-1" class="table table-sm table-bordered table-striped"><thead><tr>'
    				+'<th>院系</th>'
					+'<th>专业</th>'
					+'<th>第一学年</th>'
					+'<th>第二学年</th>'
					+'<th>第三学年</th>'
					+'<th>第四学年</th>'
				+'</tr></thead><tbody>'
				+ tr
			    +'</tbody></table>'
		  );
		},
		error : function(){
			alert("出错了！");
		}
	});
	
}









