
getClassInfo();
function getClassInfo(){
	$.ajax({
		url : localhostPath() + "/user/getClassInfo.do",
		dataType : "json",
		type : "post",
		timeout:10000,
		success : function(data){
			var info = data.classInfo;
			$(".class_name").html(info.class_name);
			$(".class_master").html(info.class_master);
			$(".class_master_phone").html(info.class_master_phone);
			$(".school_name").html(info.school_name);
			$(".class_qq").html(info.class_qq);
			$(".class_title").html(info.class_title);
			$(".stu_id").html(info.stu_id);
			$(".name").html(info.name);
		},
		error : function(){
			alert("error!");
		}
	});
	
}