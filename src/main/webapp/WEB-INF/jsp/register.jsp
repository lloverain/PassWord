<%--
  Created by IntelliJ IDEA.
  User: rain
  Date: 2019-05-29
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<script type="text/javascript" src="../../js/jquery-3.3.1.js"/>
<body>
<div>
    <a>账户</a><input type="text" placeholder="注册账户" id="user"><br>
    <a>密码</a><input type="password" placeholder="输入密码" id="password"><br>
    <a>再次输入密码</a><input type="password" placeholder="输入密码" id="zcpassword"><br>
    <button type="button" value="注册" onclick=""/>
</div>
<script type="text/javascript">
    var zhanghu = $("#user").val();
    var mima = $("#password").val();
    var zcmima = $("#zcpassword").val();
    function zhuce() {
        if(yanzhengzhanghu() && yanzhengmima()){
            $.ajax(
                
            )
        }

    }
    /*账户验证*/
    function yanzhengzhanghu() {
        if(zhanghu==null || zhanghu==""){
            alert("账户不能空！")
            return false;
        }else{
            if(zhanghu.length<6){
                alert("账户不能少于6位！")
                return false;
            }else{
                return true;
            }
        }
    }

    /*验证密码*/
    function yanzhengmima() {
        if(mima.length<6){
            alert("密码不能少于6位！")
            return false;
        }else {
            if(mima==zcmima){
                return true;
            }else {
                alert("2次输入的密码不一致！")
                return false;
            }
        }
    }
</script>
</body>
</html>
