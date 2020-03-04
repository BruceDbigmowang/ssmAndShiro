<%--
  Created by IntelliJ IDEA.
  User: cx
  Date: 2019/12/13
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>用户登录界面</h2>
<form id="loginForm" name="loginForm" action="login.do" method="post">
    account:<input type="text" name="account" value=""/><br>
    password:<input type="password" name="password" value=""/><br>
    <input type="submit" name="sub" value="提交">
    <span>${msg }</span>
</form>
</body>
</html>
