<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账户</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/password.js"></script>
<link rel="stylesheet" href="css/password.css">
<body>
<div class="zhu">
    <a>账户<input type="text" id="zhanghu"></a><br/>
    <a>密码<input type="text" id="mima"></a><br>
    <a>平台<input type="text" id="pintai"></a><br>
    <input type="button" onclick="remake()" value="写入">
    <%--<button type="button" onclick="chakan()">查看</button>--%>
</div>
<div align="center">
    <form method="post" action="/chuli?opt=sousuo&pagenow=${now}" onsubmit="return tijiao()">
        <a>搜索</a>
        <select id="lei" name="lei">
            <option>账户</option>
            <option>平台</option>
        </select>
        <input type="text" placeholder="输入账户或平台" id="sousuoneirong" name="sousuoneirong">
        <button type="submit">搜索</button>
        <button type="button" onclick="yanzhen()">验证</button>
        <br>
        <a>每页显示个数:</a>
        <input type="radio" id="r1" class="radio" name="show" value="2">2
        <input type="radio" id="r2" class="radio" name="show" value="3">3
        <input type="radio" id="r3" class="radio" name="show" value="4">4
    </form>
</div>
<%--<div class="xianshi">--%>
    <%--<table id="aaa">--%>
        <%--<tr>--%>
            <%--<th>账户</th>--%>
            <%--<th>密码</th>--%>
            <%--<th>平台</th>--%>
            <%--<th>操作</th>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>

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
<div class="navigation" align="center">
    <a href="chuli?opt=${leixing}&pagenow=1&geshu=${pagesize}" id="shouye">首页</a>
    <a href="chuli?opt=${leixing}&pagenow=${now-2}&geshu=${pagesize}" id="fu2">${now-2}</a>
    <a href="chuli?opt=${leixing}&pagenow=${now-1}&geshu=${pagesize}" id="fu1">${now-1}</a>
    <a id="now">${now}</a>
    <a href="chuli?opt=${leixing}&pagenow=${now+1}&geshu=${pagesize}" id="zheng1">${now+1}</a>
    <a href="chuli?opt=${leixing}&pagenow=${now+2}&geshu=${pagesize}" id="zheng2">${now+2}</a>
    <a href="chuli?opt=${leixing}&pagenow=${zongyeshu}&geshu=${pagesize}" id="moye">末页</a>
</div>
<form action="" method="post" id="geshu"/>
<script type="text/javascript">
    showye();
    function showye() {
        var shouye =   document.getElementById("shouye");
        var fu2 = document.getElementById("fu2");
        var fu1 = document.getElementById("fu1");
        var now = document.getElementById("now").innerText;
        var zheng1 =document.getElementById("zheng1");
        var zheng2 = document.getElementById("zheng2");
        var moye = document.getElementById("moye");
        var r1 = document.getElementById("r1");
        var r2 = document.getElementById("r2");
        var r3 = document.getElementById("r3");
        if(now<=1){
            shouye.style.display="none";
            fu2.style.display="none";
            fu1.style.display="none";
        }
        if(now==2){
            fu2.style.display="none";
        }
        if(now==${zongyeshu}){
            zheng1.style.display="none";
            zheng2.style.display="none";
            moye.style.display="none";
        }
        if(${zongyeshu}-2<now||${zongyeshu}-1==now){
            zheng2.style.display="none";
        }
        if(${pagesize}==2){
          r1.checked=true;
        }
        if(${pagesize}==3){
            r2.checked=true;
        }
        if(${pagesize}==4){
            r3.checked=true;
        }
    }

    $(".radio").change(
        function() {
            var id = $("input[name='show']:checked").val();
            var geshu = document.getElementById("geshu");
            if (id == 2) {
                geshu.action="chuli?opt=changeshow&pagenow=${now}&geshu=2";
                geshu.submit();
            }else if (id == 3){
                geshu.action="chuli?opt=changeshow&pagenow=${now}&geshu=3";
                geshu.submit();
            }else if (id == 4){
                geshu.action="chuli?opt=changeshow&pagenow=${now}&geshu=4";
                geshu.submit();
            }
        });
    
    function yanzhen() {
        var neirong = document.getElementById("sousuoneirong").value;
        if(neirong==null||neirong==""){
            alert("不能为空!");
            return false;
        }else {
            return true;
        }
    }
    function tijiao() {
        return yanzhen();
    }
</script>
</body>
</html>
