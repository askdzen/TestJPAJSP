<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/15/2015
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Редактирование данных пользователя</h1>
<form action="userEditServlet" method="POST">
    <input type="text" name="username" value="${username}">
    <input type="text" name="password" value="${password}">
    <input type="text" name="id" value="${id}" hidden="hidden">
    <input type="submit" name="save" value="Сохранить">
</form>
</body>
</html>
