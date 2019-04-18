
function $hy(oid) {
    return document.getElementById(oid);
}

function chgOption(oid, oname, olen, tname, classOld, classCurr) {
    var obj;

    for (var i = 0; i < olen; i++) {
        obj = $hy(oname + "_" + i);
        obj.className = classOld;
        $hy(tname + "_" + i).style.display = "none";
    }

    obj = $hy(oname + "_" + oid);
    obj.className = classCurr;
    $hy(tname + "_" + oid).style.display = "block";
}
