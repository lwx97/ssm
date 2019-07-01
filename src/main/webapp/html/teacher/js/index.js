

getStuInfo();
function getStuInfo(){
	$("#table1").show();
	$.ajax({
		url : localhostPath() + "/tea/getStuInfo.do",
		dataType : "json",
		type : "post",
		success:function(data){
			var list = data.list;
			$("#table1 table tbody").empty();
			for(var i=0;i<list.length;i++){
				$("#table1 table thead tr").empty();
				var status = "已报到";
				if(list[i].status == "0"){
					status = "未报到";
				}else if(list[i].status == "1"){
					status = "网上报到";
				}
				$("#table1 table thead tr").append("<th>学号</th><th>姓名</th><th>身份证号</th><th>性别</th><th>班级</th><th>报到状态</th>");
				$("#table1 table tbody").append(
						"<tr>"
						+"		<td>"+list[i].stu_id+"</td>"
						+"		<td>"+list[i].name+"</td>"
						+"		<td>"+list[i].card+"</td>"
						+"		<td>"+list[i].sex+"</td>"
						+"		<td>"+list[i].class_name+"</td>"
						+"		<td>"+status+"</td>"
						+"</tr>"	
				);
			}
			
		},
		error:function(){
			alert("error!");
		}
		
		
		
	});
	
	
}


