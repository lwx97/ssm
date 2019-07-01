seldaikuanInfo();
function seldaikuanInfo(){
	$.ajax({
		url : localhostPath() + "/info/seldaikuanInfo.do",
		dataType : "json",
		type : "post",
		success:function(data){
			var info = data.info;
			if(info!=null){
				$('#Ctype2').attr("disabled","disabled");
				$("#phone").attr("disabled","disabled");
				$("#name").attr("disabled","disabled");
				$("#add").attr("disabled","disabled");
				$("#ps").attr("disabled","disabled");
				$("#card").attr("disabled","disabled");
				$("#name").val(info.name);
				$('#Ctype2').val(info.fs);
				$("#phone").val(info.phone);
				$("#add").val(info.adderss);
				$("#ps").val(info.ps);
				$("#card").val(info.card);
				$("#update").hide();
			}
			
		},
		error : function(){
			alert("出错！");
		}
	});
}



function daikuan(){
	var name = $("#name").val();
	var fs = $('#Ctype2  option:selected').val();
	var phone = $("#phone").val();
	var adderss = $("#add").val();
	var ps = $("#ps").val();
	var card = $("#card").val();
	if(name==""||fs==""||phone==""||adderss==""||card==""){
		alert("请将资料填完整！");
		return;
	}
	$.ajax({
		url : localhostPath() + "/info/daikuan.do",
		data : {
			name : name,
			fs : fs,
			phone : phone,
			adderss : adderss,
			ps : ps,
			card : card
		},
		dataType : "json",
		type : "post",
		success:function(data){
			if(data!=null){
				$('#Ctype2').attr("disabled","disabled");
				$("#phone").attr("disabled","disabled");
				$("#name").attr("disabled","disabled");
				$("#add").attr("disabled","disabled");
				$("#ps").attr("disabled","disabled");
				$("#card").attr("disabled","disabled");
				alert("提交成功！");
			}else{
				alert("提交失败！");
			}
			
		},
		error : function(){
			alert("出错！");
		}
	});
}