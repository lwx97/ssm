// Ajax或通信方法
function ajaxPost(url, dataMap, callback) {
    var urlRndCode = urlAddRandomCode(url);
    $.post(
        urlRndCode,
        dataMap,
        callback
    );
}
function ajaxGet(url, dataMap, callback) {
    var urlRndCode = urlAddRandomCode(url);
    $.get(
        urlRndCode,
        dataMap,
        callback
    );
}
function urlAddRandomCode(url) {
    var rndCode = Math.random(new Date().getTime() / 1000);
    rndCode = rndCode.toString().substring(2, 7);
    if (url.indexOf('?') >= 0) {
        url += "&_rnd=" + rndCode;
    }
    else {
        url += "?_rnd=" + rndCode;
    }
    return url;
}

//学生登录
var StudentLogin = {
    login: function (username, userpwd, callback) {
        ajaxPost("/Ashx/StudentLogin.ashx", { username: username, userpwd: userpwd }, callback);
    },
    loginOut: function (callback) {
        ajaxGet("/Ashx/StudentLoginOut.ashx", {}, callback);
    },
    loginValidation: function (callback) {
        ajaxGet("/Ashx/StudentLoginValidation.ashx", {}, callback);
    }
}
var StudentManager = {
    studentReg: function (cardNum, pwd, name, code, callback) {
        ajaxGet("/Ashx/StudentReg.ashx", { cardNum: cardNum, pwd: pwd, name: name, code: code }, callback);
    },
    studentChangeCateory: function (studentId, cateory, callback) {
        ajaxGet("/Ashx/StudentChangeCateory.ashx", { studentId: studentId, cateory: cateory }, callback);
    },
    studentDetailUpdate: function (studentId, phone, phone2, qq, email, address, callback) {
        ajaxGet("/Ashx/StudentDetailUpdate.ashx", { studentId: studentId, phone: phone, phone2: phone2, qq: qq, email: email, address: address }, callback);
    }
}
var StudentCompain = {
    insertCompain: function (studentId, Ctitle, Ctype, Ccontent, callback) {
        ajaxGet("/Ashx/InsertStudentCompain.ashx", { studentId: studentId, Ctitle: Ctitle, Ctype: Ctype, Ccontent: Ccontent }, callback);
    }
}

//我的信息，数据访问调用
var studentInfo = {
    deleteCompain: function (compId) {
        ajaxGet("/Ashx/DeleteStudentCompain.ashx", { compId: compId }, callback);
    },
    changeStudentCateory: function (cateory, callback) {
        ajaxGet("/User/StudentInfor/Ashx/ChangeStudentCateory.ashx", { cat: cateory }, callback);
    },
    insertStudentLetterDetail: function (lid, detail, descript, callback) {
        detail = encodeURIComponent(detail);
        descript = encodeURIComponent(descript);
        ajaxGet("/User/StudentInfor/Ashx/InsertStudentLetterDetail.ashx", { lid: lid, detail: detail, descript: descript }, callback);
    },
    modifySystemMesgeStatus: function (smid, smtype, callback){
        ajaxGet("/User/StudentInfor/Ashx/ModifySystemMesgeStatus.ashx", { smid: smid, smtype: smtype }, callback);
    }
}

//教务中心，数据访问调用
var senateCenter = {
    modifyStudentScoreStatus: function (sid, examtime, stype, callback) {
        ajaxGet("/User/SenateCenter/Ashx/ModifyStudentScoreStatus.ashx", { sid: sid, examtime: examtime, stype: stype }, callback);
    },
    modifyStudentBookStatus: function (bid, stype, callback) {
        ajaxGet("/User/SenateCenter/Ashx/ModifyStudentBookStatus.ashx", { bid: bid, stype: stype }, callback);
    },
    modifyStudentSignupExamStatus: function (sueid, stype, callback) {
        ajaxGet("/User/SenateCenter/Ashx/ModifyStudentSignupExamStatus.ashx", { sueid: sueid, stype: stype }, callback);
    }
}

//我的财务，数据访问调用
var financialInfor = {
    modifyStudentPaymentStatus: function (pid, stype, callback) {
        ajaxGet("/User/FinancialInfor/Ashx/ModifyStudentPaymentStatus.ashx", { pid: pid, stype: stype }, callback);
    }
}

//学生账户信息，数据访问调用
var studentAccount = {
    changePassword: function (oldpwd, newpwd, callback) {
        ajaxGet("/User/Account/Ashx/ChangePassword.ashx", { oldpwd: oldpwd, newpwd: newpwd }, callback);
    }
}



/* 公共数据 */
//系统学生信息
var systemStudentInfo = {
    getCurriculumByProfess: function (id, callback) {
        ajaxGet("/Admin/ExamCenter/ExamDesign/Ashx/GetCurriculumByProfess.ashx", { id: id }, callback);
    },
    getSchoolByEducatCategory: function (id, callback) {
        ajaxGet("/Admin/ExamCenter/ExamDesign/Ashx/GetSchoolByEducatCategory.ashx", { id: id }, callback);
    },
    getProfessByCatgroySchool: function (sid, ecid, callback) {
        ajaxGet("/Admin/ExamCenter/ExamDesign/Ashx/GetProfessByCatgroySchool.ashx", { sid: sid, ecid: ecid }, callback);
    },
    getProfessByCatgroy: function (ecid, callback) {
        ajaxGet("/Admin/ExamCenter/ExamDesign/Ashx/GetProfessByCatgroy.ashx", { ecid: ecid }, callback);
    }
}
