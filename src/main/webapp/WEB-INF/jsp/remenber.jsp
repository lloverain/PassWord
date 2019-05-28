<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账户</title>
</head>
<script src="../../js/jquery-3.3.1.js"></script>
<script src="../../js/password.js"></script>
<link rel="stylesheet" href="../../css/password.css">
<body background="../../image/tiankong.jpg" style="background-size: 100% 100%">
<div class="main">
    <div class="left">
        <div class="zhu">
            <span><a>欢迎您:${name}</a></span>
            <span><a>账户</a><input type="text" id="zhanghu" placeholder="输入你想保存账户～"></span>
            <span><a>密码</a><input type="text" id="mima" placeholder="这里输入你的密码！"></span>
            <span><a>平台</a><input type="text" id="pintai" placeholder="这是在哪个平台呀？"></span>
            <span><input type="button" onclick="remake()" value="写入">
                <input type="button" onclick="chongzhi()" value="重置"></span>
        </div>
    </div>

    <div class="right">
        <div class="right_top">
            <form method="post" action="/chuli?opt=sousuo&pagenow=${now}" onsubmit="return tijiao()">
                <a class="a1">搜索</a>
                <select id="lei" name="lei">
                    <option>账户</option>
                    <option>平台</option>
                </select>
                <input type="text" placeholder="输入账户或平台" id="sousuoneirong" name="sousuoneirong">
                <button type="submit">搜索</button>
                <div class="geshu">
                    <a class="a2">每页显示个数:</a>
                    <input type="radio" id="r1" class="radio" name="show" value="5">5
                    <input type="radio" id="r2" class="radio" name="show" value="7">7
                    <input type="radio" id="r3" class="radio" name="show" value="10">10
                </div>
            </form>
        </div>
        <div class="xianshi">
            <c:if test="${applicationScope.data!=null}">
                <c:set value="${applicationScope.data}" var="data"/>
            </c:if>
            <c:if test="${sessionScope.data != null}">
                <c:set value="${sessionScope.data}" var="data"/>
            </c:if>
            <table id="bbb">
                <tr>
                    <th>账户</th>
                    <th>密码</th>
                    <th>平台</th>
                </tr>
                <c:forEach items="${data}" var="rain">
                    <tr>
                        <td>${rain.getZhanghu()}</td>
                        <td>${rain.getMima()}</td>
                        <td>${rain.getPintai()}</td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${applicationScope.now!=null}">
                <c:set value="${applicationScope.now}" var="now"/>
            </c:if>
            <c:if test="${sessionScope.now!=null}">
                <c:set value="${sessionScope.now}" var="now"/>
            </c:if>

            <c:if test="${applicationScope.zongyeshu!=null}">
                <c:set value="${applicationScope.zongyeshu}" var="zongyeshu"/>
            </c:if>
            <c:if test="${sessionScope.zongyeshu!=null}">
                <c:set value="${sessionScope.zongyeshu}" var="zongyeshu"/>
            </c:if>

            <c:if test="${applicationScope.leixing!=null}">
                <c:set value="${applicationScope.leixing}" var="leixing"/>
            </c:if>
            <c:if test="${sessionScope.leixing!=null}">
                <c:set value="${sessionScope.leixing}" var="leixing"/>
            </c:if>
            <c:if test="${applicationScope.pagesize!=null}">
                <c:set value="${applicationScope.pagesize}" var="pagesize"/>
            </c:if>
            <c:if test="${sessionScope.pagesize!=null}">
                <c:set value="${sessionScope.pagesize}" var="pagesize"/>
            </c:if>
        </div>
        <div class="navigation">
            <a href="chuli?opt=${leixing}&pagenow=1&geshu=${pagesize}" id="shouye">首页</a>
            <a href="chuli?opt=${leixing}&pagenow=${now-2}&geshu=${pagesize}" id="fu2">${now-2}</a>
            <a href="chuli?opt=${leixing}&pagenow=${now-1}&geshu=${pagesize}" id="fu1">${now-1}</a>
            <a id="now">${now}</a>
            <a href="chuli?opt=${leixing}&pagenow=${now+1}&geshu=${pagesize}" id="zheng1">${now+1}</a>
            <a href="chuli?opt=${leixing}&pagenow=${now+2}&geshu=${pagesize}" id="zheng2">${now+2}</a>
            <a href="chuli?opt=${leixing}&pagenow=${zongyeshu}&geshu=${pagesize}" id="moye">末页</a>
        </div>
        <form action="" method="post" id="geshu"/>

    </div>


</div>
<script type="text/javascript">
    showye();
    function showye() {
        var shouye = document.getElementById("shouye");
        var fu2 = document.getElementById("fu2");
        var fu1 = document.getElementById("fu1");
        var now = document.getElementById("now").innerText;
        var zheng1 = document.getElementById("zheng1");
        var zheng2 = document.getElementById("zheng2");
        var moye = document.getElementById("moye");
        var r1 = document.getElementById("r1");
        var r2 = document.getElementById("r2");
        var r3 = document.getElementById("r3");
        if(${pagesize}==5){
            $("#r1").attr("checked","checked");
        }
        if(${pagesize}==7){
            $("#r2").attr("checked","checked");
        }
        if(${pagesize}==10){
            $("#r3").attr("checked","checked");
        }

        if (now <= 1) {
            shouye.style.display = "none";
            fu2.style.display = "none";
            fu1.style.display = "none";
        }
        if (now == 2) {
            fu2.style.display = "none";
        }
        if (now ==${zongyeshu}) {
            zheng1.style.display = "none";
            zheng2.style.display = "none";
            moye.style.display = "none";
        }
        if (${zongyeshu}-2 < now || ${zongyeshu}-1 == now) {
            zheng2.style.display = "none";
        }
        if (${pagesize}==2
    )
        {
            r1.checked = true;
        }
        if (${pagesize}==3
    )
        {
            r2.checked = true;
        }
        if (${pagesize}==4
    )
        {
            r3.checked = true;
        }
    }

    $(".radio").change(
        function () {
            var id = $("input[name='show']:checked").val();
            var geshu = document.getElementById("geshu");
            var r1 = $("#r1");
            var r2 = $("#r2");
            var r3 = $("#3");
            if (id == 5) {
                geshu.action = "chuli?opt=changeshow&pagenow=${now}&geshu=5";
                geshu.submit();
                r1.attr("checked","checked");
                r2.removeAttr("checked");
                r3.removeAttr("checked");
            } else if (id == 7) {
                geshu.action = "chuli?opt=changeshow&pagenow=${now}&geshu=7";
                geshu.submit();
                r2.attr("checked","checked");
                r1.removeAttr("checked");
                r3.removeAttr("checked");
            } else if (id == 10) {
                geshu.action = "chuli?opt=changeshow&pagenow=${now}&geshu=10";
                geshu.submit();
                r3.attr("checked","checked");
                r2.removeAttr("checked");
                r1.removeAttr("checked");
            }
        });

    function yanzhen() {
        var neirong = document.getElementById("sousuoneirong").value;
        if (neirong == null || neirong == "") {
            alert("不能为空!");
            return false;
        } else {
            return true;
        }
    }

    function tijiao() {
        return yanzhen();
    }
    
    function chongzhi() {
        var zh = document.getElementById("zhanghu");
        var mm = document.getElementById("mima");
        var pt = document.getElementById("pintai");
        zh.value = "";
        mm.value = "";
        pt.value = "";

    }
</script>
</body>
</html>
