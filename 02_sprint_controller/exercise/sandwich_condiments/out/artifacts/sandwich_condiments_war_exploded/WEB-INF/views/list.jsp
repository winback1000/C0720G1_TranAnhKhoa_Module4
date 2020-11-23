<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/23/2020
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <table border="2px">
        <tr>
            <th>Name</th>
            <th>Condiments</th>
        </tr>
        <c:forEach var="sandwich" items="${sandwichList}">
        <tr>
                <td>${sandwich.name}</td>
                <td>${sandwich.getCondiments()}</td>
        </tr>
        </c:forEach>
    </table>
<a type="button" href="/add">Add new Sandwich</a>
</body>
</html>