//现场报到
function pageClick1(k) {
	$("#dai").hide();
	$("#form2").hide();
	$("#main").hide();
	$("#main1").hide();
	$("#table1").show();
	$("#form1").show();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	getStuInfo();
}
//查询单个学生信息
function selStuInfoById(id){
	
	if(id==null){
		id = $("#b333").val();
	}
	$("#table1").show();
	if(id=="" || id == null){
		getStuInfo();
		return;
	}
	$.ajax({
		url : localhostPath() + "/tea/selStuInfoById.do",
		dataType : "json",
		data : {
			id : id 
		},
		type : "post",
		success:function(data){
			var info = data.stuInfo;
			if(info!=null){
				$("#table1 table tbody").empty();
				$("#table1 table thead tr").empty();
				var status = "已报到";
				var caoz = "<td></td>";
				var caoz1 = "<td></td>";
				if(info.status == "0"){
					status = "未报到"
					caoz = "<td><a href='javascript:report()'>现场报到</a></td>";
				}else if(info.status == "1"){
					status = "网上报到";
					caoz = "<td><a href='javascript:report()'>现场报到</a></td>";
				}
				if(info.outlay=="未缴纳"){
					caoz1 = "<td><a href='javascript:jiaona("+info.stu_id+")'>确认缴纳</a></td>";
				}
				$("#table1 table thead tr").append("<th>学号</th><th>姓名</th><th>身份证号</th><th>性别</th><th>班级</th><th>报到状态</th>" +
						"<th id='t'>操作</th><th>学费缴纳</th><th id='t'>操作</th>"
				);
				$("#table1 table tbody").append(
						"<tr>"
						+"		<td id='td1'>"+info.stu_id+"</td>"
						+"		<td>"+info.name+"</td>"
						+"		<td>"+info.card+"</td>"
						+"		<td>"+info.sex+"</td>"
						+"		<td>"+info.class_name+"</td>"
						+"		<td>"+status+"</td>"
						+caoz
						+"<td>"+info.outlay+"</td>"
						+caoz1
						+"</tr>"	
				);
				
			}else{
				$("#table1").hide();
				alert("没有该学生！");
			}
		},
		error:function(){
			alert("error!");
		}
		
	});
}
//报到
function report(){
	var id = $("#td1").html();
	$.ajax({
		url : localhostPath() + "/tea/report.do",
		dataType : "json",
		data : {
			id : id 
		},
		type : "post",
		success:function(data){
			if(data.flag == "true"){
				selStuInfoById(id);
			}else{
				alert("报到失败！请重试！");
			}
		},
		error:function(){
			alert("error!");
		}
	});
}
//学生信息统计
function pageClick2(k) {
	$("#dai").hide();
	$("#form2").hide();
	$("#main").show();
	$("#main1").show();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	$("#table1").hide();
	$("#form1").hide();
	tongji();
}
var at1 = 200;
var at2 = 100;
var at3 = 120;
var bt1 = 200;
var bt2 = 100;
function chart(){
	var myChart = echarts.init(document.getElementById('main'));

	var option = {
	   
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        // orient: 'vertical',
	        // top: 'middle',
	        bottom: 10,
	        left: 'center',
	       
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '50%'],
	            selectedMode: 'single',
	            data:[
	                 
	                {value:at1, name: '已现场报名'+at1},
	                {value:at2, name: '未报名'+at2},
	                {value:at3, name: '网上填写报名'+at3}
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	myChart.setOption(option);
}
function chart1(){
	var myChart = echarts.init(document.getElementById('main1'));

	var option = {
	   
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        // orient: 'vertical',
	        // top: 'middle',
	        bottom: 10,
	        left: 'center',
	       
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '50%'],
	            selectedMode: 'single',
	            data:[
	                 
	                {value:bt1, name: '男生'+bt1},
	                {value:bt2, name: '女生'+bt2},
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};
	myChart.setOption(option);
}
//获得统计数据
function tongji(){
	$.ajax({
		url : localhostPath() + "/tea/getInfo.do",
		dataType : "json",
		type : "post",
		success:function(data){
			if(data.data!=null){
				at1 = data.data.at1;
				at2 = data.data.at2;
				at3 = data.data.at3;
				bt1 = data.data.bt1;
				bt2 = data.data.bt2;
				chart();
				chart1();
			}else{
				alert("未获得统计！");
			}
		},
		error:function(){
			alert("error!");
		}
	
});
}

//导出
function exportExcel(){  
    location.href=localhostPath()+"/tea/exporExcel.do";  
    <!--这里不能用ajax请求，ajax请求无法弹出下载保存对话框-->  
}

function updatePwd(k){
	$("#dai").hide();
	$("#main").hide();
	$("#main1").hide();
	$("#table1").hide();
	$("#form1").hide();
	$("#form2").show();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
}
function updatePwd1(){
	var p = $("#p").val();
	var p1 = $("#p1").val();
	var p2 = $("#p2").val();
	if(p1!=p2 || p1=="" || p =="" || p1==null || p==null){
		alert("两次输入不一致！");
		return;
	}
	$.ajax({
		url : localhostPath() + "/tea/updatePwd.do",
		dataType : "json",
		data:{
			p:p,
			p1:p1
		},
		type : "post",
		success:function(data){
			if(data!=null){
				if(data.flag=="true"){
					alert("修改成功！");
					loginOut();
				}else{
					alert("修改失败！");
				}
				
			}
		},
		error:function(){
			alert("error!");
		}
	
});
	
	
}
function jiaona(id){
	$.ajax({
		url : localhostPath() + "/tea/jiaona.do",
		dataType : "json",
		data:{
			id:id
		},
		type : "post",
		success:function(data){
			if(data!=null){
				alert("操作成功！");
				selStuInfoById(id);
			}else{
				alert("操作失败！");
			}
		},
		error:function(){
			alert("error!");
		}
	
});
}

function seldaikuan(k){
	$("#s").hide();
	$("#dai").show();
	$("#main").hide();
	$("#main1").hide();
	$("#table1").hide();
	$("#form1").hide();
	$("#form2").hide();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	$("#stu_id").val("");
	$("#name").val("");
	$('#fs').val("");
	$("#phone").val("");
	$("#add").val("");
	$("#ps").val("");
	$("#card").val("");
	$("#b1").val("");
}

var did = null;
//查询贷款信息
function seldaikuanInfo(){
	$("#s").show();
	var id = $("#b1").val();
	if(id==""||id==null){
		alert("请填写！");
		return;
	}
	$.ajax({
		url : localhostPath() + "/tea/seldaikuanInfo.do",
		dataType : "json",
		data:{
			id:id
		},
		type : "post",
		success:function(data){
			var info = data.info;
			if(info!=null){
				$("#stu_id").val(info.stu_id);
				$("#name").val(info.name);
				if(info.fs=="1"){
					$('#fs').val("生源地助学贷款");
				}else{
					$('#fs').val("国家助学贷款");
				}
				$("#phone").val(info.phone);
				$("#add").val(info.adderss);
				$("#ps").val(info.ps);
				$("#card").val(info.card);
			}
			if(info.status!=0){
				$("#s").attr("disabled","disabled");
				$("#s").html("已审批");
			}else{
				did = id;
			}
		},
		error:function(){
			alert("error!");
		}
	
});
}
function save(){
	alert();
	if(did!=null){
		$.ajax({
			url : localhostPath() + "/tea/updatedaikuanInfo.do",
			dataType : "json",
			data:{
				id:did
			},
			type : "post",
			success:function(data){
				if(data!=null){
					alert("审批成功！");
					seldaikuanInfo();
				}
			},
			error:function(){
				alert("error!");
			}
		
	});
	}
}