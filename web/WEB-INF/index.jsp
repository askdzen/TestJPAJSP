<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2015
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<a href="registration">registration</a>
<form action="sequrityServlet" method="POST">
    <label for="username">Username</label>
    <input id="username" type="text" name="username" value="${username}">
    <label for="password">Password</label>
    <input id="password" type="text" name="password" value="${password}">
    <input type="submit" name="addUser" value="sign">
</form>
</body>
</html>
