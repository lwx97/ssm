

var list = null;

getNoticeList();

function getNoticeList(){
	
	$.ajax({
		url : localhostPath() + "/notice/getNoticeList.do",
		dataType : "json",
		type : "post",
		success : function(data){
			list = data.noticeList;
			$(".tabula-box ul").find("li").remove();
			for(var i=0;i<list.length;i++){
				$(".tabula-box ul").append(
						"<li><a href='javascript:getValue("+list[i].id+");'>"+list[i].menu_name+"</a></li>"
						);
				if(i==0){
					$(".content-box h1").html(list[i].menu_name);
					$(".content-box .content").html(list[i].menu_value);
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
	for(var i=0;i<list.length;i++){
		if(list[i].id==id){
			$(".content-box h1").html(list[i].menu_name);
			$(".content-box .content").html(list[i].menu_value);
			$(".tit-80 span").html(list[i].menu_name);
		}
	}
}