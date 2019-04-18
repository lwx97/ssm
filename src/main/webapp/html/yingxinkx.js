

var url = window.location.href;
index = url.indexOf("flag");
if(index != -1){
	var start = url.indexOf("A");  
    var id = url.substring(start + "A".length+1);
    getNewsFlashList(false);
    getNewsFlashById(id);
}else{
	getNewsFlashList(true);
}


function getNewsFlashList(flag){
	$.ajax({
		url : localhostPath() + "/newsAll/getNewsFlashList.do",
		dataType : "json",
		success : function(data){
			$(".tabula-box ul").find("li").remove();
			$(".content-box ul").find("li").remove(); 
			//获取要闻类型
			for(var i=0;i<data.typeList.length;i++){
				$(".tabula-box ul").append(
						"<li><a href='javascript:getNewsFlashListByTypeId("+data.typeList[i].id+");'>"+data.typeList[i].news_type_name+"</a></li>"
				);
			}
//			$("tit-80 span").html(data.typeList[0].news_type_name());
			if(flag){
				//获取第一种类型下的新闻
				for(var i=0;i<data.newsFlashList.length;i++){
					$(".content-box ul").append(
							"<li class='text'><a href='javascript:getNewsFlashById("+data.newsFlashList[i].id+");'>"+data.newsFlashList[i].nf_title+"</a><span>"+data_string(data.newsFlashList[i].nf_time,0)+"</span></li>"
					);
				}
			}
			
		},
		error : function(){
			alert("出错了！");
		}
	});
}

function getNewsFlashListByTypeId(typeid){
	$.ajax({
		url : localhostPath() + "/newsAll/getNewsFlashListByTypeId.do",
		dataType : "json",
		data :{
			typeid : typeid
		},
		success : function(data){
//			$("tit-80 span").html(typename);
			$(".content-box ul").find("li").remove(); 
			$(".text").html("");
			$(".content-box h1").html("新闻类型列表标题")
			for(var i=0;i<data.newsFlashList.length;i++){
				$(".content-box ul").append(
						"<li class='text'><a href='javascript:getNewsById("+data.newsFlashList[i].id+");'>"+data.newsFlashList[i].nf_title+"</a><span>"+data_string(data.newsFlashList[i].nf_time,0)+"</span></li>"
				);
			}
		},
		error : function(){
			alert("出错了！");
		}
	});
}
function getNewsFlashById(id){
		$.ajax({
			url : localhostPath() + "/newsAll/getNewsFlashById.do",
			data:{
				id : id
			},
			dataType : "json",
			success : function(data){
				$(".content-box ul").find("li").remove();
				$(".text").html(data.newsFlash.nf_text);
				$(".content-box h1").html(data.newsFlash.nf_title);
			},
			error : function(){
				alert("出错了！");
			}
		});
}
