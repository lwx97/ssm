/**
 * 获取当前项目地址
 */
var localhostPath = function(){
	//获取当前网址，如： http://192.168.26.127:8080/continuedBuild/jobManage/gotoJobList.asp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： /continuedBuild/jobManage/gotoJobList.asp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://192.168.26.127:8080
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/continuedBuild
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
};

function loginOut(){
	alert(1);
}

/**
 * 将毫秒转换为xx天xx小时xx分xx秒的格式
 * @param millisecond 毫秒数
 * @returns {String}
 */
function millisecondChangeTime(millisecond){
	millisecond = parseInt(millisecond);
	var second = Math.ceil(millisecond/1000);
	if(second > 60){
		var Minute = Math.floor(second/60);
		var second = Math.floor(second%60);
		if(Minute > 60){
			var hour = Math.floor(Minute/60);
			var Minute = Math.floor(Minute%60);
			if(hour > 24){
				var day = Math.floor(hour/24);
				hour = Math.floor(hour%24);
				return day + "天" + hour + "小时" + Minute + "分" + second + "秒";
			}else{
				return hour + "小时" + Minute + "分" + second + "秒";
			} 
		}else{
			return Minute + "分" + second + "秒";
		}
	}else{
		return second + "秒";
	}
}
/**
 * 获取当前的日期时间 格式“yyyy-MM-dd HH:MM:SS”
 * @returns {String}
 */
function getNowFormatDate() {
	var currentTime = ""
	$.ajax({
		type : "post",
		dataType : "json",
		url : localhostPath() + "/sdic/getNowFormatDate.do",
		async:false,
		success : function(data){
			currentTime = data.currentTime;
			return currentTime;
		},
		error : function(){
			alert("获取当前时间失败！");
		}
	});
    return currentTime;
}

/**
 * 获取iframe的src中的参数
 * @param iframeId父窗口中iframe的id
 * @param name 要获取参数名称
 * @returns
 */
function getIframeSrcPara(iframeId,name) {
    var reg = new RegExp("[^\?&]?" + encodeURI(name) + "=[^&]+");
    if(window.parent.document.getElementById(iframeId) != null){
    	var arr = window.parent.document.getElementById(iframeId).contentWindow.location.search.match(reg);
        if (arr != null) {
            return decodeURI(arr[0].substring(arr[0].search("=") + 1));
        }
    }else{
    	var arr = window.location.search.match(reg);
        if (arr != null) {
            return decodeURI(arr[0].substring(arr[0].search("=") + 1));
        }
    }
    return "";
}
/**
 * 从url中获取参数
 * @param name 要获取参数名称
 * @returns
 */
function getUrlPara(name) {
	var url = location.search;
    var reg = new RegExp("[^\?&]?" + encodeURI(name) + "=[^&]+");
    var arr = window.location.search.match(reg);
    if (arr != null) {
        return decodeURI(arr[0].substring(arr[0].search("=") + 1));
    }
    return "";
}

//设置窗口高度
function setWindowHeight(){
	var documentHeight = $(document.body).outerHeight(true);
	documentHeight = documentHeight + 30;
	if(documentHeight < 650){//默认最小高度为650px;
		documentHeight = 650;
	}
	try{
		if(parent.document.getElementById("workIframeDiv")){
			parent.document.getElementById("workIframeDiv").style.height = documentHeight + "px";
			parent.document.getElementById("workIframe").style.height = documentHeight + "px";
		}
		if(parent.parent.document.getElementById("mainIframeDiv")){
			parent.parent.document.getElementById("mainIframeDiv").style.height = documentHeight + "px";
			parent.parent.document.getElementById("mainIframe").style.height = documentHeight + "px";
		}
	}catch(e){}
}
/**
 * 获取定时执行任务的cron表达式
 * @param day 每月的日期数
 * @param week 每周的星期数
 * @param hour  小时数
 * @param minute 分钟数
 * @returns {String}
 */
function cronExpression(day,week,hour,minute){
	var cron = "";
	//每月day日hour时minute分执行一次
	if(day != null){
		cron = "0 " + minute + " " + hour + " " + day + " * ?";
	}
	//每周week，hour时minute分执行一次
	if(week != null){
		cron = "0 " + minute + " " + hour + " ? * " + week;
	}
	//每天hour时minute分执行一次
	if(day == null && week == null){
		cron = "0 " + minute + " " + hour + " ? * *";
	}
	return cron;
}
/**
 * 判断字符串是否为json格式
 * @param str
 * @returns {Boolean}
 */
function isJSON(str) {
    if (typeof str == 'string') {
        try {
            var obj=JSON.parse(str);
            if(str.indexOf('{')>-1){
                return true;
            }else{
                return false;
            }

        } catch(e) {
            return false;
        }
    }
    return false;
}
/**
 * 根据字典code获取字典项集合
 * @param dic_code  字典code
 * @param Callback  回调函数function(data){
 * 							//data:{"result" : "true","itemList" : "Array"}
 * 						  }
 */
function getDicItemList(dic_code,Callback,async){
	$.ajax({
		url : localhostPath() + "/dictionary/queryDictionaryItemList.do",
		type : "post",
		dataType : "json",
		data : {
			dic_code : dic_code
		},
		async : async == undefined ? true : false,
		success : Callback,
//		success : function(data){
//			var result = data.result;
//			var itemList = data.itemList;
//			alert("查询字典成功！");
//		},
		error : function(){
			alert("查询字典失败！");
		}
	});
}

/**
 * 根据字典code获取字典项集合，并在指定的元素赋值下拉框内容
 * @param dic_code
 * @param objName
 * @param async		是否异步
 * @param initVla	初始值
 * @param width		宽度
 */
