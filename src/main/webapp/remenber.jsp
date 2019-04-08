<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<body>
<div class="zhu">
    <a>账户<input type="text" id="zhanghu"></a><br />
    <a>密码<input type="text" id="mima"></a><br>
    <a>平台<input type="text" id="pintai"></a><br>
    <input type="button" onclick="remake()" value="写入">
    <button type="button" onclick="chakan()">查看</button>
</div>

<div class="xianshi">
    <table id="aaa">
        <tr >
            <th>账户</th>
            <th>密码</th>
            <th>平台</th>
            <th>操作</th>
        </tr>
    </table>

</div>
<style type="text/css">
    * {
        padding: 0px;
        margin: 0px;
    }

    .zhu {
        position: relative;
        text-align: center;
        /* background-color: aqua; */
    }

    .xianshi {
        padding-top: 50px;
        width: 70%;
        margin: 0px auto;
        /* background-color: blueviolet; */
    }

    .xianshi table {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #c6c6c6 !important;
        margin-bottom: 20px;
    }

    .xianshi table th {
        border-collapse: collapse;
        border-right: 1px solid #c6c6c6 !important;
        border-bottom: 1px solid #c6c6c6 !important;
        background-color: #ddeeff !important;
        padding: 5px 9px;
        font-size: 14px;
        font-weight: normal;
        text-align: center;
    }

    .xianshi table td {
        border-collapse: collapse;
        border-right: 1px solid #c6c6c6 !important;
        border-bottom: 1px solid #c6c6c6 !important;
        padding: 5px 9px;
        font-size: 12px;
        font-weight: normal;
        text-align: center;
        word-break: break-all;
    }

    input[type=text] {
        border-radius: 5px;

    }
    .xianshi tr:hover{
        background: rgba(93, 247, 20, 0.32);
    }
</style>

<script type="text/javascript">
    chakan();
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
                    chakan();
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
</script>
</body>
</html>
