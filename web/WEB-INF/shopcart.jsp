<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2015
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <c:forEach items="${userCart}" var="i">
        <table border="1" bgcolor="#00bfff">
            <caption>Список товаров</caption>
            <tr>
                <th>Название товара</th>
                <th>стоимость</th>

                <th>удалить</th>
            </tr>
            <tr>
                <td>${i.name}</td>
                <td>${i.cost}</td>

                <td>
                    <form action="deleteFromCartServlet" method="get">
                        <input type="text" name="id" value="${i.id}" hidden="hidden">
                        <input type="submit" name="cart" value="удалить" >
                    </form>
                </td>

            </tr>
        </table>

    </c:forEach>
</body>
</html>
