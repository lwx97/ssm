


getIndex();
function getIndex(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : localhostPath() + "/mainView/index.do",
		success : function(data){
			$("input[name='account']").val(data.account);
			$("input[name='password']").val(data.password);
			//展示校长致辞
			$("#p_xzzc").html(data.xzzc);
			//展示院系列表
			for(var i=0;i<data.CollegeList.length;i++){
				$("#collegeList").append(
						"<li><a href='javascript:openReport(1,"+ data.CollegeList[i].id+");'  id='"+data.CollegeList[i].id+"'>"+data.CollegeList[i].college_name+"</a><span>2017-02-23</span></li>"
				);
			}
			//展示新闻快讯
			for(var i=0;i<data.newsFlash.length;i++){
				var date = data_string(data.newsFlash[i].nf_time);
				$("#newsFlash").append(
						"<li><a href='javascript:openReport(2,"+data.newsFlash[i].id+");' id='"
						+data.newsFlash[i].id+"'>"
						+data.newsFlash[i].nf_title+"</a><span>"
						+date+"</span></li>"
				);
			}
			//展示要闻
			for(var i=0;i<data.news.length;i++){
				var date = data_string(data.news[i].news_time,0);
				$("#news").append(
						"<li><a href='javascript:openReport(3,"+data.news[i].id+");' id='"
						+data.news[i].id+"'>"
						+data.news[i].news_title+"</a><span>"
						+date+"</span></li>"
				);
			}
			//展示视频
			for(var i=0;i<data.video.length;i++){
				if(i==0){
					$("#v1").attr("src",data.video[i].v_url);
					$("#myModalLabel").html(data.video[i].v_title);
					$("#v2").attr("src",data.video[i].v_url);
				}else{
					$("#video ul").append(
							"<li><a href='detail2.html' id='"
							+data.video[i].id+"'>"
							+data.video[i].v_title+"</a></li>"	
					);
				}
			}
			//展示图片
			for(var i=0;i<data.imgs4.length;i++){
				$(".scrollleft ul").append(
						"<li>"
						+"<a href='javascript:#;'><img alt='"+data.imgs4[i].img_title+"' src='"+data.imgs4[i].img_url+"' /></a>"
						+"<span>"+data.imgs4[i].img_title+"</span>"
						+"</li>"
				);
			}
			gundong();
		},
		error : function(){
			alert("出错了！");
		}
	});
	
}


function myVideo(){
	var video1 = document.getElementsByTagName('video')[1];
	video1.load();
}

function openReport(url,data){
	//window.location.href = url+"?flag=true&A="+data;
	//url=1 是院系的url   yuanxijieshao.html
	//url=2 是新闻快讯  url=3 是要闻  url=4 是视频   url=5 是图片（图片暂时不单独跳转）
	if(url==1){
		url = 'yuanxijieshao.html';
	}else if(url==2){
		url = 'yingxinkx.html';
	}else if(url==3){
		url = 'gdyw.html';
	}else if(url==4){
		url = 'yuanxijieshao.html';
	}else if(url==5){
		url = 'yuanxijieshao.html';
	}
	window.location.href = url+"?flag=true&A="+data;
}

function gundong(){

	$(".scrollleft").imgscroll({
		speed: 40,    //图片滚动速度
		amount: 0,    //图片滚动过渡时间
		width: 1,     //图片滚动步数
		dir: "left"   // "left" 或 "up" 向左或向上滚动
	});
	
}
function ulogin(){
	var account = $("input[name='account']").val();
	var password = $("input[name='password']").val();
	//判断是否记住密码
	var checked = $("#checkbox").is(':checked');
	
	if(account==""||password==""){
		alert("用户名和密码不能为空！测试阶段===角色为：学生！账号密码为：1516270255/123456");
	}else{
		$.ajax({
			url : localhostPath() + "/user/ulogin.do",
			data : {
				account : account,
				password : password,
				checked : checked
			},
			dataType : "json",
			success : function(data){
				//role 为角色，0为游客，1为学生，2为老师，3为管理员
				if(data.flag=="true"){
					if(data.role+"" =="1"){
						window.location.href="../html/student/Index.aspx.html";
					}else if(data.role+"" == "2"){
						window.location.href="../html/teacher/index.html";
					}else if(data.role+"" == "3"){
						window.location.href="../html/admin/index.html";
					}
					
				}else if(data.flag=="false"){
					alert("账号密码错误！测试阶段===角色为：学生！账号密码为：stu/123")
				}
			},
			error : function(){
				alert("出错了！");
			}
		});
	}
}
document.onkeydown = function(e){
	if(e.keyCode == 13){
		ulogin();
}
}
