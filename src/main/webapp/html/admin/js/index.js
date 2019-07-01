getMenuType();
function getInfo(){
	$("#table1").show();
	$("#c2").show();
	$.ajax({
		url : localhostPath() + "/admin/getInfo.do",
		dataType : "json",
		type : "post",
		success:function(data){
			var list = data.list;
			$("#table1 table tbody").empty();
			for(var i=0;i<list.length;i++){
				$("#table1 table thead tr").empty();
				var role = "教师";
				if(list[i].role == "3"){
					role = "超级管理员"
				}
				$("#table1 table thead tr").append("<th>账号</th><th>姓名</th><th>角色</th><th>操作</th>");
				$("#table1 table tbody").append(
						"<tr>"
						+"		<td>"+list[i].account+"</td>"
						+"		<td>"+list[i].name+"</td>"
						+"		<td>"+role+"</td>"
						+"		<td><a onclick='update("+list[i].userid+")'>修改权限</a></td>"
						+"</tr>"	
				);
			}
			
		},
		error:function(){
			alert("error!");
		}
		
		
		
	});
	
	
}
//修改权限
function update(id){
	$.ajax({
		url : localhostPath() + "/admin/updatePower.do",
		dataType : "json",
		data : {
			id : id 
		},
		type : "post",
		success:function(data){
			if(data.flag!=null){
				getInfo();
			}else{
				alert("修改权限出错！");
			}
		},
		error:function(){
			alert("error!");
		}
	});
}



//网站维护
function pageClick1(k) {
	$("#txt").val("");
	$("#c3").hide();
	$("#c1").hide();
	getInfo();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	getMenuType();
}


//权限管理
function pageClick2(k) {
	$("#b1").val("");
	$("#b2").val("");
	$("#txt").val("");
	$("#c3").hide();
	$("#table1").hide();
	$("#c2").hide();
	$("#c1").show();
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	$("#table1").hide();
	$("#form1").hide();
}
var mt = null;
//获取菜单类型
function getMenuType(){
	$.ajax({
		url : localhostPath() + "/admin/getMenuType.do",
		dataType : "json",
		type : "post",
		success:function(data){
			mt = data.mt;
			$("#u1").empty();
			for(var i=0;i<mt.length;i++){
				$("#u1").append(
						"<li><a href='javascript:getMenu("+mt[i].id+");'>"+mt[i].type_name+"</a></li>"
				);
			}
		},
		error:function(){
			alert("error!");
		}
	});
}
//获取功能
var list = null;
var mid = null;
function getMenu(id){
	for(var i=0;i<mt.length;i++){
		if(mt[i].id==id){
			$("#b1").val(mt[i].type_name);
			$("#b2").val("");
			$("#txt").val("");
		}
	}
	
	$.ajax({
		url : localhostPath() + "/admin/getMenu.do",
		dataType : "json",
		data:{
			id : id
		},
		type : "post",
		success:function(data){
			var m = data.mList;
			list = m;
			$("#u2").empty();
			for(var i=0;i<m.length;i++){
				$("#u2").append(
						"<li><a href='javascript:getMenuInfo("+m[i].id+");'>"+m[i].menu_name+"</a></li>"
				);
			}
		},
		error:function(){
			alert("error!");
		}
	});
}
//给文本框赋值
function getMenuInfo(id){
	mid = id;
	for(var i=0;i<list.length;i++){
		if(list[i].id==id){
			$("#b2").val(list[i].menu_name);
			$("#txt").val(list[i].menu_value);
		}
	}
}
function saveInfo(){
	var txt = $("#txt").val();
	if(mid==null||mid==""||txt==""||txt==null){
		alert("请选择！");
		return;
	}
	$.ajax({
		url : localhostPath() + "/admin/saveInfo.do",
		dataType : "json",
		data:{
			id : mid,
			txt : txt
		},
		type : "post",
		success:function(data){
			if(data!=null){
				alert("保存成功！");
				getMenuType();
			}
		
		},
		error:function(){
			alert("error!");
		}
	});
}