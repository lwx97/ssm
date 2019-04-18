function Calendar(CalendarName, year, month, day) {
	this.name = CalendarName;
	this.months = new Array("一", "二", "三","四", "五", "六", "七", "八", "九","十", "十一", "十二");
	this.daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31,30, 31, 30, 31);
	this.days = new Array("一", "二", "三","四", "五", "六", "日");
	this.year=-1;
	this.month=-1;
	this.day = -1;
	this.now = new Date(year,month-1,day);
	this.todayCount = 0;
	
	//取得天数
	Calendar.prototype.getDays = function(month, year) {
		if (1 == month) return ((0 == year % 4)  &&  (0 != (year % 100))) ||(0 == year % 400) ? 29 : 28;
		else return this.daysInMonth[month];
	}
	
	//初始化
	Calendar.prototype.init = function () {
	    this.year = this.now.getFullYear();
	    this.month = this.now.getMonth();
	    this.day = this.now.getDate();
	    this.queryCourse(this.year, this.month + 1);
	}
	
	//下一月
	Calendar.prototype.nextMonth = function () {
		if(this.month+1>11){
			this.month=0;
			this.year=this.year+1;
		}else{
			this.month=this.month+1;

        }
        //查询数据库记录(课程信息)
        this.queryCourse(this.year,this.month + 1);
	}
	
	//上一月
    Calendar.prototype.prevMonth = function () {
	    if ((this.month - 1) < 0) {
	        this.month = 11;
	        this.year = this.year - 1;
	    } else {
	        this.month = this.month - 1;
	    }

	    //查询数据库记录(课程信息)
	    this.queryCourse(this.year, this.month + 1);
	}

    //查询数据库记录(课程信息)
	Calendar.prototype.queryCourse = function (year, month) {
	    this.todayCount = 0;
	    $.ajax({
	        type: "POST",
	        url: "/OnlineTeaching/GetCurriculumData.ashx",
	        data: "year=" + year + "&month=" + month,
	        beforeSend: function (XMLHttpRequest) {
	            //loding;
	            $("#loading").show();
	        },
	        success: function (msg) {
	            if (msg == "3") {
	                $("#rl_id").html("<span style='color:red'>没有任何课程</span>");
	                //location.href = getRootPath() + "/Error.aspx?ErrNum=0&FromUrl=" + getRootPath() + "/Login.aspx";
	            } else if (msg != undefined && msg != null && msg.length > 3) {
	                var tempArr1 = msg.split("_");
	                var monthdays = tempArr1[0];
	                var tempArr2 = tempArr1[1].split("|");
	                var data = new Array();
	                for (var i = 0; i < Number(monthdays); i++) {

	                    var tempNowday = 0;
	                    var tempDayCount = 0;
	                    for (var j = 0; j < tempArr2.length; j++) {
	                        var tempArr3 = tempArr2[j].split(",");
	                        if (tempArr3[0] == (i + 1)) {
	                            tempNowday = tempArr3[0];
	                            tempDayCount++;
	                        }
	                    }
	                    if (tempNowday > 0 && tempDayCount > 0) {
	                        var paramStr = tempNowday + "," + tempDayCount + ",0"
	                        data.push(paramStr);
	                        if (tempNowday == rl.day)
	                            rl.todayCount = tempDayCount;
	                    }

	                }
	                rl.showCal(data);
	            } else {
	                var data = new Array();
	                rl.showCal(data);
	            }
	        },
	        complete: function (XMLHttpRequest, textStatus) {
	            //成功
	            $("#loading").hide();
	        }
	    });
	}
	
	//显示日历
	Calendar.prototype.showCal = function (data) {
	    //每个月的第一天
	    var newCal = new Date(this.year, this.month, 1);
	    //var day = -1;
	    var startWeek = newCal.getDay(); //每个月的第一天是星期几
	    var allDays = this.getDays(newCal.getMonth(), newCal.getFullYear()); //天数

//	    if ((this.now.getFullYear() == newCal.getFullYear()) && (this.now.getMonth() == newCal.getMonth())) {
//	        day = this.day;
//	    }

	    var tab_head = '<table width="100%" border="0" cellspacing="0" cellpadding="0">';
	    var tab_end = '</table>';
	    var cal_week = "";
	    cal_week += '<tr>';
	    cal_week += '<th width="14%">日</th>';
	    cal_week += '<th width="14%">一</th>';
	    cal_week += '<th width="14%">二</th>';
	    cal_week += '<th width="14%">三</th>';
	    cal_week += '<th width="14%">四</th>';
	    cal_week += '<th width="14%">五</th>';
	    cal_week += '<th width="14%">六</th>';
	    cal_week += '</tr>';

	    var cal_days = "";

	    var n = 1;
	    var tf = false;
	    for (var i = 0; i < 6; i++) {
	        cal_days += '<tr>';
	        for (var j = 0; j < 7; j++) {
	            var tmpStr = "&nbsp;";
	            if (j == startWeek && n == 1) {
	                tmpStr = n + '';
	                tf = true;
	            } else if (n > 1 && n <= allDays) {
	                tmpStr = n + '';
	            }
	            if (this.day == n) {
	                if (this.todayCount > 0) {
	                    var classStr = "";
	                    var clickStr = "";
	                    tmpStr += '<div class="kc" title="点击查看课程安排">' + this.todayCount + '节课程</div>';
	                    classStr = ' class="reding"';
	                    //var dateTmp = "'" + this.year + '-' + (this.month + 1) + '-' + this.day + "'";
	                    var dateTmp = this.year + '-' + (this.month + 1) + '-' + n;
	                    clickStr = " onclick=location.href=\"/OnlineTeaching/CurriculumListOfDay.aspx?dateTime=" + dateTmp + "\"";
	                    //clickStr = ' onclick="alert(' + dateTmp + ')"';
	                    cal_days += '<td style="cursor:pointer;"' + clickStr + classStr + '>' + tmpStr + '</td>';
	                } else {
	                    cal_days += '<td style="cursor:pointer;background:#fcc">' + tmpStr + '</td>';
	                }
	            }
	            else {
	                var classStr = "";
	                var clickStr = "";
	                if (data != undefined) {
	                    for (var t = 0; t < data.length; t++) {
	                        var tmpData = data[t].split(',');
	                        if (tmpData[0] == n && tf) {
	                            tmpStr += '<div class="kc" title="点击查看课程安排">' + tmpData[1] + '节课程</div>';
	                            if (tmpData[2] == 0) {
	                                classStr = ' class="yellowing"';
	                            } else if (tmpData[2] == 1) {
	                                classStr = ' class="reding"';
	                            } else {
	                                classStr = ' class="greening"';
	                            }
	                            var dateTmp = this.year + '-' + (this.month + 1) + '-' + n;

	                            clickStr = " onclick=location.href=\"/OnlineTeaching/CurriculumListOfDay.aspx?dateTime=" + dateTmp + "\"";
	                        }
	                    }
	                }

	                cal_days += '<td style="cursor:pointer;"' + clickStr + classStr + '>' + tmpStr + '</td>';
	            }

	            if (n <= allDays && tf == true) {
	                n++;
	            }
	        }

	        cal_days += '</tr>';
	    }

	    var obj = document.getElementById("Calendar_id");
	    if (obj != null) {
	        document.getElementById("yyyymm_id").innerHTML = this.year + '年' + (this.month + 1) + '月';
	        document.getElementById("cal_id").innerHTML = tab_head + cal_week + cal_days + tab_end;
	    } else {
	        var rlObj = document.getElementById("rl_id");
	        var rlStr = "";
	        rlStr += '<div class="data" id="Calendar_id">';
	        rlStr += '<div class="datetop">';
	        rlStr += '<div id="left_arrow" style="cursor:pointer;"><img src="/Images/left_arrow.jpg" alt="上一月" onclick="javascript:' + this.name + '.prevMonth();"/></div>';

	        rlStr += '<span id="yyyymm_id">' + this.year + '年' + (this.month + 1) + '月</span>';
	        rlStr += '<div id="right_arrow" style="cursor:pointer;"><img src="/Images/right_arrow.jpg" alt="下一月" onclick="javascript:' + this.name + '.nextMonth();"/></div>';
	        rlStr += '</div>';
	        rlStr += '<div id="cal_id">';
	        rlStr += tab_head;
	        rlStr += cal_week;
	        rlStr += cal_days;
	        rlStr += tab_end;
	        rlStr += '</div>';
	        rlStr += '</div>';

	        if (rlObj != null) {
	            rlObj.innerHTML = rlStr;
	        } else {
	            return;
	        }
	    }
	}
	
	//初始化日历
	this.init();
}