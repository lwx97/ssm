
getMyInfo();
function getMyInfo(){
	$.ajax({
		url: localhostPath() + "/user/getMyInfo.do",
		dataType:'json',//服务器返回json格式数据
		type:'post',//HTTP请求类型
		timeout:10000,//超时时间设置为10秒；
		success:function(data){
			var info = data.myInfo;
			$(".name").html(info.name+"&nbsp;");
			$(".stu_id").html(info.stu_id+"&nbsp;");
			$(".sex").html(info.sex+"&nbsp;");
			$(".card").html(info.card+"&nbsp;");
			$(".qq").html(info.qq+"&nbsp;");
			$(".address").html(info.address+"&nbsp;");
			$(".enrol_batch").html(info.enrol_batch+"&nbsp;");
			$(".email").html(info.email+"&nbsp;");
			$(".phone").html(info.phone+"&nbsp;");
			$(".status").html(info.status+"&nbsp;");
			$(".tu_major").html(info.tu_major+"&nbsp;");
			$(".enrol_time").html(info.enrol_time+"&nbsp;");
			if(info.exam_type=="1"){
				$(".exam_type").html("统招&nbsp;");
			}else if(info.exam_type=="2"){
				$(".exam_type").html("自考&nbsp;");
			}
			
		},
		error:function(){
			alert("error!");
		}
	});
}