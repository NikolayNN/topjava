<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://javawebinar.ru/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>

<p>Еда</p>

<table>
    <tr>
        <th>Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    <c:forEach var="m" items="${requestScope.meals}">
        <tr style="${m.excess?'background-color: #fe6b40' : 'background-color: #b8c36b'}">
            <td>
                <p>${f:formatLocalDateTime(m.dateTime, 'dd.MM.yyyy HH:mm')} </p>
            </td>
            <td><c:out value="${m.description}"/></td>
            <td><c:out value="${m.calories}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