function getDicItemSelectByObjName(dic_code,objName, async,initVla,width){
	$.ajax({
		url : localhostPath() + "/dictionary/queryDictionaryItemList.do",
		type : "post",
		dataType : "json",
		data : {
			dic_code : dic_code
		},
		async : async == undefined ? async : false,
		success : function(data){
			var result = data.result;
			if(result == "true"){
				var itemList = data.itemList;
				var selectObj = $("select[name=" + objName + "]");
				selectObj.html("");
				if(initVla == undefined){
					selectObj.append("<option value=''>请选择</option>");
				}
				if(itemList.length > 0){
					for (var i = 0; i < itemList.length; i++) {
						var item = itemList[i];
						var dic_code = item.DIC_CODE;
						var item_name = item.ITEM_NAME;
						var item_value = item.ITEM_VALUE;
						selectObj.append("<option value='" + item_value + "'>" + item_name + "</option>");
					}
				}
				if(initVla != undefined && initVla != ""){
					selectObj.val(initVla);
				}
				selectObj.select2({
					width : width == undefined ? 170 : width,
					dropdownAutoWidth : true,
					minimumResultsForSearch: -1,
					selectOnBlur : true,
					language: "zh-CN"
				});
			}
		},
		error : function(){
			alert("查询字典失败！");
		}
	});
}

//字符串转义
function htmlToStr(str){
	
	if(str.indexOf("\"")){//对表达式中双引号转义
		str = str.replace(/"/g,"&quot;");
	}
	if(str.indexOf("\\")){//对表达式中反斜线，替换为两个反斜线
		str = str.replace("\\","\\\\");
	}
	return str;
};

/**
 * 必填项添加红星
 */
function formatForm(objId){
	$("#" + objId).find(".reqStar").prepend("<span class=\"redstar\">*</span>");
}
/**
 * form表单，必填项验证
 * @param objId	
 * @returns {Boolean}
 */
function verificationFormat(objId){
	var flag = true;
	$("#" + objId).find("input[requisite=requisite]").each(function(){//文本框验证
		if($(this).val() == ""){
			$(this).css("border-color","#ff0000");
			$(this).css("color","#ff0000");
			$(this).attr("placeholder","此处为必填项！");
			flag = false;
		}
	});
	$("#" + objId).find("textarea[requisite=requisite]").each(function(){//文本域验证
		if($(this).val() == ""){
			$(this).css("border-color","#ff0000");
			$(this).css("color","#ff0000");
			$(this).attr("placeholder","此处为必填项！");
			flag = false;
		}
	});
	$("#" + objId).find("select[requisite=requisite]").each(function(){//下拉框验证
		if($(this).val() == ""){
			$(this).parent().find(".select2 .selection .select2-selection").css("border-color","#ff0000");
			flag = false;
		}
	});
	
	$("#" + objId).find("input[requisite=requisite]").click(function(){//取消文本框验证样式
		$(this).css("border-color","#ebebeb");
		$(this).css("color","inherit");
		$(this).attr("placeholder","");
	});
	$("#" + objId).find("textarea[requisite=requisite]").click(function(){//取消文本域验证样式
		$(this).css("border-color","#ebebeb");
		$(this).css("color","inherit");
		$(this).attr("placeholder","");
	});
	$("#" + objId).find("select[requisite=requisite]").change(function(){//取消下拉框验证样式
		$(this).parent().find(".select2 .selection .select2-selection").css("border-color","#ebebeb");
	});
	return flag;
}



function data_string(date,n) {
	var y = date.year + 1900; 
	var m = date.month + 1;
	m = m < 10 ? ('0' + m) : m; 
	var d = date.date; 
	d = d < 10 ? ('0' + d) : d;
	var h = date.hours;
	var minute = date.minutes; 
	minute = minute < 10 ? ('0' + minute) : minute; 
	var second= date.seconds; 
	second = second < 10 ? ('0' + second) : second; 
	if(n==null){
		return y + '-' + m + '-' + d+' '+h+':'+minute+':'+ second; 
	}else{
		return y + '-' + m + '-' + d; 
	}
	
} 


/**
 * =======================websocket begin======================================
 */
//var websocket = null;
//var usernoRand = Math.ceil(Math.random()*10000000000);
//
////判断当前浏览器是否支持WebSocket
//if ('WebSocket' in window) {
//	var localhost = localhostPath();
//	var websocketPath = "ws" + localhost.substr(localhost.indexOf(':')) + "/websocket/" + usernoRand;
//	websocket = new WebSocket(websocketPath);
//} else {
//	alert('当前浏览器 Not support websocket')
//}
////连接发生错误的回调方法
//websocket.onerror = function() {
//	alert("WebSocket连接发生错误");
//	setMessageInnerHTML("WebSocket连接发生错误");
//};
////连接成功建立的回调方法
//websocket.onopen = function() {
//	setMessageInnerHTML("WebSocket连接成功");
//}
////接收到消息的回调方法
////websocket.onmessage = function(event) {
////	setMessageInnerHTML(event.data);
////}
////连接关闭的回调方法
//websocket.onclose = function() {
//	setMessageInnerHTML("WebSocket连接关闭");
//}
////监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
//window.onbeforeunload = function() {
//	closeWebSocket();
//}
////将消息显示在网页上
//function setMessageInnerHTML(innerHTML) {
//	//页面测试显示区域id为message
//	document.getElementById('message').innerHTML += innerHTML + '<br/>';
//}
////关闭WebSocket连接
//function closeWebSocket() {
//	websocket.close();
//}
////发送消息
//function send() {
////	var message = document.getElementById('text').value;//测试文本框中数据
////	websocket.send(message);
//}
/**
 * =======================websocket end========================================
 */

