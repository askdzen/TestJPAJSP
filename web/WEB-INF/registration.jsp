
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:forEach items="${list}" var="u">
    <table border="1" bgcolor="#00bfff">
        <caption>Данные пользователя </caption>
        <tr>
            <th>Наименование товара</th>
            <th>Количество</th>
            <th>Стоимость</th>

        </tr>

        <tr>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.email}</td>

            <td>
                <form action="orderEditServlet" method="get">
                    <input type="text" name="id" value="${ord.id}" hidden="hidden">
                    <input type="submit" name="editOrder" value="изменить" >
                </form>
            </td>
            <td>
                <form action="orderDeleteServlet" method="get">
                    <input type="text" name="id" value="${ord.id}" hidden="hidden">
                    <input type="submit" name="deleteOrder" value="удалить" >
                </form>
            </td>
            <td>

            </td>
        </tr>
    </table>

</c:forEach>
</body>
</html>
