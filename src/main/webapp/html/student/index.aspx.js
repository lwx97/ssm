getIndex();
function getIndex(){
	$.ajax({
		url : localhostPath() + "/user/getIndex.do",
		dataType : "json",
		type : "post",
		success : function(data){
			$(".name").html(data.name);
			$("#stu_id").html(data.stu_id);
			$("#outlay_need_all").html(data.outlay_need_all);
			$("#outlay_yes_all").html(data.outlay_yes_all);
			$("#outlay_no_all").html(data.outlay_no_all);
			$("#outlay_ps_count").html(data.outlay_ps_count);
		},
		error : function(){
			alert("error!");
		}
	});
}