// chakan()
function remake() {
    var a = document.getElementById("zhanghu").value;
    var b = document.getElementById("mima").value;
    var c = document.getElementById("pintai").value;
    var json = {
        "zhanghu":a,
        "mima":b,
        "pintai":c
    };
    $.ajax({
        type:"POST",
        url:"chuli?opt=window",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(json),
        dataType: "json",
        success:function (data) {
            if(data == 1){
                alert("添加成功");
                document.getElementById("zhanghu").value = "";
                document.getElementById("mima").value = "";
                document.getElementById("pintai").value = "";
                window.location.reload();
                // chakan();
            }else{
                alert("添加失败");
            }
        }
    });
}

function chakan() {
    $.ajax({
        type:"POST",
        url:"chuli?opt=chakan",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success:function (data) {
            $("#aaa tr:gt(0)").remove();
            for(var i=0;i<data.length;i++){
                var zhanghu = data[i].zhanghu;
                var mima = data[i].mima;
                var pintai = data[i].pintai;
                $("#aaa").append("<tr id='tr"+i+"'><td id='zhanghu"+i+"'>"+zhanghu+"</td><td id='mima"+i+"'>"+mima+"</td><td>"+pintai+"</td><td><button type='button' onclick='shanchu("+i+")'>删除</button></td></tr>");
            }
        }
    });
}

function shanchu(a) {
    var zh = "zhanghu"+a;
    var mm = "mima"+a;
    var zhanghu = document.getElementById(zh).innerHTML;
    var mima =    document.getElementById(mm).innerHTML;
    var json = {
        "zhanghu":zhanghu,
        "mima":mima
    };
    $.ajax({
        type:"post",
        url:"chuli?opt=shanchu",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(json),
        dataType: "json",
        success:function (data){
            if(data == 1){
                //执行删除行
                chakan();
            }else{
                alert("删除失败")
            }
        }
    });
}
