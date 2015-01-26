<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/19/2015
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="addCartServlet" method="post">
    <input type="submit" value="Корзина">
</form>
<h1>Welcome!</h1>
<table>
    <c:forEach items="${itemList}" var="i">
        <table border="1" bgcolor="#00bfff">
            <caption>Список товаров</caption>
            <tr>
                <th>Название товара</th>
                <th>стоимость</th>

                <th>купить</th>
            </tr>
            <tr>
                <td>${i.name}</td>
                <td>${i.cost}</td>

                <td>
                    <form action="addCartServlet" method="get">
                        <input type="text" name="id" value="${i.id}" hidden="hidden">
                        <input type="submit" name="cart" value="купить" >
                    </form>
                </td>

            </tr>
        </table>

    </c:forEach>

</table>
</body>
</html>
