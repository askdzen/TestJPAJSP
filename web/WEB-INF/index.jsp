<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/14/2015
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="addUserServlet" method="POST">
    <label for="username">Username</label>

    <input id="username" type="text" name="username" value="${username}">
    <label for="password">Password</label>
    <input id="password" type="text" name="password" value="${password}">
    <input type="submit" name="addUser" value="add user">
</form>
<hr>

<c:forEach items="${list}" var="us">
<table>
    <tr>
        <td>${us.username}</td>
        <td>${us.password}</td>
        <td>
            <form action="userEditServlet" method="get">
                <input type="text" name="id" value="${us.id}" hidden="hidden">
                <input type="submit" name="editUser" value="изменить" >
            </form>
        </td>
        <td>
            <form action="userDeleteServlet" method="get">
                <input type="text" name="id" value="${us.id}" hidden="hidden">
                <input type="submit" name="deleteUser" value="удалить" >
            </form>
        </td>
    </tr>
</table>

    </c:forEach>
</body>
</html>
