

getOutlayInfo();
function getOutlayInfo(){
	
	$.ajax({
		url : localhostPath() + "/user/getOutlayInfo.do",
		dataType : "json",
		type : "post",
		success : function(data){
			$(".name").html(data.name);
			$(".stu_id").html(data.stu_id);
			$(".outlay_type").html("总计费用");
			$(".outlay_need_all").html(data.outlay_need_all);
			$(".outlay_yes_all").html(data.outlay_yes_all);
			$(".outlay_no_all").html(data.outlay_no_all);
			var list = data.list;
			var j = 1;
			var k = 1;
			//现在删除表格下的子节点
			$("tr").remove(".child");
			for(var i=0;i<list.length;i++){
				//缴费项目
				$(".table1").append(
						'<tr class="child">'
		              +  '<td align="center" class="greenfont"><span>'+list[i].outlay_type+'</span>&nbsp;</td>'
		               + '<td align="right" class="greenfont">'
		              +  '<span style="color: #FF0000; font-size: 16px; font-weight: bold;">'
		               + list[i].outlay_need
		               + '</span>'
		              +  '</td>'
		              +  '<td align="right" class="greenfont">'
		               +     '<span style="color: #FF0000; font-size: 16px; font-weight: bold;">'
		               + list[i].outlay_yes
		              +      '</span>'
		               + '</td>'
		                
		              +  '<td align="right" class="greenfont">'
		               +     '<span style="color: #FF0000; font-size: 16px; font-weight: bold;">'
		              + list[i].outlay_no
		               +    ' </span>'
		              +  '</td>'
		         +  ' </tr>'
				);
				//欠费项目
				if(list[i].outlay_need!=list[i].outlay_yes){
					$(".table2").append(
						'<tr class="child"><td style="text-align:center">'
				            +'<span style="color: #FF0000; font-size: 16px; font-weight: bold;">'
				            +j
				            +'</span>'
				            +'</td>'
				            +'<td>'
				            +'<span style="color: #FF0000;  font-size: 16px; font-weight: bold;">'
				            +list[i].outlay_type
				            +'</span>'
				            +'</td>'
				            +'<td style="text-align:right">'
				            +'<span style="color: #FF0000;  font-size: 16px; font-weight: bold;">'
				            +list[i].outlay_need
				            +'</span>'
				            +'</td>'
				            +'<td style="text-align:right">'
				            +'<span style="color: #FF0000;  font-size: 16px; font-weight: bold;">'
				            +list[i].outlay_yes
				            +'</span>'
				            +'</td>'
				            +'<td style="text-align:right">'
				            +'<span style="color: #FF0000;  font-size: 16px; font-weight: bold;">'
				            +list[i].outlay_no
				            +'</span>'
				            +'</td>'
				            +'</tr>'	
					);
					j++;
				}
				//缴费信息
				var txt = "";
				if(list[i].outlay_ps=="0"){
					txt = '<a href="javascript:outlayObjection('+list[i].id+',true);">[确认无误]</a> &nbsp; &nbsp;'
						+'<a href="javascript:outlayObjection('+list[i].id+',false);">[有异议]</a>';
				}else if(list[i].outlay_ps=="1"){
					txt = '<font color="#008000">已审核</font>';
				}else{
					txt = '<font color="red">待审核</font>';
				}
				if(list[i].outlay_time!=null){
					$(".table3").append(
							'<tr class="child">'
							+'<td style="text-align:center">'+k+'</td>'
							+'<td>'
							+list[i].outlay_type
							+'</td>'
							+'<td>'+list[i].outlay_yes+'</td>'
							+'<td>'+data_string(list[i].outlay_time)+'</td>'
							+'<td>'
							+txt
							+'</td>'
							+'</tr>'
					);
					k++;
				}
			}
			
		},
		error : function(){
			alert("error!");
		}
	});
	
}


function outlayObjection(id,flag){
	$.ajax({
		url : localhostPath() + "/user/outlayObjection.do",
		data : {
			id : id,
			flag : flag
		},
		dataType : "json",
		type : "post",
		success : function(data){
			if(data!=null){
				getOutlayInfo();
			}else{
				alert("出现未知错误，未保存成功，请稍后再试或联系管理员！");
			}
		},
		error : function(){
			alert("error!");
		}
	});
}