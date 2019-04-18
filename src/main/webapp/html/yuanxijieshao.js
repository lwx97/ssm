


var url = window.location.href;
index = url.indexOf("flag");
if(index != -1){
	var start = url.indexOf("A");  
    var id = url.substring(start + "A".length+1);
    getCollegeList(false);
    getCollegeById(id);
}else{
	getCollegeList(true);
}

	
function getCollegeList(flag){
	$.ajax({
		type : "post",
		dataType : "json",
//		async : false,
		url : localhostPath()+"/college/getCollegeList.do",
		success : function(data){
			for(var i=0; i< data.collegeList.length;i++){
				$(".tabula-box ul").append(
						"<li><a href='javascript:getCollegeById("+data.collegeList[i].id+");'>"+data.collegeList[i].college_name+"</a></li>"
				);
				if(flag){
					if(i==0){
						$(".tit-80 span").html(data.collegeList[i].college_name);
						$(".content-box h1").html(data.collegeList[i].college_name);
						$(".content").html(data.collegeList[i].college_text);
						
						$(".prv a").html("上一篇：无！");
						$(".prv a").removeAttr('href');
						if(i+1<data.collegeList.length){
							$(".next a").html("下一篇："+data.collegeList[i+1].college_name);
							$(".next a").attr("href","javascript:getCollegeById("+data.collegeList[i+1].id+");");
						}else{
							$(".next a").html("下一篇：无！");
							$(".next a").removeAttr('href');
						}
						
					}
				}
			}
		},
		error : function(){
			alert("出错了！");
		}
		
	});
}

function getCollegeById(id){
	$.ajax({
		type : "post",
		dataType : "json",
		url : localhostPath()+"/college/getCollegeById.do",
		data : {
			id : id
		},
		success : function(data){
			$(".tit-80 span").html(data.college.college_name);
			$(".content-box h1").html(data.college.college_name);
			$(".content").html(data.college.college_text);
		},
		error : function(){
			alert("出错了！");
		}
	});
}