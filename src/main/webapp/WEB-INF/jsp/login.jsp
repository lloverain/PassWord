<%--
  Created by IntelliJ IDEA.
  User: rain
  Date: 2019-05-28
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="login">
</form>
</body>
</html>
