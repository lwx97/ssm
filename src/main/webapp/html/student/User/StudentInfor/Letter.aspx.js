
//回显报到信息
function getMsg(){
	
	$.ajax({
		dataType : "json",
		type : "post",
		success : function(data){
			if(data.flag == "true"){
				//报到状态
				$('#Ctype1  option:selected').val(data.report_status);
				//到校方式
				var vs2 = $('#Ctype2  option:selected').val(data.report_type);
				//无法报到原因
				$('#Ctype3  option:selected').val(data.noReport);
				$("#Ctitle3").val(report_phone);
				$(".Wdate").val(report_time);
				$("#Ctitle1").val(title);
				$("#Ccontent").val(text);
				if(noReport!=""){
					
				}
			}
		},
		error : function(data){
			alert("error!");
		}
		
	});
}


function func(){
	var vs = $('#Ctype1  option:selected').val();
	if(vs==3){
		$("#tr1").hide();
		$("#tr2").hide();
		$("#tr3").show();
		$("#tr3").attr("class","true");
	}else{
		$("#tr1").show();
		$("#tr2").show();
		$("#tr3").hide();
		$("#tr3").attr("class","false");
	}
}


function sendReportInfo(){
	//报到状态
	var vs1 = $('#Ctype1  option:selected').val();
	//到校方式
	var vs2 = $('#Ctype2  option:selected').val();
	//无法报到原因
	var vs3 = $('#Ctype3  option:selected').val();
	var report_phone = $("#Ctitle3").val();
	var report_time = $(".Wdate").val();
	var title = $("#Ctitle1").val();
	var text = $("#Ccontent").val();
	//报到flag true为能报到，false不能
	var flag = true;
	if($("#tr3").attr("class")=="true"){
		flag = false;
		if(vs3 == "Unselected"){
			alert("请选择无法报到的原因！");
			return;
		}
	}else{
		if(vs1 == "Unselected"){
			alert("请选择报到状态！");
			return;
		}else if(vs2 == "Unselected"){
			alert("请选择到校方式！");
			return;
		}
	}
	if(report_phone==null || report_phone==""){
		alert("请填写联系方式！");
		return;
	}else if(report_phone.length!=11){
		alert("请检查你填写的联系方式！");
		return;
	}
	$.ajax({
		url : localhostPath() + "/info/sendReportInfo.do",
		data : {
			report_status : vs1,
			report_type : vs2,
			noReport : vs3,
			report_phone : report_phone,
			report_time : report_time,
			title : title,
			text : text
		},
		dataType : "json",
		type : "post",
		success : function(data){
			if(data.flag!=null){
				alert("提交成功！");//disabled="disabled"
				$('#Ctype1').attr("disabled","disabled");
				$('#Ctype2').attr("disabled","disabled");
				$('#Ctype3').attr("disabled","disabled");
				$("#Ctitle3").attr("disabled","disabled");
				$(".Wdate").attr("disabled","disabled");
				$("#Ctitle1").attr("disabled","disabled");
				$("#Ccontent").attr("disabled","disabled");
				$("#update").val("修改");
				$("#update").attr("onclick","");
			}else{
				alert("提交失败！");
			}
		},
		error : function(){
			alert("error!");
		}
	});
	
}